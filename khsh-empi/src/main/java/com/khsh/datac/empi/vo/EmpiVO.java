package com.khsh.datac.empi.vo;

import com.ejet.comm.utils.time.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
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

    //======== HIS关联信息 ======
    /**  患者id  */
    private java.lang.String patientId;
    /**  患者id  */
    private java.lang.String inpatientId;
    /**  就诊类型 1：门诊 2：住院  */
    private java.lang.Integer visitType;
    /**  就诊类型标志  */
    private java.lang.String visitTypeCode;
    /**  住院号、门诊号  */
    private java.lang.String inHospitalId;
    /**  入院时间  */
    @JsonFormat(pattern = DateUtil.PATTERN_DATETIME)
    @DateTimeFormat(pattern = DateUtil.PATTERN_DATETIME)
    private LocalDateTime inHospitalDate;
    /**  出院时间  */
    @JsonFormat(pattern = DateUtil.PATTERN_DATETIME)
    @DateTimeFormat(pattern = DateUtil.PATTERN_DATETIME)
    private LocalDateTime outHospitalDate;
    /**  入院次数  */
    private java.lang.Integer hospitalNum;
    /**  入院科室  */
    private java.lang.String inDeptName;
    /**  转出科室  */
    private java.lang.String outDeptName;
    /**  床位号  */
    private java.lang.String bedId;
    /**  诊断类别代码:门诊诊断、入院诊断、主要诊断、次要诊断等  */
    private java.lang.String diagCategCode;
    /**  诊断代码  */
    private java.lang.String diagCode;
    /**  诊断名称  */
    private java.lang.String diagName;
    /**  诊断依据  */
    private java.lang.String diagBasis;
    /**  诊断医生姓名  */
    private java.lang.String visitDoctorName;
    /**  诊断日期  */
    @JsonFormat(pattern = DateUtil.PATTERN_DATETIME)
    @DateTimeFormat(pattern = DateUtil.PATTERN_DATETIME)
    private LocalDateTime diagDate;
    /**  诊断描述  */
    private java.lang.String diagDesc;
    /**  诊断结果  */
    private java.lang.String diagResult;

    //======== 获取接口渠道标识channelId
    /**  渠道id  */
    private String channelId;
    /**  性别名称    */
    private String sexName;
    /**  军官证    */
    private String junguanCard;
    /** 驾驶证 */
    private String jiashiCard;
    /** 社保卡 */
    private String shebaoCard;

    /**
     * visitType传值转换使用
     */
    private String visitTypeName;


}
