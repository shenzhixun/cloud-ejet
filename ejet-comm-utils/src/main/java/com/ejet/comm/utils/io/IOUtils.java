package com.ejet.comm.utils.io;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * IO操作类
 * 
 * @author ShenYijie
 * @Description: TODO(  )
 * @date 2018年8月6日
 *
 */
public class IOUtils {

	/**
	 * 关闭连接
	 * 
	 * @param stm
	 */
	public static void closeQuietly(AutoCloseable stm) {
		try {
			if (stm != null) {
				stm.close();
				stm = null;
			}
		} catch (Exception ioe) {
			// ignore
		}
	}
	/**
	 * 关闭连接
	 */
	public static void closeQuietly(Closeable closeable) {
		try {
			if (closeable != null) {
				closeable.close();
				closeable = null;
			}
		} catch (IOException ioe) {
			// ignore
		}
	}
	/**
	 * error message
	 * 
	 * @param ex
	 * @return
	 */
	public static String getError(Throwable ex) {
		StringWriter sw = new StringWriter();
		try {
			PrintWriter pw = new PrintWriter(sw);
			ex.printStackTrace(pw);
			Throwable cause = ex.getCause();
			while (null != cause) {
				cause.printStackTrace(pw);
				cause = cause.getCause();
			}
			pw.close();
			sw.append(pw.toString()).append("\r\n");
		} catch (Exception e) {
			// Log.e("", "", e);
		}
		return sw.toString();
	}

	/**
	 * 获得调用的类及函数信息
	 * 
	 * @return
	 */
	public static String generateTag() {
		StackTraceElement caller = Thread.currentThread().getStackTrace()[4];
		String tag = "%s.%s(Line:%d)"; // 占位符
		String callerClazzName = caller.getClassName(); // 获取到类名
		callerClazzName = callerClazzName.substring(callerClazzName
				.lastIndexOf(".") + 1);
		tag = String.format(tag, callerClazzName, caller.getMethodName(),
				caller.getLineNumber()); // 格式化输出
		return tag;
	}
	
	

}
