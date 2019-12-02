package com.khsh.datacent.patientview.vo;

import lombok.Data;

import java.util.List;

/**
 * FileName: PatientVisitReqVO
 * Author:   ShenYijie
 * CreateDate:     2019-01-26 16:39
 * Description: 查询患者请求信息
 * History:
 * Version: 1.0
 */
@Data
public class PatientVisitParam extends PatientVO {
    /**  患者查询关键字（姓名，住院号，或者门诊号，手机号，身份证号） */
    private String queryKeywords;
    /**  就诊开始时间 */
    private String inHospitalStartTime;
    /** 就诊结束时间 */
    private String inHospitalEndTime;
    /** 就诊类型列表 */
    private List<String> visitTypes;
    /** 科室列表 */
    private List<String> depts;
    /** 关联的empi信息列表 */
    private List<String> epmiRel;

}
