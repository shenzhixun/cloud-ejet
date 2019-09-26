package com.khsh.datacent.patientview.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2016-2019, 武汉康华数海有限公司
 * FileName: PatientVisitResultVO
 * Author:   ShenYijie
 * CreateDate:     2019-01-26 16:11
 * Description: 患者信息及就诊信息
 * History:
 * Version: 1.0
 */
@Data
public class PatientVisitResult implements Serializable {
    /**
     * 患者信息
     */
    private PatientVO patient;
    /**
     * 患者就诊信息
     */
    private List<PatientVisitVO> visitList = new ArrayList<>();



}
