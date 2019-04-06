package com.ejet.mapper.master;

import com.ejet.model.PatientVisitModel;
import org.apache.ibatis.annotations.Mapper;

/**
 * Copyright (C), 2016-2019, 武汉康华数海有限公司
 * FileName: SlaverPatientMapper
 * Author:   ShenYijie
 * CreateDate:     2019-01-26 17:10
 * Description:
 * History:
 * Version: 1.0
 */
@Mapper
public interface PatientMapper {

    public PatientVisitModel queryPatientByPage(PatientVisitModel req) throws Exception;

}
