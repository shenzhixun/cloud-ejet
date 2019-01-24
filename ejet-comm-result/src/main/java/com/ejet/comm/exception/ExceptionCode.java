package com.ejet.comm.exception;


import java.util.HashMap;
import java.util.Map;


/**
 *格式化返回客户端数据格式（json）
 * 
 * @author Ejet
 *
 */
public class ExceptionCode {
	
	public static Map<String,String> messageMap = new HashMap<String, String>();

	//初始化状态码与文字说明,后期可以放入到数据库中，根据返回码，自定义返回信息
    static {
    	
    	put(ExceptionCode.SUCCESS, "success");
        put(ExceptionCode.SYS_HINT, "[服务器]自定义提示!");
        put(ExceptionCode.SYS_ERROR, "[服务器]系统异常,请联系管理员!");
        put(ExceptionCode.SYS_TOKEN_TIMEOUT, "[服务器]您长时间未操作，系统自动退出!");

        //============== 权限 ===============================
        put(ExceptionCode.RIGHTS_ROLE_NO_SELECTED, "角色未分配任何权限");
        put(ExceptionCode.RIGHTS_ROLE_TYPE_NO_SELECTED, "角色类型未选择!");
        put(ExceptionCode.RIGHTS_USER_NO_SELECTED, "用户未分配任何权限");
        put(ExceptionCode.RIGHTS_USER_NO_ROLES, "用户未分配任何角色");
        put(ExceptionCode.RIGHTS_ROLES_NOT_EXIST, "角色不存在，或者停用");
        
        //============== 基础参数 ===============================
        put(ExceptionCode.PARAM_MISSING, "缺少参数或值为空");
        put(ExceptionCode.PARAM_INVALID, "参数不合法");
        put(ExceptionCode.PARAM_MISSING_ID, "参数ID缺失");
        put(ExceptionCode.LOGIC_ERROR_DATABASE, "[逻辑错误]数据库数据异常");
        

        //============== 用户账户 ===============================
        put(ExceptionCode.USER_UNREGISTER, "用户未注册");
        put(ExceptionCode.USER_AREADY_REGISTER, "用户已注册");
        put(ExceptionCode.USER_OR_PASSWD_ERROR, "用户名或密码错误");
        put(ExceptionCode.USER_NO_LOGIN, "请重新登录");
        put(ExceptionCode.USER_STATE_UNNORMAL, "用户帐号冻结");
        put(ExceptionCode.USER_STATE_STOP, "用户账号停用");
        put(ExceptionCode.USER_ACCOUNT_EXIST, "登录账号已存在，请检查后重试");
        put(ExceptionCode.USER_ACCOUNT_ERROR, "启用状态账号无法删除");
        put(ExceptionCode.CODE_FAIL, "验证码错误，请重新输入！");
        put(ExceptionCode.MODIF_PWD_FAIL, "修改密码失败！");

    }

    /**
     * 获取业务返回码信息
     * 
     * @param code
     * @return
     */
    public static String getMessage(String code) {
    	String message = " [提示] " + code;
    	String obj = messageMap.get(code);
    	return obj==null ? message : obj;
    }
    
    /**
     * 返回码放入map中
     * 
     * @param m
     */
    public static void putAll(Map<String,String> m) {
    	messageMap.putAll(m);
    }
    
    /**
     * 放入到map中
     */
    public static void put(String key, String value) {
    	if(key==null || "".equals(key.trim()) || value==null || "".equals(value.trim())) {
    		return;
    	}
    	messageMap.put(key, value);
    }
	
    
   //===================================================
    /** 成功 */
    public static final String SUCCESS = "100000";
    /** 系统提示信息*/
    public static final String SYS_HINT = "100001";
    /** 系统异常,请联系管理员! */
    public static final String SYS_ERROR = "100002";
    /** 特殊码， session超时，或者token失效*/
    public static final String SYS_TOKEN_TIMEOUT = "100003";
    //===================================================

    /** 缺少参数或值为空 */
    public static final String PARAM_MISSING = "110001";
    /** 参数不合法 */
    public static final String PARAM_INVALID = "110002";
    /** 缺少参数Id */
    public static final String PARAM_MISSING_ID = "110003";
    /** 数据库查询数据逻辑异常 */
    public static final String LOGIC_ERROR_DATABASE = "110004";
    


   //=== 角色 权限 910001================================================
    /** 角色未分配任何权限 */
    public static final String RIGHTS_ROLE_NO_SELECTED = "910001";
    /** 用户未分配任何权限 */
    public static final String RIGHTS_USER_NO_SELECTED = "910002";
    /** 用户未分配任何角色 */
    public static final String RIGHTS_USER_NO_ROLES = "910003";
    /** 角色不存在或者停用 */
    public static final String RIGHTS_ROLES_NOT_EXIST = "910004";
    /** 角色类型未选择 */
    public static final String RIGHTS_ROLE_TYPE_NO_SELECTED = "910005";

    //============用户 登录 ===============
    /** 用户未注册 */
    public static final String USER_UNREGISTER = "920001";
    /** 用户已注册 */
    public static final String USER_AREADY_REGISTER = "920002";
    /** 用户名或者密码错误 */
    public static final String USER_OR_PASSWD_ERROR = "920003";
    /** 用户状态不正常 */
    public static final String USER_STATE_UNNORMAL = "920004";
    /** 用户未登录 */
    public static final String USER_NO_LOGIN = "920005";
    /** 用户账号停用 */
    public static final String USER_STATE_STOP = "920006";
    /** 登录账号已存在，请检查后重试  */
    public static final String USER_ACCOUNT_EXIST = "920007";
    /** 启用状态账号无法删除 */
    public static final String USER_ACCOUNT_ERROR = "920008";
    /**验证码错误，请重新输入！*/
    public static final String CODE_FAIL="920009";
    /**修改密码失败！*/
    public static final String MODIF_PWD_FAIL = "920010";

    

}
