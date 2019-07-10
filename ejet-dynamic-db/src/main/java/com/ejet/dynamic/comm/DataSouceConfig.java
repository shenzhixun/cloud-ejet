package com.ejet.dynamic.comm;


import com.ejet.comm.db.CoDataSourceConfig;
import lombok.Data;

@Data
public class DataSouceConfig extends CoDataSourceConfig {

    private String dbType;

    private String dbIp;

    private String dbPort;

    private String dbName;

    private Integer status;

    private String description;

    private String remark;


}
