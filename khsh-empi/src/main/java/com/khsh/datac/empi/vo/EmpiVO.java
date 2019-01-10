package com.khsh.datac.empi.vo;

import com.khsh.datac.empi.model.PixEmpiModel;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2016-2019, 武汉康华数海有限公司
 * FileName: EmpiVO
 * Author:   ShenYijie
 * CreateDate:     2019-01-08 16:18
 * Description: empi对象信息
 * History:
 * Version: 1.0
 */
@Data
public class EmpiVO extends PixEmpiModel {
    /**
     * 身份唯一标识信息
     */
    private List<PixEmpiIdentityVO> identityList = new ArrayList<>();

    /**
     * 机构id(如果跨区域时，则为医院代号)
     */
    private String regCorpId;
    /**
     * 应用系统id
     */
    private String regSysId;
    /**
     * 身份证号
     */
    private String idCard;
    /**
     * 社保卡
     */
    private String shebaoCard;
    /**
     * 医保卡
     */
    private String yibaoCard;
    /**
     * 军官证号
     */
    private String junguanCard;

    /**
     * 就诊卡（院内）
     */
    private String jiuzhenCard;
    /**
     * 护照
     */
    private String huzhaoCard;
    /**
     * 驾驶证
     */
    private String jiashiCard;


    /**  患者id  */
    private String patientId;
    /**  in患者id  */
    private String patientInId;
    /**  是否主索引标志 1：是 2：否  */
    private Integer empiFlag;



    /**
     * 患者姓名
     */
    private String name;
    /**  性别 1：男 2：女  */
    private Integer sex;
    /**
     * 患者出生日期
     */
    private String birthday;
    /**
     * 患者联系方式
     */
    private String phone;
    /**
     * 患者国别
     */
    private String country;
    /**
     * 患者民族
     */
    private String nation;
    /**  文化程度  */
    private String eduDegree;
    /**  职业  */
    private String job;
    /**  邮箱  */
    private String email;
    /**  婚姻状况  */
    private String marriageState;



}
