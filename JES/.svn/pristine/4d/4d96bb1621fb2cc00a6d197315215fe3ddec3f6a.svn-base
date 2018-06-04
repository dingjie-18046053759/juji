package com.fmcq.util.datautil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import com.fmcq.util.exception.ParamException;

public class XMLUtil {

	/**
	 * 把xml字符串转换成 Document对象。
	 * 
	 * @param xml
	 *            需要转换的xml字符串
	 * @return 返回Document对象
	 * @throws ParamException
	 *             如果转换成Document对象异常的话抛出异常。
	 */
	public static Document parseXml(String xml) throws ParamException {
		try {
			return DocumentHelper.parseText(xml);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ParamException("传入的 xml 不是标准的xml字符串，请检查字符串是否合法。");
		}
	}

	/**
	 * 转换成xml字符串
	 * 
	 * @param xmlDoc
	 *            需要解析的xml对象
	 * @throws ParamException
	 */
	public static String toXML_UTF_8(org.dom4j.Document xmlDoc) throws ParamException {
		return toXML(xmlDoc, "UTF-8", true);
	}

	/**
	 * 转换成xml字符串
	 * 
	 * @param xmlDoc
	 *            需要解析的xml对象
	 * @throws ParamException
	 */
	public static String toXML_GBK(org.dom4j.Document xmlDoc) throws ParamException {
		return toXML(xmlDoc, "GBK", true);
	}

	/**
	 * 转换成xml字符串
	 * 
	 * @param xmlDoc
	 *            需要解析的xml对象
	 * @param encoding
	 *            编码格式：UTF-8、GBK
	 * @param iscom
	 *            是否为紧凑型格式
	 * @return 修正完成后的xml字符串
	 * @throws ParamException
	 */
	public static String toXML(org.dom4j.Document xmlDoc, String encoding, boolean iscom) throws ParamException {
		ByteArrayOutputStream byteRep = new ByteArrayOutputStream();
		OutputFormat format = null;
		if (iscom) {
			format = OutputFormat.createCompactFormat();// 紧凑型格式
		} else {
			format = OutputFormat.createPrettyPrint();// 缩减型格式
		}
		format.setEncoding(encoding);// 设置编码
		format.setTrimText(false);// 设置text中是否要删除其中多余的空格
		XMLWriter xw;
		try {
			xw = new XMLWriter(byteRep, format);
			xw.write(xmlDoc);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ParamException(e, "传入的编码格式错误，请传入正确的编码。");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ParamException(e, "文档转换成xml字符串时出错。" + xmlDoc.asXML());
		}
		return byteRep.toString();
	}

	/**
	 * 对节点Element 添加节点。
	 * 
	 * @param e
	 *            需要添加的节点
	 * @param name
	 *            添加的节点的名称
	 * @param value
	 *            添加的内容 <br/>
	 *            Demo: < Root > aaa < /Root > <br/>
	 *            call--> addChildElement(root, "A", "a"); <br/>
	 *            result--> < Root >< A >a< /A >< /Root >
	 */
	public static void addElement(Element e, String name, Object value) {
		if (isBlank(value)) {
			e.addElement(name).addText("");
		} else {
			e.addElement(name).addText(value.toString());
		}
	}

	/**
	 * 判断对象是否非空！(null,"", "null")
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isNotBlank(Object obj) {
		return !isBlank(obj);
	}

	/**
	 * 判断对象是否为空！(null,"", "null")
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isBlank(Object obj) {
		if (obj == null) {
			return true;
		}
		if (obj instanceof String) {
			return isBlank((String) obj);
		} else {
			return isBlank(obj.toString());
		}
	}

	public static void addElement(Element e, String name, Integer value) {
		Element current = e.addElement(name);
		if (value != null) {
			current.setText(Integer.toString(value));
		}
	}

	/**
	 * 添加CDATA 类型节点
	 * 
	 * @param e
	 * @param name
	 * @param value
	 */
	public static void addCDATAElement(Element e, String name, String value) {
		Element current = e.addElement(name);
		if (value != null) {
			current.addCDATA(value.trim());
		}
	}

	/**
	 * 添加CDATA 类型节点
	 * 
	 * @param e
	 * @param name
	 * @param value
	 */
	public static void addCDATAElement(Element e, String name, Integer value) {
		Element current = e.addElement(name);
		if (value != null) {
			current.addCDATA(value.toString());
		}
	}

	/**
	 * 获取节点中的整数
	 * 
	 * @throws ParamException
	 */
	public static int getInt(Element e, String name, boolean isMust) throws ParamException {
		Element current = e.element(name);

		if (current == null || current.getText() == null || "".equals(current.getText().trim()) || current.getText().length() <= 0) {
			if (isMust) {
				throw new ParamException("在 $" + e.asXML() + "$中获取节点：" + name + " 的值为空。");
			}
			return 0;
		}
		Integer i = 0;
		try {
			i = Integer.parseInt(current.getTextTrim());
		} catch (NumberFormatException e1) {
			i = 0;
			if (isMust) {
				throw new ParamException("在 $" + e.asXML() + "$中获取节点：" + name + " 的值不是整形。");
			}
		}
		return i;
	}

	/**
	 * 获取节点中的字符串
	 * 
	 * @throws ParamException
	 */
	public static String getString(Element e, String name, boolean isMust) throws ParamException {
		return getString(e, name, isMust, null);
	}

	/**
	 * 获取节点中的字符串
	 * 
	 * @param e
	 * @param name
	 * @param isMust
	 *            是否必填 true 必填 false非必填
	 * @param defVal
	 *            默认值
	 * @return
	 * @throws ParamException
	 */
	public static String getString(Element e, String name, boolean isMust, String defVal) throws ParamException {
		Element current = e.element(name);
		if (current == null || current.getText() == null || StringUtil.isEmpty(current.getText().trim())) {
			if (isMust) {
				throw new ParamException("在 $" + e.asXML() + "$中获取节点：" + name + " 的值为空。");
			}
			return defVal;
		}
		return current.getTextTrim();
	}

	public static String ElementStringValue(String str) {
		if (str != null) {
			return str;
		} else {
			return "";
		}
	}

	public static Integer ElementIntegerValue(Integer str) {
		if (str != null) {
			return str;
		} else {
			return 0;
		}
	}

	public static String ElementValue(String str) {
		if (str != null && !str.equalsIgnoreCase("null")) {
			return str;
		} else {
			return "";
		}
	}

	public static void main(String[] args) throws ParamException {

		Document doc = parseXml("<Root></Root>");
		Element root = doc.getRootElement();
		addElement(root, "A", "阿萨德飞");
		addElement(root, "A", 2);
		System.out.println("添加子节点：\r\n" + toXML(doc, "GBK", true));
		addCDATAElement(root, "B", "所发生的");
		System.out.println("添加 CDATA 子节点：\r\n" + toXML(doc, "UTF-8", true));
	}
}
