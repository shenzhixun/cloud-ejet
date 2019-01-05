package com.ejet.core.version;

import com.ejet.comm.ModuleVersion;
import com.ejet.comm.Param;
import com.ejet.comm.Result;
import com.ejet.core.base.ControllerBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static com.ejet.comm.exception.ExceptionCode.SYS_ERROR;

/**
 * Copyright (C), 2016-2018, 武汉康华数海有限公司
 * FileName: VersionController
 * Author:   Ejet
 * CreateDate:     2018-09-26 17:19
 * Description: 查看版本
 * History:
 * Version: 1.0
 */
@RestController
@RequestMapping("/ejet-core-web")
public class VersionController extends ControllerBase {
    private final Logger log = LoggerFactory.getLogger(VersionController.class);
    @ResponseBody
    @RequestMapping(value="/version")
    public Result getVersion(@RequestBody(required=false) Param param, BindingResult bindResult) {
        Result rs = new Result();
        try {
            ModuleVersion version = new ModuleVersion();
            version.setModuleName("springboot(comm-web)基础模块");
            version.setModuleVersion("v1.0.1 release");
            version.setLastModifyTime("2018-10-16 18:00:00");
            version.setOwner("shenyijie");
            version.setModifyUser("shenyijie");
            rs = new Result(version);
        } catch (Exception e) {
            log.error("", e);
            rs = new Result(SYS_ERROR, e);
        }
        return rs;
    }
}
