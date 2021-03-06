package com.fmcq.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.fmcq.controller.ClientController;
import com.fmcq.entity.Client;
import com.fmcq.entity.Control;
import com.fmcq.entity.DtuInfo;
import com.fmcq.entity.Mission;
import com.fmcq.entity.Users;
import com.fmcq.service.IClientService;
import com.fmcq.util.HibernateUtil;
import com.fmcq.util.MapUtil;
import com.fmcq.util.datautil.DateUtil2;
import com.google.gson.Gson;

/**
 * 设备
 * @author super-z
 *
 */
@Service
public class ClientServiceImpl implements IClientService {
	private static Log log = LogFactory.getLog(ClientController.class);
	
	@Resource
	private HibernateUtil util;
	
	/**
	 * 获取设备集合
	 * @return
	 */
	@Override
	public List<Object[]> findClientList(String uid){
		log.info("findClientList start");
		if(uid == null || "".equals(uid))
			return null;
		//获取用户
		Users us = this.util.get(Users.class, Integer.valueOf(uid));
		List<Object[]> list = null;
		if(us != null && us.getId() != null && us.getClients() != null && !"".equals(us.getClients())){
			String sql = "select t.* from("+
					" select id,name,area,2 px,state from client where id in ("+us.getClients()+")"+
					" union all "+
					" select '','',area,1 px,'' from client where id in ("+us.getClients()+") group by area"+
					" )t"+
					" order by 3,4";	
			list = this.util.queryBySQL(sql, false);
		}
		log.info("findClientList end");
		return list;
	}
	
	/**
	 * 获取设备信息
	 * @param id
	 * @return
	 */
	@Override
	public Client findClient(Integer id){
		System.out.println("======传入得ID为======="+id);
		log.info("findClient start");
		Client client = this.util.get(Client.class, id);
		log.info("findClient end");
		return client;
	}
	
	/**
	 * 获取Dtu信息
	 * @param id
	 * @return
	 */
	@Override
	public DtuInfo findDtu(String id){
		log.info("findDtu start");
		DtuInfo  dd = null;
		String hql = "from DtuInfo where sn='"+id+"' order by id desc";
		List<DtuInfo> list = this.util.queryHQL(hql, false);
		if(list!=null&&list.size()>0){
			 dd = list.get(0);
		}
		log.info("findDtu end");
		return dd;
	}
	
	/**
	 * 获取设备权限
	 * @param controllermodel
	 * @return
	 */
	@Override
	public List<String[]> findCmdList(String controllermodel){
		log.info("findCmdList start");
		String hql = "from Control where controllermodel='"+controllermodel+"' order by id desc";
		List<Control> list = this.util.queryHQL(hql, false);
		List<String[]> rList = new ArrayList<String[]>();
		if(list != null && list.size() > 0){
			Control control = list.get(0);
			String cmdlist = control.getCmdlist();
			if(cmdlist != null || !"".equals(cmdlist)){
				String[] cmds = cmdlist.split(";");
				String[] rcmds = null;
				for (String cmd : cmds) {
					rcmds = null;
					rcmds = cmd.split(":");
					rList.add(rcmds);
				}
			}
		}
		log.info("findCmdList end");
		return rList;
	}
	
//	/**
//	 * 获取设备参数
//	 * @param id
//	 * @return
//	 */
//	@Override
//	public Map<String, Object> findClientInfo(String id){
//		log.info("findClientInfo start");
//		Client client = this.util.get(Client.class, Integer.valueOf(id));
//		
//		String data = client.getData();
//		
//		data = data.substring(data.indexOf("<d>")+3, data.indexOf("</d>"));
//		
//		String[] datas = data.split("&");
//		
//		String[] ds = null;
//		String led = "";
//		List<String[]> list = new ArrayList<String[]>();
//		
//		String zt = "";
//		if("1".equals(String.valueOf(client.getState())))
//			zt = "正常";
//		else if("2".equals(String.valueOf(client.getState())))
//			zt = "超时";
//		else if("3".equals(String.valueOf(client.getState())))
//			zt = "离线";
//		else if("4".equals(String.valueOf(client.getState())))
//			zt = "故障";
//		else if("5".equals(String.valueOf(client.getState())))
//			zt = "无效";
//		ds = new String[2];
//		ds[0] = "连接状态";
//		ds[1] = zt;
//		list.add(ds);
//		ds = new String[2];
//		ds[0] = "信息";
//		ds[1] = client.getName();
//		list.add(ds);
//		ds = new String[2];
//		ds[0] = "编号";
//		ds[1] = client.getSn();
//		list.add(ds);
//		ds = new String[2];
//		ds[0] = "类型";
//		ds[1] = client.getType();
//		list.add(ds);
//		ds[0] = "控制器型号";
//		ds[1] = client.getControllermodel();
//		list.add(ds);
//		ds = null;
//		for (String d : datas) {
//			ds = d.split("=");
//			list.add(ds);
//			//if("led".equals(ds[0]))
//				led = ","+ds[1]+",";
//		}
//		
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("list", list);
//		map.put("id", id);
//		map.put("name", client.getName());
//		map.put("led", led);
//		log.info("findClientInfo end");
//		System.out.println("========================================"+map);
//		return map;
//	}
	
