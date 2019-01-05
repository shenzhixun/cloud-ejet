package com.ejet.core.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Copyright (C), 2016-2018, 武汉康华数海有限公司
 * FileName: HttpServletResponseUtils
 * Author:   Ejet
 * CreateDate:     2018/9/28 16:52
 * Description: request工具类
 * History:
 * Version: 1.0
 */
public class HttpServletRequestUtils {

    final static Logger logger = LoggerFactory.getLogger(HttpServletRequestUtils.class);
    /**
     * 获取post请求的byte[] 数组
     */
    public static byte[] getRequestPostBytes(HttpServletRequest request) {
        byte buffer[] = null;
        try {
            int contentLength = request.getContentLength();
            if(contentLength<0){
                return null;
            }
            buffer = new byte[contentLength];
            for (int i = 0; i < contentLength;) {
                int readlen = request.getInputStream().read(buffer, i,contentLength - i);
                if (readlen == -1) {
                    break;
                }
                i += readlen;
            }

        } catch (IOException e) {
            logger.error("", e);
        } finally {
        }
        return buffer;
    }

    /**
     * 获取post请求内容
     * @param request
     * @return
     */
    public static String getRequestPostString(HttpServletRequest request) {
        String result = null;
        try {
            byte buffer[] = getRequestPostBytes(request);
            String charEncoding = request.getCharacterEncoding();
            if (charEncoding == null) {
                charEncoding = "UTF-8";
            }
            result = new String(buffer, charEncoding);
        } catch (IOException e) {
            logger.error("", e);
        }
        return result;
    }

    /**
     * 获取 request 中 json 字符串的内容
     *
     * @param request
     * @return
     * @throws IOException
     */
    public static String getRequestJsonString(HttpServletRequest request) {
        try {
            String submitMehtod = request.getMethod();
            if (submitMehtod.equals("GET")) {
                return new String(request.getQueryString().getBytes("iso-8859-1"),"utf-8").replaceAll("%22", "\"");
            } else {
                return getRequestPostString(request);
            }
        } catch (IOException e) {
            logger.error("", e);
        }
        return null;
    }




}
