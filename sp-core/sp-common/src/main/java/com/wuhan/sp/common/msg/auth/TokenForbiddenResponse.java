package com.wuhan.sp.common.msg.auth;

import com.wuhan.sp.common.constant.RestCodeConstants;
import com.wuhan.sp.common.msg.BaseResponse;

/**
 * ${DESCRIPTION}
 *
 * @author admin
 * @create 2018-03
 */
public class TokenForbiddenResponse  extends BaseResponse {
    public TokenForbiddenResponse(String message) {
        super(RestCodeConstants.TOKEN_FORBIDDEN_CODE, message);
    }
}
