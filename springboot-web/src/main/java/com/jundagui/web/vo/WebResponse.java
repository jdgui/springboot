package com.jundagui.web.vo;

import java.util.Objects;

public class WebResponse<T> {
    private Integer status;
    private String message;
    private T data;

    public static WebResponse<Void> success() {
        //链式调用
        return new WebResponse<Void>().setStatus(0).setMessage("");
    }

    public static <T> WebResponse<T> success(T data) {
        Objects.requireNonNull(data);
        return new WebResponse<T>().setStatus(0).setMessage("").setData(data);
    }

    public static WebResponse<Void> fail(Integer status, String message) {
        Objects.requireNonNull(status);
        Objects.requireNonNull(message);
        return new WebResponse<Void>().setStatus(status).setMessage(message);
    }

    public Integer getStatus() {
        return status;
    }

    public WebResponse<T> setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public WebResponse<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public WebResponse<T> setData(T data) {
        this.data = data;
        return this;
    }
}
