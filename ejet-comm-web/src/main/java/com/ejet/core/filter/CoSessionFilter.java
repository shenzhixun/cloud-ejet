package com.ejet.core.filter;

import com.ejet.comm.Result;
import com.ejet.comm.exception.ExceptionCode;
import com.ejet.core.context.CoApplicationContext;
import com.ejet.core.global.CoGlobal;
import com.ejet.core.utils.HttpServletResponseUtils;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * session过滤器
 * @author Shen Yijie
 *
 */
public class CoSessionFilter implements Filter {
	final Logger logger = LoggerFactory.getLogger(CoSessionFilter.class);
	@Autowired
    private CoGlobal global;
    /**
     * 是否已经加载
     */
	private static boolean hasLoad = false;
	/**
     * 是否忽略该过滤器
     */
    private boolean ignore = false;
    /**
     * 被忽略的url
     */
    private List<String> urlExclude = new ArrayList<String>();
    /**
     * 初始化过滤器
     */
    @Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String ignoreValue = filterConfig.getInitParameter(CoSessionManager.OPEN_SESSION_AUTH);
        //只有当 ignoreValue 为"true"时，设置 ignore = true，为其他时 ignore = false;
        this.ignore = ignoreValue != null && ignoreValue.equalsIgnoreCase("true");
        loadConfig();
        //urlExclude.add(".*sys_user/login$".toLowerCase() );
        //urlExclude.add(".*sys_user/logout$".toLowerCase() );
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if (!ignore) {
			HttpServletRequest httpRequest = (HttpServletRequest) request;
	        HttpServletResponse httpResponse = (HttpServletResponse) response;
	        String url = httpRequest.getRequestURI();
	        if (!excepURL(url)) {
	        	//如果Session为空，则跳转到指定页面
	        	logger.info("Http sessionId: {}", httpRequest.getSession().getId());
	            if (CoSessionManager.getAttribute(CoSessionManager.USER_SESSION_KEY, httpRequest, httpResponse) == null) {
//	            	String redirectURL = httpRequest.getContextPath() + "/etl";
//	            	httpResponse.sendRedirect(redirectURL);
	            	Gson gson = new Gson();
	            	logger.info("{}未登录，跳转到登录页面", url);
	            	Result rs = new Result(ExceptionCode.SYS_TOKEN_TIMEOUT, new RuntimeException("用户未登录，或者长时间未操作!"));
                    HttpServletResponseUtils.writeResponse(gson.toJson(rs), "utf-8", (HttpServletResponse)response);
	            	return ;
	            }
	        }
		}
        chain.doFilter(request, response);// 执行过滤器链的下一个过滤器
	}

	/**
     * 验证请求的URL是否被忽略验证Session
     * @param url 请求的URL
     * @return true，忽略验证Session。
     */
    private boolean excepURL(String url) {
        if( url.charAt(url.length()-1)=='/' ){
            return true;
        }
        loadConfig();
        if(urlExclude.contains(url.toLowerCase())) {
        	return true;
        }
        //解析通配符
        for( int i=0, size=urlExclude.size(); i<size; i++ ) {
            String ignoreUrl = (String) urlExclude.get(i);
            try {
                if ( ignoreUrl!=null && Pattern.matches(ignoreUrl, url.toLowerCase()) ){
                    return true;
                }
            }catch (Exception e) {
                logger.error("过滤器解析错误", e);
            }
        }
        return false;
    }

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

    /**
     * 加载配置信息
     */
	private void loadConfig() {
	    if(hasLoad) return;
        if(global==null) {
            global = CoApplicationContext.getBean(CoGlobal.class);
        }
        if(global!=null) {
            List<String> ignoreURLs = global.getAuthIgnoreURLs();
            if(ignoreURLs!=null) {
                for(String item : ignoreURLs) {
                    urlExclude.add(item.toLowerCase());
                }
            }
            hasLoad = true;
        }
    }


}
