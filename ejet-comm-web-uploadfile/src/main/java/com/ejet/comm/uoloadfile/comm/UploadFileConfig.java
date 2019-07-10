package com.ejet.comm.uoloadfile.comm;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Copyright (C), 2016-2018, 武汉康华数海有限公司
 * FileName: UploadFileConfig
 * Author:   ShenYijie
 * CreateDate:     2018-11-09 13:31
 * Description: 上传文件配置信息
 * History:
 * Version: 1.0
 */
@Component
@ConfigurationProperties(prefix="ejet-comm-web")
public class UploadFileConfig {
    /**
     * 存储物理路径
     */
    String storagePhysicalPath;
    /**
     * 访问路径
     */
    String relativeURL;
    /**
     * 是否分类存储
     */
    boolean storageType = false;
    /**
     * 存储按天日期
     */
    boolean storageByDate = false;
    /**
     * 是否更改文件名称
     * @return
     */
    boolean changeFilename = false;

    public String getStoragePhysicalPath() {
        return storagePhysicalPath;
    }

    public void setStoragePhysicalPath(String storagePhysicalPath) {
        this.storagePhysicalPath = storagePhysicalPath;
    }

    public String getRelativeURL() {
        return relativeURL;
    }

    public void setRelativeURL(String relativeURL) {
        this.relativeURL = relativeURL;
    }

    public boolean isStorageType() {
        return storageType;
    }

    public void setStorageType(boolean storageType) {
        this.storageType = storageType;
    }

    public boolean isStorageByDate() {
        return storageByDate;
    }

    public void setStorageByDate(boolean storageByDate) {
        this.storageByDate = storageByDate;
    }

    public boolean isChangeFilename() {
        return changeFilename;
    }

    public void setChangeFilename(boolean changeFilename) {
        this.changeFilename = changeFilename;
    }
}
