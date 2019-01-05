package com.ejet.core;

import com.ejet.core.context.CoApplicationContext;
import com.ejet.core.interceptor.SqlInjectInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// @Configuration
// @SpringBootApplication(scanBasePackages={("com.khsh.etl.*"), "com.ejet.*.*"})
// //@EnableAutoConfiguration
// @EnableCaching
//注解后，Servlet、Filter、Listener 可以直接通过 @WebServlet、@WebFilter、@WebListener 注解自动注册
@ServletComponentScan(basePackages="com.ejet")
@EnableTransactionManagement // 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
@SpringBootApplication
@EnableCaching
public class CommWebApplication extends SpringBootServletInitializer {
    private static final Logger logger = LoggerFactory.getLogger(CommWebApplication.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CommWebApplication.class);
    }

    static {
        SqlInjectInterceptor sqlInjectInterceptor = new SqlInjectInterceptor();
        sqlInjectInterceptor.setName("Sql Inject Interceptor......");
        CoApplicationContext.addInterceptor(sqlInjectInterceptor);

        logger.info("======== [ejet-comm-web] init ======");
    }

    public static void main(String[] args) {
        SpringApplication.run(CommWebApplication.class, args);
    }



}
