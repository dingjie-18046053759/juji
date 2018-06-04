package com.fmcq.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

/**消息转换类
 * @author 沈松
 * 创建日期：2015年9月2日 下午5:32:22
 */
public class MessageUtil {
	public static final String MESSAGE_TEXT="text";
	public static final String MESSAGE_IMAGE="image";
	public static final String MESSAGE_VOICE="voice";
	public static final String MESSAGE_VIDEO="vide0";
	public static final String MESSAGE_LINK="link";
	public static final String MESSAGE_LOCATION="LOCATION";
	public static final String MESSAGE_EVENT="event";
	public static final String MESSAGE_SUBSCRIBE="subscribe";
	public static final String MESSAGE_UNSUBSCRIBE="unsubscribe";
	public static final String MESSAGE_CLICK="CLICK";
	public static final String MESSAGE_VIEW="VIEW";
	public static final String MESSAGE_SCAN="scan";
	
	
	/**把xml文件转为map集合
	 * @param req
	 * @return
	 * @throws IOException
	 * @throws DocumentException
	 */
	public static Map<String,String> xmlToMap(HttpServletRequest req) throws IOException, DocumentException{
		 // 将解析结果存储在HashMap中
        Map<String, String> map = new HashMap<String, String>();

        // 从request中取得输入流
        InputStream inputStream = req.getInputStream();
        // 读取输入流
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);
        // 得到xml根元素
        Element root = document.getRootElement();
        // 得到根元素的所有子节点
        @SuppressWarnings("unchecked")
        List<Element> elementList = root.elements();

        // 遍历所有子节点
        for (Element e : elementList)
            map.put(e.getName(), e.getText());

        // 释放资源
        inputStream.close();
        inputStream = null;

