package com.khsh.datac.patientview.controller;

import com.ejet.comm.Param;
import com.ejet.comm.Result;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.core.base.ControllerBase;
import com.ejet.core.comm.PageBean;
import com.khsh.datac.patientview.service.impl.PatientServiceImpl;
import com.khsh.datac.patientview.vo.PatientVisitReqVO;
import com.khsh.datac.patientview.vo.PatientVisitVO;
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
@RequestMapping(value="/patient")
public class PatientController extends ControllerBase{

    private final Logger log = LoggerFactory.getLogger(PatientController.class);
    @Autowired
    private PatientServiceImpl mService;

    /**
     * 获取患者信息及就诊信息
     * @param param
     * @param bindResult
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/query-visit-by-page")
    public Result queryByPage(@RequestBody(required=true) Param<PatientVisitReqVO> param, BindingResult bindResult) {
        Result rs = new Result();
        try{
            checkBindResult(bindResult);
            checkParam(param);
            PageBean<PatientVisitVO> pageBean = mService.queryPatientVisitInfo(param.getData(), param.getPage().getPageNum(), param.getPage().getPageSize());
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
