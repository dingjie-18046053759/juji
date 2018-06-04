package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class basic_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

static private org.apache.jasper.runtime.ProtectedFunctionMapper _jspx_fnmap_0;
static private org.apache.jasper.runtime.ProtectedFunctionMapper _jspx_fnmap_1;
static private org.apache.jasper.runtime.ProtectedFunctionMapper _jspx_fnmap_2;

static {
  _jspx_fnmap_0= org.apache.jasper.runtime.ProtectedFunctionMapper.getMapForFunction("fn:length", org.apache.taglibs.standard.functions.Functions.class, "length", new Class[] {java.lang.Object.class});
  _jspx_fnmap_1= org.apache.jasper.runtime.ProtectedFunctionMapper.getMapForFunction("fn:indexOf", org.apache.taglibs.standard.functions.Functions.class, "indexOf", new Class[] {java.lang.String.class, java.lang.String.class});
  _jspx_fnmap_2= org.apache.jasper.runtime.ProtectedFunctionMapper.getMapForFunction("fn:replace", org.apache.taglibs.standard.functions.Functions.class, "replace", new Class[] {java.lang.String.class, java.lang.String.class, java.lang.String.class});
}

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_005fvarStatus_005fvar_005fitems;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_005fvarStatus_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_005fvarStatus_005fvar_005fitems.release();
    _005fjspx_005ftagPool_005fc_005fif_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fnobody.release();
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
      out.write(" \r\n");

