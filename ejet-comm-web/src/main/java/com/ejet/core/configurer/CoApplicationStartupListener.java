package com.ejet.core.configurer;

import com.ejet.core.context.CoApplicationContext;
import com.ejet.core.inter.IApplicationBootCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.stereotype.Component;

/**
 * springboot生命周期监听器
 *
 * @author Shen Yijie
 *
 */
@Component
public class CoApplicationStartupListener implements ApplicationListener {
	Logger logger = LoggerFactory.getLogger(CoApplicationStartupListener.class);
	/**
	 * 是否就绪事件，初始化一次
	 */
	private static boolean hasReady = false;

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		try {
            //logger.info("=== 启动应用★ ===");
            // 应用刷新
	        if (event instanceof ContextRefreshedEvent) {
	        	if(CoApplicationContext.getApplicationContext()==null) {
                    CoApplicationContext.setApplicationContext(((ContextRefreshedEvent)event).getApplicationContext());
	        	}
                for(IApplicationBootCallback callback : CoApplicationContext.getInstance().getApplicationBootCallbacks()) {
                    if(callback!=null) {
                        try {
                            callback.callContextRefreshedEvent();
                        } catch (Exception e) {
                            logger.error(" === 全局[ContextRefreshedEvent]回调异常 ===", e);
                        }
                    }
                }
                //应用已启动完成
	        } else if (event instanceof ApplicationReadyEvent && !hasReady) {
	        	hasReady = true;
	        	for(IApplicationBootCallback callback : CoApplicationContext.getInstance().getApplicationBootCallbacks()) {
                    if(callback!=null) {
                        try {
                            callback.callApplicationReadyEvent();
                        } catch (Exception e) {
                            logger.error(" === 全局[ApplicationReadyEvent]回调异常 ===", e);
                        }
                    }
                }
                // 应用停止
	        } else if (event instanceof ContextStoppedEvent) {
                for(IApplicationBootCallback callback : CoApplicationContext.getInstance().getApplicationBootCallbacks()) {
                    if(callback!=null) {
                        try {
                            callback.callContextStoppedEvent();
                        } catch (Exception e) {
                            logger.error(" === 全局[ContextStoppedEvent]回调异常 ===", e);
                        }
                    }
                }
                // 应用关闭
	        } else if(event instanceof ContextClosedEvent) { // 应用关闭
                for(IApplicationBootCallback callback : CoApplicationContext.getInstance().getApplicationBootCallbacks()) {
                    if(callback!=null) {
                        try {
                            callback.callContextClosedEvent();
                        } catch (Exception e) {
                            logger.error(" === 全局[ContextClosedEvent]回调异常 ===", e);
                        }
                    }
                }
	        }
		} catch (Exception e) {
			logger.error("onApplicationEvent", e);
		}
	}


}
