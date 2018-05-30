package com.zackku.common.core;

import java.io.Serializable;

/**
 * @author Zack
 * @date 2018/5/25
 */
public class Response<T> implements Serializable {

    private static final long serialVersionUID = 2603825707575811116L;

    public static Response<?> SUCCESS = new Response<>(Constant.SUCCESS_CODE, Constant.SUCCESS_DESC, null);

    protected int code = Constant.SUCCESS_CODE;
    protected String msg = Constant.SUCCESS_DESC;
    protected T data;

    public Response() {

    }

    public Response(T data) {
        this.data = data;
    }

    public Response(int code, String msg) {
        this(code, msg, null);
    }

    public Response(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Response{");
        sb.append("code=").append(code);
        sb.append(", msg='").append(msg).append('\'');
        sb.append(", data=").append(data);
        sb.append('}');
        return sb.toString();
    }
}

