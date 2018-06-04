<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>基本参数</title>
    <base href="<%=basePath%>">
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel="shortcut icon" href="/favicon.ico">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="stylesheet" href="//g.alicdn.com/msui/sm/0.6.2/css/sm.min.css">
    <style type="text/css">
    </style>
    <script type="text/javascript">
    	function funBack(){
    		window.location="<%=basePath%>/client/findClientList.do?uid=${uid }";
    	}
    	
    	function funDetailed(){
			window.location="<%=basePath%>/client/findClientInfo.do?uid=${uid }&id=${client.id }";
    	}
    	
    	function funUpMission(cmd){
    		$.showPreloader("指令执行中");
    		var uid = "${uid}";
    		var sn = "${client.sn}";
    		if(uid == null || uid == ""){
    			alert("用户ID为空！");
    			$.hidePreloader();
    			return;
    		}
    		if(sn == null || sn == ""){
    			alert("设备编号为空！");
    			$.hidePreloader();
    			return;
    		}
    		if(cmd == null || cmd == ""){
    			alert("操作指令为空！");
    			$.hidePreloader();
    			return;
    		}
    		$.ajax({
   				url : "<%=basePath%>/client/upMission.do",
   			    async : false,
   			    type : "post",
   			    data : "uid="+uid+"&sn="+sn+"&cmd="+cmd,
   			 	dataType : "json",
   			 	success : function(data) {
   			      	if(data.respCode == 0){
					checkTime = true;
    					second = 0;
    					iszx = true;
   			      		startit(data.mid);
   				    } else {
   				    	alert(data.respMsg);
   				    	$.hidePreloader();
   				    }
   				}
   		  	});
    	}
    	
    	var checkTime = true;
    	var second = 0;
    	var iszx = true;
        //开始计时 
        function startit(mid){
        	if(iszx){
        		iszx = false;
		       	if (checkTime){
		       		checkTime = false;
		       		findstate(mid,second);
		       	}
		       	
	        	t = setTimeout("startit("+mid+")", 3000); //每隔3秒（3000毫秒）递归调用一次 
	        	second = second+3;
        	}
        }
        
        function findstate(mid,second){
         	$.ajax({
         		url : "<%=basePath%>/client/findMission.do",
         		async : false,
    			data: "mid="+mid,
         		type : "post",
    	  		dataType : "json",
    	   		success : function(data) {
         			if(data.state == 2){
         				$.hidePreloader();
       	  				alert("操作成功！");
    	     		}else if(data.state == 3){
    	     			$.hidePreloader();
    	     			alert("操作失败：终端不在线！");
    	     		}else if(data.state == 4){
    	     			$.hidePreloader();
    	     			alert("操作失败：超时无反应！");
    	     		}else if(data.state == 5){
    	     			$.hidePreloader();
    	     			alert("操作失败，您没有权限！");
    	     		}else if(second >= 15){
    	     			upState(mid);
    	     			$.hidePreloader();
    	     			alert("操作失败：超时无反应！");
    	     		}else{
    	     			checkTime = true;
    	     			iszx = true;
    	     		}
     			}
         	})
    	}
        
        function upState(mid){
         	$.ajax({
         		url : "<%=basePath%>/client/upMissionState.do",
         		async : false,
    			data: "mid="+mid,
         		type : "post",
    	  		dataType : "json",
    	   		success : function(data) {
     			}
         	})
    	}
    </script>
  </head>
  
  <body>
  	<div class="page"  style="background-color: white;">
  	<header class="bar bar-nav">
  		<a class="icon pull-left" onclick="funBack()"><img src="images/back.png" /></a>
  		<h1 class="title" style="font-weight: bold;">基本参数</h1>
  		<a class="icon pull-right open-panel" onclick=""><img width="30px" src="images/b3.png" /></a>
	</header>
	<table style="margin-top: 50px;width: 100%;line-height: 35px;font-weight: bold;">
		<tr>
			<td>连接状态</td>
			<td>
				<c:if test="${client.state == 1 }">
					正常
				</c:if>
				<c:if test="${client.state == 2 }">
					超时
				</c:if>
				<c:if test="${client.state == 3 }">
					离线
				</c:if>
				<c:if test="${client.state == 4 }">
					故障
				</c:if>
				<c:if test="${client.state == 5 }">
					无线
				</c:if>
			</td>
		</tr>
		<tr>
			<td>信息</td>
			<td>${client.name }</td>
		</tr>
		<tr>
			<td>编号</td>
			<td>${client.sn }</td>
		</tr>
		<tr>
			<td>类型</td>
			<td>${client.type }</td>
		</tr>
		<tr>
			<td>控制器型号</td>
			<td>${client.controllermodel }</td>
		</tr>
	</table>
	<div style="margin-bottom: 10px;">
	    <div class="row">
	      <div class="col-50" onclick="funDetailed()"><a href="javascript:;" class="button button-big button-fill" 

style="font-weight: bold;">详细参数</a></div>
	      <div class="col-50" onclick="alert('建设中！')"><a href="javascript:;" class="button button-big button-fill" 

style="font-weight: bold;">导航</a></div>
	    </div>
  	</div>
	<iframe src="jsp/map.jsp?latitude=${client.latitude }&longitude=${client.longitude }" width=375 height="250" 

frameborder="0" scrolling="no"></iframe>
  	</div>
  	
	 <!-- popup, panel 等放在这里 -->
    <div class="panel-overlay"></div>
    <!-- Left Panel with Reveal effect -->
    <div class="panel panel-right panel-reveal">
        <div class="content-block">
        	<c:forEach items="${cmds }" var="cmd" varStatus="vs">
            <p style="font-size: 20px;font-weight: bold;color: white;" onclick="funUpMission('${cmd[1] }')"><img src="images/${vs.index+1 }.png" style="width: 25px; height: 25px;" />${cmd[0] }</p>
			</c:forEach>
        </div>
    </div>
<script type='text/javascript' src='//g.alicdn.com/sj/lib/zepto/zepto.min.js' charset='utf-8'></script>
    <script type='text/javascript' src='//g.alicdn.com/msui/sm/0.6.2/js/sm.min.js' charset='utf-8'></script>
  </body>
</html>