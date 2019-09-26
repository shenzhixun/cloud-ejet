package com.khsh.datacent.patientview.api;

import com.ejet.comm.Param;
import com.ejet.comm.Result;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.core.base.ControllerBase;
import com.ejet.core.comm.PageBean;
import com.khsh.datacent.patientview.service.impl.PatientServiceImpl;
import com.khsh.datacent.patientview.vo.OMOrdersDetailResult;
import com.khsh.datacent.patientview.vo.PatientResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static com.ejet.comm.exception.ExceptionCode.SYS_ERROR;

/**
 * Copyright (C), 2016-2019, 武汉康华数海有限公司
 * FileName: PatientController
 * Author:   ShenYijie
 * CreateDate:     2019-01-26 16:35
 * Description: 患者信息
 * History:
 * Version: 1.0
 */
@RestController
@RequestMapping(value="/api")
public class PatientController extends ControllerBase {

    private final Logger log = LoggerFactory.getLogger(PatientController.class);
    @Autowired
    private PatientServiceImpl mService;

    /**
     * 检索患者
     * @param param
     * @param bindResult
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/query-patient")
    public Result queryPatientByPage(@RequestBody(required=true) Param<PatientResult> param, BindingResult bindResult) {
        Result rs = new Result();
        try{
            checkBindResult(bindResult);
            checkParam(param);
            PageBean<PatientResult> pageBean = mService.queryPatientByPage(param.getData(), param.getPage().getPageNum(), param.getPage().getPageSize());
            rs = new Result(pageBean.getPage(), pageBean.getResult());
        }catch (CoBusinessException e) {
            log.error("", e);
            rs = new Result(e.getCode(), e);
        }catch (Exception e) {
            log.error("", e);
            rs = new Result(SYS_ERROR, e);
        }
        return rs;
    }

    /**
     *
     *  获取患者就诊信息
     *
     * @param param
     * @param bindResult
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/query-patient-visits")
    public Result queryPatientVisitByPage(@RequestBody(required=true) Param<PatientResult> param, BindingResult bindResult) {
        Result rs = new Result();
        try{
            checkBindResult(bindResult);
            checkParam(param);
            PageBean<PatientResult> pageBean = mService.queryPatientVisitsByPage(param.getData(), param.getPage().getPageNum(), param.getPage().getPageSize());
            rs = new Result(pageBean.getPage(), pageBean.getResult());
        }catch (CoBusinessException e) {
            log.error("", e);
            rs = new Result(e.getCode(), e);
        }catch (Exception e) {
            log.error("", e);
            rs = new Result(SYS_ERROR, e);
        }
        return rs;
    }


    /**
     * 查询患者医嘱信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/omorders-by-page")
    public Result queryPatientOmOrdersByPage(@RequestBody(required=true) Param<OMOrdersDetailResult> param, BindingResult bindResult) {
        Result rs = new Result();
        try{
            checkBindResult(bindResult);
            checkParam(param);
            PageBean<OMOrdersDetailResult> pageBean = mService.queryPatientOmOrdersByPage(param.getData(), param.getPage().getPageNum(), param.getPage().getPageSize());
            rs = new Result(pageBean.getPage(), pageBean.getResult());
        }catch (CoBusinessException e) {
            log.error("", e);
            rs = new Result(e.getCode(), e);
        }catch (Exception e) {
            log.error("", e);
            rs = new Result(SYS_ERROR, e);
        }
        return rs;
    }


}
