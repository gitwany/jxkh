package com.wuhan.sp.common.exception.auth;


import com.wuhan.sp.common.constant.CommonConstants;
import com.wuhan.sp.common.exception.BaseException;

/**
 * ${DESCRIPTION}
 *
 * @author admin
 * @create 2018-03
 */
public class ClientTokenException extends BaseException {
    public ClientTokenException(String message) {
        super(message, CommonConstants.EX_CLIENT_INVALID_CODE);
    }
}
