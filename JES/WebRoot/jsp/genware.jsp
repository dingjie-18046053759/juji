<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%      
response.setHeader("Pragma","No-cache");      
response.setHeader("Cache-Control","no-cache");      
response.setDateHeader("Expires", -10);     
%> 
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="pragma" content="no-cache">   
    <meta http-equiv="cache-control" content="no-cache">   
    <meta http-equiv="expires" content="-1">   
	<meta charset="utf-8" />
	<title>炬集物联</title>
	<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" />
	<meta content="" name="description" />
	<meta content="" name="author" />
	<meta name="format-detection" content="telephone=no">
	<!-- ================== 基础样式表开始 ================== -->
	<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css" />
	<!-- ================== 基础样式表结束 ================== -->
    <script type="text/javascript">
	    function funBasic(id){
			window.location="<%=path%>/client/findClient.do?uid=${uid }&id="+id;
		}
    </script>
  </head>
  
  <body>
  	<div class="content_page">
		<div class="top_page">
			<div class="nav">
				<div class="left-icon">
				</div>
				<h1>设备</h1>
				<div class="right-icon">
				</div>
			</div>
		</div>
		<div class="mac-box">
			<ul class="state-list">
				<li class="normal">
					<i class="iconfont">&#xe626;</i>
					<span>正常</span>
				</li>
				<li class="overtime">
					<i class="iconfont">&#xe705;</i>
					<span>超时</span>
				</li>
				<li class="offline">
					<i class="iconfont">&#xe63a;</i>
					<span>离线</span>
				</li>
				<li class="fault">
					<i class="iconfont">&#xe612;</i>
					<span>故障</span>
				</li>
				<li class="invalid">
					<i class="iconfont">&#xe6da;</i>
					<span>无效</span>
				</li>
			</ul>
			<c:set var="z1" value=""></c:set>
			<c:set var="z2" value=""></c:set>
			<c:forEach var="info" items="${list }" varStatus="vs">
				<c:if test="${info[3] == 1 }">
					<c:if test="${vs.index != 0 }">
						</dl>
					</c:if>
					<dl class="mac-list">
					<dt>${info[2] }</dt>
				</c:if>
				<c:if test="${info[3] == 2 }">
					<c:if test="${info[4] == 1 }"><c:set var="z1" value="normal"></c:set><c:set var="z2" value="&#xe626;"></c:set></c:if>
					<c:if test="${info[4] == 2 }"><c:set var="z1" value="overtime"></c:set><c:set var="z2" value="&#xe705;"></c:set></c:if>
					<c:if test="${info[4] == 3 }"><c:set var="z1" value="offline"></c:set><c:set var="z2" value="&#xe63a;"></c:set></c:if>
					<c:if test="${info[4] == 4 }"><c:set var="z1" value="fault"></c:set><c:set var="z2" value="&#xe612;"></c:set></c:if>
					<c:if test="${info[4] == 5 }"><c:set var="z1" value="invalid"></c:set><c:set var="z2" value="&#xe6da;"></c:set></c:if>
				    <dd class="${z1 }" onclick="funBasic(${info[0]})">
						<i class="iconfont">${z2 }</i>
						<span>${info[1] }</span>
					</dd>
				</c:if>
			</c:forEach>
			</dl>
		</div>
	</div>
  </body>
  <script type="text/javascript" src="<%=path%>/js/width.js"></script>
</html>