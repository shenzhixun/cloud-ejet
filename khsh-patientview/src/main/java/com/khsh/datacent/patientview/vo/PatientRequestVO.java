package com.khsh.datacent.patientview.vo;

import lombok.Data;

import java.util.HashSet;
import java.util.List;

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
public class PatientRequestVO extends PatientVO {
    /**
     * 性别名称
     */
    private String sexName;
    /**
     * 就诊类型
     */
    private String visitTypeName;

    /**  患者查询关键字（姓名，住院号，或者门诊号，手机号，身份证号） */
    private String queryKeywords;
    /**  就诊开始时间 */
    private String inHospitalStartTime;
    /** 就诊结束时间 */
    private String inHospitalEndTime;
    /** 就诊类型列表 */
    private List<String> visitTypes;
    /** 关联的empi信息列表 */
    private HashSet<String> empiRels;
    


}
