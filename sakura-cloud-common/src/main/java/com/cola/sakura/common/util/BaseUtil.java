package com.cola.sakura.common.util;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.lang.Assert;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.file.CopyOption;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: cola
 * @License: (C) Copyright 2019-2020, liangyx Corporation Limited.
 * @Contact: Email: cola_nsd@163.com
 * @Date: 2020/7/9 20:33
 * @Version: 1.0
 * @Description:
 */
public class BaseUtil {

    private static final Log logger = LogFactory.get();

    private static String[] ignoreProperties = {"id", "ownerId", "ownerName", "objectCreateTime", "objectModifierId", "objectModifierName","objectModificationTime","dataSource","status"};

    /**
     * @Description: 复制列表元素
     * @Author cola
     * @Date 2020/7/16 17:19
     **/
    public static <T> List<T> copyList(List<?> source, Class<T> clazz) {
        if (source == null || source.size() == 0) {
            return new ArrayList<>();
        }
        List<T> res = new ArrayList<T>(source.size());
        for (Object o : source) {
            try {
                T t = clazz.newInstance();
                res.add(t);
                BeanUtil.copyProperties(o, t);
            } catch (Exception e) {
                logger.error("copyList error", e);
            }
        }
        return res;
    }

    /**
     * @Description: 复制属性
     * @Author cola
     * @Date 2020/7/16 17:19
     **/
    public static <T> T copyProperties(Object source, Class<T> clazz) {
        T t = null;
        try {
            t = clazz.newInstance();
            BeanUtil.copyProperties(source, t);
        } catch (Exception e){
            logger.error("copyBean error", e);
        }
        return t;
    }

    /**
     * @Description: 复制属性，忽略指定属性
     * @Author cola
     * @Date 2020/7/16 17:19
     **/
    public static <T> T copyProperties(Object source, Class<T> clazz, String... ignoreProperties) {
        T t = null;
        try {
            t = clazz.newInstance();
            BeanUtil.copyProperties(source, t, ignoreProperties);
        } catch (Exception e){
            logger.error("copyBean error", e);
        }
        return t;
    }

    /**
     * @Description: 复制属性
     * @Author cola
     * @Date 2020/7/16 17:19
     **/
    public static void copyProperties(Object source, Object t) {
        try {
            BeanUtil.copyProperties(source, t);
        } catch (Exception e){
            logger.error("copyBean error", e);
        }
    }

    /**
     * @Description: 复制属性，忽略指定属性
     * @Author cola
     * @Date 2020/7/16 17:19
     **/
    public static void copyProperties(Object source, Object t, String... ignoreProperties) {
        try {
            BeanUtil.copyProperties(source, t, ignoreProperties);
        } catch (Exception e){
            logger.error("copyBean error", e);
        }
    }

    /**
     * @Description: 复制属性，忽略空值
     * @Author cola
     * @Date 2020/7/16 17:19
     **/
    public static void copyIgnoreNull(Object source, Object target) {
        try {
            BeanUtil.copyProperties(source,target,CopyOptions.create().setIgnoreNullValue(true));
        } catch (Exception e){
            logger.error("copyBean error", e);
        }
    }
    /**
     * @Description: 复制属性，忽略空值
     * @Author cola
     * @Date 2020/7/16 17:19
     **/
    public static <T> T copyIgnoreNull(Object source, Class<T> clazz) {
        T t = null;
        try {
            t = clazz.newInstance();
            BeanUtil.copyProperties(source,t,CopyOptions.create().setIgnoreNullValue(true));
        } catch (Exception e){
            logger.error("copyBean error", e);
        }
        return t;
    }

}
