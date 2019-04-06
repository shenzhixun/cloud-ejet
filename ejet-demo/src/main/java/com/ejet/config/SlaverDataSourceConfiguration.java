//package com.ejet.config;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
//import javax.sql.DataSource;
//
//@Configuration
//@MapperScan(basePackages = "com.ejet.mapper.slave", sqlSessionTemplateRef  = "slaverSqlSessionTemplate")
//public class SlaverDataSourceConfiguration {
//
//    @Value("${spring.datasource.slave.driver-class-name}")
//    private String driverClassName;
//
//    @Value("${spring.datasource.slave.url}")
//    private String url;
//
//    @Value("${spring.datasource.slave.username}")
//    private String username;
//
//    @Value("${spring.datasource.slave.password}")
//    private String password;
//
//
//    @Bean(name = "slaverDataSource")
//    public DataSource dataSource() {
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setDriverClassName(this.driverClassName);
//        dataSource.setUrl(this.url);
//        dataSource.setUsername(this.username);
//        dataSource.setPassword(this.password);
//        return dataSource;
//    }
//
//    @Bean(name = "slaverSqlSessionFactory")
//    public SqlSessionFactory sqlSessionFactory(@Qualifier("slaverDataSource") DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        bean.setConfigLocation(resolver.getResource("classpath:mybatis/mybatis-config-slave.xml"));
//        bean.setMapperLocations(resolver.getResources("classpath*:mybatis/slave/*Mapper.xml"));
//        //bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mybatis/slave/*Mapper.xml"));
//        return bean.getObject();
//    }
//
//    @Bean(name = "slaverTransactionManager")
//    public DataSourceTransactionManager transactionManager(@Qualifier("slaverDataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    @Bean(name = "slaverSqlSessionTemplate")
//    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("slaverSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//
//}