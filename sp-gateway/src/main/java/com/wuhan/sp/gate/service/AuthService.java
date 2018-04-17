package com.wuhan.sp.gate.service;

import com.wuhan.sp.common.util.jwt.IJWTInfo;
import com.wuhan.sp.gate.security.JwtAuthenticationRequest;

public interface AuthService {
    String login(JwtAuthenticationRequest authenticationRequest) throws Exception;
    String refresh(String oldToken);
    void validate(String token) throws Exception;
    Boolean invalid(String token);
}