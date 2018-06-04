<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
</head>
<body>
	<div id="allmap"></div>
</body>
</html>
<script type="text/javascript">
	//百度地图API功能
	var map = new BMap.Map("allmap");
	var point = new BMap.Point(119.302254,26.080962);
	map.centerAndZoom(point, 17);
	map.enableScrollWheelZoom(true);
	
	// 编写自定义函数,创建标注
	function addMarker(point){
	  var marker = new BMap.Marker(point);
	  map.addOverlay(marker);
	}
	
	
	
	function addMarker2(point){
		
		var removeMarker = function(e,ee,marker){
			map.removeOverlay(marker2);
		}
		//创建右键菜单
		var markerMenu=new BMap.ContextMenu();
		markerMenu.addItem(new BMap.MenuItem('删除',removeMarker.bind(marker2)));
		
		var myIcon = new BMap.Icon("xxxb.png", new BMap.Size(34,45));
		var marker2 = new BMap.Marker(point,{icon:myIcon});  // 创建标注
		map.addOverlay(marker2);              // 将标注添加到地图中
		marker2.addContextMenu(markerMenu);
	}
	
	point = new BMap.Point(119.316052,26.059673);
	addMarker(point);
	point = new BMap.Point(119.31907,26.103546);
	addMarker(point);
	point = new BMap.Point(119.314184,26.092774);
	addMarker(point);
	point = new BMap.Point(119.330138,26.105622);
	addMarker(point);
	point = new BMap.Point(119.297942,26.078496);
	addMarker(point);
	point = new BMap.Point(119.333731,26.069279);
	addMarker(point);
	point = new BMap.Point(119.307285,26.058244);
	addMarker(point);
	
	//创建小狐狸
	point = new BMap.Point(119.287594,26.091735);
	addMarker2(point);
	point = new BMap.Point(119.326113,26.080897);
	addMarker2(point);
	point = new BMap.Point(119.355578,26.089788);
	addMarker2(point);
	point = new BMap.Point(119.305344,26.091346);
	addMarker2(point);
</script>
