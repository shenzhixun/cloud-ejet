package com.khsh.datacent.patientview.service.impl;

import com.ejet.comm.exception.CoBusinessException;
import com.ejet.comm.utils.StringUtils;
import com.ejet.core.comm.PageBean;
import com.github.pagehelper.PageHelper;
import com.khsh.datacent.patientview.mapper.master.PatientMapper;
import com.khsh.datacent.patientview.mapper.slave.OMOdersMapper;
import com.khsh.datacent.patientview.model.PixEmpiRModel;
import com.khsh.datacent.patientview.service.PatientService;
import com.khsh.datacent.patientview.util.ValidateUtil;
import com.khsh.datacent.patientview.vo.OMOrdersDetailResult;
import com.khsh.datacent.patientview.dto.PatientParam;
import com.khsh.datacent.patientview.vo.PatientResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
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
public class PatientServiceImpl implements PatientService {
    private final Logger log = LoggerFactory.getLogger(PatientServiceImpl.class);
    @Autowired
    private PatientMapper mDao;

    @Autowired
    private OMOdersMapper omOdersMapper;
    /**
     * 检索患者信息
     *
     * @param model
     * @param pageNum
     * @param pageSize
     * @return
     * @throws CoBusinessException
     */
    public PageBean<PatientResult> queryPatientByPage(PatientResult model, Integer pageNum, Integer pageSize) throws CoBusinessException {
        PageHelper.startPage(pageNum, pageSize);
        //1、首先查询患者信息
        List<PatientResult> list = mDao.queryPatientByPage(model);
        PageBean<PatientResult> page = new PageBean<>(list);
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
    public PageBean<PatientResult> queryPatientVisitsByPage(PatientResult model, Integer pageNum, Integer pageSize) throws CoBusinessException {
        if(model==null || StringUtils.isBlank(model.getEmpi())) {
            throw new CoBusinessException("empi参数缺失!");
        }
        HashSet<String> result = new HashSet<>();
        result.add(model.getEmpi());

        //首先查询关联empi信息
        PixEmpiRModel query = new PixEmpiRModel();
        query.setEmpi(model.getEmpi());
        List<PixEmpiRModel> empis = mDao.queryEmpiRelation(query);
        if(empis!=null && empis.size()>0) {
            for (PixEmpiRModel empi:empis) {
                if(!StringUtils.isBlank(empi.getEmpi())) {
                    result.add(empi.getEmpi());
                }
                if(!StringUtils.isBlank(empi.getRelEmpi())) {
                    result.add(empi.getRelEmpi());
                }
            }
        }
        model.setEmpiRels(result);
        PageHelper.startPage(pageNum, pageSize);
        List<PatientResult> list = mDao.queryPatientVisitsByPage(model);
        PageBean<PatientResult> page = new PageBean<>(list);
        return page;
    }

    /**
     * 查询患者医嘱信息
     */
    public PageBean<OMOrdersDetailResult> queryPatientOmOrdersByPage(OMOrdersDetailResult model, Integer pageNum, Integer pageSize) throws CoBusinessException {
        PageHelper.startPage(pageNum, pageSize);
        List<OMOrdersDetailResult> list = omOdersMapper.queryPatientOmOrdersByPage(model);
        PageBean<OMOrdersDetailResult> page = new PageBean<>(list);
        return page;
    }



    @Override
    public String queryEmpi(PatientParam model) throws CoBusinessException {
        /** 1先根据身份证查询empi */
        List<String> empis = null;
        if(!StringUtils.isBlank(model.getIdCard())) {
            empis = mDao.queryEmpiByIdcard(model);
        }
        if(empis!=null && empis.size()>0) {
           return empis.get(0);
        }

        /** 2根据patientid, inpatientId, inHospitalId查询 */
        empis = mDao.queryEmpi(model);
        if(empis!=null && empis.size()>0) {
            return empis.get(0);
        }
        return null;
    }


    @Override
    public PageBean<PatientResult> queryPatientView(PatientParam model, Integer pageNum, Integer pageSize) throws CoBusinessException {
        //首先校验数据
        ValidateUtil.checkPatientParam(model);

        PatientResult query = new PatientResult();
        String empi = queryEmpi(model);
        if(empi==null) {
            return new PageBean<>(new ArrayList<>());
        }
        query.setEmpi(empi);
        query.setVisitType(model.getVisitType());
        return queryPatientVisitsByPage(query, pageNum, pageSize);
    }


}
