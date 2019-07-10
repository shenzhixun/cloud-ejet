package com.khsh.datacent.patientview;

import com.ejet.core.CommWebApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2016-2019, 武汉康华数海有限公司
 * FileName: EMPIApplication
 * Author:   ShenYijie
 * CreateDate:     2019-01-03 16:05
 * Description: 启动类
 * History:
 * Version: 1.0
 */
@Slf4j
@SpringBootApplication
public class PatientViewApp extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PatientViewApp.class);
    }

    static {
        log.info("======== [khsh-patientview] init ======a63b9f1d-1ec5-4bab-b114-a95b00b86d31");
    }

    public static void main(String[] args) {
        List<Class> list  = new ArrayList<>();
        list.add(PatientViewApp.class);      //本项目
        list.add(CommWebApplication.class);         //基础项目
        SpringApplication.run(list.toArray(new Class[list.size()]), args);
    }


}
