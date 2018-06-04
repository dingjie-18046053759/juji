package com.fmcq.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.net.ssl.HttpsURLConnection;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import sun.net.www.protocol.http.HttpURLConnection;

import com.fmcq.controller.LoginController;
import com.fmcq.entity.Users;
import com.fmcq.service.ILoginService;
import com.fmcq.service.IUsersService;
import com.fmcq.util.HibernateUtil;
import com.google.gson.Gson;

@Service
public class LoginServiceImpl implements ILoginService {
	private static Log log = LogFactory.getLog(LoginController.class);
	
	@Resource
	private HibernateUtil util;
	@Resource
	private IUsersService usersService;
	
	/**
	 * 登录
	 */
	@Override
	public Map<String, Object> login(String account, String pass){
		log.info("login start");
		String sql = "select id,name from users where account = '"+account+"' and pass = '"+pass+"'";
		Object[] obj = this.util.queryBySQL(sql);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(obj != null && obj[0] != null && !"".equals(String.valueOf(obj[0]))){
			Users users = this.util.get(Users.class, Integer.valueOf(String.valueOf(obj[0])));
			map.put("code", "0");
			map.put("msg", "登录成功！");
			map.put("users", users);
		}else{
			map.put("code", "1");
			map.put("msg", "验证码错误！");
		}
		return map;
	}
	
	/**
	 * 获取验证码
	 * @param tel
	 * @return
	 * @throws Exception
	 */
	@Override
	public String upYzm(String tel) throws Exception{
		log.info("findYzm start");
		log.info("电话" + tel);
		Users users = this.usersService.findUsersByPhone(tel);
		Map<String, Object> map = new HashMap<String, Object>();
		if(users == null){
			map.put("code", "1");
			map.put("msg", "手机号码不存在。");
		}else{
			int number = (int) (Math.random() * 9000 + 1000);
			log.info(tel + "的验证码：" + number);
			users.setPass(String.valueOf(number));
			this.util.update(users);

			log.info("网关一发送完毕");
			String postUrl = "http://www.api.zthysms.com/sendSms.do";
			String username = "juji666hy";
			String message = "【炬集物联】-您的验证码是"+number+"。如非本人操作，请忽略本短信";
			//获取当前时间
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
			System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
			//Md5加密
			String res = "";  
			String str = "c7010d789db7e693ccbfffe35ff3b230"+df.format(new Date());  
			  
			MessageDigest md5 = MessageDigest.getInstance("MD5");  
			md5.update((str).getBytes("UTF-8"));  
			byte b[] = md5.digest();  
			  
			int i;  
			StringBuffer buf = new StringBuffer("");  
			  
			for(int offset=0; offset<b.length; offset++){  
			    i = b[offset];  
			    if(i<0){  
			        i+=256;  
			    }  
			    if(i<16){  
			        buf.append("0");  
			    }  
			    buf.append(Integer.toHexString(i));  
			}  
			  
			res = buf.toString();  
			System.out.println("res = " + res);  
			
			String sendUrl = postUrl + "?username=" + username
					+ "&tkey=" + df.format(new Date())
					+ "&password=" + res + "&mobile=" + tel
					+ "&content=" + URLEncoder.encode(message, "UTF-8");
			
			StringBuffer sb = new StringBuffer();
			URL url = new URL(sendUrl);
			URLConnection conn = url.openConnection();
			conn.setReadTimeout(15000);
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			for (String line = null; (line = reader.readLine()) != null;) {
				sb.append(line);
			}
			reader.close();
			String result = URLDecoder.decode(sb.toString(), "UTF-8");
			System.out.println("调用短信接口的结果是" + result);
			
			map.put("code", "0");
			map.put("msg", "获取验证码成功。");
		}
		Gson g = new Gson();
		String json = g.toJson(map);
		log.info("findYzm end");
		return json;
	}
	
}
