package com.spring.cloud.base;

import lombok.Data;

/**
 * 本地没有安装Lombok插件
 * @param <T>
 */
//@Data
public class Result<T> {
    private Integer code;

    private String msg;

    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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
}
