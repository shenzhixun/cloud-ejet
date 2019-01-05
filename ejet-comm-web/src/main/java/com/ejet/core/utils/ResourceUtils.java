package com.ejet.core.utils;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

/**
 * Copyright (C), 2016-2018, 武汉康华数海有限公司
 * FileName: ResourceUtils
 * Author:   Ejet
 * CreateDate:     2018-09-19 11:17
 * Description: 资源文件操作类
 * History:
 * Version: 1.0
 */
public class ResourceUtils {

    /**
     * 读取资源文件
     *
     * @param file
     * @return
     * @throws IOException
     */
    public static InputStream readFileByClassPathResource(String file) throws IOException {
        InputStream inputStream = null;
        ClassPathResource resource = new ClassPathResource(file);
        return resource.getInputStream();
    }









}
