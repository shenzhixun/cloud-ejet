package com.ejet.comm;

import com.ejet.comm.exception.CoBusinessException;
import com.ejet.comm.exception.ExceptionCode;

import java.io.Serializable;

/**
 * Copyright (C), 2016-2018, 武汉康华数海有限公司
 * FileName: Result
 * Author:   Ejet
 * CreateDate:     2018-09-25 8:47
 * Description: 返回结果信息
 * History:
 * Version: 1.0
 */
public class Result implements Serializable {
    /**
     * 返回码
     */
    protected String code = ExceptionCode.SUCCESS;
    /**
     * 提示信息
     */
    protected String msg = null;
    /**
     * 详细原因，调试用
     */
    protected String detail=null;
    /**
     * 数据对象
     */
    protected Object data = "";
    /**
     * 分页对象信息
     */
    protected Page page = null;
    /**
     * 默认返回正常，不需要提示信息
     */
    public Result() {

    }
    /**
     * 返回数据对象
     * @param data
     */
    public Result(Object data) {
        this.data = data;
    }

    /**
     * 返回数据对象
     * @param data
     */
    public Result(Page page, Object data) {
        this.page = page;
        this.data = data;
    }

    /**
     * 返回带返回码的异常数据对象
     * @param code
     * @param ex
     */
    public Result(String code, Throwable ex) {
        if(ex!=null) {
            if(ex instanceof CoBusinessException) {
                this.code = ((CoBusinessException)ex).getCode();
                this.msg = ((CoBusinessException)ex).getMsg();
                this.detail = ((CoBusinessException)ex).getDetail();
            } else {
                this.code = code;
                this.msg = ExceptionCode.getMessage(code);
                this.detail = ex.getMessage();
            }
        }
    }
    /**
     * 返回自定义异常
     * @param ex
     */
    public Result(CoBusinessException ex) {
        if(ex!=null) {
            this.code = ex.getCode();
            this.msg = ex.getMsg();
            this.detail = ex.getDetail();
        }
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
