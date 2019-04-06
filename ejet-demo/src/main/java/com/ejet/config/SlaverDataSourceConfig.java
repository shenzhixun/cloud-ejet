package com.ejet.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;

@Slf4j
@Configuration
@MapperScan(basePackages = "com.ejet.mapper.slave", sqlSessionTemplateRef  = "slaverSqlSessionTemplate")
public class SlaverDataSourceConfig {

    //@Value("${spring.datasource.slave}")
    //@Value("${spring.datasource.slave}")
    @Bean(name = "slaveConfig")
    @ConfigurationProperties(prefix = "spring.datasource.slave")
    IDataSourceConfig get() {
        IDataSourceConfig config = new IDataSourceConfig();
        return config;
    }

    @Autowired
    private IDataSourceConfig dataSourceConfig;

    @Bean(name = "slaverDataSource")
    public DataSource dataSource() {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setDriverClassName(dataSourceConfig.getDriverClassName());
        datasource.setUrl(dataSourceConfig.getUrl());
        datasource.setUsername(dataSourceConfig.getUsername());
        datasource.setPassword(dataSourceConfig.getPassword());
        // configuration
        datasource.setInitialSize(dataSourceConfig.getInitialSize());
        datasource.setMinIdle(dataSourceConfig.getMinIdle());
        datasource.setMaxActive(dataSourceConfig.getMaxActive());
        datasource.setMaxWait(dataSourceConfig.getMaxWait());
        datasource.setTimeBetweenEvictionRunsMillis(dataSourceConfig.getTimeBetweenEvictionRunsMillis());
        datasource.setMinEvictableIdleTimeMillis(dataSourceConfig.getMinEvictableIdleTimeMillis());
        datasource.setValidationQuery(dataSourceConfig.getValidationQuery());
        datasource.setTestWhileIdle(dataSourceConfig.isTestWhileIdle());
        datasource.setTestOnBorrow(dataSourceConfig.isTestOnBorrow());
        datasource.setTestOnReturn(dataSourceConfig.isTestOnReturn());
        datasource.setPoolPreparedStatements(dataSourceConfig.isPoolPreparedStatements());
        datasource.setMaxPoolPreparedStatementPerConnectionSize(dataSourceConfig.getMaxPoolPreparedStatementPerConnectionSize());
        try {
            datasource.setFilters(dataSourceConfig.getFilters());
        } catch (SQLException e) {
            log.error("druid configuration initialization filter: ", e);
        }
        datasource.setConnectionProperties(dataSourceConfig.getConnectionProperties());
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