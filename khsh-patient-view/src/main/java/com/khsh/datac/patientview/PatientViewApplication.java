package com.khsh.datac.patientview;

import com.ejet.core.CommWebApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

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
@EnableTransactionManagement // 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
@SpringBootApplication()
@EnableCaching
public class PatientViewApplication extends SpringBootServletInitializer {
    private static final Logger logger = LoggerFactory.getLogger(PatientViewApplication.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PatientViewApplication.class);
    }

    static {
        logger.info("======== [ejet-comm-web-db] init ======a63b9f1d-1ec5-4bab-b114-a95b00b86d31");
    }

    public static void main(String[] args) {
        List<Class> list  = new ArrayList<>();
        list.add(PatientViewApplication.class);            //本项目
        list.add(CommWebApplication.class);         //基础项目
        SpringApplication.run(list.toArray(new Class[list.size()]), args);
    }


}