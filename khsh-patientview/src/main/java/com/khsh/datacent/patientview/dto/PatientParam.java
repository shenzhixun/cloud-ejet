package com.khsh.datacent.patientview.dto;

import com.khsh.datacent.patientview.vo.PatientVO;
import lombok.Data;

import java.util.HashSet;
import java.util.List;

/**
 * FileName: PatientVO
 * Author:   ShenYijie
 * CreateDate:     2019-01-26 16:12
 * Description:
 * History:
 * Version: 1.0
 */
@Data
public class PatientParam extends PatientVO {

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

    /** 请求查询类型 1: 根据住院号查询 2：根据patientid或者inpatientid查询 3：根据身份证查询 */
    private Integer type;
    /**  患者查询关键字（姓名，住院号，或者门诊号，手机号，身份证号） */
    private String keywords;


}
