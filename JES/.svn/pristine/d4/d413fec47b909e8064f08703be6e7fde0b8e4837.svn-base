<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!--[if !IE]><!-->
<html lang="en">
	<!--<![endif]-->

	<head>
		<meta charset="utf-8" />
		<title>炬集物联</title>
		<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" />
		<meta content="" name="description" />
		<meta content="" name="author" />
		<meta name="format-detection" content="telephone=no">
		<!-- ================== 基础样式表开始 ================== -->
		<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css" />
		<script src="<%=path %>/js/jquery2.1.1.min.js"></script>
		<!-- ================== 基础样式表结束 ================== -->
		<script type="text/javascript" src="<%=path %>/js/jquery.form.js"></script>
		<script type="text/javascript">
			//退出登录
			function funLogOut(){
				android.LogOut();
			}
			//个人设置
			function shezhi() {
				window.location = "http://121.43.164.71:8080/itcastTax/nsfw/users_editAppUI.action?users.id=${users.id }";
			}
			//银行卡
			function yinhangka() {
				window.location = "http://121.43.164.71:8080/itcastTax/nsfw/yhk_ApplistUI.action?yhk.usersNumber=${users.usernumber }";
			}
			//关于我们
			function guanyuwomen() {
				window.location = "http://www.jujiiot.com/jjwl/gywm-gsjs2.jsp";
			}
			
			//服务项目
			function fuwuxiangmu() {
				window.location = "http://www.jujiiot.com/jjwl/gywm-appfwxm.jsp";
			}
			
			//功能介绍
			function gongnengjs() {
				window.location = "http://www.jujiiot.com/jjwl/gywm-appgnjs.jsp";
			}
			
			function imgUpload() {
				$('#upImg').trigger("click");
			}
			
			$(function(){
				var options = {
					type: "Post",
					dataType: "Json",
					beforeSend: function () {
						$('#logdiv').css('display','block');
					},
					success: function (data) {
						$('#logdiv').css('display','none');
						if(data.code=="0"){
							//无刷新更新头像
							$("#headimg").attr("src",data.url);
						}else{
	    					alert("头像更新失败！")
						}
					},
					error: function (XMLHttpRequest, textStatus, errorThrown) {
						$('#logdiv').css('display','none');
						alert("头像更新错误！")
					}
				};
				

				$("#form_upload").ajaxForm(options);

				$("#upImg").change(function () {
					if($("#upImg").val().length > 0)
						$("#form_upload").submit();
				});
				
			});
		</script>
	</head>
	<body>
		<form id="form_upload" style="display:none;" action="<%=path %>/uploadFile/upHeadportrait2.do" method="post" enctype="multipart/form-data">
			<input type="hidden" id="uid" name="uid" value="${users.id }" />
			<input name="uploadFile" id="upImg" type="file" />
		</form>
		<div class="content_page">
			<div class="top_page">
				<div class="nav">
					<div class="left-icon">
					</div>
					<h1>我的</h1>
					<div class="right-icon">
					</div>
				</div>
			</div>
			<div class="user-box user-box-page">
				<div class="user-img-box" onclick="imgUpload()">
					<% long date = new Date().getTime(); request.setAttribute("date", date); %>
					<img id="headimg" src="<%=path%>/${users.headportrait }?time=${date}" alt="">
				</div>
				<div class="user-mes">
					<p class="name">${users.truename }<span>（${users.userlevel }）</span></p>
					<p class="num">${users.usernumber }</p>
				</div>
			</div>
			<ul class="card-list">
				<li onclick="fuwuxiangmu()">
					<i class="iconfont">&#xe702;</i>
					<span>服务项目</span>
					<i class="iconfont right-icon">&#xe62c;</i>
				</li>
				<li onclick="yinhangka()">
					<i class="iconfont">&#xe623;</i>
					<span>银行卡</span>
					<i class="iconfont right-icon">&#xe62c;</i>
				</li>				
			</ul>
			<ul class="card-list">
				<li onclick="gongnengjs()">
					<i class="iconfont">&#xe606;</i>
					<span>功能介绍</span>
					<i class="iconfont right-icon">&#xe62c;</i>
				</li>
				<li onclick="guanyuwomen()">
					<i class="iconfont">&#xe607;</i>
					<span>关于我们</span>
					<i class="iconfont right-icon">&#xe62c;</i>
				</li>
				<li onclick="shezhi()">
					<i class="iconfont">&#xe64b;</i>
					<span>个人设置</span>
					<i class="iconfont right-icon">&#xe62c;</i>
				</li>
			</ul>
			<ul class="card-list">
				<li onclick="funOutOpen()">
					<i class="iconfont">&#xe6e2;</i>
					<span>退出账号</span>
					<i class="iconfont right-icon">&#xe62c;</i>
				</li>
			</ul>
		</div>
		<div class="modal" id="mapdiv">
			<div class="modal-body">
				<div class="form-box">
					<div class="modal-text">
						<p>确认是否退出登录!</p>
					</div>
					<div class="btn-box">
						<button onclick="funOutclose()">取消</button>
						<button onclick="funLogOut()">确定</button>
					</div>
				</div>
			</div>
			<div class="modal-bg" onclick="closeModal()"></div>
		</div>
		
		<div class="modal" id="logdiv">
			<div class="modal-body">
				<div class="load-box">
					<p>头像上传中</p>
					<img src="<%=path %>/images/loading.gif" />
				</div>
			</div>
			<div class="modal-bg" onclick="closeModal()"></div>
		</div>
		
	</body>
	<script type="text/javascript" src="<%=path%>/js/width.js"></script>
	<script type="text/javascript" src="<%=path%>/js/base.js"></script>
	<script type="text/javascript">
		function funOutOpen(){
			$('#mapdiv').css('display','block');
		}
		function funOutclose(){
			$('#mapdiv').css('display','none');
		}
	</script>
</html>