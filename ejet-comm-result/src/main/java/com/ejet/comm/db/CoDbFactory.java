package com.ejet.comm.db;

import java.sql.DriverManager;

/**
 * Copyright (C), 2016-2018, 武汉康华数海有限公司
 * FileName: CoDbFactory
 * Author:   Ejet
 * CreateDate:     2018-08-30 11:47
 * Description:
 * History:
 * Version: 1.0
 */
public class CoDbFactory {

    /**
     * 获得数据库连接
     * @param driverClass
     * @param url
     * @param username
     * @param password
     * @return
     */
    public static java.sql.Connection getConnection(String driverClass,String url,String username,String password) {
        try {
            Class.forName(driverClass);
            return DriverManager.getConnection(url,username,password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }




}
