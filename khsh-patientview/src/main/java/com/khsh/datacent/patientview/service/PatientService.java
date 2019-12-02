package com.khsh.datacent.patientview.service;

import com.ejet.comm.exception.CoBusinessException;
import com.ejet.core.comm.PageBean;
import com.khsh.datacent.patientview.dto.PatientParam;
import com.khsh.datacent.patientview.vo.OMOrdersDetailResult;
import com.khsh.datacent.patientview.vo.PatientResult;

/**
 * Author:   ShenYijie
 * Description:
 * History:
 * Version: 1.0
 */
public interface PatientService {
    /**
     *  检索患者信息
     * @param model
     * @param pageNum
     * @param pageSize
     * @return
     * @throws CoBusinessException
     */
    public PageBean<PatientResult> queryPatientByPage(PatientResult model, Integer pageNum, Integer pageSize) throws CoBusinessException;
    /**
     * 查询患者所有就诊信息
     *
     * @param model
     * @param pageNum
     * @param pageSize
     * @return
     * @throws CoBusinessException
     */
    public PageBean<PatientResult> queryPatientVisitsByPage(PatientResult model, Integer pageNum, Integer pageSize) throws CoBusinessException;

    /**
     * 查询患者医嘱信息
     */
    public PageBean<OMOrdersDetailResult> queryPatientOmOrdersByPage(OMOrdersDetailResult model, Integer pageNum, Integer pageSize) throws CoBusinessException;

    /**
     * 查询患者主索引
     * @throws CoBusinessException
     */
    public String queryEmpi(PatientParam model) throws CoBusinessException;


    /**
     * 查询患者360视图信息
     *
     * @throws CoBusinessException
     */
    public PageBean<PatientResult> queryPatientView(PatientParam model, Integer pageNum, Integer pageSize) throws CoBusinessException;


}
