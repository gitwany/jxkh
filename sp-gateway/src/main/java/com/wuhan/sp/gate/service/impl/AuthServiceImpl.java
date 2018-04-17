package com.wuhan.sp.gate.service.impl;

import com.wuhan.sp.common.exception.BaseException;
import com.wuhan.sp.common.util.jwt.IJWTInfo;
import com.wuhan.sp.common.util.jwt.JWTInfo;
import com.wuhan.sp.common.vo.UserInfo;
import com.wuhan.sp.gate.feign.IUserService;
import com.wuhan.sp.gate.security.JwtAuthenticationRequest;
import com.wuhan.sp.gate.security.JwtTokenUtil;
import com.wuhan.sp.gate.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class AuthServiceImpl implements AuthService {

    private JwtTokenUtil jwtTokenUtil;
    private IUserService userService;

    @Autowired
    public AuthServiceImpl(
            JwtTokenUtil jwtTokenUtil,
            IUserService userService) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.userService = userService;
    }

    @Override
    public String login(JwtAuthenticationRequest authenticationRequest) throws Exception {
        UserInfo info = userService.validate(authenticationRequest.getUsercode(),authenticationRequest.getPassword());
        if(info==null || info.getUsercode()==null)
        {
            throw new BaseException("用户名或者密码错误");
        }
        String token = "";
        if (!StringUtils.isEmpty(info.getId())) {
            token = jwtTokenUtil.generateToken(new JWTInfo(info.getUsercode(), info.getId() + "", info.getUsername(), info.getDeptcode()));
        }
        return token;
    }

    @Override
    public void validate(String token) throws Exception {
        jwtTokenUtil.getUsercodeFromToken(token);
    }



    @Override
    public Boolean invalid(String token) {
        return jwtTokenUtil.invalid(token);
    }

    @Override
    public String refresh(String oldToken) {
        return jwtTokenUtil.refreshToken(oldToken);
    }
}