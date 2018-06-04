package com.fmcq.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fmcq.util.datautil.DateUtil;
import com.fmcq.util.datautil.DateUtil2;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * 环信工具类
 * @time 下午4:34:27
 * @author huangzhiwei
 * @category
 */
public class HuanXinUtil {
	private static Log log = LogFactory.getLog(HuanXinUtil.class);
	
	public static String URL = "https://a1.easemob.com/"; 
	public static String CLIENTID = "YXA6qoCe0HyqEeentJ-HWUZ73Q";
	public static String CLIENTSECRET = "YXA6g1WX_GH9e9pfTUEEjdBRTLelulg";
	public static String ORGNAME = "1186170809115985";//对应#前面部分
	public static String APPNAME = "jes";
//	public static String CLIENTID = "YXA6XDIZcNLwEeaCv9XTTW8kMQ";
//	public static String CLIENTSECRET = "YXA6egzdmJlv-fgHv_XabbaucY780ec";
//	public static String ORGNAME = "1147170105178956";//对应#前面部分
//	public static String APPNAME = "yjjk";
	
	public static Map<String, Object> hxToken;
	
	public static String HXQZ = "j";
//	public static String HXQZ = "y";
	
	/**
	 * 获取token值
	 * @return
	 * @throws ParseException 
	 * @throws NumberFormatException 
	 * @throws IOException
	 */
	public static Map<String, Object> getToken() throws NumberFormatException, ParseException{
		Map<String, Object> rmap = new HashMap<String, Object>();
		Map<String,String> map = new HashMap<String, String>();
		map.put("grant_type", "client_credentials");
		map.put("client_id", HuanXinUtil.CLIENTID);
		map.put("client_secret", HuanXinUtil.CLIENTSECRET);
		
		Gson gson = new Gson();
		String g = gson.toJson(map);
		
		String json,token = null;
		try {
			json = httpSend(URL+HuanXinUtil.ORGNAME+"/"+HuanXinUtil.APPNAME+"/token", "POST", g, null);
			Map<String, Object> tmap = JsonToMap.toMap(json);
			json = String.valueOf(tmap.get("access_token"));
			token = json.substring(1, json.length()-1);
			
			log.info("获取token成功：" + token);
			rmap.put("token", token);
			rmap.put("expires_in", tmap.get("expires_in"));
			String time = DateUtil.addSecond(DateUtil2.getSysDate(DateUtil2.YYYY_MM_DD_HH_MM_SS), Integer.valueOf(String.valueOf(tmap.get("expires_in")))-300, DateUtil2.YYYY_MM_DD_HH_MM_SS);
			rmap.put("time", time);
			return rmap;
		} catch (IOException e) {
			token = null;
			log.error("获取token失败！");
		}
		return null;
	}
	
