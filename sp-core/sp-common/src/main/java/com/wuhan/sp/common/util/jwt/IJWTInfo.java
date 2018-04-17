package com.wuhan.sp.common.util.jwt;

/**
 * Created by ace on 2017/9/10.
 */
public interface IJWTInfo {
    /**
     * 获取用户名
     * @return
     */
    String getUsercode();

    /**
     * 获取用户ID
     * @return
     */
    String getId();

    /**
     * 获取名称
     * @return
     */
    String getUsername();

    /**
     * 获取机构
     * @return
     */
    String getDeptcode();
}
