package com.fmcq.controller;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fmcq.entity.Client;
import com.fmcq.entity.DtuInfo;
import com.fmcq.service.IClientService;
import com.fmcq.util.Comm;
import com.google.gson.Gson;


@Controller
@RequestMapping("/client")
public class ClientController extends BaseController {
	private static Log log = LogFactory.getLog(ClientController.class);
	
	@Resource
	private IClientService clientService;
	
	/**
	 * 获取设备集合
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/findClientList.do")
	public String findClientList(String uid){
		log.info("获取设备集合 start");
		
		List<Object[]> list= clientService.findClientList(uid);
		
		request.setAttribute("list", list);
		request.setAttribute("msg", "ok");
		request.setAttribute("uid", uid);
		log.info("获取设备集合 end");
		return "/jsp/genware";
	}
	
//	/**
//	 * 获取设备信息
//	 * @return
//	 * @throws IOException 
//	 * @throws Exception 
//	 */
//	@RequestMapping("/findClient.do")
//	public String findClient(String id, String uid) throws IOException{
//		log.info("获取设备信息 start");
//		Client client = clientService.findClient(id);
//		Map<String, Object> rmap = findTxt(id, client);
//		List<String[]> cmds = null;
//		Map<String, Object> map = null;
//		if(rmap == null){
//			System.out.println("从服务器获取到的文件为空");
//			cmds = clientService.findCmdList(client.getControllermodel());//获取有哪些指令
//			map = clientService.findClientInfo(id);//map里面有list，id,name,led；list是client详细信息
//		}else{
//			System.out.println("从服务器获取到了相应的文件");
//			cmds = (List<String[]>) rmap.get("cmds");
//			map = (Map<String, Object>) rmap.get("map");
//			System.out.println("==============从服务器获取到了相应的文件的CMDS==============="+cmds);
//			System.out.println("==============从服务器获取到了相应的文件的MAP==============="+map);
//		}
//		
//		request.setAttribute("map", map);
//		request.setAttribute("client", client);
//		request.setAttribute("id", id);
//		request.setAttribute("uid", uid);
//		request.setAttribute("cmds", cmds);
//		log.info("获取设备信息 end");
//		return "/jsp/basic";
//	}
	
	
	/**
	 * 获取设备信息
	 * @return
	 * @throws IOException 
	 * @throws Exception 
	 */
	@RequestMapping("/findClient.do")
	public String findClient(Integer id, String uid) throws IOException{
		log.info("获取设备信息 start");
//		System.out.println("传入id为"+id);
		Client client = clientService.findClient(id);
		DtuInfo dtuinfo = clientService.findDtu(client.getSn());
//		System.out.println("=======dtuinfo的sn========"+dtuinfo.getSn());
		
		List<String[]> cmds = null;
		Map<String, Object> map = null;
		cmds = clientService.findCmdList(client.getControllermodel());//获取有哪些指令
		map = clientService.findClientInfo(dtuinfo,String.valueOf(id));//map里面有list，id,name,led；list是client详细信息
		
		request.setAttribute("Dtu", dtuinfo);
		request.setAttribute("map", map);
		request.setAttribute("client", client);
		request.setAttribute("id", id);
		request.setAttribute("uid", uid);
		request.setAttribute("cmds", cmds);
		log.info("获取设备信息 end");
		return "/jsp/basic";
	}
	
	/**
	 * ajax获取设备信息
	 * @param json
	 * @throws IOException
	 */
	@RequestMapping("/ajaxFindClient.do")
	@ResponseBody
	public void ajaxFindClient(Integer id) throws IOException{
		log.info("ajax获取设备信息 start");
		Client client = clientService.findClient(id);
		DtuInfo dtuinfo = clientService.findDtu(client.getSn());
		List<String[]> cmds = clientService.findCmdList(client.getControllermodel());
		Map<String, Object> map = clientService.findClientInfo(dtuinfo,String.valueOf(id));
		request.setAttribute("map", map);
		request.setAttribute("client", client);
		request.setAttribute("cmds", cmds);
		
		Map<String, Object> rm = new HashMap<String, Object>();
		rm.put("map", map);
		rm.put("client", client);
		rm.put("cmds", cmds);
		rm.put("dtuinfo", dtuinfo);
		
		Gson g = new Gson();
		String json = g.toJson(rm);
		log.info("ajax获取设备信息 end");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(json);
		response.getWriter().flush();
		response.getWriter().close();
	}
	
	/**
	 * ajax获取设备信息
	 * @param json
	 * @throws IOException
	 */
	@RequestMapping("/ajaxFindClientTxt.do")
	@ResponseBody
	public void ajaxFindClientTxt(Integer id) throws IOException{
		log.info("ajax获取设备信息 start");
		Client client = clientService.findClient(id);
		Map<String, Object> rmap = findTxt(String.valueOf(id), client);
		Gson g = new Gson();
		String json = g.toJson(rmap);
		log.info("ajax获取设备信息 end");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(json);
		response.getWriter().flush();
		response.getWriter().close();
	}
	
	private Map<String, Object> findTxt(String cid, Client client) throws IOException{
			DtuInfo dtuinfo = clientService.findDtu(client.getSn());
			List<String[]> cmds = null;
			Map<String, Object> map = null;
			cmds = clientService.findCmdList(client.getControllermodel());//获取有哪些指令
			map = clientService.findClientInfo(dtuinfo,cid);//map里面有list，id,name,led；list是client详细信息
			
	        Map<String, Object> rm = new HashMap<String, Object>();
	        rm.put("map", map);
	        rm.put("cmds", cmds);
			rm.put("client", client);//设备所以属性
	        return rm;
	}
	
	/**
	 * 获取设备参数
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/findClientInfo.do")
	public String findClientInfo(Integer id, String uid){
		log.info("获取设备参数 start");
		Client client = clientService.findClient(id);
		DtuInfo dtuinfo = clientService.findDtu(client.getSn());
		Map<String, Object> map = clientService.findClientInfo(dtuinfo,String.valueOf(id));
		request.setAttribute("map", map);
		request.setAttribute("uid", uid);
		log.info("获取设备参数 end");
		return "/jsp/detailed";
	}
	
	/**
	 * 发送指令
	 * @param json
	 * @throws IOException
	 */
	@RequestMapping("/upMission.do")
	@ResponseBody
	public void upMission(String uid, String sn, String cmd) throws IOException{
		log.info("发送指令 start");
		String json = clientService.upMission(uid, sn, cmd);//在里面调用DTU服务端
		log.info("发送指令 end");
		
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(json);
		response.getWriter().flush();
		response.getWriter().close();
	}
	
	

	/**
	 * 获取指令状态
	 * @param json
	 * @throws IOException
	 */
	@RequestMapping("/findMission.do")
	@ResponseBody
	public void findMission(String mid) throws IOException{
		log.info("获取指令状态 start");
		String json = clientService.findMission(mid);
		log.info("获取指令状态 end");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(json);
		response.getWriter().flush();
		response.getWriter().close();
	}
	
	/**
	 * 修改指令状态
	 * @param json
	 * @throws IOException
	 */
	@RequestMapping("/upMissionState.do")
	@ResponseBody
	public void upMissionState(String mid) throws IOException{
		log.info("修改指令状态 start");
		clientService.upMissionState(mid);
		log.info("修改指令状态 end");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print("");
		response.getWriter().flush();
		response.getWriter().close();
	}
}
