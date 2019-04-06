package com.ejet.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Copyright (C), 2016-2019, 武汉康华数海有限公司
 * FileName: PatientVisitModel
 * Author:   ShenYijie
 * CreateDate:     2019-01-27 14:13
 * Description:
 * History:
 * Version: 1.0
 */
@Data
public class PatientModel implements Serializable {

    private String empi;
    /** 姓名 */
    private String name;
    //性别
    //@DicData(DicUserConstant.SEX)
    private String sex;
    /**  出生日期yyyy.MM.dd  */
    private String birthday;
    /**  身份证  */
    private String idCard;
    /**  年龄  */
    private Integer age;

    /**  国家  */
    private String countryName;
    /**  民族  */
    private String nationName;
    /**  文化程度  */
    private String eduDegree;
    /**  职业  */
    private String jobName;
    /**  婚姻状况  */
    private String marriageStateName;
    /**  联系电话  */
    private String phone;
    /**  联系人 省  */
    private String addrProvince;
    /**  联系人 地市  */
    private String addrCity;
    /**  联系人 区域（县）  */
    private String addrArea;
    /**  联系人 详细地址  */
    private String addrDetail;


}
