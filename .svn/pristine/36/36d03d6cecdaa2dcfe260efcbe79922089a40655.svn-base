package com.cxs.framework.utils;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class EnumUtil {
	  
	private static final Logger logger = LoggerFactory.getLogger(EnumUtil.class);
	/**
	 * 获取此枚举的List对象
	 * @param <T>
	 * @param enumClass
	 * @return
	 */
	public static <T extends Enum<T>> List<T> getEnumList(Class<T> enumClass){
		List<T> list = new ArrayList<T>();
		EnumSet<T> sets = EnumSet.allOf(enumClass);
		for(T s : sets){
			list.add(s);
		}
		return list;
	}

	/**
	 * 以传入的枚举的字段的值为key，获取此枚举的Map对象
	 * @param enumClass
	 * @param propertyName
	 * @return
	 */
	public static <T extends Enum<T>> Map<String,T> getEnumMap(Class<T> enumClass,String propertyName){
		Map<String,T> map = new HashMap<String,T>();
		List<T> instances = getEnumList(enumClass);
		for(T instance : instances){
			try {
				Object p = PropertyUtils.getProperty(instance, propertyName);
				map.put((String)p, instance);
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(e.getMessage(), e);
			} 
		}
		return map;
	}
	
	/**
	 * 根据枚举的一个属性值取该枚举元素
	 * @param <T>
	 * @param enumClass			枚举类的class 
	 * @param propertyName		枚举属性名                    
	 * @param value				枚举属性值                    
	 * @return
	 */
	public static <T extends Enum<T>> T getEnumByPropertyName(Class<T> enumClass,String propertyName, Object value){
		List<T> instances = getEnumList(enumClass);
		T e = null;
		for(T instance : instances){
			try {
				Object p = PropertyUtils.getProperty(instance, propertyName);
				if(p == value || value.equals(p)){
					e = instance;
					break;
				}
			} catch (Exception ex) {
				logger.error(ex.getMessage(), ex);
			} 
		}
		return e;
	}
}
