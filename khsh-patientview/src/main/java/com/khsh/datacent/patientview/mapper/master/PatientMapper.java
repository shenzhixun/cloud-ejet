package com.khsh.datacent.patientview.mapper.master;

import com.ejet.comm.exception.CoBusinessException;
import com.khsh.datacent.patientview.model.PixEmpiRModel;
import com.khsh.datacent.patientview.dto.PatientParam;
import com.khsh.datacent.patientview.vo.PatientResult;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Copyright (C), 2016-2019, 武汉康华数海有限公司
 * FileName: PatientMapper
 * Author:   ShenYijie
 * CreateDate:     2019-01-26 17:10
 * Description:
 * History:
 * Version: 1.0
 */
@Mapper
public interface PatientMapper {

    public List<PatientResult> queryPatientVisitsByPage(PatientResult req) throws CoBusinessException;

    public List<PatientResult> queryPatientByPage(PatientResult req) throws CoBusinessException;

    public abstract List<PixEmpiRModel> queryEmpiRelation(PixEmpiRModel obj) throws CoBusinessException;

    public abstract List<String> queryEmpi(PatientParam obj) throws CoBusinessException;

    public abstract List<String> queryEmpiByIdcard(PatientParam obj) throws CoBusinessException;

}
