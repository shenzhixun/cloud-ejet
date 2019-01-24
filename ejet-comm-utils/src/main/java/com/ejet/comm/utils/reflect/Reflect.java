package com.ejet.comm.utils.reflect;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * A reflection utility class.  
 * 
 * @author ejet
 * 
 */

public class Reflect {
	private Object object;

	/**
	 * Constructs this object 
	 * 
	 * @param object the object to reflect on
	 */
	
	public Reflect(Object object) {
		if (object == null)
			throw new IllegalArgumentException("Object can not be null.");
		this.object = object;
	}
	
	public List<Field> getDeclaredFields(Class clazz) {
		List<Field> list = new ArrayList<Field>();
		Field[] arr = clazz.getDeclaredFields();
		for(Field i : arr) {
			list.add(i);
		}
		return list;
	}
	
	public List<Field> getDeclaredFieldsAll() {
		Class clazz = object.getClass();
		List<Field> list = getDeclaredFields(clazz);
		Class pclazz = clazz.getSuperclass();
		list.addAll(getDeclaredFields(pclazz));
		return list;
	}

	/**
	 * Get a field from the object 
	 * 
	 * @param name the name of the field
	 * 
	 * @return a field reference
	 */
	
	public FieldRf field(String name) {
		return new FieldRf(object, name);
	}

	/**
	 * A field reference.  
	 */
	public class FieldRf {
		private Class<?> clazz;
		private Object object;
		private String name;

		/**
		 * Constructs this object 
		 * 
		 * @param object the object to reflect on
		 * @param name the name of the field
		 */
		
		public FieldRf(Object object, String name) {
			this.object = object;
			this.name = name;
		}

		/**
		 * Constructs this object 
		 * 
		 * @param outclazz the output type
		 *
		 * @return <T> T
		 */
		
		public <T> T out(Class<T> outclazz) {
			Field field = getField();
			Object obj = getValue(field);
			return outclazz.cast(obj);
		}

		public Object getValue() {
			Field field = getField();
			Object obj = getValue(field);
			return obj;
		}
		
		/**
		 * Set a value to a field 
		 * 
		 * @param value the value to set
		 */
		
		public void in(Object value) {
			Field field = getField();
			try {
				field.setAccessible(true);
				field.set(object, value);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}

		/**
		 * Set the class type 
		 * 
		 * @param clazz the type
		 *
		 * @return a field reference
		 */
		
		public FieldRf type(Class<?> clazz) {
			this.clazz = clazz;
			return this;
		}

		public Field getField() {
			if (clazz == null) {
				clazz = object.getClass();
			}

			Field field = null;
			try {
				field = clazz.getDeclaredField(name);
				field.setAccessible(true);
			} catch (NoSuchFieldException ignored) {}
			return field;
		}

		private Object getValue(Field field) {
			if (field == null) {
				return null;
			}
			Object obj = null;
			try {
				obj = field.get(object);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			return obj;
		}
	}

}
