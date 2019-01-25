package com.khsh.datac.patientview.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author wj
 * @date 2018/12/14
 */
@Configuration
@MapperScan(basePackages = "com.cxkh.dataserver.mapper.postgresql",sqlSessionTemplateRef = "postgresqlSqlSessionTemplate")
public class PostgreSqlConfiguration {

    @Bean(name = "postgresqlDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.postgresql")
    public DataSource dataSource() {
        DruidDataSource datasource = new DruidDataSource();
        return datasource;
    }

    @Bean(name = "postgresqlSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("postgresqlDataSource") DataSource postgresqlDataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(postgresqlDataSource);

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setConfigLocation(resolver.getResource("classpath:/mybatis/mybatis-config.xml"));
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/mapper/postgresql/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "postgresqlSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("postgresqlSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
