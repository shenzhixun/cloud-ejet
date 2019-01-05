package com.ejet.core.global;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Copyright (C), 2016-2018, 武汉康华数海有限公司
 * FileName: Global
 * Author:   Ejet
 * CreateDate:     2018-09-05 11:43
 * Description: 全局变量配置信息
 * History:
 * Version: 1.0
 */
@Component
@ConfigurationProperties(prefix="ejet-comm-web")
public class CoGlobal {
    /**
     * 是否开启token认证
     */
    private boolean openTokenAuth;
    /**
     * 是否开启session认证
     */
    private boolean openSessionAuth;
    /**
     * 忽略的url地址信息
     */
    private List<String> authIgnoreURLs;

    public boolean isOpenTokenAuth() {
        return openTokenAuth;
    }

    public void setOpenTokenAuth(boolean openTokenAuth) {
        this.openTokenAuth = openTokenAuth;
    }

    public boolean isOpenSessionAuth() {
        return openSessionAuth;
    }

    public void setOpenSessionAuth(boolean openSessionAuth) {
        this.openSessionAuth = openSessionAuth;
    }

    public List<String> getAuthIgnoreURLs() {
        return authIgnoreURLs;
    }

    public void setAuthIgnoreURLs(List<String> authIgnoreURLs) {
        this.authIgnoreURLs = authIgnoreURLs;
    }
}
