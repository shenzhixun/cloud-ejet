package com.ejet.comm.utils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ejet.comm.utils.io.IOUtils;
import com.ejet.comm.utils.reflect.Reflect;

/**
 * 读取properties文件工具类
 * 
 * @author EJet
 *
 */
@SuppressWarnings("unchecked")
public class PropertyUtils {
	
	private static final Logger log = LoggerFactory.getLogger(PropertyUtils.class);
	
	/**
	 * 加载配置文件，返回Properties对象
	 * 
	 * @param file
	 * @return
	 */
	public static Properties loadProperty(String file) {
		Properties properties = new Properties(); 
		InputStream ins = null;
		try {
			ins = new FileInputStream(file);
			properties.load(ins);
		} catch (Exception e) { 
			log.error("loadProterty", e);
		} finally {
			IOUtils.closeQuietly(ins);
		}
		return properties; 
	}
	
	/**
	 * 获得所有属性值
	 * 
	 * @param file
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> getProterty(String file) {
		Map<String, String> map = new HashMap<String, String>();
		InputStream ins = null;
		try {
			Properties properties = new Properties(); 
			ins = new FileInputStream(file);
			properties.load(ins);
			Enumeration<Object> en = (Enumeration<Object>) properties.propertyNames(); // 得到配置文件的名字
			while (en.hasMoreElements()) {
				String key = (String) en.nextElement();
				map.put(key, properties.getProperty(key));
			}
		} catch (Exception e) { 
			log.error("loadProterty", e);
		} finally {
			IOUtils.closeQuietly(ins);
		}
		return map;
	}
	
	/**
	 * 根据Key读取配置文件中的value
	 * 
	 * @param filePath
	 * @param key
	 * @return
	 */
	public static String getProtertyValue(String filePath, String key) {
		return getProterty(filePath).get(key);
	}

	/**
	 * 修改key对应值
	 * 
	 * @param filePath
	 * @param pKey
	 * @param pValue
	 * @throws IOException
	 */
	public static void WriteProperties(String filePath, String pKey,
			String pValue) throws IOException {
		Properties pps = new Properties();
		InputStream in = new FileInputStream(filePath);
		pps.load(in);
		// 强制要求为属性的键和值使用字符串。
		OutputStream out = new FileOutputStream(filePath);
		pps.setProperty(pKey, pValue);
		// 以适合使用 load 方法加载到 Properties 表中的格式，
		// 将此 Properties 表中的属性列表（键和元素对）写入输出流
		pps.store(out, "Update " + pKey + " name");
	}
	/**
	 * 获取properties文件，转换map后，从map里取对应key的值，并将值String类型转int类型
	 * 
	 * @param map
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public static int getInt(Map<String, String> map, String key, int defaultValue){
		int r = defaultValue;
		try{
			String value = (String)map.get(key);
			r = Integer.valueOf(value);
		}catch(Exception e){
			//log.error("获取值失败，key:" + key, e);
		}
		return r;
	}
	
	/**
     * 将一个 Map 对象转化为一个 JavaBean
     * @param type 要转化的类型
     * @param map 包含属性值的 map
     * @return 转化出来的 JavaBean 对象
     * @throws IntrospectionException 如果分析类属性失败
     * @throws IllegalAccessException 如果实例化 JavaBean 失败
     * @throws InstantiationException 如果实例化 JavaBean 失败
     * @throws InvocationTargetException 如果调用属性的 setter 方法失败
     */
    @SuppressWarnings("rawtypes")
	public static Object convertMap(Class type, Map map) throws IntrospectionException, IllegalAccessException,
            InstantiationException, InvocationTargetException {
        BeanInfo beanInfo = Introspector.getBeanInfo(type); // 获取类属性
        Object obj = type.newInstance(); // 创建 JavaBean 对象
        // 给 JavaBean 对象的属性赋值
        PropertyDescriptor[] propertyDescriptors =  beanInfo.getPropertyDescriptors();
        for (int i = 0; i< propertyDescriptors.length; i++) {
            PropertyDescriptor descriptor = propertyDescriptors[i];
            String propertyName = descriptor.getName();
            if (map.containsKey(propertyName)) {
                // 下面一句可以 try 起来，这样当一个属性赋值失败的时候就不会影响其他属性赋值。
            	try {
            		Object value = map.get(propertyName);
            		Object[] args = new Object[1];
                    args[0] = value;
                    descriptor.getWriteMethod().invoke(obj, args);
            		
            	}catch(Exception e) {
            		
            	}
            }
        }
        return obj;
    }
	
