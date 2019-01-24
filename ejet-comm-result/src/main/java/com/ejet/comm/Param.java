package com.ejet.comm;

import java.io.Serializable;

/**
 * Copyright (C), 2016-2018, 武汉康华数海有限公司
 * FileName: Result
 * Author:   Ejet
 * CreateDate:     2018-09-25 8:47
 * Description: 请求参数信息
 * History:
 * Version: 1.0
 */
public class Param<T> implements Serializable {
    /**
     * 数据对象
     */
    protected T data = null;
    /**
     * 分页对象信息
     */
    protected Page page = null;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
