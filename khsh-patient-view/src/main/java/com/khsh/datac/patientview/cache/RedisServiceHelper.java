package com.khsh.datac.patientview.cache;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.concurrent.TimeUnit;

/**
 * Copyright (C), 2016-2018, 武汉康华数海有限公司
 * FileName: RedisHelper
 * Author:   ShenYijie
 * CreateDate:     2018-10-16 16:27
 * Description: redis数据操作工具类
 * History:
 * Version: 1.0
 */
@Component
public class RedisServiceHelper {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    /**
     * 默认过期时长，单位：秒(24小时)
     */
    public static final long DEFAULT_EXPIRE = 60 * 60 * 24;
    /**
     * 不设置过期时长
     */
    public static final long NOT_EXPIRE = -1;

    private static Gson gson = new Gson();

    /**
     * 放置对象
     * @param key
     * @param value
     */
    public void put(String key, Object value) {
        put(key, value, DEFAULT_EXPIRE, TimeUnit.SECONDS);
    }
    /**
     * redis放置对象
     *
     * @param key
     * @param value
     * @param expireTime
     * @param timeUnit
     */
    public void put(String key, Object value, long expireTime, TimeUnit timeUnit) {
        if(value==null) return;
        if(value instanceof String) {
            redisTemplate.opsForValue().set(key, (String) value, expireTime, timeUnit);
        } else {
            redisTemplate.opsForValue().set(key, gson.toJson(value), expireTime, timeUnit);
        }
    }

    public Object get(String key) {
        Object value = null;
        if(redisTemplate.hasKey(key)) {
            value = redisTemplate.opsForValue().get(key);
        }
        return value;
    }

    // public <T> T get(String key, T t) {
    //     T value = null;
    //     if(redisTemplate.hasKey(key)) {
    //         String tmp = redisTemplate.opsForValue().get(key);
    //         if(tmp!=null) {
    //             value = (T) gson.fromJson(tmp, t.getClass());
    //         }
    //     }
    //     return value;
    // }

    public <T> T get(String key, Type typeOfT) {
        T value = null;
        if(redisTemplate.hasKey(key)) {
            String tmp = redisTemplate.opsForValue().get(key);
            if(tmp!=null) {
                value = (T) gson.fromJson(tmp, typeOfT);
            }
        }
        return value;
    }

    public <T> T get(String key, Class clazz) {
        T value = null;
        if(redisTemplate.hasKey(key)) {
            String tmp = redisTemplate.opsForValue().get(key);
            if(tmp!=null) {
                value = (T) gson.fromJson(tmp, clazz);
            }
        }
        return value;
    }

    /**
     *  判断key是否存在
     * @param key
     * @return
     */
    public boolean exist(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     *  删除key
     * @param key
     * @return
     */
    public boolean delete(String key) {
        return redisTemplate.delete(key);
    }

    /**
     *  更新过期时间
     *
     * @param key
     * @param expireTime
     * @param timeUnit
     */
    public void refresh(String key, final long expireTime, TimeUnit timeUnit) {
        redisTemplate.expire(key, expireTime, timeUnit);
    }

    /**
     * 更新过期时间，默认单位s
     * @param key
     * @param expireTime
     */
    public void refresh(String key, final long expireTime) {
        redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
    }


}
