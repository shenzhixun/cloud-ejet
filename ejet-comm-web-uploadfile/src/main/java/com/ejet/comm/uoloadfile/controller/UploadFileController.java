package com.ejet.comm.uoloadfile.controller;

import com.ejet.comm.Result;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.comm.uoloadfile.comm.ExceptionCodeUploadfile;
import com.ejet.comm.uoloadfile.comm.UploadFileConfig;
import com.ejet.comm.uoloadfile.comm.UploadFileMeta;
import com.ejet.comm.utils.PinyinUtils;
import com.ejet.comm.utils.UuidUtils;
import com.ejet.comm.utils.io.FileUtils;
import com.ejet.comm.utils.time.TimeUtils;
import com.ejet.core.base.ControllerBase;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.ejet.comm.exception.ExceptionCode.SYS_ERROR;

/**
 * Copyright (C), 2016-2018, 武汉康华数海有限公司
 * FileName: UploadController
 * Author:   ShenYijie
 * CreateDate:     2018-11-09 9:40
 * Description: 上传文件接口
 * History:
 * Version: 1.0
 */
@RestController
@RequestMapping(value="/file")
public class UploadFileController extends ControllerBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(UploadFileController.class);

    @Autowired
    private UploadFileConfig config;

    @PostMapping("/upload")
    @ResponseBody
    public Result upload(@RequestParam("file") MultipartFile file) {
        Result rs = new Result();
        try {
            if (file.isEmpty()) {
                rs = new Result(ExceptionCodeUploadfile.SYS_FILE_UPLOAD_NO_FILE_SELECT);
            }
            UploadFileMeta item = new UploadFileMeta();
            item.setFieldName(file.getName());

            UploadFileMeta itemFile = deal(file);
            BeanUtils.copyProperties(item, itemFile);
            rs  = new Result(item);
        }catch (CoBusinessException e) {
            LOGGER.error("", e);
            rs = new Result(e.getCode(), e);
        }catch (Exception e) {
            LOGGER.error("", e);
            rs = new Result(SYS_ERROR, e);
        }
        return rs;
    }


    //多文件上传
    @RequestMapping(value = "/upload/batch", method = RequestMethod.POST)
    @ResponseBody
    public Result handleFileUpload(HttpServletRequest request) {
        Result rs = new Result();
        try {
            List<UploadFileMeta> data = new ArrayList<>();
            List<MultipartFile> files = ((MultipartHttpServletRequest)request).getFiles("file");
            if(files==null || files.size()==0) {
                throw new CoBusinessException(ExceptionCodeUploadfile.SYS_FILE_UPLOAD_NO_FILE_SELECT);
            }
            MultipartFile file = null;
            for (int i = 0; i < files.size(); ++i) {
                file = files.get(i);
                UploadFileMeta item = new UploadFileMeta();
                item.setFieldName(file.getName());
                if (!file.isEmpty()) {
                    try {
                        UploadFileMeta itemFile = deal(file);
                        BeanUtils.copyProperties(item, itemFile);
                    } catch (Exception e) {
                        item.setFileError(e.getMessage());
                    }
                } else {
                    item.setFileError(" file is empty!");
                }
                data.add(item);
            }
            rs = new Result(data);
        }catch (CoBusinessException e) {
            LOGGER.error("", e);
            rs = new Result(e.getCode(), e);
        }catch (Exception e) {
            LOGGER.error("", e);
            rs = new Result(SYS_ERROR, e);
        }
        return rs;
    }

    /**
     * 处理请求包
     */
    public UploadFileMeta deal(MultipartFile file) throws CoBusinessException, IOException {
        if (file==null || file.isEmpty()) {
            throw new CoBusinessException(ExceptionCodeUploadfile.SYS_FILE_UPLOAD_NO_FILE_SELECT);
        }
        UploadFileMeta item = new UploadFileMeta();

        String name = file.getName();
        item.setName(name);

        String originalFilename = file.getOriginalFilename();
        item.setOriginalFilename(originalFilename);

        String extension = FileUtils.getFileExtension(originalFilename);
        item.setExtension(extension);

        String contentType = file.getContentType(); // MIME类型
        item.setContentType(contentType);

        String fileName = FileUtils.getFileName(originalFilename);
        String storageFilename = originalFilename;
        if(config.isChangeFilename()) {
            String pinName = PinyinUtils.getPinYin(fileName);//获得客户端文件拼音
            if(pinName!=null && pinName.length()>30) { //获取拼音后名字太长，截取
                pinName = pinName.substring(0, 30);
            }
            storageFilename = UuidUtils.getUUID() + "_" + pinName + "." + extension;
        }
        item.setStorageFilename(storageFilename);

        String physicalPath = config.getStoragePhysicalPath();
        String relativeURL = config.getRelativeURL();

        physicalPath = physicalPath.replaceAll("\\\\", "/");
        physicalPath = physicalPath.endsWith("/") ? physicalPath : physicalPath + "/";

        relativeURL = relativeURL.replaceAll("\\\\", "/");
        relativeURL = relativeURL.endsWith("/") ? relativeURL : relativeURL + "/";

        String typePath = getTypePath(contentType);
        if(config.isStorageType()) { //分类存储
            physicalPath += typePath;
            relativeURL += typePath;
        }
        item.setStorageRelativePath(typePath + storageFilename);

        File dest = new File(physicalPath, storageFilename);
        item.setStoragePhysicalPath(dest.getPath());

        item.setRelativeURL(relativeURL + storageFilename);

        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();// 新建文件夹
        }

        // try {
        //     InputStream inputStream = files.getInputStream();
        //     OutputStream out = new FileOutputStream(new File("c://12.jpg"))) {
        // } catch (Exception e) {
        //
        // }

        file.transferTo(dest);// 文件写入
        item.setFileSize(file.getSize());
        item.setFileMd5(DigestUtils.md5DigestAsHex(new FileInputStream(dest)));
        return item;
    }


    public String getTypePath(String contentType) {
        String local = "file";
        if(contentType==null || contentType.equals("")) {
            return local;
        }
        if(contentType.contains("video")) {
            local = "video";
        }else if(contentType.contains("image")) {
            local = "image";
        }else if(contentType.contains("audio")) {
            local = "audio";
        }else if(contentType.contains("html")) {
            local = "html";
        }
        //按日期建文件夹
        if(config.isStorageByDate()) {
            local = local.endsWith("/") ? local : local + "/";
            String day = TimeUtils.getCurrentDay();
            local+=day;
        }
        local = local.endsWith("/") ? local : local + "/";
        return local;
    }



}
