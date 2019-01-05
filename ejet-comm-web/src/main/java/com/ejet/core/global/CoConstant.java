package com.ejet.core.global;

/**
 * Copyright (C), 2016-2018, 武汉康华数海有限公司
 * FileName: CoConstant
 * Author:   Ejet
 * CreateDate:     2018-09-30 15:01
 * Description: 全局公共常量
 * History:
 * Version: 1.0
 */
public final class CoConstant {

    private CoConstant(){}
    /**
     * 正常状态
     */
    public static final Integer STATUS_NORMAL = 1;
    /**
     * 禁用状态
     */
    public static final Integer STATUS_UNNORMAL = 0;
    /**
     * 设置事务超时时间(秒)
     */
    public static int TRANSACTION_TIME_OUT = 3600;



    public static final String FILTER_NAME_CROS = "CROS";

    public static final String FILTER_NAME_SESSION = "SESSION";


    //spring boot 会按照order值的大小，从小到大的顺序来依次过滤。
    public static final int FILTER_ORDER_CROS = Integer.MAX_VALUE-1;
    public static final int FILTER_ORDER_SESSION = Integer.MAX_VALUE;



}
