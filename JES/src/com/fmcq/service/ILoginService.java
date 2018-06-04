package com.fmcq.service;

import java.net.MalformedURLException;
import java.util.Map;

public interface ILoginService {
	/**
	 * 登录
	 */
	public Map<String, Object> login(String account, String pass);

	/**
	 * 获取验证码
	 * @param tel
	 * @return
	 * @throws MalformedURLException
	 */
	public String upYzm(String tel) throws Exception;
}
