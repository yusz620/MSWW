package com.msww.ms.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MSWWJsonResult {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private Integer status;
    private String msg;
    private Object data;
    private String ok;

    public MSWWJsonResult(Integer status, String msg, Object data) {
        super();
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public static MSWWJsonResult build(Integer status, String msg, Object data) {
        return new MSWWJsonResult(status, msg, data);
    }

    public MSWWJsonResult(Object data) {
        this.data = data;
    }

    public static MSWWJsonResult errorMsg(String msg) {
        return new MSWWJsonResult(500, msg, null);
    }

    public static MSWWJsonResult errorMap(Object data) {
        return new MSWWJsonResult(501, "error", data);
    }

    public static MSWWJsonResult errorTokenMsg(String msg) {
        return new MSWWJsonResult(502, msg, null);
    }

    public static MSWWJsonResult errorException(String msg) {
        return new MSWWJsonResult(555, msg, null);
    }

    public static MSWWJsonResult ok(Object data) {
        return new MSWWJsonResult(200, "success", data, "OK");
    }

    public MSWWJsonResult(Integer status, String msg, Object data, String ok) {
        super();
        this.status = status;
        this.msg = msg;
        this.data = data;
        this.ok = ok;
    }

    public static MSWWJsonResult ok() {
        return new MSWWJsonResult(null);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }


}
