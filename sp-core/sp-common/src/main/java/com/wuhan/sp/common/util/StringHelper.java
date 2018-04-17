package com.wuhan.sp.common.util;

/**
 * ${DESCRIPTION}
 *
 * @author admin
 * @create 2018-03
 */
public class StringHelper {
    public static String getObjectValue(Object obj){
        return obj==null?"":obj.toString();
    }
}
