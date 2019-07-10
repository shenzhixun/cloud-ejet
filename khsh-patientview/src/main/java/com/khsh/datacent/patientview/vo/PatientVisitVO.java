package com.khsh.datacent.patientview.vo;

import com.khsh.datacent.patientview.model.PatientVisitModel;
import lombok.Data;

/**
 * Copyright (C), 2016-2019, 武汉康华数海有限公司
 * FileName: PatientVisitVO
 * Author:   ShenYijie
 * CreateDate:     2019-01-26 16:29
 * Description: 患者就诊、住院信息
 * History:
 * Version: 1.0
 */
@Data
public class PatientVisitVO extends PatientVisitModel {

    private String empi;
    /** 姓名 */
    private String name;
    //性别
    //@DicData(DicUserConstant.SEX)
    private String sexName;
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
