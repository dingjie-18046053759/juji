package com.fmcq.util.datautil;

import java.util.Iterator;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;

import com.fmcq.util.exception.ParamException;

/**
 * 常用的Json操作工具类
 * 
 * @author Administrator
 * 
 */
public class JSONUtil {

	public static Boolean getJsonBoolean(net.sf.json.JSONObject json, String key, boolean isMust) throws ParamException {
		boolean retval = false;
		Object obj = null;
		obj = json.get(key);
		if (null == obj) {
			obj = getO(json, key);
		}
		if (null == obj && isMust) {
			throw new ParamException("从Json中解析数据.[json]对象中没有:" + key + " 的值.[json] = " + json.toString());
		}
		try {
			retval = json.getBoolean(key);
		} catch (Exception e) {
			throw new ParamException("从Json中解析数据.[json]对象时:" + key + " 的值不是Boolean型.[json] = " + json.toString());
		}
		return retval;
	}

	/**
	 * @param json
	 *            数据源
	 * @param key
	 *            key
	 * @param isMust
	 *            是否必须存在如果不存在抛出异常
	 * @param defVal
	 *            默认值
	 */
	public static Integer getJsonInt(net.sf.json.JSONObject json, String key, boolean isMust, int defVal) throws ParamException {
		Integer retval = defVal;
		if (null == json) {
			throw new ParamException("入参不能为空.");
		}
		Object obj = null;
		obj = json.get(key);
		if (null == obj) {
			obj = getO(json, key);
		}
		if ((null == obj || "".equals(obj.toString())) && isMust) {
			throw new ParamException("参数：" + key + "不能为空.");
		}
		if ((null == obj || "".equals(obj.toString())) && !isMust) {
			return retval;
		}
		if (null == obj || "".equals(obj.toString())) {
			return retval;
		}
		try {
			retval = Integer.parseInt(obj.toString());
		} catch (NumberFormatException e) {
			if (isMust) {
				throw new ParamException("从Json中解析数据.[json]对象中:" + key + " 的参数类型不正确.[json] = " + json.toString());
			}
			retval = 0;
		}
		return retval;
	}

	public static Integer getJsonInt(net.sf.json.JSONObject json, String key, boolean isMust) throws ParamException {
		Integer retval = 0;
		if (null == json) {
			throw new ParamException("从Json中解析数据.[json]对象为空.");
		}
		Object obj = json.get(key);
		if (null == obj) {
			obj = getO(json, key);
		}
		if (null == obj && isMust) {
			throw new ParamException("从Json中解析数据.[json]对象中没有:" + key + " 的值.[json] = " + json.toString());
		}
		if (null == obj || "".equals(obj.toString())) {

			return 0;

		}
		try {
			retval = Integer.parseInt(obj.toString());
		} catch (NumberFormatException e) {
			if (isMust) {
				throw new ParamException("从Json中解析数据.[json]对象中:" + key + " 的值不是整数.[json] = " + json.toString());
			}
		}

		return retval;

	}

