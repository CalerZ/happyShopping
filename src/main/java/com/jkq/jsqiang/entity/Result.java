package com.jkq.jsqiang.entity;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author Caler_赵康乐
 * @create 2020-02-10 19:01
 * @description :返回结果json
 */

public class Result implements Serializable {
    private Boolean res;
    private String msg;
    private Object data;
    private Integer code;


    public Result() {
    }

    public Result(Boolean res, String msg, Object data, Integer code) {
        this.res = res;
        this.msg = msg;
        this.data = data;
        this.code = code;
    }

    public Boolean getRes() {
        return res;
    }

    public void setRes(Boolean res) {
        this.res = res;
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

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Result{" +
                "res=" + res +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", code=" + code +
                '}';
    }
}
