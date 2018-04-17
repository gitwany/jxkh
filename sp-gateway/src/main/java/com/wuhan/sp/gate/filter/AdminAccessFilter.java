package com.wuhan.sp.gate.filter;

import com.alibaba.fastjson.JSON;
import com.wuhan.sp.common.context.BaseContextHandler;
import com.wuhan.sp.common.exception.BaseException;
import com.wuhan.sp.common.msg.auth.TokenErrorResponse;
import com.wuhan.sp.common.msg.auth.TokenForbiddenResponse;
import com.wuhan.sp.common.util.ClientUtil;
import com.wuhan.sp.common.util.jwt.IJWTInfo;
import com.wuhan.sp.common.vo.LogInfo;
import com.wuhan.sp.common.vo.PermissionInfo;
import com.wuhan.sp.gate.feign.ILogService;
import com.wuhan.sp.gate.feign.IUserService;
import com.wuhan.sp.gate.security.JwtTokenUtil;
import com.wuhan.sp.gate.utils.DBLog;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * ${DESCRIPTION}
 *
 * @author admin
 * @create 2018-03
 */
@Component
@Slf4j
public class AdminAccessFilter extends ZuulFilter {
    @Autowired
    @Lazy
    private IUserService userService;
    @Autowired
    @Lazy
    private ILogService logService;

    @Value("${gate.ignore.startWith}")
    private String startWith;

    @Value("${zuul.prefix}")
    private String zuulPrefix;

    @Value("${jwt.token-header}")
    private String tokenHeader;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        final String requestUri = request.getRequestURI().substring(zuulPrefix.length());
        final String method = request.getMethod();
        BaseContextHandler.setToken(null);
        // 不进行拦截的地址
        if (isStartWith(requestUri)) {
            return null;
        }

        String authToken = request.getHeader(tokenHeader);
        if (StringUtils.isBlank(authToken)) {
            authToken = request.getParameter("token");
        }
        ctx.addZuulRequestHeader(tokenHeader, authToken);
        BaseContextHandler.setToken(authToken);

        IJWTInfo user = null;
        try {
            if(authToken==null || authToken.isEmpty())
            {
                throw new Exception("令牌失效，请重新登陆");
            }
            user = getJWTUser(authToken);
            boolean bSuc=jwtTokenUtil.validateToken(authToken,user);
            if(!bSuc)
            {
                throw new Exception("令牌失效，请重新登陆");
            }
        } catch (Exception e) {
            setFailedRequest(JSON.toJSONString(new TokenErrorResponse(e.getMessage())), 200);
            return null;
        }

        /*
        List<PermissionInfo> permissionIfs = userService.getAllPermissionInfo();
        // 判断资源是否启用权限约束
        Stream<PermissionInfo> stream = getPermissionIfs(requestUri, method, permissionIfs);
        List<PermissionInfo> result = stream.collect(Collectors.toList());
        PermissionInfo[] permissions = result.toArray(new PermissionInfo[]{});
        if (permissions.length > 0) {
            checkUserPermission(permissions, ctx, user);
        }
        */
        return null;
    }

    /**
     * 获取目标权限资源
     *
     * @param requestUri
     * @param method
     * @param serviceInfo
     * @return
     */
    private Stream<PermissionInfo> getPermissionIfs(final String requestUri, final String method, List<PermissionInfo> serviceInfo) {
        return serviceInfo.parallelStream().filter(new Predicate<PermissionInfo>() {
            @Override
            public boolean test(PermissionInfo permissionInfo) {
                String url = permissionInfo.getUri();
                String uri = url.replaceAll("\\{\\*\\}", "[a-zA-Z\\\\d]+");
                String regEx = "^" + uri + "$";
                return (Pattern.compile(regEx).matcher(requestUri).find() || requestUri.startsWith(url + "/"))
                        && method.equals(permissionInfo.getMethod());
            }
        });
    }

    private void setCurrentUserInfoAndLog(RequestContext ctx, IJWTInfo user, PermissionInfo pm) {
        String host = ClientUtil.getClientIp(ctx.getRequest());
        ctx.addZuulRequestHeader("userId", user.getId());
        ctx.addZuulRequestHeader("userName", URLEncoder.encode(user.getUsername()));
        ctx.addZuulRequestHeader("userHost", ClientUtil.getClientIp(ctx.getRequest()));
        LogInfo logInfo = new LogInfo(pm.getMenu(), pm.getName(), pm.getUri(), new Date(), user.getId(), user.getUsername(), host);
        DBLog.getInstance().setLogService(logService).offerQueue(logInfo);
    }

    /**
     * 返回session中的用户信息
     *
     * @param request
     * @param ctx
     * @return
     */
    private IJWTInfo getJWTUser(HttpServletRequest request, RequestContext ctx) throws Exception {
        String authToken = request.getHeader(tokenHeader);
        if (StringUtils.isBlank(authToken)) {
            authToken = request.getParameter("token");
        }
        ctx.addZuulRequestHeader(tokenHeader, authToken);
        BaseContextHandler.setToken(authToken);
        return jwtTokenUtil.getInfoFromToken(authToken);
    }

    /**
     * 返回session中的用户信息
     *
     * @return
     */
    private IJWTInfo getJWTUser(String authToken) throws Exception {
        return jwtTokenUtil.getInfoFromToken(authToken);
    }

    private void checkUserPermission(PermissionInfo[] permissions, RequestContext ctx, IJWTInfo user) {
        List<PermissionInfo> permissionInfos = userService.getPermissionByUsercode(user.getUsercode());
        PermissionInfo current = null;
        for (PermissionInfo info : permissions) {
            boolean anyMatch = permissionInfos.parallelStream().anyMatch(new Predicate<PermissionInfo>() {
                @Override
                public boolean test(PermissionInfo permissionInfo) {
                    return permissionInfo.getCode().equals(info.getCode());
                }
            });
            if (anyMatch) {
                current = info;
                break;
            }
        }
        if (current == null) {
            setFailedRequest(JSON.toJSONString(new TokenForbiddenResponse("Token Forbidden!")), 200);
        } else {
            if (!RequestMethod.GET.toString().equals(current.getMethod())) {
                setCurrentUserInfoAndLog(ctx, user, current);
            }
        }
    }


    /**
     * URI是否以什么打头
     *
     * @param requestUri
     * @return
     */
    private boolean isStartWith(String requestUri) {
        boolean flag = false;
        for (String s : startWith.split(",")) {
            if (requestUri.startsWith(s)) {
                return true;
            }
        }
        return flag;
    }

    /**
     * 网关抛异常
     *
     * @param body
     * @param code
     */
    private void setFailedRequest(String body, int code) {
        log.debug("Reporting error ({}): {}", code, body);
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.setResponseStatusCode(code);
        if (ctx.getResponseBody() == null) {
            ctx.addZuulResponseHeader("Content-Type", "text/html; charset=UTF-8");
            ctx.setResponseBody(body);
            ctx.setSendZuulResponse(false);
        }
    }

}
