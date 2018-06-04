package com.fmcq.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.common.json.JSONException;
import com.common.json.JSONObject;
import com.fmcq.entity.Users;
import com.fmcq.service.IUsersService;
import com.fmcq.util.Comm;
import com.fmcq.util.MapUtil;
import com.fmcq.util.datautil.DateUtil2;

/**
 * 上传文件控制器
 * @author lcq
 */
@Controller
@RequestMapping("/uploadFile")
public class UploadFileController extends BaseController {
	private final static Log log = LogFactory.getLog(UploadFileController.class);

	@Resource
	private IUsersService usersService;
	
	/**
	 * 头像上传
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping("/upHeadportrait.do")
	@ResponseBody
	public void upHeadportrait() throws ServletException, IOException {
		
		JSONObject o = new JSONObject();
		
		// 获取传入的ID
		String uid = request.getParameter("uid");
		log.info("用户" + uid + "正在进行头像上传");
		
		// 保存路径
		String savePath = request.getSession().getServletContext().getRealPath("/upload/");

		File f1 = new File(savePath);
		log.info("上传的图片的保存路径为============== " + savePath);
		if (!f1.exists()) {
			// 不存在创建目录
			f1.mkdirs();
		}

		DiskFileItemFactory fac = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fac);
		upload.setHeaderEncoding("utf-8");
		List<FileItem> fileList = null;
		try {
			// 解析请求 获得项
			fileList = upload.parseRequest(request);
		} catch (FileUploadException ex) {
			return;
		}

		Iterator<FileItem> it = fileList.iterator();
		String name = "";
		String extName = "";
		String tname = uid;
		// 遍历请求数据项
		while (it.hasNext()) {
			FileItem item = it.next();

			if (!item.isFormField()) {
				// 如果不为表单域 则进入此操作
				name = item.getName();
//				long size = item.getSize();
//				String type = item.getContentType();
				if (name == null || name.trim().equals("")) {
					continue;
				}
				// 文件后缀
				if (name.lastIndexOf(".") >= 0) {
					extName = name.substring(name.lastIndexOf("."));
				}
				File file = null;

				file = new File(savePath + tname + extName);
				
				if(file.exists())
				{
					System.out.println(uid+"当前用户头像文件已经存在，对原有头像进行覆盖");
				}
				
				// 保存文件到健康之路的服务器
				File saveFile = new File(savePath + tname + extName);
				try {
					// item.write(saveFile);
					item.write(saveFile);
					savePath = savePath + tname + extName;
					log.info("保存路径----------------------> " + saveFile.getAbsolutePath());
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				//如果是表单域的话
				System.out.println("传入表单域数据");
			}
		}
		
		//此处做数据库保存操作   serverPath为健康之路图片保存路径  保存到数据库
		Users users = this.usersService.findUser(uid);
		users.setHeadportrait("upload/" + tname + extName);
		this.usersService.updateUsers(users);
		
		try {
			o.put("url", savePath+"?time="+DateUtil2.getNow(DateUtil2.YYYY_MM_DD_HH_MM_SS).getTime());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(o.toString());
		response.getWriter().flush();
		response.getWriter().close();
	}
	
	/**
	 * 头像上传
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping("/upHeadportrait2.do")
	@ResponseBody
	public void upHeadportrait2(@RequestParam("uploadFile") MultipartFile myfile, String uid) throws Exception{
		log.info("头像上传 start");
		JSONObject o = new JSONObject();
		o.put("code", "1");
		try {
			log.info("用户" + uid + "正在进行头像上传");
			if(uid!= null && !"".equals(uid) && !myfile.isEmpty()){
		    	System.out.println("==================================原文件名["+myfile.getOriginalFilename()+"]===========================");
		        //获取原文件后缀名
				String edFile=myfile.getOriginalFilename().substring(myfile.getOriginalFilename().indexOf("."),myfile.getOriginalFilename().length());
				System.out.println("==================================上传文件的后缀名["+edFile+"]================================");
				//设置文件名称
				String fileNam=uid + edFile;
				System.out.println("==================================新文件名["+fileNam+"]================================");
				//设置文件上传到项目的保存路径
				// 保存路径
				String savePath = request.getSession().getServletContext().getRealPath("/upload/");
				
				String mf = DateUtil2.getSysDate(DateUtil2.YYYYMM);
				
				String headportrait = "upload/"+mf+"/"+fileNam;
				
				savePath += "/"+mf+"/";
				
				File f1 = new File(savePath);
				log.info("上传的图片的保存路径为============== " + savePath);
				if (!f1.exists()) {
					// 不存在创建目录
					f1.mkdirs();
				}
				
				//通过输入流将文件拷贝到保存目录底下(使用原文件名)
				FileUtils.copyInputStreamToFile(myfile.getInputStream(),new File(savePath,fileNam));
				
				//此处做数据库保存操作   serverPath为健康之路图片保存路径  保存到数据库
				Users users = this.usersService.findUser(uid);
				users.setHeadportrait(headportrait);
				this.usersService.updateUsers(users);
				log.info("返回头像路径为============== " + Comm.THIS_URL+headportrait);
				o.put("code", "0");
				o.put("url", Comm.THIS_URL+headportrait+"?time="+DateUtil2.getNow(DateUtil2.YYYY_MM_DD_HH_MM_SS).getTime());
			}
		} catch (Exception e) {
			log.error("头像上传出现异常");
			log.error(MapUtil.outError(e));
		}
		log.info("头像上传 end");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(o.toString());
		response.getWriter().flush();
		response.getWriter().close();
	}
	
	
	/**
	 * 头像上传
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping("/upHeadportrait3.do")
	@ResponseBody
	public void upHeadportrait3(String uid) throws Exception{
		
		log.info("头像上传 start");
		log.info("头像上传 start");
		log.info("头像上传 start");
		log.info("头像上传 start");
		log.info("头像上传 start");
		log.info("头像上传 start");
		log.info("头像上传 start");
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;  
		MultipartFile myfile = multipartRequest.getFile("uploadFile");
		
		if(myfile.isEmpty()){
			log.info("文件为空了================================");
			log.info("文件为空了================================");
			log.info("文件为空了================================");
		}
		
		
		JSONObject o = new JSONObject();
		o.put("code", "1");
		try {
			log.info("用户" + uid + "正在进行头像上传");
			if(uid!= null && !"".equals(uid) && !myfile.isEmpty()){
		    	System.out.println("==================================原文件名["+myfile.getOriginalFilename()+"]===========================");
		        //获取原文件后缀名
				String edFile=myfile.getOriginalFilename().substring(myfile.getOriginalFilename().indexOf("."),myfile.getOriginalFilename().length());
				System.out.println("==================================上传文件的后缀名["+edFile+"]================================");
				//设置文件名称
				String fileNam=uid + edFile;
				System.out.println("==================================新文件名["+fileNam+"]================================");
				//设置文件上传到项目的保存路径
				// 保存路径
				String savePath = request.getSession().getServletContext().getRealPath("/upload/");
				
				String mf = DateUtil2.getSysDate(DateUtil2.YYYYMM);
				
				String headportrait = "upload/"+mf+"/"+fileNam;
				
				savePath += "/"+mf+"/";
				
				File f1 = new File(savePath);
				log.info("上传的图片的保存路径为============== " + savePath);
				if (!f1.exists()) {
					// 不存在创建目录
					f1.mkdirs();
				}
				
				//通过输入流将文件拷贝到保存目录底下(使用原文件名)
				FileUtils.copyInputStreamToFile(myfile.getInputStream(),new File(savePath,fileNam));
				
				//此处做数据库保存操作   serverPath为健康之路图片保存路径  保存到数据库
				Users users = this.usersService.findUser(uid);
				users.setHeadportrait(headportrait);
				this.usersService.updateUsers(users);
				log.info("返回头像路径为============== " + Comm.THIS_URL+headportrait);
				o.put("code", "0");
				o.put("url", Comm.THIS_URL+headportrait+"?time="+DateUtil2.getNow(DateUtil2.YYYY_MM_DD_HH_MM_SS).getTime());
			}
		} catch (Exception e) {
			log.error("头像上传出现异常");
			log.error(MapUtil.outError(e));
		}
		log.info("头像上传 end");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(o.toString());
		response.getWriter().flush();
		response.getWriter().close();
	}
}
