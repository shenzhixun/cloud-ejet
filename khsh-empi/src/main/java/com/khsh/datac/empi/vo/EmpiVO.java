package com.khsh.datac.empi.vo;

import lombok.Data;

import java.io.Serializable;
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
public class EmpiVO extends PixEmpiRegisterVO implements Serializable {
    /**
     * 身份唯一标识信息
     */
    private List<PixEmpiIdentityVO> identityList = new ArrayList<>();
    /**
     * 社保卡
     */
    private String shebaoCard;
    /**
     * 军官证号
     */
    private String junguanCard;
    /**
     * 驾驶证
     */
    private String jiashiCard;
    //============ 扩展信息=====
    /**  国家  */
    private String country;
    /**  民族  */
    private String nation;
    /**  文化程度  */
    private String eduDegree;
    /**  职业  */
    private String job;
    /**  婚姻状况  */
    private String marriageState;
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
    /**  邮政编码  */
    private String zipCode;
    /**  邮箱  */
    private String email;
    /**  工作单位  */
    private String workDept;
    /**  工作单位地址  */
    private String workAddress;

    //============ 联系人信息
    /**  与患者关系 1:本人   */
    private String relation;
    /**  联系人 姓名  */
    private String relName;
    /**  联系人 名字拼音  */
    private String relNamePin;
    /**  联系人 性别 1：男 2：女  */
    private Integer relSex;
    /**  联系人 电话  */
    private String relPhone;
    /**  联系人 省  */
    private String relAddrProvince;
    /**  联系人 地市  */
    private String relAddrCity;
    /**  联系人 区域（县）  */
    private String relAddrArea;
    /**  联系人 详细地址  */
    private String relAddrDetail;
    /**  邮政编码  */
    private String relZipCode;

    //======== 获取接口渠道标识channelId
    /**  渠道id  */
    private String channelId;

    /** 入院日期  */
    private String inHospitalDate;
    /**  床位号  */
    private String bedId;
    /** 入院科室 */
    private String inDeptName;
    /**
     * 住院号
     */
    private String inHospitalId;


}
