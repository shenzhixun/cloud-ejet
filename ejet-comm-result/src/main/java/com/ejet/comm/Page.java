package com.ejet.comm;

import java.io.Serializable;

/**
 * Copyright (C), 2016-2018, 武汉康华数海有限公司
 * FileName: Page
 * Author:   Ejet
 * CreateDate:     2018-09-25 8:48
 * Description: 分页对象
 * History:
 * Version: 1.0
 */
public class Page implements Serializable {
    /**
     * 总记录数
     */
    private long total;
    /**
     * 当前页码
     */
    private int pageNum = 1;
    /**
     * 每页记录数
     */
    private int pageSize = 20;
    /**
     * 总页数
     */
    private int pages;

    public Page() {

    }

    public Page(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public Page(int pageNum, int pageSize, int pages, long total) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.pages = pages;
        this.total = total;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Page{" +
                "total=" + total +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", pages=" + pages +
                '}';
    }
}
