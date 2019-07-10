package com.ejet.comm.uoloadfile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class CommUploadfileApplication extends SpringBootServletInitializer {
    private static final Logger logger = LoggerFactory.getLogger(CommUploadfileApplication.class);

    static {
        logger.info("======== [ejet-comm-web-uploadfile] init ======");
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CommUploadfileApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(CommUploadfileApplication.class, args);
    }



}
