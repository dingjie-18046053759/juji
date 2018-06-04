package com.fmcq.service.impl;

import java.text.ParseException;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.fmcq.controller.WeixinController;
import com.fmcq.dao.BaseDao;
import com.fmcq.entity.AccessToken;
import com.fmcq.service.IWeixinService;
import com.fmcq.util.WeixinUtil;
import com.fmcq.util.datautil.DateUtil;
import com.fmcq.util.datautil.DateUtil2;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * 微信相关Service
 * @author super-z
 *
 */
@Service
public class WeixinServiceImpl implements IWeixinService {
	private final static Log log = LogFactory.getLog(WeixinController.class);
	
	@Resource
	private BaseDao<AccessToken> dao;
	
	
	/**
	 * 获取Token
	 * @return
	 * @throws ParseException 
	 */
	@Override
	public String upAccessToken(String json) throws ParseException{
			System.out.println("json="+json+"======================================================================");
			log.info("获取TOKEN start");
			String tokenId = "99999";
			if(json != null && !"".equals(json)){
				JsonObject obj = new JsonParser().parse(json).getAsJsonObject();
				tokenId = obj.get("tokenId").getAsString();
			}
			
			//获取TOKEN对象
			AccessToken at = new AccessToken();
			at = getAccessToken(tokenId);
			String accessToken = "";
			//获取数据库为空 重新获取TOKEN
			if(at == null || "".equals(at.getToken())){
				at = new AccessToken();
				at.setOpenid(tokenId);
				accessToken = upToken(at);
			}else{
				//获取TOKEN
				accessToken = at.getToken();
				//获取到期时间
				String time = at.getTime();
				
				Date now = DateUtil2.getNow(DateUtil2.YYYY_MM_DD_HH_MM_SS);
				Date qjsj = DateUtil2.string2Date(time, DateUtil2.YYYY_MM_DD_HH_MM_SS);
				
				int xcz = Integer.valueOf(String.valueOf(DateUtil2.getTimeDiffSecs(qjsj, now)));
				//如果到期重新获取TOKEN
				if(xcz < 0){
					log.info("TOKEN到期重新获取");
					accessToken = upToken(at);
				}
			}
			log.info("获取TOKEN end");
            return accessToken;
	}
	
	
	
	/**
	 * 更新TOKEN表
	 * @param tokenId
	 * @throws ParseException
	 */
	@Override
	public String upToken(AccessToken at) throws ParseException{
		AccessToken at2 = WeixinUtil.getAccessToken();
		if(at2 != null && !"".equals(at2.getToken())){
			String time = DateUtil.addSecond(DateUtil2.getSysDate(DateUtil2.YYYY_MM_DD_HH_MM_SS), at2.getExpiresIn()-300, DateUtil2.YYYY_MM_DD_HH_MM_SS);
			at.setTime(time);
			at.setToken(at2.getToken());
			at.setExpiresIn(at2.getExpiresIn());
			dao.save(at);
		}
		return at.getToken();
	}
	
	@Override
	public AccessToken getAccessToken(String openid) {
		// TODO Auto-generated method stub
		AccessToken at=null;
		at=dao.get("from AccessToken where openid='"+openid+"'");
		return at;
	}
}
