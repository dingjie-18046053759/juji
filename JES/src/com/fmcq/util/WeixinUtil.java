package com.fmcq.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Timer;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fmcq.entity.AccessToken;

/**
 * 微信相关工具类
 * 
 * @author super-z
 * 
 */
public class WeixinUtil {

	private static Log log = LogFactory.getLog(WeixinUtil.class);

	// 获取access_token的接口地址（GET） 限200（次/天）
	public final static String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

	// 菜单创建（POST） 限100（次/天）
	public static String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

	// 发送消息的url地址
	public static String POSTMESSAGE_URL = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";

	// 获取用户基本信息URL
	public static String USERINFO_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";

	// 获取网页的通行证token的url地址
	public static String WEB_ACCESSTOKEN_Url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";

	// 刷新webToken的地址
	public static String UP_WEB_ACCESSTOKEN_Url = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN";

	public static String WX_ZF = "https://api.mch.weixin.qq.com/pay/unifiedorder";
	
	/**
	 * 生成带参数的二维码的url地址
	 */
	public static String GET_PIC_URL="https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=TOKEN";
	
	/**
	 * 获取全局临时票据TICKET的url地址
	 */
	public static String ACCESS_TICKET_URL="https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";
	
	// public static String CUSTOMER_APPID="wxb1dda21e2f616b8c";//线上
	// public static String CUSTOMER_APPSECRET =
	// "132556b94adcee117e212b28bfa8ce5a";//线上
	public static String CUSTOMER_APPID = "wxc65d5d3ca73af74e";//公众号应用ID
	public static String CUSTOMER_APPSECRET = "0c544525c522100168ff2100daf2f6fc";//公众号应用密钥
	public static String CUSTOMER_PARTNER = "1258997801";//商户号
	public static String CUSTOMER_PARTNERKEY = "CB3CEB5373CE4A436C8321CE9F03D990";//商户密钥
	
	/**
	 * 获取全局access_token
	 * 
	 * @param appid
	 *            凭证
	 * @param appsecret
	 *            密钥
	 * @return
	 */
	public static AccessToken getAccessToken() {
		AccessToken accessToken = null;

		String requestUrl = access_token_url.replace("APPID", CUSTOMER_APPID)
				.replace("APPSECRET", CUSTOMER_APPSECRET);
		JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
		// 如果请求成功
		if (null != jsonObject) {
			try {
				accessToken = new AccessToken();
				log.info("获取token成功：" + jsonObject.getString("access_token"));
				accessToken.setToken(jsonObject.getString("access_token"));
				accessToken.setExpiresIn(jsonObject.getInt("expires_in"));
			} catch (JSONException e) {
				accessToken = null;
				// 获取token失败
				log.error("获取token失败 errcode:{" + jsonObject.getInt("errcode")
						+ "} errmsg:{" + jsonObject.getString("errmsg") + "}");
			}
		}
		return accessToken;
	}

