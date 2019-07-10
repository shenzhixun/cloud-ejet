package com.khsh.datacent.patientview.config;

import com.alibaba.druid.pool.DruidDataSource;
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
public class SlaverDataSourceConfig {

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
        DruidDataSource datasource = new DruidDataSource();
        datasource.setDriverClassName(slaveConfig.getDriverClassName());
        datasource.setUrl(slaveConfig.getUrl());
        datasource.setUsername(slaveConfig.getUsername());
        datasource.setPassword(slaveConfig.getPassword());
        // configuration
        datasource.setInitialSize(slaveConfig.getInitialSize());
        datasource.setMinIdle(slaveConfig.getMinIdle());
        datasource.setMaxActive(slaveConfig.getMaxActive());
        datasource.setMaxWait(slaveConfig.getMaxWait());
        datasource.setTimeBetweenEvictionRunsMillis(slaveConfig.getTimeBetweenEvictionRunsMillis());
        datasource.setMinEvictableIdleTimeMillis(slaveConfig.getMinEvictableIdleTimeMillis());
        datasource.setValidationQuery(slaveConfig.getValidationQuery());
        datasource.setTestWhileIdle(slaveConfig.isTestWhileIdle());
        datasource.setTestOnBorrow(slaveConfig.isTestOnBorrow());
        datasource.setTestOnReturn(slaveConfig.isTestOnReturn());
        datasource.setPoolPreparedStatements(slaveConfig.isPoolPreparedStatements());
        datasource.setMaxPoolPreparedStatementPerConnectionSize(slaveConfig.getMaxPoolPreparedStatementPerConnectionSize());
        try {
            datasource.setFilters(slaveConfig.getFilters());
        } catch (SQLException e) {
            log.error("druid configuration initialization filter: ", e);
        }
        datasource.setConnectionProperties(slaveConfig.getConnectionProperties());
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