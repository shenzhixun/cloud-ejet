package com.ejet.comm.utils.collect;

import java.lang.reflect.Field;
import java.util.List;

import com.ejet.comm.utils.reflect.ReflectUtils;

public class BeanUtils {

	/**
	 * 实体间复制相同字段和类型的属性值
	 *
	 * @param target
	 *            赋值后的目标实体
	 * @param source
	 *            取数据的实体来源
	 */
	@SuppressWarnings("unchecked")
	public static Object copyProperties(Object source, Object target) {
		try {
		    List<Field> sourceFileds = ReflectUtils.getDeclaredFields(source);
		    for (Field field: sourceFileds) {
		        Object value = ReflectUtils.getFieldValue(source, field.getName());
		        ReflectUtils.setFieldValue(target, field.getName(), value);
            }


			// Class sourceClz = source.getClass();
			// Class targetClz = target.getClass();
			// // 获得类的所有属性(包括私有属性,但不包括父类属性。。。。)
			// Field[] fields = sourceClz.getDeclaredFieldsBy();
			// for (int i = 0; i < fields.length; i++) {
			// 	String fieldName = fields[i].getName();
			// 	Field targetField = null;
			// 	try {
			// 		// 得到targetClz对象所表征的类的名为fieldName的属性，不存在就进入下次循环
			// 		targetField = targetClz.getDeclaredField(fieldName);
			// 	} catch (SecurityException e) {
			// 		break;
			// 	} catch (NoSuchFieldException e) {
			// 		continue;
			// 	}
			// 	// 判断sourceClz字段类型和targetClz同名字段类型是否相同
			// 	if (!fields[i].getName().equals("serialVersionUID")
			// 			&& fields[i].getType() == targetField.getType()) {
			// 		Method getMethod = ReflectUtils.getGetMethod(sourceClz, fieldName);
			// 		Method setMethod = ReflectUtils.getSetMethod(targetClz, fieldName);
			// 		try {
			// 			// 调用source对象的getMethod方法
			// 			Object result = getMethod.invoke(source, new Object[]{});
			// 			// 调用target对象的setMethod方法
			// 			if(result!=null) {
			// 				setMethod.invoke(target, result);
			// 			}
			// 	 	} catch (Exception e) {
			// 			//e.printStackTrace();
			// 		}
			// 	}
			// }


		} catch (Exception e) {
			// log.error(e);
			//e.printStackTrace();
		}
		return target;
	}








}
