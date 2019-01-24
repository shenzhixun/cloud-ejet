package com.ejet.comm;

/**
 * Copyright (C), 2016-2018, 武汉康华数海有限公司
 * FileName: ModuleVersion
 * Author:   Ejet
 * CreateDate:     2018-09-26 17:23
 * Description: 模块版本信息
 * History:
 * Version: 1.0
 */
public class ModuleVersion {

    private String moduleName;
    private String moduleVersion;
    private String lastModifyTime;
    private String modifyUser;
    private String owner;

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleVersion() {
        return moduleVersion;
    }

    public void setModuleVersion(String moduleVersion) {
        this.moduleVersion = moduleVersion;
    }

    public String getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(String lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
