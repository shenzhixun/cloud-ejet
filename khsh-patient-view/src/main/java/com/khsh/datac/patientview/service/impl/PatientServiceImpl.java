package com.khsh.datac.patientview.service.impl;

import com.ejet.comm.exception.CoBusinessException;
import com.ejet.core.comm.PageBean;
import com.github.pagehelper.PageHelper;
import com.khsh.datac.patientview.mapper.oracle.PatientMapper;
import com.khsh.datac.patientview.vo.PatientVisitReqVO;
import com.khsh.datac.patientview.vo.PatientVisitVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright (C), 2016-2019, 武汉康华数海有限公司
 * FileName: PatientServiceImpl
 * Author:   ShenYijie
 * CreateDate:     2019-01-26 16:50
 * Description:
 * History:
 * Version: 1.0
 */
@Service("patientService")
public class PatientServiceImpl {
    private final Logger log = LoggerFactory.getLogger(PatientServiceImpl.class);
    @Autowired
    private PatientMapper mDao;

    public PageBean<PatientVisitVO> queryPatientVisitInfo(PatientVisitReqVO model, Integer pageNum, Integer pageSize) throws CoBusinessException {
        PageHelper.startPage(pageNum, pageSize);
        List<PatientVisitVO> list = mDao.queryPatientVisitInfo(model);
        PageBean<PatientVisitVO> page = new PageBean<>(list);
        return page;
    }



}
