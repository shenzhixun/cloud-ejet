package com;

import com.ejet.comm.utils.random.RandomUtils;
import com.ejet.comm.utils.reflect.ReflectUtils;
import com.ejet.comm.utils.time.TimeUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Copyright (C), 2016-2018, 武汉康华数海有限公司
 * FileName: MockUtils
 * Author:   Ejet
 * CreateDate:     2018-10-08 14:30
 * Description:
 * History:
 * Version: 1.0
 */
public class MockUtils {

    public static <T> T newInstance(Class clazz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {
        // Class clazz = Class.forName(clazzName);
        Class[] paramTypes = {};
        T inter = null;
        Constructor<T> constructor = clazz.getConstructor(paramTypes);
        inter = constructor.newInstance();
        return inter;
    }
    public static <T> void setIntValue(T model, Field field) {
        Object value = RandomUtils.getRandom(1, 100);
        if (value != null) {
            ReflectUtils.setFieldValue(model, field.getName(), value);
        }
    }

    public static <T> void setStringValue(T model, Field field) {
        Object value = value = field.getName() + "测试";
        if (value != null) {
            ReflectUtils.setFieldValue(model, field.getName(), value);
        }
    }

    public static <T> void setDoubleValue(T model, Field field) {
        Object value = value = Float.parseFloat(RandomUtils.getRandom(1, 100) + "." + RandomUtils.getRandom(1, 1000));
        if (value != null) {
            ReflectUtils.setFieldValue(model, field.getName(), value);
        }
    }

    public static <T> void setByteValue(T model, Field field) {
        Object value = value = new Byte(RandomUtils.getRandomNumbers(1));
        if (value != null) {
            ReflectUtils.setFieldValue(model, field.getName(), value);
        }
    }

    public static <T> void setCharValue(T model, Field field) {
        Object value = RandomUtils.getRandomNumbersAndUperLetters(2).charAt(1);
        if (value != null) {
            ReflectUtils.setFieldValue(model, field.getName(), value);
        }
    }


    private static <T> void setSpecailValue(T model, Field field) {
        Object value = null;
        if(field.getName().equalsIgnoreCase("createTime")) {
            value = TimeUtils.getCurrentFullTime();
        } else if(field.getName().equalsIgnoreCase("updateTime")) {
            value = TimeUtils.getCurrentFullTime();
        } else if(field.getName().equalsIgnoreCase("modifyBy")) {
            value = "Admin";
        } else if(field.getName().equalsIgnoreCase("remark")) {
            value = "备注信息";
        } else if(field.getName().equalsIgnoreCase("ext")) {
            value = "ext扩展";
        } else if(field.getName().equalsIgnoreCase("ext1")) {
            value = "ext扩展1";
        } else if(field.getName().equalsIgnoreCase("ext2")) {
            value = "ext扩展2";
        }

        if(field.getName().equalsIgnoreCase("status")) {
            value = 1;
        }

        if(value!=null) {
            ReflectUtils.setFieldValue(model, field.getName(), value);
        }
    }

    /**
     * 获取测试数据
     * @param clazz
     * @return
     */
    public static <T> T getMockJson(Class<T> clazz) throws InvocationTargetException, NoSuchMethodException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        List<Field> fields = ReflectUtils.getDeclaredFieldsByClazz(clazz);
        T model = newInstance(clazz);
        for (Field field: fields) {
            String typeName = field.getType().getTypeName();
            System.out.println("属性名：" + field.getName() + ",  类型名:" + typeName);
            synchronized (model) {
                switch (typeName) {
                    case "int" :
                        setIntValue(model, field);
                        //System.out.println("  *** int *** ");
                        break;
                    case "byte":
                        setByteValue(model, field);
                        //System.out.println("  *** byte *** ");
                        break;
                    case "byte[]":
                        setStringValue(model, field);
                        //System.out.println("  *** byte[] *** ");
                        break;
                    case "char":
                        setCharValue(model, field);
                        //ystem.out.println("  *** char *** ");
                        break;


                    case "java.lang.Integer" :
                        setIntValue(model, field);
                        //System.out.println("  *** java.lang.Integer *** ");
                        break;
                    case "java.lang.String":
                        setStringValue(model, field);
                        //System.out.println("  *** java.lang.String *** ");
                        break;
                    case "java.lang.Float":
                        setDoubleValue(model, field);
                        //System.out.println("  *** java.lang.Float *** ");
                        break;
                    case "java.lang.Double":
                        setDoubleValue(model, field);
                        //System.out.println("  *** java.lang.Double *** ");
                        break;
                    case "java.math.BigDecimal":
                        setDoubleValue(model, field);
                        //System.out.println("  *** java.math.BigDecimal *** ");
                        break;

                    default:
                        break;
                }

                setSpecailValue(model, field);
            }
        }
        return model;
    }


}
