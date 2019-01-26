package com.khsh.datac.patientview.mapper.oracle;

import com.ejet.comm.exception.CoBusinessException;
import com.khsh.datac.patientview.vo.PatientVisitReqVO;
import com.khsh.datac.patientview.vo.PatientVisitVO;
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

    public List<PatientVisitVO> queryPatientVisitInfo(PatientVisitReqVO req) throws CoBusinessException;

}
