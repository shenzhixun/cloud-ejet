package com.ejet.core.inter;

/**
 * Copyright (C), 2016-2018, 武汉康华数海有限公司
 * FileName: IApplicationBootCallback
 * Author:   Ejet
 * CreateDate:     2018-09-07 14:21
 * Description: 启动接口回调类，各模块实现接口进行回调。
 * History:
 * Version: 1.0
 */
public interface IApplicationBootCallback {

    /**
     * 应用已启动完成
     */
    public void callApplicationReadyEvent();

    /**
     * 应用停止
     */
    public void callContextStoppedEvent();

    /**
     * 应用关闭
     */
    public void callContextClosedEvent();

    /**
     * 启动时，容器上下文环境刷新
     */
    public void callContextRefreshedEvent();

}
