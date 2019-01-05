package com.ejet.core.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * session管理
 *
 */
public class CoSessionManager {

    /**
     * 保存session对应key信息
     */
	public static final String USER_SESSION_KEY = "MY_USER_SESSION_KEY";
	public static final String OPEN_SESSION_AUTH = "openSessionAuth";

	private CoSessionManager(){}

	/**
	 * 设置session值
	 * @param key
	 * @param value
	 * @param request
	 * @param response
	 */
	public static void setAttribute(String key, Object value, HttpServletRequest request, HttpServletResponse response){
		request.getSession().setAttribute(key, value);
	}

	/**
	 * 获取session值
	 * @param key
	 * @param request
	 * @param response
	 * @return
	 */
	public static Object getAttribute(String key, HttpServletRequest request, HttpServletResponse response){
		if(request.getSession(false)==null)
			return null;
		Object obj = request.getSession(false).getAttribute(key);
		return obj;
	}

	/**
	 * 删除指定session
	 * @param key
	 * @param request
	 * @param response
	 */
	public static void removeAttribute(String key, HttpServletRequest request, HttpServletResponse response){
		if(request.getSession(false)==null)
			return;
		request.getSession(false).removeAttribute(key);
	}

	/**
	 * 删除所有session
	 * @param request
	 * @param response
	 */
	public static void invalidate(HttpServletRequest request, HttpServletResponse response){
		request.getSession().invalidate();
	}




}
