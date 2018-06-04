
package com.fmcq.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fmcq.entity.Users;
import com.fmcq.service.IUsersService;
import com.fmcq.util.MapUtil;

@Controller
@RequestMapping("/home")
public class HomeController extends BaseController {
	private static Log log = LogFactory.getLog(HomeController.class);

	@Resource
	private IUsersService usersService;
	
	/**
	 * 跳转首页
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/toHome.do")
	public String toHome(String uid){
		log.info("跳转首页 start");
		
		Users users = this.usersService.findUser(uid);
		request.setAttribute("users", users);
		log.info("跳转首页 end");
		return "/jsp/home";
	}
	
	
	/**
	 * 修改首页当前地址
	 * @return
	 * @throws UnsupportedEncodingException 
	 * @throws Exception 
	 */
	@RequestMapping("/changeAdress.do")
	public String changeAdress(String uid,String city) throws UnsupportedEncodingException{
		System.out.println("修改地址 start");
		log.info("修改地址 start");
		
		city = new String(city.getBytes("ISO-8859-1"),"UTF-8");
		Users users = this.usersService.findUser(uid);
		//重新设置所在城市
		users.setCity(city);		
		request.setAttribute("users", users);
		//保存用户信息
		this.usersService.updateUsers(users);
		log.info("修改地址 end");
		return "/jsp/home";
	}
	
	/**
	 * 上传App状态
	 * @param json
	 * @throws IOException
	 */
	@RequestMapping("/upAppState.do")
	@ResponseBody
	public void upAppState(String uid) throws IOException{
		log.info("上传App状态 start");
		log.info("uid="+uid);
		String rJson = MapUtil.outMap("上传App状态成功");
		
		log.info("上传App状态 end");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(rJson);
		response.getWriter().flush();
		response.getWriter().close();
	}
}
