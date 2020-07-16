package com.cola.sakura.common.criteria;

import com.cola.sakura.common.constant.Constant;

/**
 * @Author: cola
 * @License: (C) Copyright 2019-2020, liangyx Corporation Limited.
 * @Contact: Email: cola_nsd@163.com
 * @Date: 2020/7/9 20:33
 * @Version: 1.0
 * @Description:
 */

public class AbstractBaseCriteria {

    private Integer pageNumber;

    private Integer pageSize;

    public AbstractBaseCriteria() {
        this.pageNumber = Constant.PAGE_NUM_DEFAULT;
        this.pageSize = Constant.PAGE_SIZE_DEFAULT;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
