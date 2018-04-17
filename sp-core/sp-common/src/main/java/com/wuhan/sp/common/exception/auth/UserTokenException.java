package com.wuhan.sp.common.exception.auth;


import com.wuhan.sp.common.constant.CommonConstants;
import com.wuhan.sp.common.exception.BaseException;

/**
 * ${DESCRIPTION}
 *
 * @author admin
 * @create 2018-03
 */
public class UserTokenException extends BaseException {
    public UserTokenException(String message) {
        super(message, CommonConstants.EX_USER_INVALID_CODE);
    }
}
