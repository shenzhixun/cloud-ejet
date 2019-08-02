package com.khsh.datacent.patientview.config;

import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

public abstract class DruidBase {


    public DataSource registDataSource(IDataSourceConfig config) throws SQLException {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setDriverClassName(config.getDriverClassName());
        datasource.setUrl(config.getUrl());
        datasource.setUsername(config.getUsername());
        datasource.setPassword(config.getPassword());
        // configuration
        datasource.setInitialSize(config.getInitialSize());
        datasource.setMinIdle(config.getMinIdle());
        datasource.setMaxActive(config.getMaxActive());
        datasource.setMaxWait(config.getMaxWait());
        datasource.setTimeBetweenEvictionRunsMillis(config.getTimeBetweenEvictionRunsMillis());
        datasource.setMinEvictableIdleTimeMillis(config.getMinEvictableIdleTimeMillis());
        datasource.setValidationQuery(config.getValidationQuery());
        datasource.setTestWhileIdle(config.isTestWhileIdle());
        datasource.setTestOnBorrow(config.isTestOnBorrow());
        datasource.setTestOnReturn(config.isTestOnReturn());
        datasource.setPoolPreparedStatements(config.isPoolPreparedStatements());
        datasource.setMaxPoolPreparedStatementPerConnectionSize(config.getMaxPoolPreparedStatementPerConnectionSize());
        datasource.setFilters(config.getFilters());
        datasource.setConnectionProperties(config.getConnectionProperties());
        return datasource;
    }

}
