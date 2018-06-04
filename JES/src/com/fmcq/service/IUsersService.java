package com.fmcq.service;

import java.util.List;

import com.fmcq.entity.Users;

public interface IUsersService {
	/**
	 * 根据环信ID获取用户信息
	 * @param hxid
	 * @return
	 */
	public String findUserInfoByHxid(String hxid);
	
	/**
	 * 获取用户信息
	 * @param uid
	 * @return
	 */
	public Users findUser(String uid);

	/**
	 * 根据电话号码获取用户
	 * @param tel
	 * @return
	 */
	public Users findUsersByPhone(String tel);
	/**
	 * 保存用户信息
	 * @param User
	 * @return
	 */
	public String updateUsers(Users user);
	
	/**
	 * 根据设备Sn获取用户Id
	 * @param User
	 * @return
	 */	
	public String findUserIdBySn(String sn,String reason);
}
