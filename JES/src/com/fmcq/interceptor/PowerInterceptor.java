package com.fmcq.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @category 权限验证拦截器，控制权限
 */
public class PowerInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//		String absolutePath = request.getRequestURI();
//		if (StringUtil.isNotEmpty(absolutePath) && absolutePath.indexOf("/flow/interface/") != -1) {
//			String ip = Share.getIpAddr(request);
//			System.out.println("请求IP的值是:" + ip + "路径：" + absolutePath);
//			return true;
//		}
		
		if (request.getRequestURI().indexOf("userActivity") != -1){
//			HttpSession session = request.getSession();
//			MfUser admin = null;
//			
//			if (session.getAttribute(Comm.USER_SESSION_NAME) != null){
//				admin = (MfUser) session.getAttribute(Comm.USER_SESSION_NAME);
//			}
//			
//			if (admin == null) {
//				request.setAttribute("msg", "登录已过期或未登录，请先登录！");
//				request.getRequestDispatcher("/mobile/login.jsp").forward(request, response);
				return false;
//			} else {
//				return true;
//			}
		} else {
			return true;
		}

	}

}
