package com.fmcq.service;

import java.util.List;
import java.util.Map;

import com.fmcq.entity.Client;
import com.fmcq.entity.DtuInfo;

public interface IClientService {
	/**
	 * 获取设备集合
	 * @return
	 */
	public List<Object[]> findClientList(String uid);
	
	/**
	 * 获取设备信息
	 * @param id
	 * @return
	 */
	public Client findClient(Integer id);

	/**
	 * 获取设备参数
	 * @param id
	 * @return
	 */
	public Map<String, Object> findClientInfo(DtuInfo dtu,String id);

	/**
	 * 发送指令
	 * @param uid
	 * @param sn
	 * @param cmd
	 * @return
	 */
	public String upMission(String uid, String sn, String cmd);
	
	/**
	 * 获取指令状态
	 * @param mid
	 * @return
	 */
	public String findMission(String mid);
	
	/**
	 * 修改指令状态
	 * @param mid
	 * @return
	 */
	public void upMissionState(String mid);

	/**
	 * 获取设备权限
	 * @param controllermodel
	 * @return
	 */
	public List<String[]> findCmdList(String controllermodel);

	/**
	 * 获取Dtu详情
	 * @param controllermodel
	 * @return
	 */
	public DtuInfo findDtu(String sn);

	/**
	 * 获取Dtu列表
	 * @param controllermodel
	 * @return
	 */
	public List<DtuInfo> getDtuInfo();
	/**
	 * 根据Sn获取Client
	 * @param controllermodel
	 * @return
	 */
	public Client findClientBysn(String sn);

	/**
	 * 获取Client列表
	 * @param controllermodel
	 * @return
	 */
	public List<Client> findClientList();
	
	/**
	 * 更新Client
	 * @param controllermodel
	 * @return
	 */
	public void updateClient(Client client);
	/**
	 * 保存Client
	 * @param controllermodel
	 * @return
	 */
	public void addClient(Client client);

}
