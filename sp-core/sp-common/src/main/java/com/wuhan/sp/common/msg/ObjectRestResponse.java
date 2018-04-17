package com.wuhan.sp.common.msg;

/**
 * ${DESCRIPTION}
 *
 * @author admin
 * @create 2018-03
 */
public class ObjectRestResponse<T> extends BaseResponse {

    T data;

    public ObjectRestResponse data(T data) {
        this.setData(data);
        return this;
    }
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}
