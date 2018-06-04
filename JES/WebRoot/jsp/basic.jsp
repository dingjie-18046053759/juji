<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%
response.setHeader("Pragma","No-cache");
response.setHeader("Cache-Control","no-cache");
response.setDateHeader("Expires", 0);
%>
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
		<link href="<%=path %>/css/style.css" rel="stylesheet" type="text/css" />
		<script src="<%=path %>/js/jquery2.1.1.min.js"></script>
		<link rel="stylesheet" href="<%=path %>/css/swiper.min.css">
		<!-- ================== 基础样式表结束 ================== -->
		<script type="text/javascript">
	    	function funBack(){
	    		window.location="<%=basePath%>/client/findClientList.do?uid=${uid }";
	    	}
	    	
	    	function funDetailed(){
				window.location="<%=basePath%>/client/findClientInfo.do?uid=${uid }&id=${client.id }";
	    	}
	    	
	    	var cmdz = "";
	    	function funUpMission(cmd){
	    		if(cmd == "无"){
	    			return;
	    		}
	    		cmdz = cmd;
	    		$('#condiv').css('display','block');
	    	}
	    	
	    	function funUpMission2(){

	   			$('#sure').css("background-color","#B2E0FF");

	   			setTimeout(function(){
	   	        $('#sure').css("background-color","#ffffff");
	   	                    },500);
	   	        dis();
	    		
	    		var cmd = cmdz;
	    		cmdz = "";
	    			    		
	    		var uid = "${uid}";
	    		var sn = "${client.sn}";
	    		if(uid == null || uid == ""){
	    			alert("用户ID为空！");
	    			$('#logdiv').css('display','none');
	    			return;
	    		}
	    		if(sn == null || sn == ""){
	    			alert("设备编号为空！");
	    			$('#logdiv').css('display','none');
	    			return;
	    		}
	    		if(cmd == null || cmd == ""){
	    			alert("操作指令为空！");
	    			$('#logdiv').css('display','none');
	    			return;
	    		}
	    		$('#logdiv').css('display','block');
	    		$.ajax({
	   				url : "<%=basePath%>/client/upMission.do",
	   			    async : false,
	   			    type : "post",
	   			    data : "uid="+uid+"&sn="+sn+"&cmd="+cmd,
	   			 	dataType : "json", 
	   			 	success : function(data) {
	   			      	if(data.respCode == 1){//成功
  	                        setTimeout(function(){
	    	                    $('#logdiv').css('display','block');
                            },6000);
	   				    	setTimeout(function(){
	   				    		$('#logdiv').css('display','none');
	   				    	},8000);
	   				    	
	   				    	setTimeout(function(){
	   				    		alert(data.respMsg);
	   				    	},8000);
	   				    } else {//失败
	   				    	//alert(data.respMsg);
	   				    	checkTime = true;
	    					second = 0;
	    					iszx = true;
							setTimeout(function(){
	    	                 $('#logdiv').css('display','block');
                            },6000);
	    					setTimeout(function(){
	   				    		$('#logdiv').css('display','none');
	   				    	},7000);
	   				    	
	   				    	setTimeout(function(){
	   				    		alert(data.respMsg);
	   				    	},8000);
	   			      		startit(data.mid);
	   				    	
	   				    }
	   				}
	   		  	});
	    	}
	    	//确认按钮消失
	    	function dis(){
	    	setTimeout(function(){
	    	    $('#condiv').css('display','none');
	    	    },2000);
	    	
	    	}
	    	var checkTime = true;
	    	var second = 0;
	    	var iszx = true;
	    	
	    	
	    	
	    	
	    	function xianshi(resp){
	        	if(iszx){
	        		//alert(resp);
	        	}
	        }
	        //开始计时 
	        function startit(mid){
	        	if(iszx){
	        		iszx = false;
			       	if (checkTime){
			       		checkTime = false;
			       		findstate(mid,second);
			       	}
			       	
		        	t = setTimeout("startit("+mid+")", 30000); //每隔3秒（3000毫秒）递归调用一次 
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
	         				$('#logdiv').css('display','none');
	       	  				alert("操作成功！");
	    	     		}else if(data.state == 3){
	    	     			$('#logdiv').css('display','none');
	    	     			alert("操作失败：终端不在线！");
	    	     		}else if(data.state == 4){
	    	     			$('#logdiv').css('display','none');
	    	     			//alert("操作失败：超时无反应！");
	    	     		}else if(data.state == 5){
	    	     			$('#logdiv').css('display','none');
	    	     			alert("操作失败，您没有权限！");
	    	     		}else if(second >= 15){
	    	     			upState(mid);
	    	     			$('#logdiv').css('display','none');
	    	     			//alert("操作失败：超时无反应！");
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
	        
	        //百度导航
	        function dbmap(){
	        	android.bdMap("bdapp://map/marker?location=${client.latitude},${client.longitude}&title=${client.name}&content=${client.name}&traffic=on");
	        	//window.location.href="bdapp://map/marker?location=${client.latitude},${client.longitude}&title=${client.name}&content=${client.name}&traffic=on";
	        }
	        
	        function funqwgjz(){
				android.bdMap("bdapp://map/marker?location=${client.latitude},${client.longitude}&title=${client.name}&content=${client.name}&traffic=on");
	        	//window.location.href="<%=basePath%>/jsp/map.jsp?latitude=${client.latitude}&longitude=${client.longitude}&id=${client.id}&uid=${uid}";
	        }
	    </script>
	</head>
	<body>
		<div class="content_page">
			<div class="top_page">
				<div class="nav">
					<div class="left-icon" onclick="funBack()">
						<i class="iconfont">&#xe743;</i>
					</div>
					<h1>设备状态</h1>
<%--					<div class="right-icon" onclick="openModal()">--%>
					<div class="right-icon" onclick="funqwgjz()">
						<span>位置</span>
					</div>
				</div>
			</div>
			<div class="about-mac">
				<div class="swiper-container">
			        <div class="swiper-wrapper" id="idcsxx">
			            <c:forEach var="info" items="${map.list }" varStatus="st"><!-- map.list是设备的具体属性参数 -->
			            	<c:if test="${st.index % 5 == 0}">
			            		<div class="swiper-slide">
									<ul class="pare-list">
			            	</c:if>
			            	
			            	<li>
								<span class="title">${info[0] }：</span><!-- title是标题：采样时间 -->
								<span class="pare">${info[1] }</span><!-- pare是标题值：例如2017-9-25 12:19:22 -->
							</li>
							<c:if test="${(st.index+1) % 5 == 0 || (st.index+1) == fn:length(map.list) }">
				            		</ul>
				            	</div>
			            	</c:if>
						</c:forEach>
			        </div>
			    </div>
			</div>
			<div class="operation" id="idkg"><!-- 这里是按钮指令和指示灯（指示灯可以不用操作） -->
				<c:forEach items="${cmds }" var="cmd" varStatus="vs"><!-- cmds的list循环, cmd为单个对象，cmd[]-->
					<c:if test="${(vs.index % 4) == 0 }">
						<ul class="oper-btn-list">
					</c:if>
					<c:set var="cmd2" value=",${cmd[0] },"></c:set><!-- cmd[0]是指令的编号 -->
					<li class="${fn:indexOf(map.led, cmd2) > -1 ? 'active' : '' }"  id="${fn:replace(cmd2,",","")}" onclick="funUpMission('${cmd[2] }')">
						<div>
							<i class="iconfont">&#xe60a;</i>
							<p>${cmd[1] }</p>
						</div>
					</li>
					<c:if test="${((vs.index+1) % 4) == 0 ||  (vs.index+1) == fn:length(cmds) }">
						</ul>
					</c:if>
				</c:forEach>
			</div>
		</div>
		<div class="modal" id="mapdiv">
			<div class="modal-body">
				<div class="form-box">
					<h2>选择导航地图</h2>
					<div class="map-list">
						<ul>
							<li onclick="dbmap()">百度地图</li>
						</ul>
					</div>
					<div class="btn-box">
						<button onclick="closeModal()">关闭</button>
					</div>
				</div>
			</div>
			<div class="modal-bg" onclick="closeModal()"></div>
		</div>
		<div class="modal" id="logdiv">
			<div class="modal-body">
				<div class="load-box">
					<p>指令执行中</p>
					<img src="<%=path %>/images/loading.gif" />
				</div>
			</div>
			<div class="modal-bg" onclick="closeModal()"></div>
		</div>
		<div class="modal" id="condiv">
			<div class="modal-body">
				<div class="form-box">
					<div class="modal-text">
						<p>确认是否执行!</p>
					</div>
					<div class="btn-box">
						<button class="quxiao" id="quxiao"onclick="closecondiv()">取消</button>
						<button class="sure" id="sure"  onclick="funUpMission2()">确定</button>
					</div>
				</div>
			</div>
			<div class="modal-bg" onclick="closecondiv()"></div>
		</div>
	</body>
	<script src="<%=path %>/js/swiper.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/width.js"></script>
	 <script>
    var swiper = new Swiper('.swiper-container', {
        pagination: '.swiper-pagination',
        paginationClickable: true
    });

    function openModal(){
    	$('#mapdiv').css('display','block');
	}
	function closeModal(){
	    $('#mapdiv').css('display','none');
	}
	
	function closecondiv(){
	    setTimeout(function(){
	   	$('#quxiao').css("background-color","#B2E0FF");},50000);
	   	setTimeout(function(){
	   	$('#quxiao').css("background-color","#ffffff");},2000);
	    $('#condiv').css('display','none');
	}
	
	$(function(){
		setTimeout("ajaxFindClient()", 3000); //每隔5秒（5000毫秒）递归调用一次 
	})
	
	function ajaxFindClient(){
		var id = "${client.id}"
			$.ajax({
   				url : "<%=basePath%>/client/ajaxFindClientTxt.do",
   				data : "id="+id,
   			    async : false,
   			    type : "post",
   			 	dataType : "json",
   			 	success : function(data) {
   			      	if(data != null){
   			      		
   			      		var idcsxx = "";
   			      		
   			      		
		   				
		   				var csxxs = data.map.list;
		   				var csxx;
		   				for(var i = 0;csxxs.length > i;i++){
		   					csxx = csxxs[i];
		   					if(i % 5 == 0){
		   						idcsxx+="<div class=\"swiper-slide\">";
		   						idcsxx+="<ul class=\"pare-list\">";
		   					}
			            	
		   					idcsxx+="<li>";
	   						idcsxx+="<span class=\"title\">"+csxx[0]+"：</span>";
	   						idcsxx+="<span class=\"pare\">"+csxx[1]+"</span>";
	   						idcsxx+="</li>";
		   						
	   						if((i+1) % 5 == 0 || (i+1) == csxxs.length){
	   							idcsxx+="</ul>";
	   							idcsxx+="</div>";
	   						}
		   				}
						$("#idcsxx").html(idcsxx);
						
					
						var kghtml = "";
						var cmds = data.cmds;
						var cmd;
						var c = "";
						var active = "";
						for(var i = 0;cmds.length > i;i++){
							cmd = cmds[i];
							if(i % 4 == 0){
								kghtml+="<ul class=\"oper-btn-list\">";
							}
							c = ","+cmd[0]+",";
							active = "";
							if(data.map.led.indexOf(c) > -1)
								active = "active";
							kghtml+="<li class=\""+ active +"\" onclick=\"funUpMission('"+cmd[2]+"')\">";
							kghtml+="<div>";
							kghtml+="<i class=\"iconfont\">&#xe60a;</i>";
							kghtml+="<p>"+cmd[1]+"</p>";
							kghtml+="</div>";
							kghtml+="</li>";
							
							if((i+1) % 4 == 0 || (i+1) == cmds.length)
								kghtml+="</ul>";
						}
						$("#idkg").html(kghtml);
   			      	}
   				}
   		  	});
		setTimeout("ajaxFindClient()", 3000); //每隔5秒（5000毫秒）递归调用一次 
	}
    </script>
</html>