package com.fmcq.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fmcq.entity.Users;
import com.fmcq.service.IUsersService;
import com.google.gson.Gson;

@Controller
@RequestMapping("/users")
public class UsersController extends BaseController {
	private static Log log = LogFactory.getLog(UsersController.class);

	@Resource
	private IUsersService usersService;
	 
	/**
	 * 跳转设置
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/toUsers.do")
	public String toUsers(String uid){
		log.info("跳转设置 start");
		Users users = this.usersService.findUser(uid);
		request.setAttribute("users", users);
		log.info("跳转设置 end");
		return "/jsp/users";
	}
	
	/**
	 * 根据环信ID获取用户信息
	 * @param json
	 * @throws Exception 
	 */
	@RequestMapping("/findUserInfoByHxid.do")
	@ResponseBody
	public void findUserInfoByHxid(String hxid) throws Exception{
		log.info("根据环信ID获取用户信息 start");
		
		String rJson = usersService.findUserInfoByHxid(hxid);
		
		log.info("根据环信ID获取用户信息 end");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(rJson);
		response.getWriter().flush();
		response.getWriter().close();
	}
	
	/**
	 * 根据设备Sn获取用户Id
	 * @param json
	 * @throws Exception 
	 */
	@RequestMapping("/postBySn.do")
	@ResponseBody
	public void postBySn(String sn,String reason) throws Exception{
		log.info("根据设备Sn获取用户Id start");
		if(reason==null||"".equals(reason)){
			reason = "需现场查看";
		}
		//发送短信
		String rJson = usersService.findUserIdBySn(sn,reason);	
		System.out.println("结果为"+rJson);
		log.info("根据设备Sn获取用户Id end");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(rJson);
		response.getWriter().flush();
		response.getWriter().close();
	}
	
	/**
	 * 上传经纬度地址
	 * @param json
	 * @throws Exception 
	 */
	@RequestMapping("/upAddress.do")
	@ResponseBody
	public void upAddress(String uid, String latitude, String longitude) throws Exception{
		log.info("上传经纬度地址 start");
		log.info("uid="+uid);
		log.info("latitude="+latitude);
		log.info("longitude="+longitude);
		Map<String, Object> rm = new HashMap<String, Object>();
		rm.put("code", "0");
		rm.put("msg", "上传成功");
		Gson g = new Gson();
		String rJson = g.toJson(rm);
		log.info("上传经纬度地址 end");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(rJson);
		response.getWriter().flush();
		response.getWriter().close();
	}
}
