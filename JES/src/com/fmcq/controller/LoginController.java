package com.fmcq.controller;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fmcq.service.ILoginService;
import com.google.gson.Gson;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {
	private static Log log = LogFactory.getLog(LoginController.class);
	
	@Resource
	private ILoginService loginService;
	
	
	/**
	 * 登录
	 * @param json
	 * @throws IOException
	 */
	@RequestMapping("/login.do")
	@ResponseBody
	public void login(String account, String pass) throws IOException{
		log.info("登录 start");
		Map<String, Object> map = loginService.login(account, pass);
		Gson g = new Gson();
		String rJson = g.toJson(map);
		log.info("登录 end");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(rJson);
		response.getWriter().flush();
		response.getWriter().close();
	}
	
	/**
	 * 获取验证码
	 *
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/findYzm.do")
	@ResponseBody
	public void findYzm(String tel) throws Exception {
		log.info("获取验证码 start");
		String json = this.loginService.upYzm(tel);
		log.info("获取验证码 end");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(json);
		response.getWriter().flush();
		response.getWriter().close();
	}
}
