package com.fmcq.service;

import java.text.ParseException;

import com.fmcq.entity.AccessToken;

public interface IWeixinService {
	String upAccessToken(String json) throws Exception;

	AccessToken getAccessToken(String openid);

	String upToken(AccessToken at) throws ParseException;
}
