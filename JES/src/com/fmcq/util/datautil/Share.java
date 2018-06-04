package com.fmcq.util.datautil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @date 2016-01-21 22:02:17
 * @author xb
 * 
 */
public class Share {

	private static Log logger = LogFactory.getLog(Share.class);

	/**
	 * 返回字符信息到客户端
	 * 
	 * @author xb
	 * @param content
	 * @param response
	 */
	public static void print_writer(Object content, HttpServletResponse response) {
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			writer.print(content);
			logger.info(content);
		} catch (Exception e) {
			logger.error(content, e);
		} finally {
			if (writer != null) {
				writer.flush();
				writer.close();
			}
		}
	}

	/**
	 * 转换流数据
	 * 
	 * @author xb
	 * @param in
	 * @return
	 */
	public static String streams(InputStream in) {
		try {
			StringBuffer out = new StringBuffer();
			InputStreamReader isr = new InputStreamReader(in, "GBK");
			char[] b = new char[2048];
			int length = 0;
			while ((length = isr.read(b)) > 0) {
				out.append(b, 0, length);
			}
//			String str = new String(out.toString().getBytes("GBK"), "UTF-8");
			return out.toString();
		} catch (Exception e) {
			logger.error("streams to String error", e);
			return null;
		}
	}

	/**
	 * 转换字符流
	 * 
	 * @author xb
	 * @param in
	 * @return
	 */
	public static String streamsString(InputStream in) {
		InputStreamReader isr = new InputStreamReader(in);// 字符流
		BufferedReader br = new BufferedReader(isr);// 缓冲流
		String str = null;
		try {
			System.out.println(br.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;

	}

	public static void logRequestHead(HttpServletRequest request, Log log) {
		try {
			Log l = log == null ? logger : log;
			// 打印主机头
			Enumeration headers = request.getHeaderNames();
			l.info("***********************request info begin***********************");
			if (headers != null) {
				while (headers.hasMoreElements()) {
					String name = (String) headers.nextElement();
					l.info("---" + name + " ---:" + request.getHeader(name));
				}
			}
			l.info("x-forwarded-for:" + request.getHeader("x-forwarded-for"));
			l.info("Proxy-Client-IP:" + request.getHeader("Proxy-Client-IP"));
			l.info("WL-Proxy-Client-IP:" + request.getHeader("WL-Proxy-Client-IP"));
			l.info("---RemoteAddr---:" + request.getRemoteAddr());
			l.info("***********************request info end***********************");
		} catch (Exception e) {
			logger.error("writeHistory error", e);
		}
	}

	/**
	 * 根据实体对象获取表单
	 * 
	 * @author xb
	 * @param request
	 * @param c
	 * @return
	 */
	public static Object request_bean(HttpServletRequest request, Class<?> c) {
		Object o = null;
		try {
			o = c.newInstance();
			Field[] fieldlist = c.getDeclaredFields();
			for (int i = 0; i < fieldlist.length; i++) {
				Field field = fieldlist[i];
				field.setAccessible(true);
				String value = request.getParameter(field.getName());
				if (value != null) {
					try {
						Type type = field.getGenericType();
						if (type.equals(String.class)) {
							try {
								value = URLDecoder.decode(value, "UTF-8");
							} catch (Exception e) {
								e.printStackTrace();
							}
							value = value.replace("%26", "&");
							field.set(o, value.trim());
						}
						if (type.equals(Integer.class)) {
							if (!value.equals("")) {
								field.set(o, new Integer(value));
							}
						}
					} catch (Exception e) {
						logger.error("request_bean error", e);
					}
				}
			}
		} catch (Exception e) {
			logger.error("request_bean error", e);
		}
		return o;
	}

	/**
	 * 获取真实的IP 2016-1-21 22:13
	 * 
	 * @author xb
	 * @param request
	 * @return ip
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}
