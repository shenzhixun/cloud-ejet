package com.ejet.core.db.druid;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * 忽略静态资源拦截， druid对应的web资源过滤，监控sql性能
 */
@WebFilter(filterName = "druidStatFilter", urlPatterns = "/*",
		initParams = {	@WebInitParam(name = "exclusions",
		value = "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")// 忽略资源
})
public class DruidStatFilter extends WebStatFilter {




}