        return map;
	}
	/**将消息转化为xml
	 * @param textMessage
	 * @return
	 */
	public static String messageToXml(InputMessage inputMessage){
		XStream xstream=new XStream();
		xstream.alias("xml", inputMessage.getClass());
		return xstream.toXML(inputMessage);
	}
	/**拼接文本消息基本内容
	 * @param toUserName 
	 * @param fromUserName 
	 * @param content
	 * @return
	 */
	public static String initText(String toUserName,String fromUserName,String content){
		InputMessage inputMessage=new InputMessage();
		inputMessage.setFromUserName(toUserName);
		inputMessage.setToUserName(fromUserName);
		inputMessage.setMsgType(MessageUtil.MESSAGE_TEXT);
		inputMessage.setCreateTime(new Date().getTime());
		inputMessage.setContent(content);
		return MessageUtil.messageToXml(inputMessage);
	}
	/**主菜单的回复
	 * @return
	 */
	public static String menuText(){
		StringBuffer sb=new StringBuffer();
		sb.append("欢迎您的关注，请您按照菜单提示进行操作：\n");
		sb.append("1、我们的平台介绍\n");
		sb.append("2、使用帮助\n");
		sb.append("回复？调出此菜单。\n");
		sb.append("使用说明：请点击个人信息填写个人资料完整并通过审核才能使用该服务。");
		return sb.toString();
	}
	/**用户发送“1”的时候回复的内容
	 * @return
	 */
	public static String firstMenu(){
		StringBuffer sb=new StringBuffer();
		sb.append("您可以通过手机端提交求医订单，系统匹配相关专业医生初步电联后两小时提供上门问诊服务，同时您可以通过本平台购买药物，支付医药费。");
		return sb.toString();
	}
	public static String firstMenuDoc(){
		StringBuffer sb=new StringBuffer();
		sb.append("本平台为您提供更多便捷创造财富的机会。您可以利用空闲之余，通过平台在专长医疗领域接受患者发布需求订单，初步电联了解病情，对非重大疾病患者提供上门问诊服务。");
		return sb.toString();
	}
	/**用户发送“2”的时候回复的内容
	 * @return
	 */
	public static String secondMenu(){
		StringBuffer sb=new StringBuffer();
		sb.append("您可以通过点击下方的菜单进行一键叫医和查看您在本平台上的个人信息。");
		return sb.toString();
	}
	public static String secondMenuDoc(){
		StringBuffer sb=new StringBuffer();
		sb.append("点击下方“我的状态”来更改您的状态,点击“接诊记录”查看您的相关订单，点击“我的资料完善和查看您的相关个人资料。”");
		return sb.toString();
	}
	public static String online(){
		StringBuffer sb=new StringBuffer();
		sb.append("操作成功，您现在是在线状态，您将接收到用户的订单请求，如果您有事离开，请您及时改变状态！");
		return sb.toString();
	}
	public static String offline(){
		StringBuffer sb=new StringBuffer();
		sb.append("操作成功，您现在是离线状态，您将无法接收到用户订单请求，如果您有空的时候，请记得改变您的状态！");
		return sb.toString();
	}
	public static String mystate(int state){
		StringBuffer sb=new StringBuffer();
		if(state==1){
			sb.append("您现在是在线状态，您将接收到用户的订单请求，如果您有事离开，请您及时改变状态！");
		}
		if(state==0){
			sb.append("您现在是离线状态，您将无法接收到用户订单请求，如果您有空的时候，请记得改变您的状态！");
		}
		return sb.toString();
	}
	
	/** 
     * 返回消息类型：文本 
     */  
    public static final String RESP_MESSAGE_TYPE_TEXT = "text";  
  
    /** 
     * 返回消息类型：音乐 
     */  
    public static final String RESP_MESSAGE_TYPE_MUSIC = "music";  
  
    /** 
     * 返回消息类型：图文 
     */  
    public static final String RESP_MESSAGE_TYPE_NEWS = "news";  
  
    /** 
     * 请求消息类型：文本 
     */  
    public static final String REQ_MESSAGE_TYPE_TEXT = "text";  
  
    /** 
     * 请求消息类型：图片 
     */  
    public static final String REQ_MESSAGE_TYPE_IMAGE = "image";  
  
    /** 
     * 请求消息类型：链接 
     */  
    public static final String REQ_MESSAGE_TYPE_LINK = "link";  
  
    /** 
     * 请求消息类型：地理位置 
     */  
    public static final String REQ_MESSAGE_TYPE_LOCATION = "location";  
  
    /** 
     * 请求消息类型：音频 
     */  
    public static final String REQ_MESSAGE_TYPE_VOICE = "voice";  
  
    /** 
     * 请求消息类型：推送 
     */  
    public static final String REQ_MESSAGE_TYPE_EVENT = "event";  
  
    /** 
     * 事件类型：subscribe(订阅) 
     */  
    public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";  
  
    /** 
     * 事件类型：unsubscribe(取消订阅) 
     */  
    public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";  
  
    /** 
     * 事件类型：CLICK(自定义菜单点击事件) 
     */  
    public static final String EVENT_TYPE_CLICK = "CLICK";  
  
    /** 
     * 解析微信发来的请求（XML） 
     *  
     * @param request 
     * @return 
     * @throws Exception 
     */  
    @SuppressWarnings("unchecked")  
    public static Map<String, String> parseXml(HttpServletRequest request) throws Exception {  
        // 将解析结果存储在HashMap中  
        Map<String, String> map = new HashMap<String, String>();  
  
        // 从request中取得输入流  
        InputStream inputStream = request.getInputStream();  
        // 读取输入流  
        SAXReader reader = new SAXReader();  
        Document document = reader.read(inputStream);  
        // 得到xml根元素  
        Element root = document.getRootElement();  
        // 得到根元素的所有子节点  
        List<Element> elementList = root.elements();  
  
        // 遍历所有子节点  
        for (Element e : elementList)  
            map.put(e.getName(), e.getText());  
  
        // 释放资源  
        inputStream.close();  
        inputStream = null;  
  
        return map;  
    }  
  
    /** 
     * 图文消息对象转换成xml 
     *  
     * @param newsMessage 图文消息对象 
     * @return xml 
     */  
    public static String newsMessageToXml(NewsMessage newsMessage) {  
        xstream.alias("xml", newsMessage.getClass());  
        xstream.alias("item", new Article().getClass());  
        return xstream.toXML(newsMessage);  
    }  
  
    /** 
     * 扩展xstream，使其支持CDATA块 
     *  
     * @date 2013-05-19 
     */  
    private static XStream xstream = new XStream(new XppDriver() {  
        public HierarchicalStreamWriter createWriter(Writer out) {  
            return new PrettyPrintWriter(out) {  
                // 对所有xml节点的转换都增加CDATA标记  
                boolean cdata = true;  
  
                @SuppressWarnings("unchecked")  
                public void startNode(String name, Class clazz) {  
                    super.startNode(name, clazz);  
                }  
  
                protected void writeText(QuickWriter writer, String text) {  
                    if (cdata) {  
                        writer.write("<![CDATA[");  
                        writer.write(text);  
                        writer.write("]]>");  
                    } else {  
                        writer.write(text);  
                    }  
                }  
            };  
        }  
    }); 
}
