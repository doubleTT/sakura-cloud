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
     * 失败
     */
    FAIL("-1") ,
    /**
     * 未登录
     */
    NO_LOGIN("999");

    private final String value;

    ResultEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
