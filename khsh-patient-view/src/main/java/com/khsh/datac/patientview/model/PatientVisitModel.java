package com.khsh.datac.patientview.model;

import com.ejet.comm.base.CoBaseVO;
import lombok.Data;

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
public class PatientVisitModel extends CoBaseVO {
    /** 就诊医疗机构代码 */
    private String visitCorp;
    /** 就诊医疗机构名称 */
    private String visitCorpName;
    /**  就诊类型  */
    private String visitType;
    /**  就诊类型标识  */
    private String visitTypeCode;
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
    /** 诊断医生姓名 */
    private String visitDoctorName;

}
