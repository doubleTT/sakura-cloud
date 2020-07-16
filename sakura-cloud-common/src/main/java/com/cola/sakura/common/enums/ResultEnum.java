package com.cola.sakura.common.enums;

/**
 * @Author: liangyx
 * @License: (C) Copyright 2019-2020, liangyx Corporation Limited.
 * @Contact: Email: liangyingxing@gz.iscas.ac.cn
 * @Date: 2020/7/11 15:22
 * @Version: 1.0
 * @Description:
 */

public enum ResultEnum {
    /**
     * 成功
     */
    SUCCESS("200"),

    /**
     * 过期
     */
    EXPIRED("403"),

    /**
     * @Description: 重定向
     * @Author cola
     * @Date 2020/7/16 17:35
     **/
    REDIRECT("301"),

    /**
     * @Description: 参数错误
     * @Author cola
     * @Date 2020/7/16 19:02
     **/
    BAD_REQUEST("400"),

    /**
     * @Description: 资源未找到
     * @Author cola
     * @Date 2020/7/16 17:35
     **/
    NOT_FOUND("404"),

    /**
     * @Description: 服务器错误
     * @Author cola
     * @Date 2020/7/16 17:35
     **/
    ERROR("500"),
    ;

    private final String value;

    ResultEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
