package com.fmcq.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fmcq.service.IWeixinService;
import com.fmcq.util.Article;
import com.fmcq.util.Comm;
import com.fmcq.util.MessageUtil;
import com.fmcq.util.NewsMessage;
import com.fmcq.util.SignUtil;


@Controller
@RequestMapping("/weixinCon")
public class WeixinController extends BaseController {
	private static Log log = LogFactory.getLog(WeixinController.class);
	
	@Resource
	private IWeixinService weixinService;
	
	
	@RequestMapping("/get.do")
	@ResponseBody
	public void get() throws IOException {
		log.info("请求进来了..."); 
		if (!"post".equals(request.getMethod().toLowerCase())) {
			log.info("微信后端验证开发者模式使用");
			// 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
			String signature = request.getParameter("signature");
			// 时间戳
			String timestamp = request.getParameter("timestamp");
			// 随机数
			String nonce = request.getParameter("nonce");
			// 随机字符串
			String echostr = request.getParameter("echostr");

			PrintWriter out = null;
			try {
				out = response.getWriter();
				// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，否则接入失败
				if (SignUtil.checkSignature(signature, timestamp, nonce)) {
					out.print(echostr);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				out.close();
				out = null;
			}
		}else{
			receive();
		}
	}
	
	public void receive() throws IOException {
		// 设置字符串的格式
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		try {
			Map<String, String> map = MessageUtil.xmlToMap(request);
			String fromUserName = map.get("FromUserName");
			log.info("========================关注微信公众号的用户openId["
					+ fromUserName + "]=======================");
			String toUserName = map.get("ToUserName");
			String msgType = map.get("MsgType");
			String content = map.get("Content");
			String message = "";
			// 判断消息的类型
			if (MessageUtil.MESSAGE_TEXT.equals(msgType)) {
				log.info("==========================用户发送文字消息，内容["
						+ content + "]======================");
				if ("1".equals(content)) {
					message = MessageUtil.initText(toUserName, fromUserName,
							MessageUtil.firstMenu());
				} else if ("2".equals(content)) {
					message = MessageUtil.initText(toUserName, fromUserName,
							MessageUtil.secondMenu());
				}else if("白血病".equals(content)){
					List<Article> articleList = new ArrayList<Article>();  
					Article article = new Article();  
                    article.setTitle("白血病是不治之症？和装修污染有关？答案在这里");  
                    article.setDescription("");  
                    article.setPicUrl(Comm.THIS_URL+"/images/weixin/fdfsfdfdf.jpg");  
                    article.setUrl("http://mp.weixin.qq.com/s?__biz=MzAxNDY1ODM1NQ==&tempkey=gRGnP4WT03NKP1x5vq62W0Tdtx2Q319LUKt4kFp6SUn6QOTO%2BAGDkJcGZFpGnuLXCb2Cvp78L%2FHSbSZmZ3wqEy%2Bgn0kkp%2B7%2FOQZLQ7RnBay0pdYPB16eRXdt4mSidC5kTuLyRn%2BNlu3P1zMO75%2B%2BnQ%3D%3D&chksm=0075bf45370236533fa0ac5fb8a321d957478d0c1dd4b4664f4ef985507c6740a1f87b37287b#rd");  
                    articleList.add(article);  
                    
                    // 创建图文消息  
                    NewsMessage newsMessage = new NewsMessage();  
                    newsMessage.setToUserName(fromUserName);  
                    newsMessage.setFromUserName(toUserName);  
                    newsMessage.setCreateTime(new Date().getTime());  
                    newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);  
                    newsMessage.setFuncFlag(0);  
                    
                    // 设置图文消息个数  
                    newsMessage.setArticleCount(articleList.size());  
                    // 设置图文消息包含的图文集合  
                    newsMessage.setArticles(articleList);  
                    // 将图文消息对象转换成xml字符串  
                    message = MessageUtil.newsMessageToXml(newsMessage);  
				}else if("手机".equals(content)){
					List<Article> articleList = new ArrayList<Article>();  
					Article article = new Article();  
                    article.setTitle("千万别让手机亮\"瞎\"了眼");  
                    article.setDescription("");  
                    article.setPicUrl(Comm.THIS_URL+"/images/weixin/o672432.png");  
                    article.setUrl("http://mp.weixin.qq.com/s?__biz=MzAxNDY1ODM1NQ==&mid=2651774297&idx=2&sn=eacc94f98395224d11f02cd6b0882c35#rd");  
                    articleList.add(article);  
                    
                    // 创建图文消息  
                    NewsMessage newsMessage = new NewsMessage();  
                    newsMessage.setToUserName(fromUserName);  
                    newsMessage.setFromUserName(toUserName);  
                    newsMessage.setCreateTime(new Date().getTime());  
                    newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);  
                    newsMessage.setFuncFlag(0);  
                    
                    // 设置图文消息个数  
                    newsMessage.setArticleCount(articleList.size());  
                    // 设置图文消息包含的图文集合  
                    newsMessage.setArticles(articleList);  
                    // 将图文消息对象转换成xml字符串  
                    message = MessageUtil.newsMessageToXml(newsMessage);  
				}else if("找医生".equals(content) || "医生".equals(content)){
					List<Article> articleList = new ArrayList<Article>();  
					Article article = new Article();  
                    article.setTitle("点击开始找医生");  
                    article.setDescription("");  
                    article.setPicUrl(Comm.THIS_URL+"/images/weixin/zys.jpg");  
                    article.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxb1dda21e2f616b8c&redirect_uri="+Comm.THIS_URL+"/doctor/wxGetDocList.do&response_type=code&scope=snsapi_userinfo&state=cusService#wechat_redirect");  
                    articleList.add(article);  
                    
                    // 创建图文消息  
                    NewsMessage newsMessage = new NewsMessage();  
                    newsMessage.setToUserName(fromUserName);  
                    newsMessage.setFromUserName(toUserName);  
                    newsMessage.setCreateTime(new Date().getTime());  
                    newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);  
                    newsMessage.setFuncFlag(0);  
                    
                    // 设置图文消息个数  
                    newsMessage.setArticleCount(articleList.size());  
                    // 设置图文消息包含的图文集合  
                    newsMessage.setArticles(articleList);  
                    // 将图文消息对象转换成xml字符串  
                    message = MessageUtil.newsMessageToXml(newsMessage);  
				}else{
					message = MessageUtil.initText(toUserName, fromUserName,
							MessageUtil.menuText());
				}
			}else if (MessageUtil.MESSAGE_EVENT.equals(msgType)) { // 如果是Event事件再进行处理
				log.info("==========================用户触发事件======================");
				String Event = map.get("Event") == null ? "":map.get("Event");
				log.info("1事件Event:" + Event);
				String EventKey = map.get("EventKey") == null ? "":map.get("EventKey");
				log.info("推荐人EventKey:" + EventKey);

				if (MessageUtil.MESSAGE_CLICK.equals(Event)) {
					log.info("==========================用户触发菜单单击事件======================");
					String eventKey = map.get("EventKey");
					log.info(eventKey);
					
					if ("mydoc".equals(eventKey)) {
						
					} else if ("aboutus".equals(eventKey)) {// 进行关于我们信息推送
						
					}
				} else if (MessageUtil.MESSAGE_LOCATION.equals(Event)) {
					log.info("======================================================");
					log.info("==========================定位推送======================");
					log.info("======================================================");
					if(map.get("Latitude") != null && map.get("Longitude") != null){
						log.info("==========================获取定位成功======================");
						log.info("纬度" + map.get("Latitude") + "经度" + map.get("Longitude"));
						
						//修改用户位置
						Map<String, String> pMap = new HashMap<String, String>();
						pMap.put("openid", fromUserName);
						pMap.put("latitude", map.get("Latitude"));
						pMap.put("longitude", map.get("Longitude"));
						
					}else{
						log.info("==========================获取定位失败======================");
					}
					
				}else if (MessageUtil.MESSAGE_UNSUBSCRIBE.equals(Event)) {
					log.info("==========================取消订阅(关注)事件======================");
					
				} else if (MessageUtil.MESSAGE_SUBSCRIBE.equals(Event)) {
					log.info("==========================用户触发订阅(关注)事件======================");
					
				} else {
					log.info("==========================其他事件======================");
					
				}
			}

			out.print(message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			out.close();
		}
	}
	
 	// 过滤特殊字符
	public String StringFilter(String str) {

		Pattern emoji = Pattern
				.compile(
						"[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]",
						Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);
		Matcher emojiMatcher = emoji.matcher(str);
		if (emojiMatcher.find()) {
			str = emojiMatcher.replaceAll("");
		}
		return str;
	}
}
