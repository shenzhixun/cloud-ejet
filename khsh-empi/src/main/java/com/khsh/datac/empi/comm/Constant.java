package com.khsh.datac.empi.comm;

import com.ejet.comm.utils.des.MD5;

/**
 * Copyright (C), 2016-2019, 武汉康华数海有限公司
 * FileName: Constant
 * Author:   ShenYijie
 * CreateDate:     2019-01-09 21:59
 * Description:
 * History:
 * Version: 1.0
 */
public class Constant {

    /** 性别 男 */
    public static final Integer SEX_MAIL = 1;
    /** 性别 女 */
    public static final Integer SEX_FEMAIL = 2;

    /** 主索引唯一标识： 1： 生效 0：未生效*/
    public static final Integer EMPI_FLAG_ENABLE = 1;
    /** 主索引唯一标识： 1： 生效 0：未生效*/
    public static final Integer EMPI_FLAG_DISABLE = 0;

    public static final String DEFAULT_PASSWORD = MD5.getMD5("123456");

    /** 渠道ID (电子病历)    */
    public static final String CHANNEL_EMR = "emr";


    public static final Integer REL_FLAG_MAIN = 1;

    public static final Integer REL_FLAG_NOTMAIN = 2;


}
