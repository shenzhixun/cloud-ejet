package com.ejet.core.context;

import com.ejet.core.base.InterceptorBase;
import com.ejet.core.inter.IApplicationBootCallback;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2016-2018, 武汉康华数海有限公司
 * FileName: CoApplicationContext
 * Author:   Ejet
 * CreateDate:     2018-09-10 10:13
 * Description: 全局上下文信息,包括配置信息，拦截器、回调接口设置
 * History:
 * Version: 1.0
 */
public class CoApplicationContext {
    /**
     * 拦截器信息
     */
    private static List<InterceptorBase> interceptors = new ArrayList<>();
    /**
     * 回调接口信息
     */
    private static List<IApplicationBootCallback> callbacks = new ArrayList<>();
    /**
     * 单实例对象
     */
    private static CoApplicationContext instance;
    /**
     * 应用的上下文环境
     */
    private ApplicationContext appContext;

    /**
     * 私有构造函数
     */
    private CoApplicationContext() {}

    /**
     * 获取单实例对象
     *
     * @return 单实列对象
     */
    public static CoApplicationContext getInstance() {
        if(instance==null) {
            instance = new CoApplicationContext();
        }
        return instance;
    }

    public static ApplicationContext getApplicationContext() {
        return getInstance().appContext;
    }

    public static void setApplicationContext(ApplicationContext c) {
        getInstance().appContext = c;
    }

    /**
     * 添加拦截器
     */
    public static void addInterceptor(InterceptorBase interceptor) {
        interceptors.add(interceptor);
    }

    /**
     * 获取所有拦截器
     * @return
     */
    public List<InterceptorBase> getInterceptors() {
        return interceptors;
    }


    /**
     * 添加回调接口
     */
    public synchronized static void addApplicationBootCallback(IApplicationBootCallback callback) {
        callbacks.add(callback);
    }

    /**
     * 获取所有回调接口
     * @return
     */
    public synchronized List<IApplicationBootCallback> getApplicationBootCallbacks() {
        return callbacks;
    }

    /**
     * 获取注入的bean对象
     * @param requiredType
     * @param <T>
     * @return
     * @throws BeansException
     */
    public static <T> T getBean(Class<T> requiredType) throws BeansException {
        return getInstance().appContext==null ? null :getInstance().appContext.getBean(requiredType);
    }

    /**
     * 根据bean名字，获取注入的bean对象
     * @return
     * @throws BeansException
     */
    public static Object getBean(String beanName) throws BeansException {
        return getInstance().appContext==null ? null :getInstance().appContext.getBean(beanName);
    }

}
