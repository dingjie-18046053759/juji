<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
  	<meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-

scalable=no" />
   	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>详细参数</title>
    <base href="<%=basePath%>">
    <%@ include file="/SUIMobile.jsp"%>
    <style type="text/css">
    	.s1{
    		width: 33%;
    		background-color: #F0F076;
    		display: inline-block;
    		text-align: center;
    	}
    	.s2{
    		width: 33%;
    		display: inline-block;
    		text-align: center;
    		background-color: #BAE708;
    	}
    	.s3{
    		width: 33%;
    		display: inline-block;
    		text-align: center;
    		background-color: #CC99A3;
    	}
	    .odd{  
	        background-color: #f2f2f2;  
	    }  
	    .even{  
	        background-color: #dddddd;  
	    }  
    </style>
    <script type="text/javascript">
    	function funBack(){
    		window.location="<%=basePath%>/client/findClient.do?id=${map.id}&uid=${uid}";
    	}
    </script>
  </head>
  
  <body style="background-color: white;">
  
  	<header class="bar bar-nav" style="position:fixed; top:0; left: 0;">
  		<a class="icon pull-left" onclick="funBack()"><img src="images/back.png" /></a>
  		<h1 class="title" style="font-weight: bold;">详细参数<span style="font-size: 10px;">-${map.name }</span></h1>
	</header>
	<table style="margin-top: 50px;width: 100%;line-height: 35px;font-weight: bold;">
		<c:forEach var="info" items="${map.list }" varStatus="st">
		<tr class="${st.index%2==0?'':'odd' }">
			<td width="50%" style="padding-left:10px;">${info[0] }</td>
			<td width="50%">${info[1] }</td>
		</tr>
		</c:forEach>
	</table>
  </body>
</html>