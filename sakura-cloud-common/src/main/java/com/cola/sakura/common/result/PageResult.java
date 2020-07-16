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

    /**
     * 包装Page对象，因为直接返回Page对象，在JSON处理以及其他情况下会被当成List来处理，
     * 而出现一些问题。
     * @param data          page结果
     * @param
     */
//    public PageResult(List<T> list) {
//        if (list instanceof Page) {
//            Page<T> page = (Page<T>) list;
//            this.count = page.getTotal();
//            this.page = page.getPageNum();
//            this.data = page;
//        }
//    }

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
