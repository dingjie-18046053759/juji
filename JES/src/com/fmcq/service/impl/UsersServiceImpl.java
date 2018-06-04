package com.fmcq.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.fmcq.controller.UsersController;
import com.fmcq.entity.Client;
import com.fmcq.entity.Control;
import com.fmcq.entity.Users;
import com.fmcq.service.IUsersService;
import com.fmcq.util.Comm;
import com.fmcq.util.HibernateUtil;
import com.fmcq.util.HttpRequestUtil;
import com.fmcq.util.HuanXinUtil;
import com.google.gson.Gson;

@Service
public class UsersServiceImpl implements IUsersService {
	private static Log log = LogFactory.getLog(UsersController.class);

	@Resource
	private HibernateUtil util;
	
	/**
	 * 根据环信ID获取用户信息
	 * @param hxid
	 * @return
	 */
	@Override
	public String findUserInfoByHxid(String hxid){
		log.info("findUserInfoByHxid start");
		
		hxid = hxid.replace(HuanXinUtil.HXQZ, "");
		
		Users users = this.util.get(Users.class, Integer.valueOf(hxid));
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", users.getUsernumber());
		String url = "";
		if(users.getHeadportrait() != null && !"".equals(users.getHeadportrait())){
			url = Comm.THIS_URL+users.getHeadportrait();
		}
		map.put("headportrait", url);
		
		Gson g = new Gson();
		String json = g.toJson(map);
		log.info(json);
		log.info("findUserInfoByHxid end");
		return json;
	}
	
	/**
	 * 获取用户信息
	 * @param uid
	 * @return
	 */
	@Override
	public Users findUser(String uid){
		log.info("findUser start");
		Users users = this.util.get(Users.class, Integer.valueOf(uid));
		log.info("findUser end");
		return users;
	}
	
	/**
	 * 根据电话号码获取用户
	 * @param tel
	 * @return
	 */
	@Override
	public Users findUsersByPhone(String tel){
		log.info("findUsersByPhone start");
		String hql = "from Users where phone = '"+tel+"'";
		List<Users> list = this.util.queryHQL(hql, false);
		Users users = null;
		if(list != null && list.size() > 0){
			users = list.get(0);
		}
		log.info("findUsersByPhone end");
		return users;
	}

	
	@Override
	public String updateUsers(Users user) {
		this.util.update(user);
		return null;
	}

	/**
	 * 根据设备Sn获取用户Id
	 * @param tel
	 * @return
	 */	
	@Override
	public String findUserIdBySn(String sn,String reason) {
		//根据sn先获取到设备Id
		log.info("findCmdList start");
		String rr = null;
		String hql = "from Client where sn='"+sn+"' order by id desc";
		List<Client> list = this.util.queryHQL(hql, false);
		List<String> rList = new ArrayList<String>();
		if(list != null && list.size() > 0){
			Client client = list.get(0);
			int clientId = client.getId();
			//查询哪些users.clients底下有这个设备Id
			String hql2 = "from Users where clients like '%,"+clientId+"' or clients like '%,"+clientId+",%' or clients like '"+clientId+",%' order by id asc";
			System.out.println("hql2=="+hql2);
			List<Users> userlist = this.util.queryHQL(hql2, false);
			if(userlist != null || !"".equals(userlist)){	
				String rcmds = null;
				for (Users users : userlist) {
					rcmds = null;
					rcmds = users.getAccount();					
					rList.add(rcmds);
				}
				//调用短信推送预警报接口
				try {
					rr = this.tuisongJb(rList,client,reason);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		log.info("findCmdList end");
		return rr;
	}

	/**
	 * 向用户推送设备警报信息
	 * @param rList
	 * @return 
	 * @return
	 * @throws NoSuchAlgorithmException 
	 * @throws IOException 
	 */	
	private String tuisongJb(List<String> rList, Client client, String reason)
			throws NoSuchAlgorithmException, IOException {
		String phonelist=StringUtils.join(rList, ",");
		Map<String, Object> map = new HashMap<String, Object>();
		String postUrl = "http://www.api.zthysms.com/sendSmsBatch.do";
		String username = "juji666hy";
		String message = "【炬集物联】-设备" + client.getName() + "编号为"+client.getSn()+"故障原因："+reason+"故障预警报。请就近工程师进行维修！";
		// 获取当前时间
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");// 设置日期格式
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

//		String sendUrl = postUrl + "?username=" + username + "&tkey="
//				+ df.format(new Date()) + "&password=" + res + "&mobile=" + phonelist
//				+ "&content=" + URLEncoder.encode(message, "UTF-8");
//        System.out.println("==========sendUrl========="+sendUrl);
        
        Map<String, String> mapParam = new HashMap<String, String>();  
        mapParam.put("username", username);  
        mapParam.put("tkey",df.format(new Date()));  
        mapParam.put("password",res);  
        mapParam.put("mobile",phonelist);  
        mapParam.put("content",URLEncoder.encode(message, "UTF-8"));  
        
        String result = HttpRequestUtil.sendPost(postUrl, mapParam);          
		System.out.println("调用短信接口的结果是" + result);
		if(result=="1"||"1".equals(result)){
		    map.put("code", "1");
		    map.put("msg", "推送预警报成功。");
		}else{
			map.put("code", "0");
			map.put("msg", "推送预警报失败。");
		}
		Gson g = new Gson();
		String json = g.toJson(map);
		return json;
	}
}
