package com.wuhan.sp.common.exception;

/**
 * ${DESCRIPTION}
 *
 * @author admin
 * @create 2018-03
 */
public class BaseException extends RuntimeException {
    private int status = 200;
    private String data = "";
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


    public BaseException() {
    }

    public BaseException(String message,int status) {
        super(message);
        this.status = status;
        this.data = "";
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
