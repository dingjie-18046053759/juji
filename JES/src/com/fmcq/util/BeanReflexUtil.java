package com.fmcq.util;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


/**
 * Bean反射写入值对应的工具类
 * @time 2016年3月17日
 * @author lcq
 */
public class BeanReflexUtil<T> {
	
	/**
	 * 将对象的值写入另一个对象，仅限于Get Set方法
	 * 仅限于同名的Set和Get方法写入
	 * 传入的对象必须实例化过的
	 * @author lcq
	 * @param fromObj
	 * @param toObj
	 * @param isSetNull true为写入null值的  false不写入
	 */
	public void objValToObj(T fromObj, T toObj, boolean isSetNull){
		try {
			Method[] methods = fromObj.getClass().getMethods();
			Map<String, Method> valMap = new HashMap<String, Method>();
			Map<String, Method> getMap = new HashMap<String, Method>();
			if (methods != null && methods.length > 0){
				for (Method method : methods) {
					if (method.getName().indexOf("set") != -1){
						valMap.put(method.getName(), method);
					} else if (method.getName().indexOf("get") != -1){
						getMap.put(method.getName(), method);
					}
				}
			}
			
			for (String key : getMap.keySet()) {
				
				Method getMethod = getMap.get(key);//获取方法
				
				Object val = getMethod.invoke(fromObj);//Get方法的结果
				
				Method setMethod = valMap.get(key.replace("get", "set"));
				
				if (setMethod != null){
					if (!isSetNull && val == null){
						continue;
					}
					setMethod.invoke(toObj, val);//写入
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
