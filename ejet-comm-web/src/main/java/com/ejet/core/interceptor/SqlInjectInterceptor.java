package com.ejet.core.interceptor;

import com.ejet.core.base.InterceptorBase;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.regex.Pattern;

/**
 * Copyright (C), 2016-2018, 武汉康华数海有限公司
 * FileName: SqlInjectInterceptor
 * Author:   Ejet
 * CreateDate:     2018-09-16 10:19
 * Description: 防止sql注入
 * History:
 * Version: 1.0
 */
@Component
public class SqlInjectInterceptor extends InterceptorBase {

    /**
     * 防止sql注入的过滤表达式
     */
    private static Pattern scriptPattern = Pattern.compile("<[\r\n| | ]*script[\r\n| | ]*>(.*?)</[\r\n| | ]*script[\r\n| | ]*>", Pattern.CASE_INSENSITIVE);
    private static Pattern srcPattern = Pattern.compile("src[\r\n| | ]*=[\r\n| | ]*[\\\"|\\\'](.*?)[\\\"|\\\']", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
    private static Pattern scriptPattern2 = Pattern.compile("</[\r\n| | ]*script[\r\n| | ]*>", Pattern.CASE_INSENSITIVE);
    private static Pattern scriptPattern3 = Pattern.compile("<[\r\n| | ]*script(.*?)>", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
    private static Pattern evalPattern = Pattern.compile("eval\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
    private static Pattern exPattern = Pattern.compile("e-xpression\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
    private static Pattern jsPattern = Pattern.compile("javascript[\r\n| | ]*:[\r\n| | ]*", Pattern.CASE_INSENSITIVE);
    private static Pattern vbPattern = Pattern.compile("vbscript[\r\n| | ]*:[\r\n| | ]*", Pattern.CASE_INSENSITIVE);
    private static Pattern onloadPattern = Pattern.compile("onload(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);

    /**
     * Controller处理之前拦截处理，对传入的参数进行拦截处理
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            String[] values = request.getParameterValues(name);
            for (String value : values) {
                value = sqlEncoder(value);
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    @Override
    public String[] excludePathPatterns() {
        return new String[0];
    }

    /**
     * 对参数进行拦截替换
     *
     * @param value
     * @return
     */
    private String sqlEncoder(String value) {
        if (value != null) {
            //处理转义
            value = value.replaceAll("<", "<").replaceAll(">", ">");
            value = value.replaceAll("\\(", "(").replace("\\)", ")");
            value = value.replaceAll("'", "'");
            value = value.replaceAll("#", "#");
            value = value.replaceAll("&", "&");

            value = scriptPattern.matcher(value).replaceAll("");
            value = srcPattern.matcher(value).replaceAll("");
            value = scriptPattern2.matcher(value).replaceAll("");
            value = scriptPattern3.matcher(value).replaceAll("");
            value = evalPattern.matcher(value).replaceAll("");
            value = exPattern.matcher(value).replaceAll("");
            value = jsPattern.matcher(value).replaceAll("");
            value = vbPattern.matcher(value).replaceAll("");
            value = onloadPattern.matcher(value).replaceAll("");
        }
        return value;
    }
}
