package com.ejet.comm.uoloadfile.comm;

import java.io.Serializable;

public class UploadFileMeta implements Serializable {
    /**
     * 控件名称
     */
	String fieldName;
    /**
     *  名字
     */
	String name;
    /**
     * 名字
     */
    String originalFilename;
    /**
     * 扩展名
     */
	String extension;
    /**
     * 文件类型
     */
	String contentType;
    /**
     * 文件大小
     */
    Long fileSize;
    /**
     * 文件大小
     */
    String fileMd5;
    /**
     * 播放时长(媒体文件)
     */
    Long timeLength;

    /**
     * 存储物理路径
     */
    String storagePhysicalPath;
    /**
     * 存储文件名
     */
    String storageFilename;
    /**
     * 存储相对路径
     */
    String storageRelativePath;
    /**
     * 访问相对路径（外部程序）
     */
    String relativeURL;
    /**
     * 处理文件错误
     */
    String fileError;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginalFilename() {
        return originalFilename;
    }

    public void setOriginalFilename(String originalFilename) {
        this.originalFilename = originalFilename;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileMd5() {
        return fileMd5;
    }

    public void setFileMd5(String fileMd5) {
        this.fileMd5 = fileMd5;
    }

    public Long getTimeLength() {
        return timeLength;
    }

    public void setTimeLength(Long timeLength) {
        this.timeLength = timeLength;
    }

    public String getStoragePhysicalPath() {
        return storagePhysicalPath;
    }

    public void setStoragePhysicalPath(String storagePhysicalPath) {
        this.storagePhysicalPath = storagePhysicalPath;
    }

    public String getStorageRelativePath() {
        return storageRelativePath;
    }

    public void setStorageRelativePath(String storageRelativePath) {
        this.storageRelativePath = storageRelativePath;
    }

    public String getRelativeURL() {
        return relativeURL;
    }

    public void setRelativeURL(String relativeURL) {
        this.relativeURL = relativeURL;
    }

    public String getStorageFilename() {
        return storageFilename;
    }

    public void setStorageFilename(String storageFilename) {
        this.storageFilename = storageFilename;
    }

    public String getFileError() {
        return fileError;
    }

    public void setFileError(String fileError) {
        this.fileError = fileError;
    }

    @Override
    public String toString() {
        return "UploadFileMeta{" +
                "fieldName='" + fieldName + '\'' +
                ", name='" + name + '\'' +
                ", originalFilename='" + originalFilename + '\'' +
                ", extension='" + extension + '\'' +
                ", contentType='" + contentType + '\'' +
                ", fileSize=" + fileSize +
                ", storageFilename='" + storageFilename + '\'' +
                ", storagePhysicalPath='" + storagePhysicalPath + '\'' +
                ", storageRelativePath='" + storageRelativePath + '\'' +
                ", relativeURL='" + relativeURL + '\'' +
                '}';
    }
}
