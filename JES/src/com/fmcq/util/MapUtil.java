package com.fmcq.util;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;

import com.google.gson.Gson;

public class MapUtil {
	/**
	 * 失败封装
	 * @param log
	 * @param respCode
	 * @param respMsg
	 * @return
	 */
	public static String outMap(int respCode,String respMsg) {
		Map<String, Object> map = new HashMap<String, Object>();
		Gson gson = new Gson();
		map.put("respCode", respCode);
		map.put("respMsg", respMsg);

		return gson.toJson(map);
	}
	/**
	 * 成功封装
	 * @param log
	 * @param respCode
	 * @param respMsg
	 * @return
	 */
	public static String outMap(String respMsg) {
		Map<String, Object> map = new HashMap<String, Object>();
		Gson gson = new Gson();
		map.put("respCode", 0);
		map.put("respMsg", respMsg);

		return gson.toJson(map);
	}
	/**
	 * 
	 * @param log
	 * @param respMsg 响应的提示信息
	 * @param parameter Map封装参数
	 * @return
	 */
	public static String outParameterMap(String respMsg,Map parameter,String result) {
		Map<String, Object> map = new HashMap<String, Object>();
		Gson gson = new Gson();
		map.put("respCode", result);
		map.put("respMsg", respMsg);

		map.putAll(parameter);
		
		return gson.toJson(map);
	}
	
	/**
	 * 异常封装
	 * @param log 
	 * @param e
	 * @param msg
	 */
	public static String outError(Exception e){
		ByteArrayOutputStream buf = new java.io.ByteArrayOutputStream();
		e.printStackTrace(new java.io.PrintWriter(buf, true));
		return buf.toString();
	}
}
