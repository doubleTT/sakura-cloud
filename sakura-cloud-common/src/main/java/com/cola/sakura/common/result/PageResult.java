package com.cola.sakura.common.result;





import java.util.List;

/**
 * @Author: cola
 * @License: (C) Copyright 2019-2020, liangyx Corporation Limited.
 * @Contact: Email: cola_nsd@163.com
 * @Date: 2020/7/9 20:33
 * @Version: 1.0
 * @Description:
 */

public class PageResult<T> extends Result  {

    private List<T> data;

    private Long count;
    private Integer pageNumber;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }
}