	/**
	 * 获取设备参数
	 * @param id
	 * @return
	 */
	@Override
	public Map<String, Object> findClientInfo(DtuInfo dtu,String id){
		log.info("findClientInfo start");
		Client client = this.util.get(Client.class, Integer.valueOf(id));

		String[] ds = null;
		String led = ","+dtu.getLed()+",";
		List<String[]> list = new ArrayList<String[]>();
		
		String zt = "";
		if("1".equals(String.valueOf(client.getState())))
			zt = "正常";
		else if("2".equals(String.valueOf(client.getState())))
			zt = "超时";
		else if("3".equals(String.valueOf(client.getState())))
			zt = "离线";
		else if("4".equals(String.valueOf(client.getState())))
			zt = "故障";
		else if("5".equals(String.valueOf(client.getState())))
			zt = "无效";
		ds = new String[2];
		ds[0] = "连接状态";
		ds[1] = zt;
		list.add(ds);
		
		ds = new String[2];
		ds[0] = "时间";
		ds[1] = dtu.getUpdate_time().toString();
		list.add(ds);
		
		ds = new String[2];
		ds[0] = "信息";
		ds[1] = client.getName();
		list.add(ds);
		ds = new String[2];
		ds[0] = "编号";
		ds[1] = client.getSn();
		list.add(ds);
		ds = new String[2];
		ds[0] = "LED";
		System.out.println("=========LED========"+dtu.getLed());
		if(dtu.getLed()!=null){
		ds[1] = dtu.getLed();
		}
		list.add(ds);
		ds = new String[2];
		ds[0] = "类型";
		ds[1] = client.getType();
		list.add(ds);
		ds = new String[2];
		ds[0] = "控制器型号";
		ds[1] = client.getControllermodel();
		list.add(ds);
		ds = new String[2];
		ds[0] = "基站类型";
		if(dtu.getMnc()==0){
		ds[1] = "移动基站";
		}else{
			ds[1] = "联通基站";	
		}
		list.add(ds);
		ds = new String[2];
		ds[0] = "小区号";
		ds[1] = dtu.getLac().toString();
		list.add(ds);
		ds = new String[2];
		ds[0] = "预警报";
		if(dtu.getPrealarm()==1){
		ds[1] = "警报！";
		}else{
			ds[1] = "暂无警报！";	
		}
		list.add(ds);
		ds = new String[2];
		ds[0] = "警报";
		if(dtu.getAlarm()==1){
			ds[1] = "警报！";
			}else{
				ds[1] = "暂无警报！";	
			}
		list.add(ds);
		ds = new String[2];
		ds[0] = "经度";
		ds[1] = dtu.getLat();
		list.add(ds);
		ds = new String[2];
		ds[0] = "纬度";
		ds[1] = dtu.getLon();
		list.add(ds);
		ds = new String[2];
		ds[0] = "发电频率 (单位:0.1Hz)";
		ds[1] = dtu.getPgf().toString();
		list.add(ds);
		ds = new String[2];
		ds[0] = "转速(单位:RPM)";
		ds[1] = dtu.getRs().toString();
		list.add(ds);
		ds = new String[2];
		ds[0] = "运行时间累计(单位:h)";
		ds[1] = dtu.getTotaltime().toString();
		list.add(ds);
		ds = new String[2];
		ds[0] = "油压(单位:0.1BAR)";
		ds[1] = dtu.getOp().toString();
		list.add(ds);
		ds = new String[2];
		ds[0] = "水温(单位:.C)";
		ds[1] = dtu.getWt().toString();
		list.add(ds);
		ds = new String[2];
		ds[0] = "电池电压(单位:0.1V)";
		ds[1] = dtu.getBatbol().toString();
		list.add(ds);
		ds = new String[2];
		ds[0] = "L1-N 发电机A相电压(单位:V)";
		ds[1] = dtu.getAv().toString();
		list.add(ds);
		ds = new String[2];
		ds[0] = "L2-N 发电机A相电压(单位:V)";
		ds[1] = dtu.getBv().toString();
		list.add(ds);
		ds = new String[2];
		ds[0] = "L3-N 发电机A相电压(单位:V)";
		ds[1] = dtu.getCv().toString();
		list.add(ds);
		ds = new String[2];
		ds[0] = "L1-L2 发电机AB线电压(单位:V)";
		ds[1] = dtu.getAblv().toString();
		list.add(ds);
		ds = new String[2];
		ds[0] = "L2-L3 发电机BC线电压(单位:V)";
		ds[1] = dtu.getBclv().toString();
		list.add(ds);
		ds = new String[2];
		ds[0] = "L3-L1 发电机CA线电压(单位:V)";
		ds[1] = dtu.getAclv().toString();
		list.add(ds);
		ds = new String[2];
		ds[0] = "L1 发电机A相电流(单位:A)";
		ds[1] = dtu.getApc().toString();
		list.add(ds);
		ds = new String[2];
		ds[0] = "L2 发电机B相电流(单位:A)";
		ds[1] = dtu.getBpc().toString();
		list.add(ds);
		ds = new String[2];
		ds[0] = "L3 发电机C相电流(单位:A)";
		ds[1] = dtu.getCpc().toString();
		list.add(ds);
		ds = new String[2];
		ds[0] = "发电机有功总功率(单位KW)(发电C相有功功率 + 发电B相有功功率 + 发电A相有功功率)";
		ds[1] = dtu.getTotalap().toString();
		list.add(ds);
		ds = new String[2];
		ds[0] = "发电机视在总功率(单位KVA)(发电C相视在功率 + 发电B相视在功率 + 发电A相视在功率)";
		ds[1] = dtu.getTotalip().toString();
		list.add(ds);
		ds = new String[2];
		ds[0] = "发电机功率因数(单位:0.01)(发电C相功率因数 + 发电B相功率因数 + 发电A相功率因数)/3";
		ds[1] = dtu.getGpf().toString();
		list.add(ds);
		ds = new String[2];
		ds[0] = "市电频率(单位:0.1Hz)";
		ds[1] = dtu.getEf().toString();
		list.add(ds);
		ds = new String[2];
		ds[0] = "L1-N 市电A相电压(单位:V);";
		ds[1] = dtu.getEapv().toString();
		list.add(ds);
		ds = new String[2];
		ds[0] = "L2-N 市电B相电压(单位:V);";
		ds[1] = dtu.getEbpv().toString();
		list.add(ds);
		ds = new String[2];
		ds[0] = "L3-N 市电C相电压(单位:V)";
		ds[1] = dtu.getEcpv().toString();
		list.add(ds);
		ds = new String[2];
		ds[0] = "L1-L2 市电AB线电压(单位:V);";
		ds[1] = dtu.getEablv().toString();
		list.add(ds);
		ds = new String[2];
		ds[0] = "市电BC线电压(单位:V);";
		ds[1] = dtu.getEbclv().toString();
		list.add(ds);
		ds = new String[2];
		ds[0] = "市电CA线电压(单位:V)";
		ds[1] = dtu.getEaclv().toString();
		list.add(ds);
		ds = new String[2];
		ds[0] = "控制器开关量输入";
		ds[1] = dtu.getCtrdiginput().toString();
		list.add(ds);
		ds = new String[2];
		ds[0] = "控制器继电器输出";
		ds[1] = dtu.getCtroutput().toString();
		list.add(ds);

		

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("id", id);
		map.put("name", client.getName());
		map.put("led", led);
		log.info("findClientInfo end");
		System.out.println("========================================"+map);
		return map;
	}
	
