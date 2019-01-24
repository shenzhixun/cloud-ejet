package com.ejet.comm.db;
/**
 * Copyright (C), 2016-2018, 武汉康华数海有限公司
 * FileName: CoDbConfig
 * Author:   Ejet
 * CreateDate:     2018-08-28 10:49
 * Description: 数据库配置信息
 * History:
 * Version: 1.0
 */
public class CoDbConfig {
    /**
     * 数据库驱动名（次字段可取消，直接根据URL获取对应驱动名称）
     */
    private String driverClassName;
    /**
     * 数据库URL
     */
    private String url;
    /**
     * 数据库用户名
     */
    private String username;
    /**
     * 数据库密码
     */
    private String password;

    public String getDriverClassName() {
        return driverClassName;
    }
    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
