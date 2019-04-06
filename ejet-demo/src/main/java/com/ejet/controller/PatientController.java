package com.ejet.controller;

import com.ejet.mapper.master.PatientMapper;
import com.ejet.mapper.slave.SlaverPatientMapper;
import com.ejet.model.PatientVisitModel;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping(value="/pt")
@Slf4j
public class PatientController {
    @Autowired
    private SlaverPatientMapper slaverPatientMapper;
    @Autowired
    private PatientMapper masterPatientMapper;

    @ResponseBody
    @RequestMapping(value="/slave")
    public String queryPatientByPage(@RequestBody(required=false) PatientVisitModel param) {
        String rs = "slave";
        try{
            PatientVisitModel query  = new PatientVisitModel();
            query.setEmpi("42203707-3-c9004387d2614ae98c144c947c9f80f5100010");
            PatientVisitModel result = slaverPatientMapper.queryPatientByPage(query);
            rs = new Gson().toJson(result);
        }catch (Exception e) {
            log.error("", e);
            rs = e.getMessage();
        }
        return rs;
    }

    @ResponseBody
    @RequestMapping(value="/master")
    public String master(@RequestBody(required=false) PatientVisitModel param) {
        String rs = "master";
        try{
            PatientVisitModel query  = new PatientVisitModel();
            query.setEmpi("42203707-3-c9004387d2614ae98c144c947c9f80f5100010");
            PatientVisitModel result = masterPatientMapper.queryPatientByPage(query);
            rs = new Gson().toJson(result);
        }catch (Exception e) {
            log.error("", e);
            rs = e.getMessage();
        }
        return rs;
    }



}
