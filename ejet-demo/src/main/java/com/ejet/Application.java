package com.ejet;

import com.ejet.core.CommWebApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    static {
        log.info("======== [ejet-comm-web-db] init ======a63b9f1d-1ec5-4bab-b114-a95b00b86d31");
    }

    public static void main(String[] args) {
        List<Class> list  = new ArrayList<>();
        list.add(Application.class);      //本项目
        list.add(CommWebApplication.class);         //基础项目
        //list.add(CommWebDBApplication.class);         //基础项目
        SpringApplication.run(list.toArray(new Class[list.size()]), args);
    }


}