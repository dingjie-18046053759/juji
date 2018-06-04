package com.fmcq.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.fmcq.controller.BaseController;

/**
 * @category 注入servlet api组件
 */
@Component
public class ServletApiInterceptor extends HandlerInterceptorAdapter {

	/**
	 * 该方法将在请求处理之前进行调用
	 * 可以在这个方法中进行一些前置初始化操作或者是对当前请求的一个预处理，也可以在这个方法中进行一些判断来决定请求是否要继续进行下去
	 * 当它返回为false 时，表示请求结束，后续的Interceptor 和Controller 都不会再执行
	 * 当返回值为true 时就会继续调用下一个Interceptor 的preHandle 方法，
	 * 如果已经是最后一个Interceptor 的时候就会是调用当前请求的Controller 方法。
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		HandlerMethod method=(HandlerMethod)handler;
		
		BaseController base=(BaseController)method.getBean();
		//System.out.println("进入拦截器");
		if(base!=null){
			base.setRequest(request);
			base.setResponse(response);
			base.setSession(request.getSession());
			//System.out.println("注入成功");
		}
		return super.preHandle(request, response, handler);
	}
	
}
