package com.ejet.comm.utils.thread;

/**
 * 线程池配置bean对象
 * 
 * @author ShenYijie
 * @Description: TODO(  )
 * @date 2018年8月6日
 *
 */
public class ThreadPoolConfig {
	/**
	 * 核心线程数，核心线程会一直存活，即使没有任务需要处理。 当线程数小于核心线程数时，即使现有的线程空闲，线程池也会优先创建新线程来处理任务，
	 * 而不是直接交给现有的线程处理。 核心线程在allowCoreThreadTimeout被设置为true时会超时退出，默认情况下不会退出。
	 */
	private int corePoolSize = 5;
	/**
	 * 当线程数大于或等于核心线程，且任务队列已满时，线程池会创建新的线程，直到线程数量达到maxPoolSize。
	 * 如果线程数已等于maxPoolSize，且任务队列已满，则已超出线程池的处理能力，线程池会拒绝处理任务而抛出异常。
	 */
	private int maximumPoolSize = 30;
	
	private int poolSize = 40;
	/**
	 * 当线程空闲时间达到keepAliveTime，该线程会退出，直到线程数量等于corePoolSize。
	 * 如果allowCoreThreadTimeout设置为true，则所有线程均会退出直到线程数量为0。
	 */
	private int keepAliveTime = 200;
	
	private int waitThreadSize = 30;
	/**
	 * 是否允许核心线程空闲退出，默认值为false。
	 */
	private boolean allowCoreThreadTimeOut = false;

	public int getCorePoolSize() {
		return corePoolSize;
	}

	public void setCorePoolSize(int corePoolSize) {
		this.corePoolSize = corePoolSize;
	}

	public int getMaximumPoolSize() {
		return maximumPoolSize;
	}

	public void setMaximumPoolSize(int maximumPoolSize) {
		this.maximumPoolSize = maximumPoolSize;
	}

	public int getPoolSize() {
		return poolSize;
	}

	public void setPoolSize(int poolSize) {
		this.poolSize = poolSize;
	}

	public int getKeepAliveTime() {
		return keepAliveTime;
	}

	public void setKeepAliveTime(int keepAliveTime) {
		this.keepAliveTime = keepAliveTime;
	}

	public int getWaitThreadSize() {
		return waitThreadSize;
	}

	public void setWaitThreadSize(int waitThreadSize) {
		this.waitThreadSize = waitThreadSize;
	}

	public boolean isAllowCoreThreadTimeOut() {
		return allowCoreThreadTimeOut;
	}

	public void setAllowCoreThreadTimeOut(boolean allowCoreThreadTimeOut) {
		this.allowCoreThreadTimeOut = allowCoreThreadTimeOut;
	}

	public String toString() {
		StringBuffer info = new StringBuffer();
		info.append("============  线程池 配置 ================").append("\r\n");
		info.append("corePoolSize：").append(corePoolSize).append("\r\n");
		info.append("maximumPoolSize：").append(maximumPoolSize).append("\r\n");
		info.append("poolSize：").append(poolSize).append("\r\n");
		info.append("waitThreadSize：").append(waitThreadSize).append("\r\n");
		info.append("keepAliveTime：").append(keepAliveTime).append("\r\n");
		return toString();
	}

}
