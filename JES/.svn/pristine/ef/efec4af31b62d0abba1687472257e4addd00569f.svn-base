package com.fmcq.util.datautil;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.fmcq.util.codingutil.CryptAES;

/**
 * 
 * @date 2016-01-21 22:02:43
 * @author xb
 * 
 */
public class StringUtil {
	private static Log log = LogFactory.getLog(StringUtil.class);
	/** ip地址缓存列表 */
	public static List<String> ipCacheList = Collections.synchronizedList(new ArrayList<String>());

	//	public static void main(String[] a) {
	//				Head h1=new Head("12345","asdsda\"asda");
	//				Head h2=new Head("12ww45","asdswwda\"asda");
	//				Head h3=new Head("12ww345","asdswwwda\"asda");
	//				List<Head> l=new ArrayList<Head>();
	//				l.add(h1);
	//				l.add(h2);
	//				l.add(h3);
	//				System.out.println(isValidDate("2013-12-01"));
	//				JSONArray lo=JSONArray.fromObject(l);
	//				for(int i=0,j=lo.size();i<j;i++){
	//					JSONObject o=lo.getJSONObject(i);
	//					System.out.println(o.toString());
	//					System.out.println(o.get("rtnCode").toString()+o.get("rtnMsg").toString());
	//				}
	////		StringUtil.initIPList();
	//		//		System.out.println(new StringUtil().getClass().getClassLoader().getResource("").getPath());
	//	}

	public static void initIPList() {
		synchronized (ipCacheList) {
			ipCacheList.clear();
			SAXReader saxReader = new SAXReader();
			try {
				String filepath = new StringUtil().getClass().getClassLoader().getResource("").getPath() + "ips.xml";
				log.info(">>>the ips filepath is:" + filepath);
				Document document = saxReader.read(new File(filepath));
				Element root = document.getRootElement();
				//遍历根结点（ips）的所有孩子节点（肯定是ip节点）
				for (Iterator iter = root.elementIterator(); iter.hasNext();) {
					Element element = (Element) iter.next();
					//获取ip值
					Attribute ipAttr = element.attribute("value");
					if (ipAttr != null) {
						log.info("ip address is:" + ipAttr.getValue());
						ipCacheList.add(ipAttr.getValue().trim());
					}
				}
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}
	}

	public static boolean containsIPList(String str) {
		log.info(">>>>>>>>>>>the ip is:" + str);
		if (str == null || str.trim().equals("")) {
			return false;
		}
		return ipCacheList.contains(str.trim());
	}

	/**
	 * 获取一个UUID
	 * 
	 * @date 2013-11-21 下午04:37:40
	 * @author xb
	 * @return
	 */
	public static synchronized String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	/**
	 * 字符串处理，null处理成"",非空字符串去掉前后空白
	 * 
	 * @date 2016-01-21 下午22:37:50
	 * @author xb
	 * @param str
	 * @return
	 */
	public static String null2String(String str) {
		if (str == null) {
			return "";
		} else {
			return str.trim();
		}
	}

	public static String nullToString(Object str) {
		if (str == null) {
			return "";
		} else {
			return str.toString().trim();
		}
	}

	public static String getResultJson(String head, String body) {
		head = null2String(head);
		if ("".equals(head)) {
			head = "{\"rtnCode\": \"999999\",\"rtnMsg\": \"系统异常\"}";
		}
		body = null2String(body);
		if ("".equals(body) || "{null}".equals(body)) {
			body = "{}";
		} else if ("[null]".equals(body)) {
			body = "[]";
		}
		return "{\"head\":" + head + ",\"body\":" + body + "}";
	}

	/**
	 * 返回分页总数的
	 * 
	 * @param head
	 * @param body
	 * @return
	 */
	public static String getCountResultJson(String head, String body, int count) {
		head = null2String(head);
		if ("".equals(head)) {
			head = "{\"rtnCode\": \"999999\",\"rtnMsg\": \"系统异常\"}";
		}
		body = null2String(body);
		if ("".equals(body) || "{null}".equals(body)) {
			body = "{}";
		} else if ("[null]".equals(body)) {
			body = "[]";
		}
		return "{\"head\":" + head + ",\"count\":\"" + count + "\",\"body\":" + body + "}";
	}

	/**
	 * 过滤字符串内的SQL关键字
	 * 
	 * @author xb
	 * @param text
	 * @return
	 */
	public static String filterSql(String text) {
		if (!"".equals(null2String(text))) {
			text = Pattern.compile("insert|update|delete|select|creat|drop|truncate\\*", Pattern.CASE_INSENSITIVE).matcher(text).replaceAll(" sql关键字 ");
		}
		return text;
	}

	//    public static String imgPath(String imgpath, String defaultImg, int height, int width){
	//		String params = "imgpath=" + imgpath + "&width=" + width + "&height=" + height + "&defaultImg=" + defaultImg;
	//		return StaticValue.FILE + "/back/file/scaleImg.html?" + params;
	//	}
	/**
	 * 数字获取日期
	 * 
	 * @author xb
	 * @param weekStr
	 * @return
	 */
	public static String String2Week(String weekStr) {
		if (weekStr != null) {
			weekStr = weekStr.replace("1,", "星期一,").replace("2,", "星期二,").replace("3,", "星期三,").replace("4,", "星期四,").replace("5,", "星期五,")
					.replace("6,", "星期六,").replace("7,", "星期天,");
			weekStr = weekStr.replace(",　", "　");
		}
		return weekStr;
	}

	/**
	 * 验证日期格式是否是yyyy-MM-dd
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isValidDate(String date) {
		try {
			date = StringUtil.null2String(date);
			if (date.length() > 10) {
				date = date.substring(0, 10);
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			return sdf.format(sdf.parse(date)).equals(date);
		} catch (Exception e) {
			log.error(null, e);
			return false;
		}
	}

	/**
	 * 判断是否为空
	 * 
	 * @author xb
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if (str == null || str.trim().equals("")) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 判断是否为空
	 * 
	 * @author xb
	 * @param str
	 * @return
	 */
	public static boolean isEmptyString(String str) {
		if (str == null || "".equals(str.trim()) || "null".equals(str.trim()) || "NULL".equals(str.trim())) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断是否不为空
	 * 
	 * @author xb
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		if (StringUtil.isEmpty(str)) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 判断是否为数字
	 * 
	 * @author xb
	 * @param str
	 * @return
	 */
	public static boolean isNumer(String str) {
		if (str != null) {
			Pattern pattern = Pattern.compile("[0-9]+");
			return pattern.matcher(str).matches();
		}
		return false;
	}

	/**
	 * 获取工程根目录文件夹
	 * 
	 * @author xb
	 * @return
	 */
	public static String getFileRoot() {
		String t = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		t = t.replaceAll("/WEB-INF/classes/", "");
		return t;
	}

	/**
	 * 加密
	 * 
	 * @author xb
	 * @return
	 */
	public static String encodeASE(String data, String firstKey) {

		String encodeData = CryptAES.AES_Encrypt(firstKey, data);

		return encodeData;
	}

	/**
	 * 解密
	 * 
	 * @author xb
	 * @return
	 */
	public static String decodeASE(String data, String firstKey) {
		String decString = CryptAES.AES_Decrypt(firstKey, data);
		return decString;
	}

	public static void main(String[] args) {
		String data = "<Request><test><test/><Request/>";
		System.err.println("fverlRXXotmqAyuHS".length());
		String str = StringUtil.encodeASE(data, "fverlRXXotmqAyuH");
		System.err.println(str);
		System.err.println(StringUtil.decodeASE(str, "fverlRXXotmqAyuH"));

	}

}
