package com.ejet.comm.exception;

/**
 * 统一异常处理
 * 
 * @author Shen Yijie
 *
 */
public abstract class BaseException extends Exception {
	/**
	 * 错误代码
	 */
	protected String code = ExceptionCode.SYS_ERROR;
	/**
	 * 错误信息（可以是包装的业务异常）
	 */
	protected String msg = "系统异常，请联系系统管理员!";
	/**
	 * 错误详细信息
	 */
	protected String detail;
	
	protected BaseException(String errorMessage) {
		super(errorMessage);
		this.msg = errorMessage;
	}
	
	protected BaseException(String errorCode, String errorMessage) {
		super(errorMessage);
		this.code = errorCode;
		this.msg = errorMessage;
	}

	protected BaseException(String errorCode, String errorMessage, Throwable t) {
		super(errorMessage, t);
		this.code = errorCode;
		this.msg = errorMessage;
		this.detail = t.getMessage();
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	/**
	 * 异常堆栈增加错误代码和绑定变量
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("系统异常，异常代码[").append(this.code).append("]\n");
		sb.append("异常信息:[").append(this.msg).append("]\n");
		sb.append("异常详情:[").append(this.detail).append("]\n");
		sb.append(super.toString());
		return sb.toString();
	}
	
}