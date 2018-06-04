<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
	<style type="text/css">
	body, html,#allmap {width: 100%;height: 100%;overflow: hidden;margin:0;font-family:"微软雅黑";}
	</style>
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=Mdvy0am1HLsPsv4dr1jEjF0rgfG1Pw9O"></script>
	<title>地图展示</title>
	<!-- ================== 基础样式表开始 ================== -->
	<link href="<%=path %>/css/style.css" rel="stylesheet" type="text/css" />
	<script src="<%=path %>/js/jquery2.1.1.min.js"></script>
	<link rel="stylesheet" href="<%=path %>/css/swiper.min.css">
	<!-- ================== 基础样式表结束 ================== -->
	<script type="text/javascript">
    	function funBack(){
    		var id = "<%=request.getParameter("id")%>";  
    		var uid = "<%=request.getParameter("uid")%>";  
    		window.location="<%=basePath%>/client/findClient.do?id="+id+"&uid="+uid;
    	}
    </script>
</head>
<body>
	<div style="height:100%>
	<div class="content_page">
			<div class="top_page">
				<div class="nav">
					<div class="left-icon" onclick="funBack()">
						<i class="iconfont">&#xe743;</i>
					</div>
					<h1>位置</h1>
				</div>
			</div>
	</div>
	<div id="allmap"></div>
	</div>
</body>
</html>
<script type="text/javascript">
	//百度地图API功能
	var map = new BMap.Map("allmap");
	
	var latitude = "<%=request.getParameter("latitude")%>";  
	var longitude = "<%=request.getParameter("longitude")%>";  
	
	var point = new BMap.Point(longitude,latitude);
	map.centerAndZoom(point, 17);
	map.enableScrollWheelZoom(true);
	
	// 编写自定义函数,创建标注
	function addMarker(point){
	  var marker = new BMap.Marker(point);
	  map.addOverlay(marker);
	}
	addMarker(point);
	
</script>
