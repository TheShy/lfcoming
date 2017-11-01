package com.zwtx.swing.lfcoming.MVP.Entity;

/**
 * Created by Administrator on 2016/11/14.
 */

public class HttpResult<T> {

    public String msg;
    public int code;
    public T data;

    public HttpResult(String msg, int code, T data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public String msg() {
        return msg;
    }

    public void msg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
