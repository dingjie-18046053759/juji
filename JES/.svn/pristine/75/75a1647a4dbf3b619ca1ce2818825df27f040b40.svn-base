<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>炬集物联</title>
<meta
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"
	name="viewport" />
<meta content="" name="description" />
<meta content="" name="author" />
<meta http-equiv="expires" content="0" />
<!-- ================== 基础样式表开始 ================== -->
<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css" />
<script src="<%=path%>/js/jquery2.1.1.min.js"></script>
<link rel="stylesheet" href="<%=path%>/css/swiper.min.css">
<script src="<%=path%>/js/jquery-1.7.min.js" type="text/javascript"></script>
<script src="<%=path%>/js/Area.js" type="text/javascript"></script>
<script src="<%=path%>/js/AreaData_min.js" type="text/javascript"></script>

<!-- ================== 基础样式表结束 ================== -->
<script type="text/javascript">
	var num = null;
	//获取未读信息数量，页面加载前完成
	$(function() {
		var account = '${users.id }';
		if (account != "") {
			$
					.ajax({
						type : "get",
						async : false,
						url : "http://www.jujiiot.com/nsfw/gcs_getUnReadMessage.action",
						data : {
							"gcs.gcsNumber" : account
						},
						dataType : "jsonp",
						jsonp : "callback",
						jsonpCallback : "getUnReadMessage",
						success : function(data) {
						},
						error : function() {
							alert('fail');
						}
					});
		}

		//window.location = "http://www.jujiiot.com/nsfw/gcs_getUnReadMessage.action?gcs.gcsNumber=${users.usernumber }";	
	});
	function getUnReadMessage(data) {
		//alert("通过JSONP获取到的NUM" + data.num);
		if(data.num>0){
		document.getElementById("hello").innerText = data.num;
		}else{
		var a=document.getElementsByClassName("news")[0];
		a.setAttribute("style","display:none");
		}
		
	}

	//window.onload=function()
	//{  
	//    var account = ${users.usernumber };
	//    if(account != ""){ 
	//	$.ajax({
	//			url : "http://www.jujiiot.comnsfw/gcs_getUnReadMessage.action",
	//			type : "post",
	//			data: {"gcs.gcsNumber":account},
	//			//async : false,//非异步
	//			success : function(msg) {
	//			    alert(msg);
	//				num = msg;
	//			}
	//		});
	//		}
	//		//window.location = "http://www.jujiiot.comnsfw/gcs_getUnReadMessage.action?gcs.gcsNumber=${users.usernumber }";
	//		alert(num);
	//		document.getElementById("hello").innerText = num;
	//	}
	//所有订单
	function OrderList() {
		window.location = "http://121.43.164.71:8080/itcastTax/nsfw/order_listAppUI.action?order.gcsNum=${users.usernumber }";
	}
	//客户评价
	function kehupingjia() {
		window.location = "http://121.43.164.71:8080/itcastTax/nsfw/order_listPjUI.action?order.gcsNum=${users.usernumber }";
	}
	//未接订单
	function weijieList() {
		window.location = "http://121.43.164.71:8080/itcastTax/nsfw/order_listWjAppUI.action?order.gcsNum=${users.usernumber }";
	}
	//待解决订单
	function djjList() {
		window.location = "http://121.43.164.71:8080/itcastTax/nsfw/order_listDjjAppUI.action?order.gcsNum=${users.usernumber }";
	}
	//费用代收
	function daishou() {
		window.location = "http://www.jujiiot.com/jjwl/FeiYongDaiShou.jsp"
	}
	//我的收入
	function qianbao() {
		window.location = "http://121.43.164.71:8080/itcastTax/nsfw/order_qianbao.action?order.gcsNum=${users.usernumber }";
	}
	//备件查询
	function findBeijian() {
		window.location = "http://www.jujiiot.com/nsfw/info_APPcpzlfdjzListUI.action?info.firstLevel=cpzl&info.secondLevel=fdjz";
	}
	//我的进修
	function jinxiu() {
		window.location = "http://www.jujiiot.com/nsfw/info_appjinxiuListUI.action?info.type=APPjinxiu";
	}
	//未读消息
	function unReadMessage() {
		window.location = "http://www.jujiiot.com/nsfw/info_appinfoListUI.action?info.type=APP&info.memo=${users.id }";
	}

	//联系客服
	function funLxkf() {
		android.openHxService("j18");
	}
