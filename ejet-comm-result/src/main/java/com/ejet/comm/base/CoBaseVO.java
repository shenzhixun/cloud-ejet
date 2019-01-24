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
    private String modifyTime;
    /**  修改人  */
    private String modifyUser;
    /**
     * 扩展排序
     */
    private String orderCond;
    /**
     * 扩展SQL语句
     */
    private String extSQL;

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
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
