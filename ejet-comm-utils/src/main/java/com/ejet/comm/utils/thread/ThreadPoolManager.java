package com.ejet.comm.utils.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 * public ThreadPoolExecutor(int corePoolSize,int maximumPoolSize,long keepAliveTime,TimeUnit unit,
            BlockingQueue<Runnable> workQueue);
 
    public ThreadPoolExecutor(int corePoolSize,int maximumPoolSize,long keepAliveTime,TimeUnit unit,
            BlockingQueue<Runnable> workQueue,ThreadFactory threadFactory);
 
    public ThreadPoolExecutor(int corePoolSize,int maximumPoolSize,long keepAliveTime,TimeUnit unit,
            BlockingQueue<Runnable> workQueue,RejectedExecutionHandler handler);
 
    public ThreadPoolExecutor(int corePoolSize,int maximumPoolSize,long keepAliveTime,TimeUnit unit,
        BlockingQueue<Runnable> workQueue,ThreadFactory threadFactory,RejectedExecutionHandler handler);
 * 
 * corePoolSize：核心池的大小，这个参数跟后面讲述的线程池的实现原理有非常大的关系。在创建了线程池后，默认情况下，
 * 线程池中并没有任何线程，而是等待有任务到来才创建线程去执行任务，除非调用了prestartAllCoreThreads()或者prestartCoreThread()方法，
 * 预创建线程的意思，即在没有任务到来之前就创建corePoolSize个线程或者一个线程。
 * 默认情况下，在创建了线程池后，线程池中的线程数为0，当有任务来之后，
 * 就会创建一个线程去执行任务，当线程池中的线程数目达到corePoolSize后，就会把到达的任务放到缓存队列当中；
 * 
 * maximumPoolSize：线程池最大线程数，这个参数也是一个非常重要的参数，它表示在线程池中最多能创建多少个线程；
 * 
 * keepAliveTime：表示线程没有任务执行时最多保持多久时间会终止。默认情况下，只有当线程池中的线程数大于corePoolSize时，keepAliveTime才会起作用，
 * 直到线程池中的线程数不大于corePoolSize，即当线程池中的线程数大于corePoolSize时，
 * 如果一个线程空闲的时间达到keepAliveTime，则会终止，直到线程池中的线程数不超过corePoolSize。
 * 但是如果调用了allowCoreThreadTimeOut(boolean)方法，在线程池中的线程数不大于corePoolSize时，keepAliveTime参数也会起作用，
 * 直到线程池中的线程数为0；
 * 
 * unit：参数keepAliveTime的时间单位，有7种取值，在TimeUnit类中有7种静态属性：
 *  TimeUnit.DAYS;               //天
	TimeUnit.HOURS;             //小时
	TimeUnit.MINUTES;           //分钟
	TimeUnit.SECONDS;           //秒
	TimeUnit.MILLISECONDS;      //毫秒
	TimeUnit.MICROSECONDS;      //微妙
	TimeUnit.NANOSECONDS;       //纳秒
 * 
 * @author EJet
 *
 */

public class ThreadPoolManager {
	
	private static ThreadPoolManager instance = null;
	private ThreadPoolExecutor executor = null;
	private ThreadPoolConfig config = null;
	private boolean hasInit = false;
	
	private ThreadPoolManager() {
		
	}
	
	public static ThreadPoolManager poolManagerFactory() {
		if(instance==null) {
			instance = new ThreadPoolManager();
		}
		return instance;
	}
	
	public void setConfig(ThreadPoolConfig conf) {
		poolManagerFactory().config = conf;
		if(!hasInit)
			init();
	}
	
	public static ThreadPoolExecutor getExcutor() throws Exception {
		if(poolManagerFactory().config==null || !poolManagerFactory().hasInit) {
			throw new Exception("请先调用setConfig()函数初始化设置!");
		}
		return poolManagerFactory().executor;
	}
	
	public static void execute(Runnable runner) throws Exception {
		getExcutor().execute(runner);
	}
	
	private void init() {
		if(executor==null) {
			executor = new ThreadPoolExecutor(config.getCorePoolSize(), config.getMaximumPoolSize(), 
					config.getKeepAliveTime(),TimeUnit.MILLISECONDS,
					new  LinkedBlockingQueue<Runnable>(config.getWaitThreadSize()),
					new ThreadPoolExecutor.DiscardOldestPolicy());
			hasInit = true;
		}
	}
	
	/**
	 * 池中线程数目
	 * @return
	 */
	public int getPoolSize() {
		int size  = 0;
		if(hasInit && executor!=null) {
			size = executor.getPoolSize();
		}
		return size;
	}
	/**
	 * 获得活动线程数
	 * 
	 * @return
	 */
	public int getActiveCount() {
		if(hasInit && executor!=null) {
			return executor.getActiveCount();
		}
		return 0;
	}
	
	/**
	 * 返回池中等待线程个数
	 * @return
	 */
	public int getWaitQueueSize() {
		int size  = 0;
		if(hasInit && executor!=null) {
			size = executor.getQueue().size();
		}
		return size;
	}
	
	/**
	 * 是否还有空闲线程
	 * 
	 * @return
	 */
	public boolean hasFreeThread() {
		boolean flag  = false;
		if(getWaitQueueSize()<=config.getWaitThreadSize()) {
			return true;
		}
		return flag;
	}
	
}
