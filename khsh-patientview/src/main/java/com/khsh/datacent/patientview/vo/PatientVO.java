package com.khsh.datacent.patientview.vo;

import com.khsh.datacent.patientview.model.PixEmpiHisRModel;
import lombok.Data;

/**
 * Copyright (C), 2016-2019, 武汉康华数海有限公司
 * FileName: PatientVO
 * Author:   ShenYijie
 * CreateDate:     2019-01-26 16:12
 * Description:
 * History:
 * Version: 1.0
 */
@Data
public class PatientVO extends PixEmpiHisRModel {

    /**  患者姓名  */
    private java.lang.String name;
    /**  名字拼音  */
    private java.lang.String namePin;
    /**  性别 1：男 2：女  */
    private java.lang.Integer sex;
    /**  年龄  */
    private java.lang.Integer age;
    /**  出生日期yyyy.MM.dd  */
    private java.lang.String birthday;
    /**    */
    private java.lang.String address;
    /**  身份证  */
    private java.lang.String idCard;
    /**  医保卡  */
    private java.lang.String yibaoCard;
    /**  医保卡名称  */
    private java.lang.String yibaoCardName;
    /**  患者id  */
    private java.lang.String patientId;

    /**  民族  */
    private java.lang.String nation;
    /**  民族  */
    private java.lang.String nationName;
    /**  婚姻状况  */
    private java.lang.String marriageState;
    /**  婚姻状况  */
    private java.lang.String marriageStateName;
    /**  联系电话  */
    private java.lang.String phone;
    /**  联系人 详细地址  */
    private java.lang.String addrDetail;






}
