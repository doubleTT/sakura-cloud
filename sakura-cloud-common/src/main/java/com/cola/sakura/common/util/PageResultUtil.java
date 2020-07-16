package com.cola.sakura.common.util;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.cola.sakura.common.enums.ResultEnum;
import com.cola.sakura.common.result.PageResult;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: cola
 * @License: (C) Copyright 2019-2020, liangyx Corporation Limited.
 * @Contact: Email: cola_nsd@163.com
 * @Date: 2020/7/16 18:56
 * @Version: 1.0
 * @Description:
 */

public class PageResultUtil {

    private static final Log logger = LogFactory.get();

    private PageResultUtil() { }

    public static <T> PageResult<T> success(PageResult<T> page){
        return page;
    }

    public static <T> PageResult<T> transform(PageResult<?> page, Class<T> classType) {
        PageResult<T> pb = new PageResult<T>();
        try {
            pb.setData(copyList(page.getData(), classType));
        } catch (Exception e) {
            logger.error("transform error", e);
        }
        pb.setPageNumber(page.getPageNumber());
        pb.setCount(page.getCount());
        return pb;
    }
    /**
     * @param source
     * @param clazz
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static <T> List<T> copyList(List<?> source, Class<T> clazz) {
        if (source == null || source.size() == 0) {
            return new ArrayList<T>();
        }
        List<T> res = new ArrayList<T>(source.size());
        for (Object o : source) {
            try {
                T t = clazz.newInstance();
                res.add(t);
                BeanUtils.copyProperties(o, t);
            } catch (Exception e) {
                logger.error("copyList error", e);
            }
        }
        return res;
    }

}
