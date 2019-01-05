package com.ejet.core.db;

import com.ejet.core.CommWebApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CommWebDBApplication extends SpringBootServletInitializer {
    private static final Logger logger = LoggerFactory.getLogger(CommWebDBApplication.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CommWebDBApplication.class);
    }

    static {
        logger.info("======== [ejet-comm-web-db] init ======");
    }

    public static void main(String[] args) {
        List<Class> list  = new ArrayList<>();
        list.add(CommWebDBApplication.class);       //本项目
        list.add(CommWebApplication.class);         //基础项目
        SpringApplication.run(list.toArray(new Class[list.size()]), args);
    }



}
