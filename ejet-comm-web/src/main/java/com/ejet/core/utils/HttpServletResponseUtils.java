package com.ejet.core.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ejet.comm.Page;
import com.ejet.comm.Result;
import com.ejet.comm.exception.CoBusinessException;
import com.ejet.comm.exception.ExceptionCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Copyright (C), 2016-2018, 武汉康华数海有限公司
 * FileName: HttpServletResponseUtils
 * Author:   Ejet
 * CreateDate:     2018/9/28 16:52
 * Description: response工具类
 * History:
 * Version: 1.0
 */
public class HttpServletResponseUtils {

    final static Logger logger = LoggerFactory.getLogger(HttpServletResponseUtils.class);
    final static String ERROR = "服务器返回数据为空，请联系管理员检查!";
    /**
     * 写入数据到response对象
     *
     * @param result
     * @param character
     * @param response
     */
    public static void writeResponse(String result, String character, HttpServletResponse response) {
        response.setHeader("ContentType", "text/json");
        response.setHeader("Connection", "close");
        response.setCharacterEncoding(character);
        PrintWriter pw = null;
        try {
            pw = response.getWriter();
            pw.write(result);
            pw.flush();
            pw.close();
        } catch (IOException e) {
            logger.error("", e);
        } finally {
            if (null != pw) {
                pw.flush();
                pw.close();
            }
        }
    }

    /**
     * 根据错误，返回json消息
     * @param ex
     * @return
     */
    private static JSONObject getVO(CoBusinessException ex) {
        JSONObject json = new JSONObject();
        if(ex==null) {
            json.put("code", ExceptionCode.SYS_ERROR);
            json.put("msg", ERROR);
            return json;
        }
        json.put("code", ex.getCode()==null ? ExceptionCode.SYS_ERROR : ex.getCode());
        json.put("msg", ex.getMessage()==null ? "服务器返回数据为空，请联系管理员检查!" : ex.getMessage());
        json.put("detail", com.ejet.comm.utils.io.IOUtils.getError(ex));
        return json;
    }

    /**
     * 根据Result返回json消息
     * @return
     */
    private static JSONObject getVO(Result rs) {
        JSONObject json = new JSONObject();
        if(rs==null) {
            json.put("code", ExceptionCode.SYS_ERROR);
            json.put("msg", ERROR);
            return json;
        }
        json.put("code", rs.getCode()==null ? ExceptionCode.SYS_ERROR : rs.getCode());
        json.put("data", rs.getData()==null ? "服务器返回数据为空，请联系管理员检查!" : rs.getData());
        json.put("page", rs.getPage()==null ? new Page() : rs.getPage());
        return json;
    }
    /**
     * 返回错误信息
     */
    protected void responseJson(HttpServletResponse response, String code, String message, Throwable e) {
        JSONObject json = new JSONObject();
        if (code != null && message!=null ) {
            json.put("code", code);
            json.put("msg", message);
        } else {
            json.put("code", ExceptionCode.SYS_ERROR);
            json.put("msg", "返回数据设置为空，请检查!");
        }
        if(e!=null) {
            json.put("detail", com.ejet.comm.utils.io.IOUtils.getError(e));
        }
        writeResponse(json.toString(), "UTF-8", response);
    }

    /**
     * 返回数据信息
     * @param response
     */
    public static void responseJson(HttpServletResponse response, CoBusinessException bus) {
        String result = null;
        JSONObject json = (JSONObject) JSON.toJSON(getVO(bus));
        result = json.toString();
        writeResponse(result, "UTF-8", response);
    }

    /**
     * 返回数据信息
     */
    public static void responseJson(HttpServletResponse response, Result rs) {
        String result = null;
        JSONObject json = (JSONObject) JSON.toJSON(getVO(rs));
        result = json.toString();
        writeResponse(result, "UTF-8", response);
    }







}
