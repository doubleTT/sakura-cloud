package com.cola.sakura.common.util;

import com.cola.sakura.common.enums.ResultEnum;
import com.cola.sakura.common.result.DataResult;

/**
 * @Author: cola
 * @License: (C) Copyright 2019-2020, liangyx Corporation Limited.
 * @Contact: Email: cola_nsd@163.com
 * @Date: 2020/7/16 18:55
 * @Version: 1.0
 * @Description:
 */

public class DataResultUtil {

    public static <T> DataResult<T> success() {
        DataResult<T> result = new DataResult<T>();
        result.setCode(ResultEnum.SUCCESS.getValue());
        result.setMessage(ResultEnum.SUCCESS.name());
        result.setData(null);
        return result;
    }

    public static <T> DataResult<T> success(T data) {
        DataResult<T> result = new DataResult<T>();
        result.setCode(ResultEnum.SUCCESS.getValue());
        result.setMessage(ResultEnum.SUCCESS.name());
        result.setData(data);
        return result;
    }

    public static <T> DataResult<T> error(String code, String message) {
        DataResult<T> result = new DataResult<T>();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static <T> DataResult<T> error(String message) {
        DataResult<T> result = new DataResult<T>();
        result.setCode(ResultEnum.ERROR.getValue());
        result.setMessage(message);
        return result;
    }

}
