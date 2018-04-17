package com.wuhan.sp.common.util.jwt;

import java.io.Serializable;

/**
 * Created by ace on 2017/9/10.
 */
public class JWTInfo implements Serializable,IJWTInfo {
    private String usercode;
    private String userId;
    private String username;
    private String deptcode;

    public JWTInfo(String usercode, String userId, String username, String deptcode) {
        this.usercode = usercode;
        this.userId = userId;
        this.username = username;
        this.deptcode = deptcode;
    }

    @Override
    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    @Override
    public String getDeptcode() {
        return deptcode;
    }

    public void setDeptcode(String deptcode) {
        this.deptcode = deptcode;
    }

    @Override
    public String getId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        JWTInfo jwtInfo = (JWTInfo) o;

        if (usercode != null ? !usercode.equals(jwtInfo.usercode) : jwtInfo.usercode != null) {
            return false;
        }
        return userId != null ? userId.equals(jwtInfo.userId) : jwtInfo.userId == null;

    }

    @Override
    public int hashCode() {
        int result = usercode != null ? usercode.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }
}
