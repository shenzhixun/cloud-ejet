package com.khsh.datac.empi.aop;

import com.ejet.comm.base.CoBaseVO;
import com.ejet.comm.utils.reflect.ReflectUtils;
import com.ejet.comm.utils.time.TimeUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Copyright (C), 2016-2019, 武汉康华数海有限公司
 * FileName: LoggingAspect
 * Author:   ShenYijie
 * CreateDate:     2019-01-12 19:32
 * Description: 日志记录切面
 * History:
 * Version: 1.0
 */


@Aspect
@Component
public class LoggingAspect {

    private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("execution(* com.khsh.datac.empi.service..*.insert*(..))")
    public Object invokeInsert(ProceedingJoinPoint joinPoint) throws Throwable {
        //取到所有的参数值的数组
        Object[] args = joinPoint.getArgs();
        try {
            for (Object object : args) {
                if (object != null && object instanceof CoBaseVO) {
                    String time = TimeUtils.getCurrentTime();
                    ReflectUtils.setFieldValue(object, "createTime", time);
                    ReflectUtils.setFieldValue(object, "updateTime", time);
                }
            }
        } catch (Throwable throwable) {
            log.error("时间戳校验异常");
        }
        return joinPoint.proceed();
    }

    //@Around("execution(* com.khsh.datac.empi.service..*.insert*(..)) || execution(* com.khsh.datac.empi.service..*.update*(..))")
    @Around("execution(* com.khsh.datac.empi.service..*.update*(..))")
    public Object invokeUpdate(ProceedingJoinPoint joinPoint) throws Throwable {
        //取到所有的参数值的数组
        Object[] args = joinPoint.getArgs();
        //Signature signature = joinPoint.getSignature();
        //MethodSignature methodSignature = (MethodSignature) signature;
        //获取到方法的所有参数名称的字符串数组
        //String[] parameterNames = methodSignature.getParameterNames();
        try {
            for (Object object : args) {
                if (object != null && object instanceof CoBaseVO) {
                    //System.out.println("ooooooooo----------");
                    String time = TimeUtils.getCurrentTime();
                    ReflectUtils.setFieldValue(object, "updateTime", time);
                }
            }
        } catch (Throwable throwable) {
            log.error("时间戳校验异常");
        }
        return joinPoint.proceed();
    }


}