response.setHeader("Pragma","No-cache");
response.setHeader("Cache-Control","no-cache");
response.setDateHeader("Expires", 0);

      out.write('\r');
      out.write('\n');

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!--[if !IE]><!-->\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\t<!--<![endif]-->\r\n");
      out.write("\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<meta charset=\"utf-8\" />\r\n");
      out.write("\t\t<title>炬集物联</title>\r\n");
      out.write("\t\t<meta content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\" name=\"viewport\" />\r\n");
      out.write("\t\t<meta content=\"\" name=\"description\" />\r\n");
      out.write("\t\t<meta content=\"\" name=\"author\" />\r\n");
      out.write("\t\t<meta name=\"format-detection\" content=\"telephone=no\">\r\n");
      out.write("\t\t<!-- ================== 基础样式表开始 ================== -->\r\n");
      out.write("\t\t<link href=\"");
      out.print(path );
      out.write("/css/style.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t\t<script src=\"");
      out.print(path );
      out.write("/js/jquery2.1.1.min.js\"></script>\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"");
      out.print(path );
      out.write("/css/swiper.min.css\">\r\n");
      out.write("\t\t<!-- ================== 基础样式表结束 ================== -->\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t    \tfunction funBack(){\r\n");
      out.write("\t    \t\twindow.location=\"");
      out.print(basePath);
      out.write("/client/findClientList.do?uid=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${uid }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t    \t}\r\n");
      out.write("\t    \t\r\n");
      out.write("\t    \tfunction funDetailed(){\r\n");
      out.write("\t\t\t\twindow.location=\"");
      out.print(basePath);
      out.write("/client/findClientInfo.do?uid=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${uid }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("&id=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${client.id }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t    \t}\r\n");
      out.write("\t    \t\r\n");
      out.write("\t    \tvar cmdz = \"\";\r\n");
      out.write("\t    \tfunction funUpMission(cmd){\r\n");
      out.write("\t    \t\tif(cmd == \"无\"){\r\n");
      out.write("\t    \t\t\treturn;\r\n");
      out.write("\t    \t\t}\r\n");
      out.write("\t    \t\tcmdz = cmd;\r\n");
      out.write("\t    \t\t$('#condiv').css('display','block');\r\n");
      out.write("\t    \t}\r\n");
      out.write("\t    \t\r\n");
      out.write("\t    \tfunction funUpMission2(){\r\n");
      out.write("\r\n");
      out.write("\t   \t\t\t$('#sure').css(\"background-color\",\"#B2E0FF\");\r\n");
      out.write("\r\n");
      out.write("\t   \t\t\tsetTimeout(function(){\r\n");
      out.write("\t   \t        $('#sure').css(\"background-color\",\"#ffffff\");\r\n");
      out.write("\t   \t                    },500);\r\n");
      out.write("\t   \t        dis();\r\n");
      out.write("\t    \t\t\r\n");
      out.write("\t    \t\tvar cmd = cmdz;\r\n");
      out.write("\t    \t\tcmdz = \"\";\r\n");
      out.write("\t    \t\t\t    \t\t\r\n");
      out.write("\t    \t\tvar uid = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${uid}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t    \t\tvar sn = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${client.sn}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t    \t\tif(uid == null || uid == \"\"){\r\n");
      out.write("\t    \t\t\talert(\"用户ID为空！\");\r\n");
      out.write("\t    \t\t\t$('#logdiv').css('display','none');\r\n");
      out.write("\t    \t\t\treturn;\r\n");
      out.write("\t    \t\t}\r\n");
      out.write("\t    \t\tif(sn == null || sn == \"\"){\r\n");
      out.write("\t    \t\t\talert(\"设备编号为空！\");\r\n");
      out.write("\t    \t\t\t$('#logdiv').css('display','none');\r\n");
      out.write("\t    \t\t\treturn;\r\n");
      out.write("\t    \t\t}\r\n");
      out.write("\t    \t\tif(cmd == null || cmd == \"\"){\r\n");
      out.write("\t    \t\t\talert(\"操作指令为空！\");\r\n");
      out.write("\t    \t\t\t$('#logdiv').css('display','none');\r\n");
      out.write("\t    \t\t\treturn;\r\n");
      out.write("\t    \t\t}\r\n");
      out.write("\t    \t\t$('#logdiv').css('display','block');\r\n");
      out.write("\t    \t\t$.ajax({\r\n");
      out.write("\t   \t\t\t\turl : \"");
      out.print(basePath);
      out.write("/client/upMission.do\",\r\n");
      out.write("\t   \t\t\t    async : false,\r\n");
      out.write("\t   \t\t\t    type : \"post\",\r\n");
      out.write("\t   \t\t\t    data : \"uid=\"+uid+\"&sn=\"+sn+\"&cmd=\"+cmd,\r\n");
      out.write("\t   \t\t\t \tdataType : \"json\", \r\n");
      out.write("\t   \t\t\t \tsuccess : function(data) {\r\n");
      out.write("\t   \t\t\t      \tif(data.respCode == 1){//成功\r\n");
      out.write("  \t                        setTimeout(function(){\r\n");
      out.write("\t    \t                    $('#logdiv').css('display','block');\r\n");
      out.write("                            },6000);\r\n");
      out.write("\t   \t\t\t\t    \tsetTimeout(function(){\r\n");
      out.write("\t   \t\t\t\t    \t\t$('#logdiv').css('display','none');\r\n");
      out.write("\t   \t\t\t\t    \t},8000);\r\n");
      out.write("\t   \t\t\t\t    \t\r\n");
      out.write("\t   \t\t\t\t    \tsetTimeout(function(){\r\n");
      out.write("\t   \t\t\t\t    \t\talert(data.respMsg);\r\n");
      out.write("\t   \t\t\t\t    \t},8000);\r\n");
      out.write("\t   \t\t\t\t    } else {//失败\r\n");
      out.write("\t   \t\t\t\t    \t//alert(data.respMsg);\r\n");
      out.write("\t   \t\t\t\t    \tcheckTime = true;\r\n");
      out.write("\t    \t\t\t\t\tsecond = 0;\r\n");
      out.write("\t    \t\t\t\t\tiszx = true;\r\n");
      out.write("\t\t\t\t\t\t\tsetTimeout(function(){\r\n");
      out.write("\t    \t                 $('#logdiv').css('display','block');\r\n");
      out.write("                            },6000);\r\n");
      out.write("\t    \t\t\t\t\tsetTimeout(function(){\r\n");
      out.write("\t   \t\t\t\t    \t\t$('#logdiv').css('display','none');\r\n");
      out.write("\t   \t\t\t\t    \t},7000);\r\n");
      out.write("\t   \t\t\t\t    \t\r\n");
      out.write("\t   \t\t\t\t    \tsetTimeout(function(){\r\n");
      out.write("\t   \t\t\t\t    \t\talert(data.respMsg);\r\n");
      out.write("\t   \t\t\t\t    \t},8000);\r\n");
      out.write("\t   \t\t\t      \t\tstartit(data.mid);\r\n");
      out.write("\t   \t\t\t\t    \t\r\n");
      out.write("\t   \t\t\t\t    }\r\n");
      out.write("\t   \t\t\t\t}\r\n");
      out.write("\t   \t\t  \t});\r\n");
      out.write("\t    \t}\r\n");
      out.write("\t    \t//确认按钮消失\r\n");
      out.write("\t    \tfunction dis(){\r\n");
      out.write("\t    \tsetTimeout(function(){\r\n");
      out.write("\t    \t    $('#condiv').css('display','none');\r\n");
      out.write("\t    \t    },2000);\r\n");
      out.write("\t    \t\r\n");
      out.write("\t    \t}\r\n");
      out.write("\t    \tvar checkTime = true;\r\n");
      out.write("\t    \tvar second = 0;\r\n");
      out.write("\t    \tvar iszx = true;\r\n");
      out.write("\t    \t\r\n");
      out.write("\t    \t\r\n");
      out.write("\t    \t\r\n");
      out.write("\t    \t\r\n");
      out.write("\t    \tfunction xianshi(resp){\r\n");
      out.write("\t        \tif(iszx){\r\n");
      out.write("\t        \t\t//alert(resp);\r\n");
      out.write("\t        \t}\r\n");
      out.write("\t        }\r\n");
      out.write("\t        //开始计时 \r\n");
      out.write("\t        function startit(mid){\r\n");
      out.write("\t        \tif(iszx){\r\n");
      out.write("\t        \t\tiszx = false;\r\n");
      out.write("\t\t\t       \tif (checkTime){\r\n");
      out.write("\t\t\t       \t\tcheckTime = false;\r\n");
      out.write("\t\t\t       \t\tfindstate(mid,second);\r\n");
      out.write("\t\t\t       \t}\r\n");
      out.write("\t\t\t       \t\r\n");
      out.write("\t\t        \tt = setTimeout(\"startit(\"+mid+\")\", 30000); //每隔3秒（3000毫秒）递归调用一次 \r\n");
      out.write("\t\t        \tsecond = second+3;\r\n");
      out.write("\t        \t}\r\n");
      out.write("\t        }\r\n");
      out.write("\t        \r\n");
      out.write("\t        function findstate(mid,second){\r\n");
      out.write("\t         \t$.ajax({\r\n");
      out.write("\t         \t\turl : \"");
      out.print(basePath);
      out.write("/client/findMission.do\",\r\n");
      out.write("\t         \t\tasync : false,\r\n");
      out.write("\t    \t\t\tdata: \"mid=\"+mid,\r\n");
      out.write("\t         \t\ttype : \"post\",\r\n");
      out.write("\t    \t  \t\tdataType : \"json\",\r\n");
      out.write("\t    \t   \t\tsuccess : function(data) {\r\n");
      out.write("\t         \t\t\tif(data.state == 2){\r\n");
      out.write("\t         \t\t\t\t$('#logdiv').css('display','none');\r\n");
      out.write("\t       \t  \t\t\t\talert(\"操作成功！\");\r\n");
      out.write("\t    \t     \t\t}else if(data.state == 3){\r\n");
      out.write("\t    \t     \t\t\t$('#logdiv').css('display','none');\r\n");
      out.write("\t    \t     \t\t\talert(\"操作失败：终端不在线！\");\r\n");
      out.write("\t    \t     \t\t}else if(data.state == 4){\r\n");
      out.write("\t    \t     \t\t\t$('#logdiv').css('display','none');\r\n");
      out.write("\t    \t     \t\t\t//alert(\"操作失败：超时无反应！\");\r\n");
      out.write("\t    \t     \t\t}else if(data.state == 5){\r\n");
      out.write("\t    \t     \t\t\t$('#logdiv').css('display','none');\r\n");
      out.write("\t    \t     \t\t\talert(\"操作失败，您没有权限！\");\r\n");
      out.write("\t    \t     \t\t}else if(second >= 15){\r\n");
      out.write("\t    \t     \t\t\tupState(mid);\r\n");
      out.write("\t    \t     \t\t\t$('#logdiv').css('display','none');\r\n");
      out.write("\t    \t     \t\t\t//alert(\"操作失败：超时无反应！\");\r\n");
      out.write("\t    \t     \t\t}else{\r\n");
      out.write("\t    \t     \t\t\tcheckTime = true;\r\n");
      out.write("\t    \t     \t\t\tiszx = true;\r\n");
      out.write("\t    \t     \t\t}\r\n");
      out.write("\t     \t\t\t}\r\n");
      out.write("\t         \t})\r\n");
      out.write("\t    \t}\r\n");
      out.write("\t        \r\n");
      out.write("\t        function upState(mid){\r\n");
      out.write("\t         \t$.ajax({\r\n");
      out.write("\t         \t\turl : \"");
      out.print(basePath);
      out.write("/client/upMissionState.do\",\r\n");
      out.write("\t         \t\tasync : false,\r\n");
      out.write("\t    \t\t\tdata: \"mid=\"+mid,\r\n");
      out.write("\t         \t\ttype : \"post\",\r\n");
      out.write("\t    \t  \t\tdataType : \"json\",\r\n");
      out.write("\t    \t   \t\tsuccess : function(data) {\r\n");
      out.write("\t     \t\t\t}\r\n");
      out.write("\t         \t})\r\n");
      out.write("\t    \t}\r\n");
      out.write("\t        \r\n");
      out.write("\t        //百度导航\r\n");
      out.write("\t        function dbmap(){\r\n");
      out.write("\t        \tandroid.bdMap(\"bdapp://map/marker?location=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${client.latitude}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(',');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${client.longitude}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("&title=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${client.name}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("&content=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${client.name}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("&traffic=on\");\r\n");
      out.write("\t        \t//window.location.href=\"bdapp://map/marker?location=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${client.latitude}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(',');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${client.longitude}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("&title=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${client.name}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("&content=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${client.name}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("&traffic=on\";\r\n");
      out.write("\t        }\r\n");
      out.write("\t        \r\n");
      out.write("\t        function funqwgjz(){\r\n");
      out.write("\t\t\t\tandroid.bdMap(\"bdapp://map/marker?location=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${client.latitude}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(',');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${client.longitude}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("&title=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${client.name}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("&content=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${client.name}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("&traffic=on\");\r\n");
      out.write("\t        \t//window.location.href=\"");
      out.print(basePath);
      out.write("/jsp/map.jsp?latitude=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${client.latitude}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("&longitude=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${client.longitude}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("&id=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${client.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("&uid=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${uid}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t        }\r\n");
      out.write("\t    </script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body>\r\n");
      out.write("\t\t<div class=\"content_page\">\r\n");
      out.write("\t\t\t<div class=\"top_page\">\r\n");
      out.write("\t\t\t\t<div class=\"nav\">\r\n");
      out.write("\t\t\t\t\t<div class=\"left-icon\" onclick=\"funBack()\">\r\n");
      out.write("\t\t\t\t\t\t<i class=\"iconfont\">&#xe743;</i>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<h1>设备状态</h1>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"right-icon\" onclick=\"funqwgjz()\">\r\n");
      out.write("\t\t\t\t\t\t<span>位置</span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"about-mac\">\r\n");
      out.write("\t\t\t\t<div class=\"swiper-container\">\r\n");
      out.write("\t\t\t        <div class=\"swiper-wrapper\" id=\"idcsxx\">\r\n");
      out.write("\t\t\t            ");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t        </div>\r\n");
      out.write("\t\t\t    </div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"operation\" id=\"idkg\"><!-- 这里是按钮指令和指示灯（指示灯可以不用操作） -->\r\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"modal\" id=\"mapdiv\">\r\n");
      out.write("\t\t\t<div class=\"modal-body\">\r\n");
      out.write("\t\t\t\t<div class=\"form-box\">\r\n");
      out.write("\t\t\t\t\t<h2>选择导航地图</h2>\r\n");
      out.write("\t\t\t\t\t<div class=\"map-list\">\r\n");
      out.write("\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t<li onclick=\"dbmap()\">百度地图</li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"btn-box\">\r\n");
      out.write("\t\t\t\t\t\t<button onclick=\"closeModal()\">关闭</button>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"modal-bg\" onclick=\"closeModal()\"></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"modal\" id=\"logdiv\">\r\n");
      out.write("\t\t\t<div class=\"modal-body\">\r\n");
      out.write("\t\t\t\t<div class=\"load-box\">\r\n");
      out.write("\t\t\t\t\t<p>指令执行中</p>\r\n");
      out.write("\t\t\t\t\t<img src=\"");
      out.print(path );
      out.write("/images/loading.gif\" />\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"modal-bg\" onclick=\"closeModal()\"></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"modal\" id=\"condiv\">\r\n");
      out.write("\t\t\t<div class=\"modal-body\">\r\n");
      out.write("\t\t\t\t<div class=\"form-box\">\r\n");
      out.write("\t\t\t\t\t<div class=\"modal-text\">\r\n");
      out.write("\t\t\t\t\t\t<p>确认是否执行!</p>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"btn-box\">\r\n");
      out.write("\t\t\t\t\t\t<button class=\"quxiao\" id=\"quxiao\"onclick=\"closecondiv()\">取消</button>\r\n");
      out.write("\t\t\t\t\t\t<button class=\"sure\" id=\"sure\"  onclick=\"funUpMission2()\">确定</button>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"modal-bg\" onclick=\"closecondiv()\"></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</body>\r\n");
      out.write("\t<script src=\"");
      out.print(path );
      out.write("/js/swiper.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(path );
      out.write("/js/width.js\"></script>\r\n");
      out.write("\t <script>\r\n");
      out.write("    var swiper = new Swiper('.swiper-container', {\r\n");
      out.write("        pagination: '.swiper-pagination',\r\n");
      out.write("        paginationClickable: true\r\n");
      out.write("    });\r\n");
      out.write("\r\n");
      out.write("    function openModal(){\r\n");
      out.write("    \t$('#mapdiv').css('display','block');\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction closeModal(){\r\n");
      out.write("\t    $('#mapdiv').css('display','none');\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction closecondiv(){\r\n");
      out.write("\t    setTimeout(function(){\r\n");
      out.write("\t   \t$('#quxiao').css(\"background-color\",\"#B2E0FF\");},50000);\r\n");
      out.write("\t   \tsetTimeout(function(){\r\n");
      out.write("\t   \t$('#quxiao').css(\"background-color\",\"#ffffff\");},2000);\r\n");
      out.write("\t    $('#condiv').css('display','none');\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t$(function(){\r\n");
      out.write("\t\tsetTimeout(\"ajaxFindClient()\", 3000); //每隔5秒（5000毫秒）递归调用一次 \r\n");
      out.write("\t})\r\n");
      out.write("\t\r\n");
      out.write("\tfunction ajaxFindClient(){\r\n");
      out.write("\t\tvar id = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${client.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("   \t\t\t\turl : \"");
      out.print(basePath);
      out.write("/client/ajaxFindClientTxt.do\",\r\n");
      out.write("   \t\t\t\tdata : \"id=\"+id,\r\n");
      out.write("   \t\t\t    async : false,\r\n");
      out.write("   \t\t\t    type : \"post\",\r\n");
      out.write("   \t\t\t \tdataType : \"json\",\r\n");
      out.write("   \t\t\t \tsuccess : function(data) {\r\n");
      out.write("   \t\t\t      \tif(data != null){\r\n");
      out.write("   \t\t\t      \t\t\r\n");
      out.write("   \t\t\t      \t\tvar idcsxx = \"\";\r\n");
      out.write("   \t\t\t      \t\t\r\n");
      out.write("   \t\t\t      \t\t\r\n");
      out.write("\t\t   \t\t\t\t\r\n");
      out.write("\t\t   \t\t\t\tvar csxxs = data.map.list;\r\n");
      out.write("\t\t   \t\t\t\tvar csxx;\r\n");
      out.write("\t\t   \t\t\t\tfor(var i = 0;csxxs.length > i;i++){\r\n");
      out.write("\t\t   \t\t\t\t\tcsxx = csxxs[i];\r\n");
      out.write("\t\t   \t\t\t\t\tif(i % 5 == 0){\r\n");
      out.write("\t\t   \t\t\t\t\t\tidcsxx+=\"<div class=\\\"swiper-slide\\\">\";\r\n");
      out.write("\t\t   \t\t\t\t\t\tidcsxx+=\"<ul class=\\\"pare-list\\\">\";\r\n");
      out.write("\t\t   \t\t\t\t\t}\r\n");
      out.write("\t\t\t            \t\r\n");
      out.write("\t\t   \t\t\t\t\tidcsxx+=\"<li>\";\r\n");
      out.write("\t   \t\t\t\t\t\tidcsxx+=\"<span class=\\\"title\\\">\"+csxx[0]+\"：</span>\";\r\n");
      out.write("\t   \t\t\t\t\t\tidcsxx+=\"<span class=\\\"pare\\\">\"+csxx[1]+\"</span>\";\r\n");
      out.write("\t   \t\t\t\t\t\tidcsxx+=\"</li>\";\r\n");
      out.write("\t\t   \t\t\t\t\t\t\r\n");
      out.write("\t   \t\t\t\t\t\tif((i+1) % 5 == 0 || (i+1) == csxxs.length){\r\n");
      out.write("\t   \t\t\t\t\t\t\tidcsxx+=\"</ul>\";\r\n");
      out.write("\t   \t\t\t\t\t\t\tidcsxx+=\"</div>\";\r\n");
      out.write("\t   \t\t\t\t\t\t}\r\n");
      out.write("\t\t   \t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t$(\"#idcsxx\").html(idcsxx);\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\tvar kghtml = \"\";\r\n");
      out.write("\t\t\t\t\t\tvar cmds = data.cmds;\r\n");
      out.write("\t\t\t\t\t\tvar cmd;\r\n");
      out.write("\t\t\t\t\t\tvar c = \"\";\r\n");
      out.write("\t\t\t\t\t\tvar active = \"\";\r\n");
      out.write("\t\t\t\t\t\tfor(var i = 0;cmds.length > i;i++){\r\n");
      out.write("\t\t\t\t\t\t\tcmd = cmds[i];\r\n");
      out.write("\t\t\t\t\t\t\tif(i % 4 == 0){\r\n");
      out.write("\t\t\t\t\t\t\t\tkghtml+=\"<ul class=\\\"oper-btn-list\\\">\";\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\tc = \",\"+cmd[0]+\",\";\r\n");
      out.write("\t\t\t\t\t\t\tactive = \"\";\r\n");
      out.write("\t\t\t\t\t\t\tif(data.map.led.indexOf(c) > -1)\r\n");
      out.write("\t\t\t\t\t\t\t\tactive = \"active\";\r\n");
      out.write("\t\t\t\t\t\t\tkghtml+=\"<li class=\\\"\"+ active +\"\\\" onclick=\\\"funUpMission('\"+cmd[2]+\"')\\\">\";\r\n");
      out.write("\t\t\t\t\t\t\tkghtml+=\"<div>\";\r\n");
      out.write("\t\t\t\t\t\t\tkghtml+=\"<i class=\\\"iconfont\\\">&#xe60a;</i>\";\r\n");
      out.write("\t\t\t\t\t\t\tkghtml+=\"<p>\"+cmd[1]+\"</p>\";\r\n");
      out.write("\t\t\t\t\t\t\tkghtml+=\"</div>\";\r\n");
      out.write("\t\t\t\t\t\t\tkghtml+=\"</li>\";\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\tif((i+1) % 4 == 0 || (i+1) == cmds.length)\r\n");
      out.write("\t\t\t\t\t\t\t\tkghtml+=\"</ul>\";\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t$(\"#idkg\").html(kghtml);\r\n");
      out.write("   \t\t\t      \t}\r\n");
      out.write("   \t\t\t\t}\r\n");
      out.write("   \t\t  \t});\r\n");
      out.write("\t\tsetTimeout(\"ajaxFindClient()\", 3000); //每隔5秒（5000毫秒）递归调用一次 \r\n");
      out.write("\t}\r\n");
      out.write("    </script>\r\n");
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

  private boolean _jspx_meth_c_005fforEach_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_005fvarStatus_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /jsp/basic.jsp(223,15) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("info");
    // /jsp/basic.jsp(223,15) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/jsp/basic.jsp(223,15) '${map.list }'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${map.list }",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /jsp/basic.jsp(223,15) name = varStatus type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVarStatus("st");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("<!-- map.list是设备的具体属性参数 -->\r\n");
          out.write("\t\t\t            \t");
          if (_jspx_meth_c_005fif_005f0(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write("\r\n");
          out.write("\t\t\t            \t\r\n");
          out.write("\t\t\t            \t<li>\r\n");
          out.write("\t\t\t\t\t\t\t\t<span class=\"title\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${info[0] }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("：</span><!-- title是标题：采样时间 -->\r\n");
          out.write("\t\t\t\t\t\t\t\t<span class=\"pare\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${info[1] }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</span><!-- pare是标题值：例如2017-9-25 12:19:22 -->\r\n");
          out.write("\t\t\t\t\t\t\t</li>\r\n");
          out.write("\t\t\t\t\t\t\t");
          if (_jspx_meth_c_005fif_005f1(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_005fvarStatus_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /jsp/basic.jsp(224,16) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${st.index % 5 == 0}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t            \t\t<div class=\"swiper-slide\">\r\n");
        out.write("\t\t\t\t\t\t\t\t\t<ul class=\"pare-list\">\r\n");
        out.write("\t\t\t            \t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /jsp/basic.jsp(233,7) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${(st.index+1) % 5 == 0 || (st.index+1) == fn:length(map.list) }", java.lang.Boolean.class, (PageContext)_jspx_page_context, _jspx_fnmap_0, false)).booleanValue());
    int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
    if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t            \t\t</ul>\r\n");
        out.write("\t\t\t\t            \t</div>\r\n");
        out.write("\t\t\t            \t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_005ftest.reuse(_jspx_th_c_005fif_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_005ftest.reuse(_jspx_th_c_005fif_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_005fvarStatus_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f1.setParent(null);
    // /jsp/basic.jsp(242,4) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f1.setItems(new org.apache.jasper.el.JspValueExpression("/jsp/basic.jsp(242,4) '${cmds }'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${cmds }",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /jsp/basic.jsp(242,4) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f1.setVar("cmd");
    // /jsp/basic.jsp(242,4) name = varStatus type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f1.setVarStatus("vs");
    int[] _jspx_push_body_count_c_005fforEach_005f1 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f1 = _jspx_th_c_005fforEach_005f1.doStartTag();
      if (_jspx_eval_c_005fforEach_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("<!-- cmds的list循环, cmd为单个对象，cmd[]-->\r\n");
          out.write("\t\t\t\t\t");
          if (_jspx_meth_c_005fif_005f2(_jspx_th_c_005fforEach_005f1, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f1))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t");
          if (_jspx_meth_c_005fset_005f0(_jspx_th_c_005fforEach_005f1, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f1))
            return true;
          out.write("<!-- cmd[0]是指令的编号 -->\r\n");
          out.write("\t\t\t\t\t<li class=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${fn:indexOf(map.led, cmd2) > -1 ? 'active' : '' }", java.lang.String.class, (PageContext)_jspx_page_context, _jspx_fnmap_1, false));
          out.write("\"  id=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${fn:replace(cmd2,\",\",\"\")}", java.lang.String.class, (PageContext)_jspx_page_context, _jspx_fnmap_2, false));
          out.write("\" onclick=\"funUpMission('");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cmd[2] }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("')\">\r\n");
          out.write("\t\t\t\t\t\t<div>\r\n");
          out.write("\t\t\t\t\t\t\t<i class=\"iconfont\">&#xe60a;</i>\r\n");
          out.write("\t\t\t\t\t\t\t<p>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cmd[1] }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</p>\r\n");
          out.write("\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t</li>\r\n");
          out.write("\t\t\t\t\t");
          if (_jspx_meth_c_005fif_005f3(_jspx_th_c_005fforEach_005f1, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f1))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f1.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_005fvarStatus_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f1);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f1);
    // /jsp/basic.jsp(243,5) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${(vs.index % 4) == 0 }", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f2 = _jspx_th_c_005fif_005f2.doStartTag();
    if (_jspx_eval_c_005fif_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t<ul class=\"oper-btn-list\">\r\n");
        out.write("\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_005ftest.reuse(_jspx_th_c_005fif_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_005ftest.reuse(_jspx_th_c_005fif_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f1);
    // /jsp/basic.jsp(246,5) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setVar("cmd2");
    // /jsp/basic.jsp(246,5) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setValue(new org.apache.jasper.el.JspValueExpression("/jsp/basic.jsp(246,5) ',${cmd[0] },'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),",${cmd[0] },",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
    if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f1)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f3 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f1);
    // /jsp/basic.jsp(253,5) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${((vs.index+1) % 4) == 0 ||  (vs.index+1) == fn:length(cmds) }", java.lang.Boolean.class, (PageContext)_jspx_page_context, _jspx_fnmap_0, false)).booleanValue());
    int _jspx_eval_c_005fif_005f3 = _jspx_th_c_005fif_005f3.doStartTag();
    if (_jspx_eval_c_005fif_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t</ul>\r\n");
        out.write("\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_005ftest.reuse(_jspx_th_c_005fif_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_005ftest.reuse(_jspx_th_c_005fif_005f3);
    return false;
  }
}
