package com.ejet.comm.uoloadfile.comm;


import com.ejet.comm.exception.ExceptionCode;

/**
 * Copyright (C), 2016-2018, 武汉康华数海有限公司
 * FileName: ExceptionCodeUploadfile
 * Author:   ShenYijie
 * CreateDate:     2018-11-09 17:11
 * Description: 常量
 * History:
 * Version: 1.0
 */
public class ExceptionCodeUploadfile extends ExceptionCode {
    /** [文件上传]请检查您的表单的enctype属性，确定是multipart/form-data */
    public static final String SYS_FILE_UPLOAD_TYPE_INVALID = "12001";
    /** [文件上传]上传文件校验失败（提示:单个文件最大30M,总大小40M)! */
    public static final String SYS_FILE_UPLOAD_TOO_LARGE = "12002";
    /** [文件上传]没有选择上传文件! */
    public static final String SYS_FILE_UPLOAD_NO_FILE_SELECT = "12003";
    /** [文件上传]上传文件错误! */
    public static final String SYS_FILE_UPLOAD_ERROR = "12004";
    /**文件导出失败！*/
    public static final String DOWNLOAD_FILE_DEFEATED = "12005";
    /**文件格式错误，请导入正确文件模板！*/
    public static final String DOWNLOAD_FORMAT_ERROR = "12006";

    static {
        System.out.println("***(((((ExceptionCodeFlow***" + messageMap.size());
        put(SYS_FILE_UPLOAD_TYPE_INVALID, "[文件上传]请检查您的表单的enctype属性，确定是multipart/form-data");
        put(SYS_FILE_UPLOAD_TOO_LARGE, "[文件上传]上传文件校验失败（提示:单个文件太大)!");
        put(SYS_FILE_UPLOAD_NO_FILE_SELECT, "[文件上传]没有选择上传文件!");
        put(SYS_FILE_UPLOAD_ERROR, "[文件上传]上传文件错误!");
        put(DOWNLOAD_FILE_DEFEATED, "文件导出失败！");
    }
}