    /**
     * 将一个 JavaBean 对象转化为一个  Map
     * @param bean 要转化的JavaBean 对象
     * @return 转化出来的  Map 对象
     * @throws IntrospectionException 如果分析类属性失败
     * @throws IllegalAccessException 如果实例化 JavaBean 失败
     * @throws InvocationTargetException 如果调用属性的 setter 方法失败
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map convertBean(Object bean)
            throws IntrospectionException, IllegalAccessException, InvocationTargetException {
        Class type = bean.getClass();
        Map returnMap = new HashMap();
        BeanInfo beanInfo = Introspector.getBeanInfo(type);

        PropertyDescriptor[] propertyDescriptors =  beanInfo.getPropertyDescriptors();
        for (int i = 0; i< propertyDescriptors.length; i++) {
            PropertyDescriptor descriptor = propertyDescriptors[i];
            String propertyName = descriptor.getName();
            if (!propertyName.equals("class")) {
                Method readMethod = descriptor.getReadMethod();
                Object result = readMethod.invoke(bean, new Object[0]);
                if (result != null) {
                    returnMap.put(propertyName, result);
                } else {
                    returnMap.put(propertyName, "");
                }
            }
        }
        return returnMap;
    }
    /**
     * 读取并解析property文件，赋值到bean对象中。
     * 要求文件key和bean对象成员变量名称一致。
     * 
     * @param propertyFile		Property文件
     * @param classOfT			需要复制的class对象类型
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    @SuppressWarnings("unchecked")
	public static <T> Object loadProperty(String propertyFile, Class<T> classOfT) throws InstantiationException, IllegalAccessException {
    	InputStream in = null;
    	try { 
			Properties properties = new Properties();
			in = new BufferedInputStream(new FileInputStream(propertyFile));
            return loadProperty(in, classOfT);
    	}catch(Exception e) {
			log.error("读取配置文件失败：", e);
		}finally{
			IOUtils.closeQuietly(in);
		}
		return null;
    }


    public static <T> Object loadProperty(InputStream inputStream, Class<T> classOfT) throws InstantiationException, IllegalAccessException {
        T obj = classOfT.newInstance();
        InputStream in = null;
        try {
            Reflect rf = new Reflect(obj);
            Properties properties = new Properties();
            in = new BufferedInputStream(inputStream);
            properties.load(in);
            Enumeration<Object> en = (Enumeration<Object>) properties.propertyNames(); // 得到配置文件的名字
            while (en.hasMoreElements()) {
                String key = (String) en.nextElement();
                if( rf.field(key)!=null && rf.field(key).getField()!=null ) {
                    Class<?> type = rf.field(key).getField().getType();
                    if(type==float.class) {
                        rf.field(key).in(Float.valueOf((String)properties.getProperty(key, "")));
                    }else if(type==int.class) {
                        rf.field(key).in(Integer.valueOf((String)properties.getProperty(key, "")));
                    }else if(type==boolean.class) {
                        rf.field(key).in(Boolean.valueOf((String)properties.getProperty(key, "false")));
                    }else if(type==String.class) {
                        rf.field(key).in((String)properties.getProperty(key, "false"));
                    }else {
                        rf.field(key).in((String)properties.getProperty(key, ""));
                    }
                }
            }
        }catch(Exception e) {
            log.error("读取配置文件失败：", e);
        }finally{
            IOUtils.closeQuietly(in);
        }
        return obj;
    }

}
