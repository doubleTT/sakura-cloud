package com.cola.sakura.common.enums;

/**
 * @Author: liangyx
 * @License: (C) Copyright 2019-2020, liangyx Corporation Limited.
 * @Contact: Email: liangyingxing@gz.iscas.ac.cn
 * @Date: 2020/7/9 20:34
 * @Version: 1.0
 * @Description:
 */

public enum  StatusEnum {
    /**
     * 正常
     */
    NORMAL(0),
    /**
     * 删除
     */
    DELETE(1);

    private final Integer value;

    StatusEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

}
