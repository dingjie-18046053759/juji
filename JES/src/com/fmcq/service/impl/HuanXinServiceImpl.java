package com.fmcq.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.fmcq.controller.HuanXinController;
import com.fmcq.service.IHuanXinService;
import com.fmcq.util.Comm;
import com.fmcq.util.HibernateUtil;
import com.fmcq.util.HuanXinUtil;
import com.fmcq.util.MapUtil;
import com.fmcq.util.datautil.DateUtil2;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


/**
 * 环信接口实现类
 * @time 下午2:22:45
 * @author huangzhiwei
 * @category
 */
@Service
public class HuanXinServiceImpl implements IHuanXinService{
	private final static Log log = LogFactory.getLog(HuanXinController.class);
	
	@Resource
	private HibernateUtil util;
	
	/**
	 * 获取环信token
	 */
	@Override
	public String findHxToken() throws Exception{
		 try {
			 	log.info("获取TOKEN start");
				//默认获取全局TOKEn
				Map<String, Object> hxToken = HuanXinUtil.hxToken;
				String token = "";
				//获取数据库为空 重新获取TOKEN
				if(hxToken == null || "".equals(String.valueOf(hxToken.get("token")))){
					hxToken = HuanXinUtil.getToken();
					//获取TOKEN
					token = String.valueOf(hxToken.get("token"));
				}else{
					//获取TOKEN
					token = String.valueOf(hxToken.get("token"));
					//获取到期时间
					String time = String.valueOf(hxToken.get("time"));
					
					Date now = DateUtil2.getNow(DateUtil2.YYYY_MM_DD_HH_MM_SS);
					Date qjsj = DateUtil2.string2Date(time, DateUtil2.YYYY_MM_DD_HH_MM_SS);
					
					int xcz = Integer.valueOf(String.valueOf(DateUtil2.getTimeDiffSecs(qjsj, now)));
					//如果到期重新获取TOKEN
					if(xcz < 0){
						log.info("TOKEN到期重新获取");
						hxToken = HuanXinUtil.getToken();
					}
				}
				log.info("获取TOKEN end");
	            return token;
			} catch (Exception e) {
				 log.error("获取环信TOKEN出现异常");
				 log.error(MapUtil.outError(e));
		         throw e;
			}
	 }
	
	/**
	 * 增加环信用户
	 * @return
	 * @throws Exception 
	 * @throws IOException 
	 */
	@Override
	public String addUser(String user) throws Exception{
		String token = this.findHxToken();
		return HuanXinUtil.addUser(user, token);
	}
	
	/**
	 * 判断用户是否为环信IM用户
	 * @return
	 * @throws Exception 
	 * @throws IOException 
	 */
	@Override
	public boolean ifExistSystem(String user) throws Exception{
		String token = this.findHxToken();
		return HuanXinUtil.ifExistSystem(user, token);
	}
	
	/**
	 * 用户添加好友
	 * @param user1
	 * @param user2
	 * @return
	 * @throws Exception 
	 * @throws IOException 
	 */
	@Override
	public String userAddDoc(String user1,String user2) throws Exception{
		String token = this.findHxToken();
		return HuanXinUtil.userAddDoc(user1, user2, token);
	}
	
	/**
	 * 用户解除好友
	 * @param user1
	 * @param user2
	 * @return
	 * @throws Exception 
	 * @throws IOException 
	 */
	@Override
	public String userDelDoc(String user1,String user2) throws Exception{
		String token = this.findHxToken();
		return HuanXinUtil.userDelDoc(user1, user2, token);
	}
	
	/**
	 * 删除环信用户
	 * @param user
	 * @return
	 * @throws Exception 
	 * @throws IOException 
	 */
	@Override
	public String delUser(String user) throws Exception{
		String token = this.findHxToken();
		return HuanXinUtil.delUser(user, token);
	}
	
	/**
	 * 判断是否存在好友,存在返回true,不存在返回false
	 * @return
	 * @throws Exception 
	 * @throws IOException 
	 */
	@Override
	public boolean ifExistFriend(String user,String doc) throws Exception{
		String token = this.findHxToken();
		return HuanXinUtil.ifExistFriend(user, doc, token);
	}
	
	/**
	 * 发送透传文本消息给用户
	 * @return
	 * @throws Exception 
	 * @throws IOException
	 */
	@Override
	public String sendMessage(String [] users) throws Exception{
		String token = this.findHxToken();
		//String [] users = {"h12276"};
		return HuanXinUtil.sendMessage(users,token);
	}
	