	/**
	 * 发送指令
	 * @param uid
	 * @param sn
	 * @param cmd
	 * @return
	 */
	@Override
	public String upMission(String uid, String sn, String cmd){
		log.info("upMission start");
		if(uid == null || "".equals(uid))
			return MapUtil.outMap(400, "用户ID为空");
		if(uid == null || "".equals(sn))
			return MapUtil.outMap(400, "设备编号为空");
		if(uid == null || "".equals(cmd))
			return MapUtil.outMap(400, "操作指令为空");
		
		Mission m = new Mission();
		m.setSn(sn);
		m.setUid(Integer.valueOf(uid));
//		m.setCmd("c=a"+cmd);
		m.setCmd(cmd);
		m.setState(0);
		m.setTime(DateUtil2.getNow(DateUtil2.YYYY_MM_DD_HH_MM_SS));
		this.util.save(m);
		log.info("upMission end");
		//开始调用DTU服务端
		log.info("发送调用DTU服务端 start");
		String dturesult = "";
		String result = postDtu(sn,cmd);
		Map<String, Object> map = new HashMap<String, Object>();
		if(result.equals("0")){
			map.put("mid", m.getId());
			dturesult =  MapUtil.outParameterMap("操作失败", map,result);
		}else if(result.equals("1")){		
		    map.put("mid", m.getId());
		    dturesult =  MapUtil.outParameterMap("操作成功", map,result);
		}
		return dturesult;
	}
	
