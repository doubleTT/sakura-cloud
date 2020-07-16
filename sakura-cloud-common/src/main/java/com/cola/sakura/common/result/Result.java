package com.cola.sakura.common.result;


import com.cola.sakura.common.enums.ResultEnum;

/**
 * @Author: cola
 * @License: (C) Copyright 2019-2020, liangyx Corporation Limited.
 * @Contact: Email: cola_nsd@163.com
 * @Date: 2020/7/9 20:33
 * @Version: 1.0
 * @Description:
 */
public class Result {
    /**
     * 编号
     */
    private String code;
    /**
     * 消息内容
     */
    private String message;

    public Result() {
        this.code = ResultEnum.SUCCESS.getValue();
        this.message = ResultEnum.SUCCESS.name();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static com.cola.sakura.common.result.Result success(String message) {
        com.cola.sakura.common.result.Result result = new com.cola.sakura.common.result.Result();
        result.setCode(ResultEnum.SUCCESS.getValue());
        result.setMessage(message==null? ResultEnum.SUCCESS.name():message);
        return result;
    }

    public static com.cola.sakura.common.result.Result fail(String message) {
        com.cola.sakura.common.result.Result result = new com.cola.sakura.common.result.Result();
        result.setCode(ResultEnum.ERROR.getValue());
        result.setMessage(message);
        return result;
    }

    public static com.cola.sakura.common.result.Result fail(String code, String message) {
        com.cola.sakura.common.result.Result result = new com.cola.sakura.common.result.Result();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }
}
