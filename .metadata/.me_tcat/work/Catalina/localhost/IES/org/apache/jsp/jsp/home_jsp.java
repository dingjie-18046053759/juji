package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\" />\r\n");
      out.write("<title>炬集物联</title>\r\n");
      out.write("<meta\r\n");
      out.write("\tcontent=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\"\r\n");
      out.write("\tname=\"viewport\" />\r\n");
      out.write("<meta content=\"\" name=\"description\" />\r\n");
      out.write("<meta content=\"\" name=\"author\" />\r\n");
      out.write("<meta http-equiv=\"expires\" content=\"0\" />\r\n");
      out.write("<!-- ================== 基础样式表开始 ================== -->\r\n");
      out.write("<link href=\"");
      out.print(path);
      out.write("/css/style.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<script src=\"");
      out.print(path);
      out.write("/js/jquery2.1.1.min.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(path);
      out.write("/css/swiper.min.css\">\r\n");
      out.write("<script src=\"");
      out.print(path);
      out.write("/js/jquery-1.7.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(path);
      out.write("/js/Area.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(path);
      out.write("/js/AreaData_min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("<!-- ================== 基础样式表结束 ================== -->\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tvar num = null;\r\n");
      out.write("\t//获取未读信息数量，页面加载前完成\r\n");
      out.write("\t$(function() {\r\n");
      out.write("\t\tvar account = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${users.id }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("';\r\n");
      out.write("\t\tif (account != \"\") {\r\n");
      out.write("\t\t\t$\r\n");
      out.write("\t\t\t\t\t.ajax({\r\n");
      out.write("\t\t\t\t\t\ttype : \"get\",\r\n");
      out.write("\t\t\t\t\t\tasync : false,\r\n");
      out.write("\t\t\t\t\t\turl : \"http://www.jujiiot.com/nsfw/gcs_getUnReadMessage.action\",\r\n");
      out.write("\t\t\t\t\t\tdata : {\r\n");
      out.write("\t\t\t\t\t\t\t\"gcs.gcsNumber\" : account\r\n");
      out.write("\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\tdataType : \"jsonp\",\r\n");
      out.write("\t\t\t\t\t\tjsonp : \"callback\",\r\n");
      out.write("\t\t\t\t\t\tjsonpCallback : \"getUnReadMessage\",\r\n");
      out.write("\t\t\t\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\terror : function() {\r\n");
      out.write("\t\t\t\t\t\t\talert('fail');\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t//window.location = \"http://www.jujiiot.com/nsfw/gcs_getUnReadMessage.action?gcs.gcsNumber=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${users.usernumber }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\";\t\r\n");
      out.write("\t});\r\n");
      out.write("\tfunction getUnReadMessage(data) {\r\n");
      out.write("\t\t//alert(\"通过JSONP获取到的NUM\" + data.num);\r\n");
      out.write("\t\tif(data.num>0){\r\n");
      out.write("\t\tdocument.getElementById(\"hello\").innerText = data.num;\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\tvar a=document.getElementsByClassName(\"news\")[0];\r\n");
      out.write("\t\ta.setAttribute(\"style\",\"display:none\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t//window.onload=function()\r\n");
      out.write("\t//{  \r\n");
      out.write("\t//    var account = ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${users.usernumber }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(";\r\n");
      out.write("\t//    if(account != \"\"){ \r\n");
      out.write("\t//\t$.ajax({\r\n");
      out.write("\t//\t\t\turl : \"http://www.jujiiot.comnsfw/gcs_getUnReadMessage.action\",\r\n");
      out.write("\t//\t\t\ttype : \"post\",\r\n");
      out.write("\t//\t\t\tdata: {\"gcs.gcsNumber\":account},\r\n");
      out.write("\t//\t\t\t//async : false,//非异步\r\n");
      out.write("\t//\t\t\tsuccess : function(msg) {\r\n");
      out.write("\t//\t\t\t    alert(msg);\r\n");
      out.write("\t//\t\t\t\tnum = msg;\r\n");
      out.write("\t//\t\t\t}\r\n");
      out.write("\t//\t\t});\r\n");
      out.write("\t//\t\t}\r\n");
      out.write("\t//\t\t//window.location = \"http://www.jujiiot.comnsfw/gcs_getUnReadMessage.action?gcs.gcsNumber=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${users.usernumber }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t//\t\talert(num);\r\n");
      out.write("\t//\t\tdocument.getElementById(\"hello\").innerText = num;\r\n");
      out.write("\t//\t}\r\n");
      out.write("\t//所有订单\r\n");
      out.write("\tfunction OrderList() {\r\n");
      out.write("\t\twindow.location = \"http://121.43.164.71:8080/itcastTax/nsfw/order_listAppUI.action?order.gcsNum=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${users.usernumber }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t}\r\n");
      out.write("\t//客户评价\r\n");
      out.write("\tfunction kehupingjia() {\r\n");
      out.write("\t\twindow.location = \"http://121.43.164.71:8080/itcastTax/nsfw/order_listPjUI.action?order.gcsNum=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${users.usernumber }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t}\r\n");
      out.write("\t//未接订单\r\n");
      out.write("\tfunction weijieList() {\r\n");
      out.write("\t\twindow.location = \"http://121.43.164.71:8080/itcastTax/nsfw/order_listWjAppUI.action?order.gcsNum=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${users.usernumber }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t}\r\n");
      out.write("\t//待解决订单\r\n");
      out.write("\tfunction djjList() {\r\n");
      out.write("\t\twindow.location = \"http://121.43.164.71:8080/itcastTax/nsfw/order_listDjjAppUI.action?order.gcsNum=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${users.usernumber }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t}\r\n");
      out.write("\t//费用代收\r\n");
      out.write("\tfunction daishou() {\r\n");
      out.write("\t\twindow.location = \"http://www.jujiiot.com/jjwl/FeiYongDaiShou.jsp\"\r\n");
      out.write("\t}\r\n");
      out.write("\t//我的收入\r\n");
      out.write("\tfunction qianbao() {\r\n");
      out.write("\t\twindow.location = \"http://121.43.164.71:8080/itcastTax/nsfw/order_qianbao.action?order.gcsNum=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${users.usernumber }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t}\r\n");
      out.write("\t//备件查询\r\n");
      out.write("\tfunction findBeijian() {\r\n");
      out.write("\t\twindow.location = \"http://www.jujiiot.com/nsfw/info_APPcpzlfdjzListUI.action?info.firstLevel=cpzl&info.secondLevel=fdjz\";\r\n");
      out.write("\t}\r\n");
      out.write("\t//我的进修\r\n");
      out.write("\tfunction jinxiu() {\r\n");
      out.write("\t\twindow.location = \"http://www.jujiiot.com/nsfw/info_appjinxiuListUI.action?info.type=APPjinxiu\";\r\n");
      out.write("\t}\r\n");
      out.write("\t//未读消息\r\n");
      out.write("\tfunction unReadMessage() {\r\n");
      out.write("\t\twindow.location = \"http://www.jujiiot.com/nsfw/info_appinfoListUI.action?info.type=APP&info.memo=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${users.id }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t//联系客服\r\n");
      out.write("\tfunction funLxkf() {\r\n");
      out.write("\t\tandroid.openHxService(\"j18\");\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"content\">\r\n");
      out.write("\t\t<div class=\"top\">\r\n");
      out.write("\t\t\t<div class=\"state\"></div>\r\n");
      out.write("\t\t\t<div class=\"nav\">\r\n");
      out.write("\t\t\t\t<div class=\"left-icon\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<span>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${users.city }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</span>\r\n");
      out.write("\t\t\t\t\t<!--<a class=\"iconfont\"  href=\"javascript:changecity()\">&#xe62e;</a>-->\r\n");
      out.write("\t\t\t\t\t<a class=\"iconfont\">&#xe62e;</a> <br>\r\n");
      out.write("\t\t\t\t\t<form name=\"form1\" action=\"\" method=\"post\"\r\n");
      out.write("\t\t\t\t\t\tenctype=\"multipart/form-data\"></form>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<h1>炬集物联</h1>\r\n");
      out.write("\t\t\t\t<div class=\"right-icon\">\r\n");
      out.write("\t\t\t\t\t<!-- 查看消息图标 -->\r\n");
      out.write("\t\t\t\t\t<i class=\"iconfont\" onclick=\"unReadMessage()\">&#xe63c;</i>\r\n");
      out.write("\t\t\t\t\t<!-- 未读消息数量 -->\r\n");
      out.write("\t\t\t\t\t<span class=\"news\" id=\"hello\"></span>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"banner\">\r\n");
      out.write("\t\t\t\t<div class=\"swiper-container\">\r\n");
      out.write("\t\t\t\t\t<div class=\"swiper-wrapper\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"swiper-slide\">\r\n");
      out.write("\t\t\t\t\t\t\t<img src=\"");
      out.print(path);
      out.write("/images/banner.jpg\" alt=\"\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"swiper-slide\">\r\n");
      out.write("\t\t\t\t\t\t\t<img src=\"");
      out.print(path);
      out.write("/images/banner2.jpg\" alt=\"\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"swiper-slide\">\r\n");
      out.write("\t\t\t\t\t\t\t<img src=\"");
      out.print(path);
      out.write("/images/banner3.jpg\" alt=\"\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"swiper-pagination\"></div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"icon-list\">\r\n");
      out.write("\t\t\t<div class=\"user-box\">\r\n");
      out.write("\t\t\t\t<div class=\"user-img-box\">\r\n");
      out.write("\t\t\t\t\t");

						long date = new Date().getTime();
						request.setAttribute("date", date);
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<img src=\"");
      out.print(path);
      out.write('/');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${users.headportrait }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("?time=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${date}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" alt=\"\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"user-mes\">\r\n");
      out.write("\t\t\t\t\t<p class=\"name\">\r\n");
      out.write("\t\t\t\t\t\t");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${users.truename }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("<span>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${users.userlevel }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</span>\r\n");
      out.write("\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t<p class=\"num\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${users.usernumber }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</p>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"icon-box\">\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t<li onclick=\"OrderList()\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"ico\">\r\n");
      out.write("\t\t\t\t\t\t\t<i class=\"iconfont\">&#xe742;</i>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<p>全部订单</p></li>\r\n");
      out.write("\t\t\t\t\t<li onclick=\"weijieList()\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"ico\">\r\n");
      out.write("\t\t\t\t\t\t\t<i class=\"iconfont\">&#xe603;</i>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<p>待接单</p></li>\r\n");
      out.write("\t\t\t\t\t<li onclick=\"djjList()\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"ico\">\r\n");
      out.write("\t\t\t\t\t\t\t<i class=\"iconfont\">&#xe672;</i>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<p>待解决</p></li>\r\n");
      out.write("\t\t\t\t\t<li onclick=\"kehupingjia()\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"ico\">\r\n");
      out.write("\t\t\t\t\t\t\t<i class=\"iconfont\">&#xe620;</i>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<p>客户评价</p></li>\r\n");
      out.write("\t\t\t\t\t<li onclick=\"daishou()\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"ico\">\r\n");
      out.write("\t\t\t\t\t\t\t<i class=\"iconfont\">&#xe60e;</i>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<p>费用代收</p></li>\r\n");
      out.write("\t\t\t\t\t<li onclick=\"findBeijian()\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"ico\">\r\n");
      out.write("\t\t\t\t\t\t\t<i class=\"iconfont\">&#xe639;</i>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<p>备件查询</p></li>\r\n");
      out.write("\t\t\t\t\t<li onclick=\"qianbao()\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"ico\">\r\n");
      out.write("\t\t\t\t\t\t\t<i class=\"iconfont\">&#xe665;</i>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<p>我的收入</p></li>\r\n");
      out.write("\t\t\t\t\t<li onclick=\"jinxiu()\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"ico\">\r\n");
      out.write("\t\t\t\t\t\t\t<i class=\"iconfont\">&#xe698;</i>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<p>我的进修</p></li>\r\n");
      out.write("\t\t\t\t\t<li onclick=\"funLxkf()\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"ico\">\r\n");
      out.write("\t\t\t\t\t\t\t<i class=\"iconfont\">&#xe63d;</i>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<p>意见反馈</p></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\t\r\n");
      out.write("\t</script>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("<script src=\"");
      out.print(path);
      out.write("/js/swiper.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(path);
      out.write("/js/width.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(path);
      out.write("/js/base2.js\"></script>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
