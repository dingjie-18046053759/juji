package com.fmcq.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 环信接口类
 * @time 下午2:22:31
 * @author huangzhiwei
 * @category
 */
public interface IHuanXinService {

	/**
	 * 获取token 是否有效,无效重新获取
	 * @return
	 * @throws Exception
	 */
	String findHxToken() throws Exception;

	/**
	 * 添加环信用户
	 * @param user
	 * @return
	 * @throws Exception
	 */
	String addUser(String user) throws Exception;

	/**
	 * 判断用户是否为环信IM用户
	 * @param user
	 * @return
	 * @throws Exception
	 */
	boolean ifExistSystem(String user) throws Exception;

	/**
	 * 用户添加好友
	 * @param user1
	 * @param user2
	 * @return
	 * @throws Exception 
	 * @throws IOException 
	 */
	String userAddDoc(String user1, String user2) throws Exception;

	/**
	 * 用户解除好友
	 * @param user1
	 * @param user2
	 * @return
	 * @throws Exception 
	 * @throws IOException 
	 */
	String userDelDoc(String user1, String user2) throws Exception;
	
	/**
	 * 删除环信用户
	 * @param user
	 * @return
	 * @throws Exception 
	 * @throws IOException 
	 */
	String delUser(String user) throws Exception;

	/**
	 * 判断是否存在好友,存在返回true,不存在返回false
	 * @return
	 * @throws Exception 
	 * @throws IOException 
	 */
	boolean ifExistFriend(String user, String doc) throws Exception;
	
	/**
	 * 发送透传文本消息给用户
	 * @param users
	 * @return
	 * @throws Exception 
	 */
	String sendMessage(String[] users) throws Exception;

	/**
	 * 患者发送文本消息给医生
	 * @param map
	 * @return
	 * @throws Exception 
	 */
	String userSendDoc(Map<String, String> map) throws Exception;

	/**
	 * 判断用户是否在线
	 * @param user
	 * @return
	 * @throws Exception
	 */
	boolean ifExistOnline(String user) throws Exception;
	
	/**
	 * 获取用户离线消息数
	 * @param user
	 * @return
	 * @throws Exception
	 */
	int getOfflineNumber(String user) throws Exception;
	
	/**
     * 批量检测是否有医生web在线
     */
    public List<Object[]> findIMOnline() throws Exception;

    /**
     * 获取用户好友列表
     * @param user 环信ID
     * @return
     * @throws Exception
     */
    public String findUsers(String user) throws Exception;
}
