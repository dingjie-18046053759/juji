<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
             <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>管理首页</title>
    <link href="<%=basePath%>skin/default/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="<%=basePath%>js/jquery/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/layout.js"></script>
</head>

<body class="mainbody">
    <form id="form1">
        <!--导航栏-->
        <div class="location">
            <a href="javascript:history.back(-1);" class="back"><i></i><span>返回上一页</span></a>
            <a class="home"><i></i><span>首页</span></a>
            <i class="arrow"></i>
            <span>管理中心</span>
        </div>
        <!--/导航栏-->
        <!--内容-->
        <div class="line10" style="padding-top:30px;"></div>
        <div class="nlist-1">
            <ul>
                <li>本次登录IP：<a>127.0.0.1</a></li>
                <li>上次登录IP：<a>127.0.0.1</a></li>
                <li>上次登录时间：<a>2015-2-3</a></li>
            </ul>
            
        </div>
        <div class="line10"></div>

        <div class="nlist-2">
            <h3><i></i>站点信息</h3>
            <ul>
            	<li>注册人数：<span tyle="color:red;">${numCols[1] }</span></li>
            	<li>活动数量：<span tyle="color:red;">${numCols[0] }</span></li>
                <li>站点名称：校区活动交友</li>
                <li>公司名称：软件工作室</li>
                <li>网站域名：http://localhost/</li>
                <li>安装目录：/</li>
                <li>网站管理目录：admin</li>
                <li>附件上传目录：upload</li>
                <li>服务器名称：HUIHUI</li>
                <li>服务器IP：127.0.0.1</li>
                <li>Java框架版本：1.6JDK</li>
                <li>操作系统：Windows Server 2008 6.2.9200.0</li>
                <li>IIS环境：</li>
                <li>服务器端口：80</li>
                <li>目录物理路径：D:\hospital.Web\</li>
                <li>系统版本：V1.0.0</li>
            </ul>
        </div>
        <div class="line20"></div>


        <!--/内容-->
    </form>
</body>
</html>