	/**
	 * 患者发送文本消息给医生
	 * @throws Exception 
	 */
	@Override
	public String userSendDoc(Map<String, String> map) throws Exception {
		String token = this.findHxToken();
		int doc = Integer.valueOf(map.get("doc"));
		int user = Integer.valueOf(map.get("user"));
		String msg = map.get("msg");
		return HuanXinUtil.userSendDoc(doc, user, msg, token);
	}
	
	/**
	 * 判断用户是否在线,在线返回true,不在线返回false
	 * @return
	 * @throws Exception 
	 * @throws IOException 
	 */
	@Override
	public boolean ifExistOnline(String user) throws Exception{
		String token = this.findHxToken();
		return HuanXinUtil.ifExistOnline(user, token);
	}
	
	/**
	 * 获取用户离线消息数
	 */
	@Override
	public int getOfflineNumber(String user) throws Exception {
		String token = this.findHxToken();
		return HuanXinUtil.getOfflineNumber(user, token);
	}
	
	/**
     * 批量检测是否有医生web在线
     */
	@Override
    public List<Object[]> findIMOnline() throws Exception{
    	String token = this.findHxToken();
		String sql = "select id,realname from doctordetail";
		List<Object[]> list = this.util.queryBySQL(sql, false);
		List<Object[]> rList = new ArrayList<Object[]>();
		for (Object[] objects : list) {
			if(HuanXinUtil.ifExistOnline("y"+objects[0],token)){
				objects[0] = String.valueOf(objects[0]);
				rList.add(objects);
				log.info(objects[1]+"医生在线");
			}
		}
		return rList;
    }
    
    /**
     * 获取用户好友列表
     * @param user 环信ID
     * @return
     * @throws Exception
     */
	@Override
    public String findUsers(String user) throws Exception{
		log.info("findUsers start");
    	String token = this.findHxToken();
    	List<Map<String, Object>> rl = new ArrayList<Map<String, Object>>();
    	String[] data = HuanXinUtil.findUsers(user, token);
    	if(data != null && data.length > 0){
    		List<Object[]> rlist = new ArrayList<Object[]>();
    		String sql = " select userlevel,id,concat('j',id) as hid,name,CASE ifnull(headportrait,'') when '' then '' else '"+Comm.THIS_URL+"'+headportrait end headportrait,2 px,CASE userlevel WHEN '' THEN 2 ELSE 1 END px2,0 istof,usernumber from users where id in (ids)"+
   				 " union all"+
   				 " select userlevel,id,concat('j',id) as hid,name,CASE ifnull(headportrait,'') when '' then '' else '"+Comm.THIS_URL+"'+headportrait end headportrait,2 px,CASE userlevel WHEN '' THEN 2 ELSE 1 END px2,1 istof,usernumber from users where id not in (ids)"+
   				 " union all"+
   				 " select userlevel,'','','','',1 px,CASE userlevel WHEN '' THEN 2 ELSE 1 END px2,'' istof,'' usernumber from users group by userlevel"+
   				 " order by 7,1,6,9";
	    	String uid = "";
	    	String uids = "";
	    	String esql = "";
	    	List<Object[]> list = null;
	    	int i = 0;
	    	for (String d : data) {
				uid = d.replace(HuanXinUtil.HXQZ, "");
				uids += ","+uid;
	    		i++;
	    		if((i % 500) == 0){
	    			uids = uids.substring(1);
	    			esql = sql.replace("(ids)", "("+uids+")");
	    			list = this.util.queryBySQL(esql, false);
	    			rlist.addAll(list);
	    			uids = "";
	    		}
			}
	    	if(uids != null && !"".equals(uids)){
	    		uids = uids.substring(1);
				esql = sql.replace("(ids)", "("+uids+")");
				list = this.util.queryBySQL(esql, false);
				rlist.addAll(list);
	    	}
	    	
	    	Map<String, Object> m = null;
	    	List<Object[]> l = null;
	    	for (Object[] r : rlist) {
				if("1".equals(String.valueOf(r[5]))){
					m = new HashMap<String, Object>();
					l = new ArrayList<Object[]>();
					m.put("fzname", r[0]);
					rl.add(m);
				}else{
					l.add(r);
					m.put("users", l);
				}
			}
    	}
    	Gson g = new Gson();
    	String json = g.toJson(rl);
    	log.info("findUsers end");
		return json;
    }
}
