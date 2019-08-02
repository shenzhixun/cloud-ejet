package com.khsh.datacent.patientview.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;

@Slf4j
@Configuration
@MapperScan(basePackages = "com.khsh.datacent.patientview.mapper.slave", sqlSessionTemplateRef  = "slaverSqlSessionTemplate")
public class SlaverDataSourceConfig extends DruidBase {

    @Bean(name = "slaveConfig")
    @ConfigurationProperties(prefix = "spring.datasource.slave")
    IDataSourceConfig get() {
        IDataSourceConfig config = new IDataSourceConfig();
        return config;
    }

//    @Autowired
//    private IDataSourceConfig slaveConfig;

    @Bean(name = "slaverDataSource")
    public DataSource dataSource(@Qualifier("slaveConfig") IDataSourceConfig slaveConfig) {
        DataSource datasource = null;
        try {
            datasource = registDataSource(slaveConfig);
        } catch (SQLException e) {
            log.error("druid configuration initialization filter: ", e);
        }
        return datasource;
    }

    @Bean(name = "slaverSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("slaverDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        bean.setConfigLocation(resolver.getResource("classpath:mybatis/mybatis-config-slave.xml"));
        bean.setMapperLocations(resolver.getResources("classpath*:mybatis/slave/*Mapper.xml"));
        //bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mybatis/slave/*Mapper.xml"));
        return bean.getObject();
    }

    @Bean(name = "slaverTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("slaverDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "slaverSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("slaverSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }





}