	/**
	 * 发送指令到DTU服务端
	 * @param json
	 * @throws IOException
	 */
	private String postDtu(String sn, String cmd) {
		System.out.println("第三个字符为"+cmd.charAt(3));
		String postUrl = "http://121.43.164.71:8001/dtu";//DTU服务端地址
		String sendUrl = postUrl + "?sn=" + sn
				+ "&a=" + cmd.charAt(3);	
		System.out.println("访问地址："+sendUrl);
		String result = "";
		try {
			StringBuffer sb = new StringBuffer();
			URL url = new URL(sendUrl);
			URLConnection conn = url.openConnection();
			conn.setReadTimeout(8000);
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));			
			for (String line = null; (line = reader.readLine()) != null;) {
				  sb.append(line);
			}			
			reader.close();
			result = URLDecoder.decode(sb.toString(), "UTF-8");
			if(result==null||result==""){
				result = "0";
			}
			System.out.println("调用DTU服务端接口结果是" + result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result ="0";
			return result;
		} 
		return result;
	}
	
	/**
	 * 获取指令状态
	 * @param mid
	 * @return
	 */
	@Override
	public String findMission(String mid){
		log.info("findMission start");
		
		Mission m = this.util.get(Mission.class, Integer.valueOf(mid));
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", m.getState());
		Gson g = new Gson();
		String json = g.toJson(map);
		log.info("findMission end");
		return json;
	}
	
	/**
	 * 修改指令状态
	 * @param mid
	 * @return
	 */
	@Override
	public void upMissionState(String mid){
		log.info("upMissionState start");
		Mission m = this.util.get(Mission.class, Integer.valueOf(mid));
		if("0".equals(String.valueOf(m.getState())) || "1".equals(String.valueOf(m.getState()))){
			log.info("修改指令超时");
			m.setState(4);
			this.util.save(m);
		}
		log.info("upMissionState end");
	}
	
	/**
	 * 获取DTU列表
	 * @param mid
	 * @return
	 */
	@Override
	public List<DtuInfo> getDtuInfo() {
		log.info("getDtuInfo start");
		String hql = "from DtuInfo";
		List<DtuInfo> list = this.util.queryHQL(hql, false);
		log.info("getDtuInfo end");
		return list;
	}
	
	
	/**
	 * 根据Sn获取Client信息
	 * @param sn
	 * @return
	 */
	@Override
	public Client findClientBysn(String sn){
		log.info("findClientBysn start");
		Client  cc = null;
		String hql = "from Client where sn='"+sn+"' order by id desc";
		List<Client> list = this.util.queryHQL(hql, false);
		if(list!=null&&list.size()>0){
			 cc = list.get(0);
		}
		log.info("findClientBysn end");
		return cc;
	}

	/**
	 * 获取Client列表
	 * @return
	 */
	@Override
	public List<Client> findClientList(){
		log.info("findClientList start");
		Client  cc = null;
		String hql = "from Client";
		List<Client> list = this.util.queryHQL(hql, false);
		log.info("findClientBysn end");
		return list;
	}
	
	/**
	 * 根据Sn获取Client信息
	 * @return
	 */
	@Override
	public void updateClient(Client client) {
		this.util.update(client);		
	}

	
	/**
	 * 保存Client
	 * @return
	 */
	@Override
	public void addClient(Client cc) {
		System.out.println("进入saveClient");
		this.util.save(cc);
		
	}
}
