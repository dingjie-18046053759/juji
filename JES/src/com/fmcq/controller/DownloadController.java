package com.fmcq.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * App下载地址
 * @author lcq
 */
@Controller
@RequestMapping("/download")
public class DownloadController extends BaseController {
	
	@RequestMapping("toDownload.do")
	@ResponseBody
	public void toDownload() throws IOException{
		
		response.sendRedirect("http://a.app.qq.com/o/simple.jsp?pkgname=app.view");
	}
}
