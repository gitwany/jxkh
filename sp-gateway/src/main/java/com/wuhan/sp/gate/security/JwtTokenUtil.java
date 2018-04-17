package com.wuhan.sp.gate.security;

import com.wuhan.sp.common.constant.CommonConstants;
import com.wuhan.sp.common.util.StringHelper;
import com.wuhan.sp.common.util.jwt.IJWTInfo;
import com.wuhan.sp.common.util.jwt.JWTInfo;
import com.wuhan.sp.common.vo.UserInfo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * ${DESCRIPTION}
 *
 * @author admin
 * @create 2018-03
 */
@Component
public class JwtTokenUtil {
    private static final Logger logger = LoggerFactory.getLogger(JwtTokenUtil.class);

    private static final String CLAIM_KEY_CREATED = "created";

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public String getUsercodeFromToken(String token) {
        String usercode;
        try {
            final Claims claims = getClaimsFromToken(token);
            usercode = claims.getSubject();
        } catch (Exception e) {
            usercode = null;
            logger.error("getUsercodeFromToken exception occurs: {}", e.getMessage());
        }
        return usercode;
    }
    public IJWTInfo getInfoFromToken(String token) throws Exception {
        final Claims claims = getClaimsFromToken(token);

        return new JWTInfo(claims.getSubject(),
                StringHelper.getObjectValue(claims.get(CommonConstants.JWT_KEY_USER_ID)),
                StringHelper.getObjectValue(claims.get(CommonConstants.JWT_KEY_USERNAME)),
                StringHelper.getObjectValue(claims.get(CommonConstants.JWT_KEY_DEPTCODE))
        );
    }

    public Date getCreatedDateFromToken(String token) {
        Date created;
        try {
            final Claims claims = getClaimsFromToken(token);
            created = new Date((Long) claims.get(CLAIM_KEY_CREATED));
        } catch (Exception e) {
            created = null;
            logger.error("getCreatedDateFromToken exception occurs: {}", e.getMessage());
        }
        return created;
    }

    public Date getExpirationDateFromToken(String token) {
        Date expiration;
        try {
            final Claims claims = getClaimsFromToken(token);
            expiration = claims.getExpiration();
        } catch (Exception e) {
            expiration = null;
            logger.error("getExpirationDateFromToken exception occurs: {}", e.getMessage());
        }
        return expiration;
    }

    public Boolean invalid(String token) {
        String usercode = this.getUsercodeFromToken(token);
        return redisTemplate.opsForValue().setIfAbsent(usercode, null);
    }

    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            logger.error("getClaimsFromToken exception occurs: {}", e.getMessage());
            claims = null;
        }
        return claims;
    }

    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

    public Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    private Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset) {
        return (lastPasswordReset != null && created.before(lastPasswordReset));
    }

    public String generateToken(JWTInfo info) {
        Object old = redisTemplate.opsForValue().get(info.getUsercode());
        String token = "";
        if (old == null) {
            token = Jwts.builder()
                    .setSubject(info.getUsercode())
                    .claim(CommonConstants.JWT_KEY_USER_ID, info.getId())
                    .claim(CommonConstants.JWT_KEY_USERNAME, info.getUsername())
                    .claim(CommonConstants.JWT_KEY_DEPTCODE, info.getDeptcode())
                    .setExpiration(generateExpirationDate())
                    .signWith(SignatureAlgorithm.HS512, secret)
                    .compact();
            redisTemplate.opsForValue().set(info.getUsercode(), token, expiration, TimeUnit.SECONDS);
        } else {
            token = old.toString();
        }
        return token;
    }

    public Boolean canTokenBeRefreshed(String token, Date lastPasswordReset) {
        final Date created = getCreatedDateFromToken(token);
        return !isCreatedBeforeLastPasswordReset(created, lastPasswordReset)
                && !isTokenExpired(token);
    }

    public String refreshToken(String token) {
        String refreshedToken;
        try {
            final Claims claims = getClaimsFromToken(token);
            JWTInfo info=new JWTInfo(
                    StringHelper.getObjectValue(claims.get(CommonConstants.JWT_KEY_USERCODE)),
                    StringHelper.getObjectValue(claims.get(CommonConstants.JWT_KEY_USER_ID)),
                    StringHelper.getObjectValue(claims.get(CommonConstants.JWT_KEY_USERNAME)),
                    StringHelper.getObjectValue(claims.get(CommonConstants.JWT_KEY_DEPTCODE))
            );
            refreshedToken = generateToken(info);
        } catch (Exception e) {
            refreshedToken = null;
        }
        return refreshedToken;
    }


    public Boolean validateToken(String token, IJWTInfo info) {
        if (StringUtils.isBlank(token)) {
            return false;
        }
        Object existToken = redisTemplate.opsForValue().get(info.getUsercode());
        if (token.equals(existToken)) {
            final String usercode = getUsercodeFromToken(token);
            //final Date created = getCreatedDateFromToken(token);
            return (
                    usercode.equals(info.getUsercode())
                            && !isTokenExpired(token));
        } else {
            return false;
        }
    }

}
