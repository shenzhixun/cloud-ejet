package com.ejet.comm.base;

import java.io.Serializable;

/**
 * Copyright (C), 2016-2018, 武汉康华数海有限公司
 * FileName: CoBaseVO
 * Author:   Ejet
 * CreateDate:     2018-09-04 14:46
 * Description: model基类
 * History:
 * Version: 1.0
 */
public class CoBaseVO implements Serializable {
    /**  修改时间  */
    private String updateTime;
    /**  创建时间  */
    private String createTime;
    /**  修改人  */
    private String modifyBy;
    /**  创建人  */
    private String createBy;
    /**
     * 扩展排序
     */
    private String orderCond;
    /**
     * 扩展SQL语句
     */
    private String extSQL;

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getOrderCond() {
        return orderCond;
    }

    public void setOrderCond(String orderCond) {
        this.orderCond = orderCond;
    }

    public String getExtSQL() {
        return extSQL;
    }

    public void setExtSQL(String extSQL) {
        this.extSQL = extSQL;
    }
}
