package com.khsh.datacent.patientview.service.impl;

import com.ejet.comm.exception.CoBusinessException;
import com.ejet.core.comm.PageBean;
import com.github.pagehelper.PageHelper;
import com.khsh.datacent.patientview.mapper.master.PatientMapper;
import com.khsh.datacent.patientview.mapper.slave.OMOdersMapper;
import com.khsh.datacent.patientview.vo.*;
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

    @Autowired
    private OMOdersMapper omOdersMapper;

//    /**
//     * 检索患者信息
//     *
//     * @param model
//     * @param pageNum
//     * @param pageSize
//     * @return
//     * @throws CoBusinessException
//     */
//    public PageBean<PatientVisitVO> queryPatientVisitByPage(PatientVisitReqVO model, Integer pageNum, Integer pageSize) throws CoBusinessException {
//        PageHelper.startPage(pageNum, pageSize);
//        List<PatientVisitVO> list = mDao.queryPatientVisitByPage(model);
//        PageBean<PatientVisitVO> page = new PageBean<>(list);
//        return page;
//    }

    /**
     * 检索患者信息
     *
     * @param model
     * @param pageNum
     * @param pageSize
     * @return
     * @throws CoBusinessException
     */
    public PageBean<PatientRequestVO> queryPatientByPage(PatientRequestVO model, Integer pageNum, Integer pageSize) throws CoBusinessException {
        PageHelper.startPage(pageNum, pageSize);
        //1、首先查询患者信息
        List<PatientRequestVO> list = mDao.queryPatientByPage(model);
        PageBean<PatientRequestVO> page = new PageBean<>(list);
        return page;
    }

    /**
     * 查询患者所有就诊信息
     *
     * @param model
     * @param pageNum
     * @param pageSize
     * @return
     * @throws CoBusinessException
     */
    public PageBean<PatientVisitVO> queryPatientVisitByPage(PatientVisitReqVO model, Integer pageNum, Integer pageSize) throws CoBusinessException {
        //首先查询关联empi信息


        PageHelper.startPage(pageNum, pageSize);
        List<PatientVisitVO> list = mDao.queryPatientVisitByPage(model);
        PageBean<PatientVisitVO> page = new PageBean<>(list);
        return page;
    }

//    /**
//     * 查询患者所有就诊信息
//     *
//     * @param model
//     * @return
//     * @throws CoBusinessException
//     */
//    public PatientVO queryPatientInfo(PatientVisitReqVO model) throws CoBusinessException {
//        return mDao.queryPatientInfo(model);
//    }
    /**
     * 查询患者医嘱信息
     */
    public PageBean<OMOrdersDetailVO> queryPatientOmOrdersByPage(OMOrdersDetailVO model, Integer pageNum, Integer pageSize) throws CoBusinessException {
        PageHelper.startPage(pageNum, pageSize);
        List<OMOrdersDetailVO> list = omOdersMapper.queryPatientOmOrdersByPage(model);
        PageBean<OMOrdersDetailVO> page = new PageBean<>(list);
        return page;
    }




}
