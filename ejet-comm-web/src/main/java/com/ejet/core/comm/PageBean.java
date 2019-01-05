package com.ejet.core.comm;

import com.github.pagehelper.Page;

import java.io.Serializable;
import java.util.List;

/**
 * 将Mybatis查询结果分页对象进行解析转换
 *
 * @param <T>
 */
public class PageBean<T> implements Serializable {
    @Override
    public String toString() {
        return "Data=" + result + ", page=" + (page==null ? "": page.toString());
    }

    private List<T> result; // 结果集

    private com.ejet.comm.Page page; //分页信息

    /**
     * 包装Page对象，因为直接返回Page对象，在JSON处理以及其他情况下会被当成List来处理， 而出现一些问题。
     */
    public PageBean(List<T> list) {
        if (list instanceof Page) {
            Page<T> page = (Page<T>) list;
            this.page = new com.ejet.comm.Page(page.getPageNum(), page.getPageSize());
            this.page.setPages(page.getPages());
            this.page.setTotal(page.getTotal());
            this.result = page.getResult();
        } else if(list!=null){
        	this.result = list;
        }
    }

    public List<T> getResult() {
        return result;
    }

    public com.ejet.comm.Page getPage() {
        return page;
    }
}
