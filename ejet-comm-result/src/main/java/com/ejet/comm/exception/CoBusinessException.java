package com.ejet.comm.exception;

/**
 * 业务异常统一处理
 * 
 * @author ShenYijie
 *
 */
public class CoBusinessException extends BaseException {

	public CoBusinessException(String errorCode) {
		super(errorCode, ExceptionCode.getMessage(errorCode));
	}

	public CoBusinessException(String errorCode, String msg) {
		super(errorCode, msg);
	}

	public CoBusinessException(String errorCode, Throwable t) {
		super(errorCode, ExceptionCode.getMessage(errorCode), t);
	}

	/**
	 * 异常堆栈增加错误代码和绑定变量
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("业务异常，异常代码[").append(this.code).append("]\n");
		sb.append("异常信息:[").append(this.msg).append("]\n");
        sb.append("异常详情:[").append(this.detail).append("]\n");
		return sb.toString();
	}

}
