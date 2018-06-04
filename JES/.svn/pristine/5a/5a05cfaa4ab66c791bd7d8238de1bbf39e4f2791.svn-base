package com.fmcq.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fmcq.service.IHuanXinService;
import com.fmcq.util.HuanXinUtil;
import com.fmcq.util.RequestToMap;
import com.google.gson.Gson;

@Controller
@RequestMapping("/hx")
public class HuanXinController extends BaseController{
	
	private static Log log = LogFactory.getLog(HuanXinController.class);
	
	@Resource
	private IHuanXinService huanXinService;
	
	/**
	 * 发送透传文本消息给用户
	 * @param json
	 * @throws Exception 
	 */
	@RequestMapping("/send.do")
	@ResponseBody
	public void findUserInfo(String json) throws Exception{
		log.info("发送透传文本消息给用户 start");
		
		String [] doc = {"10482"};
		String rJson = huanXinService.sendMessage(doc);
		
		log.info("发送透传文本消息给用户 end");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(rJson);
		response.getWriter().flush();
		response.getWriter().close();
	}
	
	/**
	 * 患者发送文本消息给医生
	 * @param json
	 * @throws Exception 
	 */
	@RequestMapping("/userSendDoc.do")
	@ResponseBody
	public void userSendDoc(String json) throws Exception{
		log.info("发送文本消息给用户 start");
		
		Map<String,String> map = RequestToMap.getMap(request);
		String rJson = huanXinService.userSendDoc(map);
		
		log.info("发送文本消息给用户 end");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(rJson);
		response.getWriter().flush();
		response.getWriter().close();
	}
	
	/**
	 * 获取IM医生在线集合
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/findIMOnline.do")
	@ResponseBody
	public void findIMOnline() throws Exception{
		log.info("获取IM医生在线集合 start");
		
		List<Object[]> rList = huanXinService.findIMOnline();
		Gson g = new Gson();
		String rJson = g.toJson(rList);
		log.info("获取IM医生在线集合 end");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(rJson);
		response.getWriter().flush();
		response.getWriter().close();
	}
	
	/**
	 * 添加好友
	 * @param json
	 * @throws Exception 
	 */
	@RequestMapping("/userSenduser.do")
	@ResponseBody
	public void userSenduser(String user1, String user2) throws Exception{
		log.info("添加好友 start");
		user1 = HuanXinUtil.HXQZ+user1;
		user2 = HuanXinUtil.HXQZ+user2;
		String rcode = "";
		String msg = huanXinService.userAddDoc(user1, user2);
		if(msg == null || "".equals(msg)){
			log.error("环信用户添加好友失败");
			rcode = "error";
		}else{
			log.info(msg);
			log.info("环信用户添加好友成功");
			rcode = "ok";
		}
		log.info("添加好友 end");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(rcode);
		response.getWriter().flush();
		response.getWriter().close();
	}
	
	/**
	 * 删除好友
	 * @param json
	 * @throws Exception 
	 */
	@RequestMapping("/userDeluser.do")
	@ResponseBody
	public void userDeluser(String user1, String user2) throws Exception{
		log.info("删除好友 start");
		user1 = HuanXinUtil.HXQZ+user1;
		user2 = HuanXinUtil.HXQZ+user2;
		String rcode = "";
		String msg = huanXinService.userDelDoc(user1, user2);
		if(msg == null || "".equals(msg)){
			log.error("环信用户删除好友失败");
			rcode = "error";
		}else{
			log.info(msg);
			log.info("环信用户删除好友成功");
			rcode = "ok";
		}
		log.info("删除好友 end");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(rcode);
		response.getWriter().flush();
		response.getWriter().close();
	}
	
	/**
	 * 创建环信用户
	 * @param json
	 * @throws Exception 
	 */
	@RequestMapping("/addHxUser.do")
	@ResponseBody
	public void addHxUser(String user) throws Exception{
		log.info("创建环信用户 start");
		String rcode = "";
		user = HuanXinUtil.HXQZ+user;
		if(huanXinService.ifExistSystem(user)){ //环信用户已存在
			log.info("环信用户已存在,无需再注册！");
			rcode = "ok";
		}else{
			String response = huanXinService.addUser(user);
			if(response == null || "".equals(response)){
				log.error("环信患者用户注册失败");
				rcode = "error";
			}else{
				log.info(response);
				log.info("环信患者用户注册成功");
				rcode = "ok";
			}
		}
		log.info("创建环信用户 end");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(rcode);
		response.getWriter().flush();
		response.getWriter().close();
	}
	
	/**
	 * 删除环信用户
	 * @param json
	 * @throws Exception 
	 */
	@RequestMapping("/delUser.do")
	@ResponseBody
	public void delUser(String user) throws Exception{
		log.info("删除环信用户 start");
		user = HuanXinUtil.HXQZ+user;
		String rcode = "";
		String msg = huanXinService.delUser(user);
		if(msg == null || "".equals(msg)){
			log.error("删除环信用户失败");
			rcode = "error";
		}else{
			log.info(msg);
			log.info("删除环信用户成功");
			rcode = "ok";
		}
		log.info("删除环信用户 end");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(rcode);
		response.getWriter().flush();
		response.getWriter().close();
	}
	
	
	/**
	 * 获取用户好友列表
	 * @param user 环信ID
	 * @throws Exception 
	 */
	@RequestMapping("/findUsers.do")
	@ResponseBody
	public void findUsers(String user) throws Exception{
		log.info("获取用户好友列表 start");
		
		String rJson = huanXinService.findUsers(user);
		
		log.info("获取用户好友列表 end");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(rJson);
		response.getWriter().flush();
		response.getWriter().close();
	}
}