	/**
	 * 获取网页授权access_token
	 * 
	 * @param code
	 * @return
	 */
	public static String getWebToken(String code) {
		log.info("获取网页授权access_token start");

		String tokenUrl = WEB_ACCESSTOKEN_Url;
		Timer timer = new Timer();
		JSONObject json = null;
		String openid = "";
		// String access_token = "";
		// String refresh_token = "";
		try {
			log.info("code：" + code);
			tokenUrl = tokenUrl.replaceAll("APPID", CUSTOMER_APPID);
			tokenUrl = tokenUrl.replaceAll("SECRET", CUSTOMER_APPSECRET);
			tokenUrl = tokenUrl.replaceAll("CODE", code);
			log.info(tokenUrl);
			json = httpRequest(tokenUrl, "POST", null);
			log.info(json);
			String temtime = json.getString("expires_in");
			log.info("expires_in：" + temtime);
			long time = Long.parseLong(temtime);
			openid = json.getString("openid");
			// access_token = json.getString("access_token");
			// refresh_token = json.getString("refresh_token");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Object[] obj = new Object[3];
		// obj[0] = openid;
		// obj[1] = access_token;
		// obj[2] = refresh_token;

		log.info("获取网页授权access_token end");
		return openid;
	}

	// /**
	// * 刷新access_token
	// * @param code
	// * @return
	// */
	// public static String refWebToken(String code) {
	// log.info("刷新access_token start");
	//
	// String tokenUrl = WEB_ACCESSTOKEN_Url;
	// String upTokenUrl = UP_WEB_ACCESSTOKEN_Url;
	// Timer timer = new Timer();
	// JSONObject json = null;
	// String openid = "";
	// // 判断刷新Token是否为空，为空的话再重新请求
	// log.info("第二种情况进入======================");
	// upTokenUrl = upTokenUrl.replaceAll("APPID",
	// Comm.CUSTOMER_APPID).replaceAll("REFRESH_TOKEN",
	// (String)session.getAttribute(Comm.CUSTOMER_RE_WEB_ACCESSTOKEN));
	// log.info(upTokenUrl);
	// json = sendGet(upTokenUrl);
	// log.info(json);
	// openid = json.getString("openid");
	// long time = json.getLong("expires_in");
	// session.setAttribute(Comm.CUSTOMER_WEB_ACCESSTOKEN,json.getString("access_token"));
	// session.setAttribute(Comm.CUSTOMER_RE_WEB_ACCESSTOKEN,json.getString("refresh_token"));
	// timer.schedule(new TimerTask() {
	// @Override
	// public void run() {
	// // TODO Auto-generated method stub
	// if(!session.isNew())
	// session.removeAttribute(Comm.CUSTOMER_RE_WEB_ACCESSTOKEN);
	// }
	// }, 100 * 60 * 1000);
	// log.info("刷新access_token end");
	// return openid;
	// }

	/**
	 * 描述: 发起https请求并获取结果
	 * 
	 * @param requestUrl
	 *            请求地址
	 * @param requestMethod
	 *            请求方式（GET、POST）
	 * @param outputStr
	 *            提交的数据
	 * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
	 */
	public static JSONObject httpRequest(String requestUrl,
			String requestMethod, String outputStr) {
		JSONObject jsonObject = null;
		StringBuffer buffer = new StringBuffer();
		try {
			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(requestUrl);
			HttpsURLConnection httpUrlConn = (HttpsURLConnection) url
					.openConnection();
			httpUrlConn.setSSLSocketFactory(ssf);

			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);

			// 设置请求方式（GET/POST）
			httpUrlConn.setRequestMethod(requestMethod);

			if ("GET".equalsIgnoreCase(requestMethod))
				httpUrlConn.connect();

			// 当有数据需要提交时
			if (null != outputStr) {
				OutputStream outputStream = httpUrlConn.getOutputStream();
				// 注意编码格式，防止中文乱码
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}

			// 将返回的输入流转换成字符串
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(
					inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(
					inputStreamReader);

			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// 释放资源
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();
			jsonObject = JSONObject.fromObject(buffer.toString());
		} catch (ConnectException ce) {
			log.error("Weixin server connection timed out.");
		} catch (Exception e) {
			log.error("https request error:{}", e);
		}
		return jsonObject;
	}

	/**
	 * GET方法
	 * 
	 * @param url
	 * @param param
	 * @return 使用：sendGet("http://localhost:6144/Home/RequestString",
	 *         "key=123&v=456")
	 */
	public static JSONObject sendGet(String url) {
		JSONObject json = null;
		String result = "";
		BufferedReader in = null;
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 建立实际的连接
			connection.connect();
			// 获取所有响应头字段
			Map<String, List<String>> map = connection.getHeaderFields();
			// 遍历所有的响应头字段
			for (String key : map.keySet()) {
				log.info(key + "--->" + map.get(key));
			}
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(
					connection.getInputStream(), "UTF-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
			log.info("get请求获取返回值"+result);
		} catch (Exception e) {
			log.info("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		json = JSONObject.fromObject(result);
		log.info(json);
		return json;
	}
	
	/**
	 * POST方法
	 * 
	 * @param url
	 * @param param
	 * @return
	 */
	public static JSONObject sendPost(String urlstr, String param) {
		JSONObject json = null;
		String result = "";
		try {
			// Configure and open a connection to the site you will send the
			// request
			URL url = new URL(urlstr);
			URLConnection urlConnection = url.openConnection();
			// 设置doOutput属性为true表示将使用此urlConnection写入数据
			urlConnection.setDoOutput(true);
			// 定义待写入数据的内容类型，我们设置为application/x-www-form-urlencoded类型
			urlConnection.setRequestProperty("content-type",
					"application/x-www-form-urlencoded");
			// 得到请求的输出流对象
			OutputStreamWriter out = new OutputStreamWriter(
					urlConnection.getOutputStream(),"utf-8");
			// 把数据写入请求的Body
			out.write(param);
			out.flush();
			out.close();
			// 从服务器读取响应
			InputStream inputStream = urlConnection.getInputStream();
			String encoding = urlConnection.getContentEncoding();
			result = IOUtils.toString(inputStream, encoding);
			log.info("token返回内容："+result);
		} catch (IOException e) {

		}
		json = JSONObject.fromObject(result);
		return json;
	}
	

	/**
	 * 获取用户信息接口
	 * 
	 * @param openid
	 * @param token
	 * @return
	 */
	public static JSONObject getCusInfo(String openid, String token) {
		log.info("获取微信用户基本信息 start");
		String postUrl = USERINFO_URL;
		JSONObject json = new JSONObject();

		log.info("openid:" + openid);
		log.info("ACCESS_TOKEN:" + token);
		postUrl = postUrl.replace("ACCESS_TOKEN", token).replace("OPENID",
				openid);
		log.info("URL：" + postUrl);
		json = httpRequest(postUrl, "POST", null);
		log.info("结果：" + json);

		log.info("获取微信用户基本信息 end");
		return json;
	}

	// 微信号
	/**
	 * 给用户发送消息
	 * 
	 * @param openid
	 *            给发送的用户的openid
	 * @param coutent
	 *            发送的信息内容
	 * @return 返回执行结果，如果是ok，代表执行成功！
	 * @throws IOException
	 */
	public static String sendMessage(String openid, String coutent, String token)
			throws IOException {
		String postUrl = POSTMESSAGE_URL;
		JSONObject json = new JSONObject();
		String str = "{\"touser\":\"OPENID\"," + "\"msgtype\":\"text\","
				+ "\"text\":{\"content\":\"MESSAGE\"}}";

		postUrl = postUrl.replace("ACCESS_TOKEN", token);
		str = str.replace("OPENID", openid).replace("MESSAGE", coutent);

		// 调用接口发送消息
		json = httpRequest(postUrl, "POST", str);
		log.info("发送消息结果：" + json);
		return json.toString();
	}

	/**
	 * 给用户发送图文消息（公司介绍）
	 * 
	 * @param openid
	 *            给发送的用户的openid
	 * 
	 * @return 返回执行结果，如果是ok，代表执行成功！
	 */
	public static String sendArtMessageCompany(String openid, String token) {
		String postUrl = POSTMESSAGE_URL;
		JSONObject json = new JSONObject();
		String str = "{\"touser\":\"OPENID\",\"msgtype\":\"news\",\"news\":{\"articles\": [{\"title\":\"公司介绍\",\"description\":\"易家健康是国内首创以患者为中心的全新型医疗体验，更是一种新的生活方式!\",\"url\":\"http://mp.weixin.qq.com/s?__biz=MzAxNDY1ODM1NQ==&mid=404184262&idx=1&sn=121f1cb5f013dc57b3c901f330d64eea#rd\",\"picurl\":\""+Comm.THIS_URL+"/images/yijia.jpg\"},{\"title\":\"服务流程\",\"description\":\"\",\"url\":\""+Comm.THIS_URL+"/process.html\",\"picurl\":\""+Comm.THIS_URL+"/images/processcover.jpg\"}]}}";

		postUrl = postUrl.replace("ACCESS_TOKEN", token);
		str = str.replace("OPENID", openid);

		json = httpRequest(postUrl, "POST", str);
		return json.getString("errmsg");
	}
	
	/**
	 * 获取js使用签名
	 */
	public static String getSignature(long timestamp,String noncestr,String url,String ticket){
		log.info("============================临时门票["+ticket+"]==========================");
		String signature=DigestUtils.shaHex("jsapi_ticket="+ticket+"&noncestr="+noncestr+"&timestamp="+timestamp+"&url="+url);
		
		return signature;
	}
	
	/**
	 * 通过判断状态码来获取相应的ticket，并且在115分钟后注销此ticket
	 * @return
	 */
	public static AccessToken getTicket(String token) {
		log.info("============================临时密钥["+token+"]==========================");
		
		String postUrl = WeixinUtil.ACCESS_TICKET_URL;
		postUrl = postUrl.replace("ACCESS_TOKEN", token);
		JSONObject json = null;
		json = httpRequest(postUrl, "POST", null);
		
		AccessToken ticket = null;
		ticket = new AccessToken();
		log.info("获取ticket成功：" + json.getString("ticket"));
		ticket.setToken(json.getString("ticket"));
		ticket.setExpiresIn(json.getInt("expires_in"));
		return ticket;
	}
	
	/**
	 * 根据用户的ID生成带参数的二维码
	 * @param id 用户的ID
	 * @return 返回可以去下载的的TIKET
	 * @throws UnsupportedEncodingException 
	 */
	public static String getPic(int id,String rm,String token) throws UnsupportedEncodingException{
		String url=GET_PIC_URL;
		url=url.replace("TOKEN",token);
		String count="{\"action_name\": \"QR_LIMIT_STR_SCENE\", \"action_info\": {\"scene\": {\"scene_str\": \""+rm+id+"\"}}}";
		JSONObject json = new JSONObject();
		json= httpRequest(url,"POST",count);
		String ticket=json.getString("ticket");
		log.info("ticket"+ticket);
		log.info("身份"+rm);		   
		String  qrcodeImgUrl="https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket="+urlEncode(ticket);
		log.info("urlEncode(ticket):"+urlEncode(ticket));
		//跳转到二维码图片页面
		log.info("二维码地址为："+qrcodeImgUrl);
		return qrcodeImgUrl;
	} 
	public static String urlEncode(String str) throws UnsupportedEncodingException {
		String encoderStr = java.net.URLEncoder.encode(str,"gb2312");   
		return encoderStr;
	}
	
	
	/**
	 * 给用户发送回复消息模板
	 * 
	 * @param openid
	 *            用户微信的openid
	 * @param coutent
	 *            发送的信息内容
	 * @param doctorname
	 *            回复消息的医生
	 * @return 返回执行结果，如果是ok，代表执行成功！
	 */
	public static void SendTempMsg(String openid,String coutent,String doctorname ,int docid,int patid, String token){
		if(openid==null){
			return ;
		}
		Date date=new Date();
		SimpleDateFormat timetype = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String beforetime = timetype.format(date);
        
        String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=" + token;
        String first = "您好！您收到一条回复消息.";
        String keyword1 = doctorname+"医生";
        String keyword2 = beforetime;
        String keyword3 = coutent;
        String remark = "点击联系医生！";
        String content = "{ \"touser\": \"" + openid + "\", \"template_id\": \"AjTNbEZdUX-4-pRRXNWpxjxaZXRTk4WxTzzu0J4fVPM\", \"url\": \"" +Comm.THIS_URL+"chat/patChat.do?docId="+docid+"&cusId="+patid+ "\", \"topcolor\": \"#90EE90\",  \"data\": { \"first\": { \"value\": \"" + first + "\", \"color\": \"#173177\" }, \"keyword1\": { \"value\": \"" + keyword1 + "\",  \"color\": \"#173177\"  },\"keyword2\": { \"value\": \"" + keyword2 + "\",  \"color\": \"#173177\"   }, \"keyword3\": { \"value\": \"" + keyword3 + "\",  \"color\": \"#173177\"   },  \"remark\": {            \"value\": \"" + remark + "\",  \"color\": \"#173177\"  }    } }";
        //String content = "{ \"touser\": \"" + openid + "\", \"template_id\": \"AjTNbEZdUX-4-pRRXNWpxjxaZXRTk4WxTzzu0J4fVPM\", \"url\": \"" +(backurl)+ "\", \"topcolor\": \"#90EE90\",  \"data\": { \"first\": { \"value\": \"" + first + "\", \"color\": \"#173177\" }, \"keyword1\": { \"value\": \"" + keyword1 + "\",  \"color\": \"#173177\"  },\"keyword2\": { \"value\": \"" + keyword2 + "\",  \"color\": \"#173177\"   }, \"keyword3\": { \"value\": \"" + keyword3 + "\",  \"color\": \"#173177\"   },  \"remark\": {            \"value\": \"" + remark + "\",  \"color\": \"#173177\"  }    } }";
        JSONObject retStr =WeixinUtil.sendPost(url, content);
       // String retStr = HttpHelp.PostMode(url, content);
       // Dynamic resultJson = DynamicConvertHelper.ConvertJson(retStr);
        if(retStr!=null){
        	if("0".equals(retStr.getString("errcode"))){
        	 log.info("发送回复消息模成功！");
        	}else{
        		log.info(retStr.getString("errcode"));
        	}
        }
	}
	
	/**
	 * 给用户发送体检套餐购买成功模板
	 * 
	 * @param openid
	 *            用户微信的openid
	 * @param date
	 *            有效日期
	 * @return 返回执行结果，如果是ok，代表执行成功！
	 */
	public static void SendTempSuccess(String openid,String traceNo,String price ,int id,int cusid,String token){
		
		if(openid==null){
			return ;
		}
		Date date=new Date();
		SimpleDateFormat timetype = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String beforetime = timetype.format(date);
        
        String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=" + token;
        String first = "您好，您已成功购买。";
        String keyword1 =  traceNo;
        String keyword2 = beforetime;
        String keyword3 = price;
        String remark = "客服会在第一时间与您取得联系，请耐心等待。谢谢您的信任";
        String content = "{ \"touser\": \"" + openid + "\", \"template_id\": \"PCTh_juK3qdJtLtE_AYXijTcy7q-Jo4E6553UeCSOQI\", \"url\": \"" + Comm.THIS_URL+"/physical/getCom.do?id="+id+"&cusId="+cusid+ "\",  \"topcolor\": \"#000000\",  \"data\": { \"first\": { \"value\": \"" + first + "\", \"color\": \"#173177\" }, \"keyword1\": { \"value\": \"" + keyword1 + "\",  \"color\": \"#173177\"  },\"keyword2\": { \"value\": \"" + keyword2 + "\",  \"color\": \"#173177\"   }, \"keyword3\": { \"value\": \"" + keyword3 + "\",  \"color\": \"#173177\"   },  \"remark\": {            \"value\": \"" + remark + "\",  \"color\": \"#173177\"  }    } }";
        JSONObject retStr =WeixinUtil.httpRequest(url,"POST",content);
        if(retStr!=null){
            	if("0".equals(retStr.getString("errcode"))){
            	 log.info("发送购买成功模板成功！");
            	}else{
            		log.info(retStr.getString("errcode"));
            	}
            
            }
	}
	
}