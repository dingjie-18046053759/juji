package com.fmcq.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
/**
 * request转Map集合类
 * @time 下午4:39:30
 * @author huangzhiwei
 * @category
 */
public class RequestToMap {
	public static Map<String,String> getMap(HttpServletRequest request) {

	    // 参数Map
	    Map properties = request.getParameterMap();

	    // 返回值Map
	    Map<String,String> returnMap = new HashMap();

	    Iterator entries = properties.entrySet().iterator();

	    Map.Entry entry;

	    String name = "";

	    String value = "";

	    while (entries.hasNext()) {

	        entry = (Map.Entry) entries.next();

	        name = (String) entry.getKey();

	        Object valueObj = entry.getValue();

	        if(null == valueObj){

	            value = "";

	        }else if(valueObj instanceof String[]){

	            String[] values = (String[])valueObj;

	            for(int i=0;i<values.length;i++){

	                value = values[i] + ",";

	            }

	            value = value.substring(0, value.length()-1);

	        }else{

	            value = valueObj.toString();

	        }

	        returnMap.put(name, value);

	    }

	    return returnMap;

	}
	
	public static Map<String,Object> getObjectMap(HttpServletRequest request) {

	    // 参数Map
	    Map properties = request.getParameterMap();

	    // 返回值Map
	    Map<String,Object> returnMap = new HashMap();

	    Iterator entries = properties.entrySet().iterator();

	    Map.Entry entry;

	    String name = "";

	    String value = "";

	    while (entries.hasNext()) {

	        entry = (Map.Entry) entries.next();

	        name = (String) entry.getKey();

	        Object valueObj = entry.getValue();

	        if(null == valueObj){

	            value = "";

	        }else if(valueObj instanceof String[]){

	            String[] values = (String[])valueObj;

	            for(int i=0;i<values.length;i++){

	                value = values[i] + ",";

	            }

	            value = value.substring(0, value.length()-1);

	        }else{

	            value = valueObj.toString();

	        }

	        returnMap.put(name, value);

	    }

	    return returnMap;

	}
}
