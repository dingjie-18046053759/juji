package com.fmcq.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * @author 刘秋荣 qq:46274204
 * 创建时间： 2015年3月17日 上午11:28:39
 * @category 基础Controller类
 */
@Controller
public class BaseController {
	
	@InitBinder //如果当前页面绑定的数据中有日期类型的，并且会出400错误的时候，可以加上这个方法
	protected void initBinder(HttpServletRequest request,
	   ServletRequestDataBinder binder) throws Exception {
	   binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
	}
	
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected HttpSession session;
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public HttpServletResponse getResponse() {
		return response;
	}
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	public HttpSession getSession() {
		return session;
	}
	public void setSession(HttpSession session) {
		this.session = session;
	}
}