</script>
</head>
<body>
	<div class="content">
		<div class="top">
			<div class="state"></div>
			<div class="nav">
				<div class="left-icon">

					<span>${users.city }</span>
					<!--<a class="iconfont"  href="javascript:changecity()">&#xe62e;</a>-->
					<a class="iconfont">&#xe62e;</a> <br>
					<form name="form1" action="" method="post"
						enctype="multipart/form-data"></form>

				</div>
				<h1>炬集物联</h1>
				<div class="right-icon">
					<!-- 查看消息图标 -->
					<i class="iconfont" onclick="unReadMessage()">&#xe63c;</i>
					<!-- 未读消息数量 -->
					<span class="news" id="hello"></span>
				</div>
			</div>
			<div class="banner">
				<div class="swiper-container">
					<div class="swiper-wrapper">
						<div class="swiper-slide">
							<img src="<%=path%>/images/banner.jpg" alt="">
						</div>
						<div class="swiper-slide">
							<img src="<%=path%>/images/banner2.jpg" alt="">
						</div>
						<div class="swiper-slide">
							<img src="<%=path%>/images/banner3.jpg" alt="">
						</div>
					</div>
					<div class="swiper-pagination"></div>
				</div>
			</div>
		</div>
		<div class="icon-list">
			<div class="user-box">
				<div class="user-img-box">
					<%
						long date = new Date().getTime();
						request.setAttribute("date", date);
					%>
					<img src="<%=path%>/${users.headportrait }?time=${date}" alt="">
				</div>
				<div class="user-mes">
					<p class="name">
						${users.truename }<span>${users.userlevel }</span>
					</p>
					<p class="num">${users.usernumber }</p>
				</div>
			</div>
			<div class="icon-box">
				<ul>
					<li onclick="OrderList()">
						<div class="ico">
							<i class="iconfont">&#xe742;</i>
						</div>
						<p>全部订单</p></li>
					<li onclick="weijieList()">
						<div class="ico">
							<i class="iconfont">&#xe603;</i>
						</div>
						<p>待接单</p></li>
					<li onclick="djjList()">
						<div class="ico">
							<i class="iconfont">&#xe672;</i>
						</div>
						<p>待解决</p></li>
					<li onclick="kehupingjia()">
						<div class="ico">
							<i class="iconfont">&#xe620;</i>
						</div>
						<p>客户评价</p></li>
					<li onclick="daishou()">
						<div class="ico">
							<i class="iconfont">&#xe60e;</i>
						</div>
						<p>费用代收</p></li>
					<li onclick="findBeijian()">
						<div class="ico">
							<i class="iconfont">&#xe639;</i>
						</div>
						<p>备件查询</p></li>
					<li onclick="qianbao()">
						<div class="ico">
							<i class="iconfont">&#xe665;</i>
						</div>
						<p>我的收入</p></li>
					<li onclick="jinxiu()">
						<div class="ico">
							<i class="iconfont">&#xe698;</i>
						</div>
						<p>我的进修</p></li>
					<li onclick="funLxkf()">
						<div class="ico">
							<i class="iconfont">&#xe63d;</i>
						</div>
						<p>意见反馈</p></li>
				</ul>
			</div>
		</div>
	</div>
	<script>
		
	</script>
</body>

<script src="<%=path%>/js/swiper.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/width.js"></script>
<script type="text/javascript" src="<%=path%>/js/base2.js"></script>
</html>