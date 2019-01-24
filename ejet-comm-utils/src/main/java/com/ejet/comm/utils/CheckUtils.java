package com.ejet.comm.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.ejet.comm.utils.reflect.ReflectUtils;

/**
 * 对象数据监测
 *
 * @author ShenYijie
 *
 */
public class CheckUtils {

	/**
	 * 检测对象字段是否为空
	 *
	 * @param obj
	 */
	public static void checkObject(Object obj, List<String> ignoreFileds) throws RuntimeException {
		if(obj==null)
			throw new RuntimeException("检测对象为null值");
		Class clazz = obj.getClass();
		List<Field> fieldList = new ArrayList<Field>();
		Field[] fileds = clazz.getDeclaredFields();
		for(Field f : fileds){
			fieldList.add(f);
		}
		Class pclazz = clazz.getSuperclass();
		Field[] pfileds = pclazz.getDeclaredFields();
		for(Field pf : pfileds){
			fieldList.add(pf);
		}
		String error = "";
		for(Field field : fieldList) {
			Object value = ReflectUtils.getFieldValue(obj, field.getName());
			if(ignoreFileds!=null && ignoreFileds.contains(field.getName())) {
				continue;
			}
			if(value==null || (value instanceof String && value.equals(""))) {
				error = "对象:" + obj.getClass().getName() + ", 参数字段：" + field.getName() + "为" + value;
				throw new RuntimeException(error);
			}
		}
	}


}
