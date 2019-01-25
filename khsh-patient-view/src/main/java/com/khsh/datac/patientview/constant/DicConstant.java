package com.khsh.datac.patientview.constant;

import java.text.MessageFormat;

public final class DicConstant {

    public static final String ALL_DIC_CACHE = "base.dic.all";//数据字典表hash值存储KEY

    public static final String DIC_CACHE_KEY_TEMPLATE = "base.dic.data.{0}";//数据字典数据缓存值

    public static final String DIC_CACHE_MAP_KEY_TEMPLATE = "base.dic.dataMap.{0}";//数据字典数据缓存值(MAP格式存储)

    public static String getDicCacheKey(String code){
        return MessageFormat.format(DicConstant.DIC_CACHE_KEY_TEMPLATE,code.hashCode()+"");
    }

    public static String getDicMapCacheKey(String code){
        return MessageFormat.format(DicConstant.DIC_CACHE_MAP_KEY_TEMPLATE,code.hashCode()+"");
    }

}