	public static String getJsonString(JSONObject json, String key, boolean isMust) throws ParamException {
		try {
			if (null == json) {
				throw new ParamException("从Json中解析数据.[json]对象为空.");
			}
			Object obj = null;

			obj = json.get(key);
			if (null == obj) {
				obj = getO(json, key);
			}
			if (null == obj && isMust) {
				throw new ParamException("从Json中解析数据.[json]对象中没有:" + key + " 的值.[json] = " + json.toString());
			}
			if (null == obj) {
				return null;
			}
			return obj.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Object getO(JSONObject json, String key) {
		Object obj = null;
		if (null == obj) {
			Iterator<String> keys = json.keys();
			while (keys.hasNext()) {
				String k = keys.next();
				if (k.toUpperCase().equals(key.toUpperCase())) {
					obj = json.get(k);
				}
			}
		}
		return obj;
	}

	public static String xml2JSON(String xml) {
		if (StringUtil.isEmpty(xml)) {
			return "";
		} else {
			return new XMLSerializer().read(xml).toString();
		}
	}

	public static String json2XML(String json) {
		if (StringUtil.isEmpty(json)) {
			return "";
		} else {
			net.sf.json.JSONObject jobj = net.sf.json.JSONObject.fromObject(json);
			String xml = new XMLSerializer().write(jobj).replace("<?xml version=\"1.0\" encoding=\"UTF-8\"?>", "").replace("<o>", "").replace("</o>", "");
			return xml;
		}
	}

	public static String jsonToXml(String jsonStr) {
		JSONObject json = JSONObject.fromObject(jsonStr);
		StringBuffer reqXml = new StringBuffer();
		reqXml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		reqXml.append(GetXml(json));
		String rt = reqXml.toString();
		return rt;
	}

	private static String GetXml(JSONObject json) {
		StringBuffer sb = new StringBuffer();
		if (json != null && !json.isNullObject()) {
			Iterator<?> iter = json.keys();
			while (iter.hasNext()) {
				String key = (String) iter.next();
				if (json.get(key) instanceof JSONObject) {
					sb.append("<").append(key).append(">");
					sb.append(GetXml(json.getJSONObject(key)));
					sb.append("</").append(key).append(">");
				} else if (json.get(key) instanceof JSONArray) {
					JSONArray array = json.getJSONArray(key);
					if (array != null && array.size() > 0) {
						for (int i = 0; i < array.size(); i++) {
							sb.append("<").append(key).append(">");
							sb.append(GetXml(array.getJSONObject(i)));
							sb.append("</").append(key).append(">");
						}
					}
				} else {
					sb.append("<").append(key).append(">").append(json.getString(key)).append("</").append(key).append(">");
				}
			}
		}
		return sb.toString();
	}

	/**
	 * 返回结果
	 * 
	 * @param code
	 * @param msg
	 * @return
	 */
	public static JSONObject getRespJSON(int code, String msg) {
		JSONObject obj = new JSONObject();
		obj.put("Code", code);
		obj.put("Message", msg);
//		System.err.println(obj.);
		return obj;
	}

	public static void main(String[] args) {
		String a = "{\"Req\":{\"Service\":{\"RuleId\":\"B5629530-9B69-4668-A02B-9B0B1B256994\",\"StartDay\":\"7\",\"StartTime\":\"07:00\",\"EndDay\":\"0\",\"EndTime\":\"11:00\",\"DrawPoint\":\"门诊\",\"AmtakeNum\":\"07:00\",\"PmtakeNum\":\"20:00\",\"BreachDay\":\"2\",\"BreachTimes\":\"3\",\"State\":1},\"TransactionCode\":2003}}";
		System.out.println(json2XML(a).toString());
		System.out.println(JSONUtil.xml2JSON(json2XML(a)));
		System.out.println(JSONUtil.xml2JSON("<Req class=\"object\"><Service class=\"object\"><AmtakeNum type=\"string\">07:00</AmtakeNum><BreachDay type=\"string\">2</BreachDay><BreachTimes type=\"string\">3</BreachTimes><DrawPoint type=\"string\">门诊</DrawPoint><EndDay type=\"string\">0</EndDay><EndTime type=\"string\">11:00</EndTime><PmtakeNum type=\"string\">20:00</PmtakeNum><RuleId type=\"string\">B5629530-9B69-4668-A02B-9B0B1B256994</RuleId><StartDay type=\"string\">7</StartDay><StartTime type=\"string\">07:00</StartTime><State type=\"number\">1</State></Service><TransactionCode type=\"number\">2003</TransactionCode></Req>"));
	}

	/**
	 * 获取返回的xml
	 * 
	 * @param code
	 * @param message
	 * @return
	 */
	public static Document getRespXML(Integer code, String msg) {
		Document doc = DocumentHelper.createDocument();
		doc.addElement("OutPut");
		doc.getRootElement().addElement("Code", code.toString());
		doc.getRootElement().addElement("Message", msg);
		return doc;
	}

}
