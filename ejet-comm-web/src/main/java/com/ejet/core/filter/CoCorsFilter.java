package com.ejet.core.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 跨域过滤器
 *
 * spring boot 会按照order值的大小，从小到大的顺序来依次过滤。
 *
 * @author ShenYijie
 *
 */
public class CoCorsFilter implements Filter {
	final Logger logger = LoggerFactory.getLogger(CoCorsFilter.class);
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res;
		HttpServletRequest request=(HttpServletRequest)req;
		response.setContentType("textml;charset=UTF-8");
		String origin =request.getHeader("Origin") ;
		if(origin == null ) {
		    origin = "*" ;
		}
		response.setHeader("Access-Control-Allow-Origin", origin);
        response.addHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        response.addHeader("Access-Control-Allow-Headers",
        		"Content-Type, Access-Control-Allow-Headers, withCredentials, X-Requested-With, User-Agent, Authorization, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires,  X-E4M-With");
        response.addHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("XDomainRequestAllowed","1");
        response.setHeader("Access-Control-Max-Age","3600");
        response.addHeader("Expires", "-1");
        response.addHeader("Cache-Control", "no-cache");
        response.addHeader("pragma", "no-cache");
        //logger.info("*********************************跨域过滤器被使用**************************");
        chain.doFilter(req, res);
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
