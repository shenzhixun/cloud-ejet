package com.khsh.datacent.patientview.config;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class IDataSourceConfig {
    private String url;
    private String username;
    private String password;
    private String driverClassName;
    private int initialSize = 10;
    private int minIdle = 20;
    private int maxActive = 100;
    private int maxWait = 50;
    private int timeBetweenEvictionRunsMillis;
    private int minEvictableIdleTimeMillis = 60000;
    private String validationQuery;
    private boolean testWhileIdle;
    private boolean testOnBorrow;
    private boolean testOnReturn;
    private boolean poolPreparedStatements;
    private int maxPoolPreparedStatementPerConnectionSize;
    private String filters;
    private String connectionProperties;

    public IDataSourceConfig() {

    }
}