	/**
	 * 判断用户是否为环信IM用户
	 * @return
	 * @throws IOException 
	 */
	public static boolean ifExistSystem(String user, String token){
		try {
			//log.info("token:"+token);
			//log.info(URL+HuanXinUtil.ORGNAME+"/"+HuanXinUtil.APPNAME+"/users/"+user);
			String json;
				json = httpSend(URL+HuanXinUtil.ORGNAME+"/"+HuanXinUtil.APPNAME+"/users/"+user, "GET", null, token);
			if(json != null){
				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
			log.error("判断用户是否为环信IM用户失败！");
			return false;
		}
		return false;
	}
	
	/**
	 * 增加环信用户
	 * @param user
	 * @return
	 * @throws IOException
	 */
	public static String addUser(String user, String token){
		String userInfo = "{\"username\":\""+user+"\",\"password\":\""+user+"\"}";
		//log.info(URL+ORGNAME+"/"+APPNAME+"/users");
		//log.info(userInfo);
		
		String response = null;
		try {
			response = httpSend(URL+ORGNAME+"/"+APPNAME+"/users", "POST", userInfo, token);
		} catch (IOException e) {
			System.out.println(e.toString());
			response = null;
			log.error("增加环信用户失败！");
		}
		
		return response;
	}
	
	/**
	 * 用户添加好友
	 * @param user1
	 * @param user2
	 * @return
	 * @throws IOException 
	 */
	public static String userAddDoc(String user1,String user2, String token){
		//log.info("token:"+token);
		//log.info(URL+HuanXinUtil.ORGNAME+"/"+HuanXinUtil.APPNAME+"/users/"+user+"/contacts/users/"+doc+"");
		String json = null;
		try {
			json = httpSend(URL+HuanXinUtil.ORGNAME+"/"+HuanXinUtil.APPNAME+"/users/"+user1+"/contacts/users/"+user2+"", "POST", null, token);
			log.info("用户添加好友成功！");
		} catch (IOException e) {
			json = null;
			log.error("用户添加好友失败！");
		}
		return json;
	}
	
	/**
	 * 用户解除好友
	 * @param user1
	 * @param user2
	 * @return
	 * @throws IOException 
	 */
	public static String userDelDoc(String user1,String user2, String token){
		log.info("token:"+token);
		log.info(URL+HuanXinUtil.ORGNAME+"/"+HuanXinUtil.APPNAME+"/users/"+user1+"/contacts/users/"+user2+"");
		String json = null;
		try {
			json = httpSend(URL+HuanXinUtil.ORGNAME+"/"+HuanXinUtil.APPNAME+"/users/"+user1+"/contacts/users/"+user2+"", "DELETE", null, token);
			log.info("用户解除好友成功！");
		} catch (IOException e) {
			json = null;
			log.error("用户解除好友失败！");
		}
		return json;
	}
	
	/**
	 * 删除环信用户
	 * @param user
	 * @return
	 * @throws IOException 
	 */
	public static String delUser(String user, String token){
		log.info("token:"+token);
		log.info(URL+HuanXinUtil.ORGNAME+"/"+HuanXinUtil.APPNAME+"/users/"+user);
		String json = null;
		try {
			json = httpSend(URL+HuanXinUtil.ORGNAME+"/"+HuanXinUtil.APPNAME+"/users/"+user, "DELETE", null, token);
			log.info("删除环信用户成功！");
		} catch (IOException e) {
			json = null;
			log.error("删除环信用户失败！");
		}
		return json;
	}
	
	/**
	 * 判断是否存在好友,存在返回true,不存在返回false
	 * @return
	 * @throws IOException 
	 */
	public static boolean ifExistFriend(String user,String doc, String token){
		//log.info("token:"+token);
		//log.info(URL+HuanXinUtil.ORGNAME+"/"+HuanXinUtil.APPNAME+"/users/"+user+"/contacts/users/"+doc+"");
		String json = null;
		try {
			json = httpSend(URL+HuanXinUtil.ORGNAME+"/"+HuanXinUtil.APPNAME+"/users/"+user+"/contacts/users", "GET", null, token);
		} catch (IOException e) {
			log.error("判断是否存在好友失败！");
			return false;
		}
		
		Map<String, Object> map = JsonToMap.toMap(json);
		String data = map.get("data").toString();
		data = data.replace("\"","").replace(" ", ""); ;
		String [] dataArray = data.substring(1, data.length()-1).split(",");
		int i=0;
		while(i<dataArray.length){
			if(dataArray[i].equals(doc)){
				return true;
			}
			i++;
		}
		return false;
	}
	
	/**
	 * 判断用户是否在线,在线返回true,不在线返回false
	 * @return
	 * @throws IOException 
	 */
	public static boolean ifExistOnline(String user, String token){
		//log.info("token:"+token);
		//log.info(URL+HuanXinUtil.ORGNAME+"/"+HuanXinUtil.APPNAME+"/users/"+user+"/contacts/users/"+doc+"");
		String json = null;
		try {
			json = httpSend(URL+HuanXinUtil.ORGNAME+"/"+HuanXinUtil.APPNAME+"/users/"+user+"/status", "GET", null, token);
		} catch (IOException e) {
			log.error("判断用户是否在线失败！");
			return false;
		}
		
		Map<String, Object> map = JsonToMap.toMap(json);
		Map<String, Object> map2 = (Map)map.get("data");
		String on = String.valueOf(map2.get(user));
		if("\"online\"".equals(on)){
			return true;
		}
		return false;
	}
	
	/**
	 * 获取用户离线消息数
	 * @return
	 * @throws IOException 
	 */
	public static int getOfflineNumber(String user, String token){
		//log.info("token:"+token);
		//log.info(URL+HuanXinUtil.ORGNAME+"/"+HuanXinUtil.APPNAME+"/users/"+user+"/contacts/users/"+doc+"");
		String json = null;
		try {
			json = httpSend(URL+HuanXinUtil.ORGNAME+"/"+HuanXinUtil.APPNAME+"/users/"+user+"/offline_msg_count", "GET", null, token);
		} catch (IOException e) {
			log.error("获取用户离线消息数失败！");
			return -1;
		}
		
		Map<String, Object> map = JsonToMap.toMap(json);
		Map<String, Object> map2 = (Map)map.get("data");
		String number = String.valueOf(map2.get(user));
		return Integer.valueOf(number);
	}
	
	/**
	 * 发送透传文本消息给用户
	 * @return
	 * @throws UnsupportedEncodingException 
	 * @throws IOException
	 */
	public static String sendMessage(String [] users,String token) throws UnsupportedEncodingException{
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("target_type", "users");// users 给用户发消息。chatgroups: 给群发消息，chatrooms: 给聊天室发消息
		map.put("target", users);// 注意这里需要用数组，数组长度建议不大于20，即使只有一个用户，
								 // 也要用数组 ['u1']，给用户发送时数组元素是用户名，给群组发送时  
								 // 数组元素是groupid
		Map<String,String> msg = new HashMap<String, String>();
		msg.put("type", "txt");// 消息类型
		msg.put("msg", "hello from rest");// 消息内容
		
		map.put("msg", msg);// 消息内容，参考[[start:100serverintegration:30chatlog|聊天记录]]里的bodies内容
		
		Map<String,String> ext = new HashMap<String, String>();
		ext.put("docid", "625");
		ext.put("desc", "123123");
		ext.put("userName", new String("黄志伟".getBytes("UTF-8")));
		ext.put("cid", "748");
		ext.put("msg", new String("我是来给你看病的".getBytes("UTF-8")));
		map.put("ext", ext);//扩展消息 type类型可以自定义
		
		Gson gson = new Gson();
		String g = gson.toJson(map);
		//g = "{\"target\":[\"y10429\"],\"msg\":{\"action\":\"1\",\"type\":\"cmd\"},\"target_type\":\"users\",\"ext\":{\"docid\":\"625\",\"desc\":\"去KKKKKK\",\"userName\":\"黄志伟\",\"cid\":\"748\",\"msg\":\"电话问诊:您有一个新订单~请快抢单。\"}}";
		String json = null;
		//System.out.println(g);
		try {
			json = httpSend(URL+HuanXinUtil.ORGNAME+"/"+HuanXinUtil.APPNAME+"/messages", "POST", g, token);
			log.info("发送消息给用户成功！");
		} catch (IOException e) {
			e.printStackTrace();
			json = null;
			log.error("发送消息给用户失败！");
		}
		
		return json;
	}
	
	/**
	 * 患者发送文本消息给医生
	 */
	public static String userSendDoc(int doc, int user, String msg, String token) {
		String [] d = {"y"+doc};
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("target_type", "users");// users 给用户发消息。chatgroups: 给群发消息，chatrooms: 给聊天室发消息
		map.put("target", d);// 注意这里需要用数组，数组长度建议不大于20，即使只有一个用户，
		// 也要用数组 ['u1']，给用户发送时数组元素是用户名，给群组发送时  
		// 数组元素是groupid
		Map<String,String> message = new HashMap<String, String>();
		message.put("type", "txt");// 消息类型
		message.put("msg", msg);// 消息内容
		
		map.put("msg", message);// 消息内容，参考[[start:100serverintegration:30chatlog|聊天记录]]里的bodies内容
		
		map.put("from", "h"+user);
		
		Gson gson = new Gson();
		String g = gson.toJson(map);
		log.info("++++"+g);
		String json = null;
		try {
			json = httpSend(URL+HuanXinUtil.ORGNAME+"/"+HuanXinUtil.APPNAME+"/messages", "POST", g, token);
			log.info("发送消息给用户成功！");
		} catch (IOException e) {
			e.printStackTrace();
			json = null;
			log.error("发送消息给用户失败！");
		}
		
		return json;
	}
	
	/**
	 * 获取用户好友列表
	 * @param user
	 * @param doc
	 * @return
	 * @throws IOException 
	 */
	public static String[] findUsers(String user, String token){
		log.info("token:"+token);
		log.info(URL+HuanXinUtil.ORGNAME+"/"+HuanXinUtil.APPNAME+"/users/"+user+"/contacts/users");
		String json = null;
		try {
			json = httpSend(URL+HuanXinUtil.ORGNAME+"/"+HuanXinUtil.APPNAME+"/users/"+user+"/contacts/users", "GET", null, token);
			Gson g = new Gson();
			Map<String, Object> map = g.fromJson(json, new TypeToken<Map<String, Object>>(){}.getType());
			String[] data = g.fromJson(String.valueOf(map.get("data")), new TypeToken<String[]>(){}.getType());
			return data;
		} catch (IOException e) {
			e.printStackTrace();
			log.error("获取用户好友列表失败！");
		}
		return null;
	}
	
	public static String httpSend(String url, String method, String param , String token) throws IOException {
        // Post请求的url，与get不同的是不需要带参数
        URL postUrl = new URL(url);
        // 打开连接
        HttpURLConnection connection = (HttpURLConnection) postUrl
                .openConnection();
        // 设置是否向connection输出，因为这个是post请求，参数要放在
        // http正文内，因此需要设为true
        connection.setDoOutput(true);
        // Read from the connection. Default is true.
        connection.setDoInput(true);
        // Set the post method. Default is GET
        connection.setRequestMethod(method);
        // Post cannot use caches
        // Post 请求不能使用缓存
        connection.setUseCaches(false);
        // This method takes effects to
        // every instances of this class.
        // URLConnection.setFollowRedirects是static函数，作用于所有的URLConnection对象。
        // connection.setFollowRedirects(true);

        // This methods only
        // takes effacts to this
        // instance.
        // URLConnection.setInstanceFollowRedirects是成员函数，仅作用于当前函数
        connection.setInstanceFollowRedirects(true);
        // Set the content type to urlencoded,
        // because we will write
        // some URL-encoded content to the
        // connection. Settings above must be set before connect!
        // 配置本次连接的Content-type，配置为application/x-www-form-urlencoded的
        // 意思是正文是urlencoded编码过的form参数，下面我们可以看到我们对正文内容使用URLEncoder.encode
        // 进行编码
        connection.setRequestProperty("Content-Type", "application/json");
        if(token != null){
        	connection.setRequestProperty("Authorization", "Bearer "+token);
        	//log.info("Bearer "+token);
        }
        connection.setRequestProperty("Charset", "utf-8");
        // 连接，从postUrl.openConnection()至此的配置必须要在connect之前完成，
        // 要注意的是connection.getOutputStream会隐含的进行connect。
        connection.connect();
        // The URL-encoded contend
        // 正文，正文内容其实跟get的URL中'?'后的参数字符串一致
        // 得到请求的输出流对象
        String content = "";
        if(param !=null){
        	content = param;
	        OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());  
	        // 把数据写入请求的Body  
	        out.write(content);  
	        out.flush();
	        out.close(); // flush and close
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                connection.getInputStream(),"utf-8"));
        String line;
        log.info("Contents of post request");
        String msg = "";
        while ((line = reader.readLine()) != null) {
        	msg += line;
        	log.info(line);
        }
        log.info("Contents of post request ends");
        reader.close();
        connection.disconnect();
        return msg;
    }
	
	public static void main(String[] args) throws IOException, NumberFormatException, ParseException {
//		getToken();
		String[] dat = findUsers("j2", "YWMtKVuNiIPGEeefReupXiRhFAAAAAAAAAAAAAAAAAAAAAGqgJ7QfKoR56e0n4dZRnvdAgMAAAFd82gwLwBPGgAALNX_GGb-RRwPq841i8bbCjkmrzT4xSXXra4P7mBzJg");
		for (String s : dat) {
			System.out.println(s);
		}
	}
}

