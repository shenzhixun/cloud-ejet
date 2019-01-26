package com.khsh.datac.patientview.vo;

import lombok.Data;

import java.io.Serializable;

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
public class PatientVisitVO implements Serializable {

    /** 就诊医疗机构名称 */
    private String visitCorpName;
    /**  就诊类型  */
    private String visitType;
    /** 就诊时间or入院时间  */
    private String inHospitalDate;
    /**  门诊号or住院号 */
    private String inHospitalId;
    /**  床位号  */
    private String bedId;
    /** 入院科室 */
    private String inDeptName;
    /**  转出科室  */
    private String outDeptName;
    /** 出院时间 */
    private String outHospitalDate;
    /** 诊断名称 */
    private String diagName;
    /** 诊断依据 */
    private String diagBasis;


}
