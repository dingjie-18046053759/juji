<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="/WEB-INF/MyPage.tld" prefix="pt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>添加学校</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type="text/javascript" src="<%=basePath%>js/jquery/jquery-1.10.2.min.js"></script>
	    <script type="text/javascript" src="<%=basePath%>js/artDialog/artDialog.js?skin=aero"></script>
	    <script type="text/javascript" src="<%=basePath%>js/artDialog/jquery.artDialog.js"></script>
	    <script type="text/javascript" src="<%=basePath%>js/sys_dialog.js"></script>
	    <script type="text/javascript" src="<%=basePath%>js/layout.js"></script>
	    <script type="text/javascript" src="<%=basePath%>js/formComm.js"></script>
	    <script type="text/javascript" src="<%=basePath%>js/jquery.form.js"></script>
	    <script type="text/javascript" src="<%=basePath%>js/datepicker/WdatePicker.js"></script>
		<script src="<%=basePath%>js/formvalidator/formValidator-4.1.3.js" type="text/javascript" charset="UTF-8"></script>
		<script src="<%=basePath%>js/formvalidator/formValidatorRegex.js" type="text/javascript" charset="UTF-8"></script>
	    <link href="<%=basePath%>skin/default/style.css" rel="stylesheet" type="text/css" />
	    <script type="text/javascript">
	    	$(document).ready(function(){
	    		$("#atname").formValidator({onShow:"请输入学校名称",onFocus:"学校名称至少2个字符,最多10个字符",onCorrect:"正确"}).inputValidator({min:2,max:10,onError:"学校名称1到10个字符之间"});
	    		
	    		var options = {
                    type: "Post",
                    dataType: "Json",
                    beforeSend: function () {
                        //alertLoad('上传中,请稍后..');
                    },
                    success: function (data) {
                        //alertClose(); //关闭提示
                        //alertNew(data.msg);
                        if (data.msg.indexOf("成功") == -1) {
                            alert(data.msg);
                        }
                        else {
                            $("#icopath").attr("src", '<%=basePath%>'+data.path);
                            $("#icoPathHidden").val('<%=basePath%>'+data.path);
                        }
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        //alertClose(); //关闭提示
                        //alertNew(textStatus);
                    }
                };

	    	});
	    	
	    	function add(){
	    		if ($("#atname").val() == ""){
	    			alert("名称不能为空！")
	    			return;
	    		}
	    		$.ajax({
				     url : "<%=basePath%>backActivity/aSchoolAdd.do",
				     data : $("#_form").serialize(),
				     async : false,
				     type : "post",
				     dataType : "json",
				     success : function(data) {
				         alert(data.msg);
				         if (data.msg.indexOf("成功") != -1){
				        	 window.location.href = "<%=basePath%>backActivity/aSchoolList.do";
				         }
				     },
				     error : function() {
				       alert("对不起，出现错误!");
				     }
				});
	    	}
	    	
	    </script>
	</head>
	<body class="mainbody">
	
		<!--导航栏-->
        <div class="location">
            <a href="<%=basePath%>backActivity/aSchoolList.do" class="back"><i></i><span>返回列表页</span></a>
            <a href="<%=basePath%>mgr/index.jsp" class="home"><i></i><span>首页</span></a>
            <i class="arrow"></i>
            <a href="<%=basePath%>backActivity/aSchoolList.do"><span>学校列表</span></a>
            <i class="arrow"></i>
            <span>基础问卷添加</span>
        </div>
        <div class="line10"></div>
        <!--/导航栏-->
        <!--form 的id值必须为form1-->
	    <form name="form1" id="_form" >	        
	        <!--内容-->
	        <div class="content-tab-wrap">
	            <div id="floatHead" class="content-tab">
	                <div class="content-tab-ul-wrap">
	                    <ul>
	                        <li><a href="javascript:;" onclick="tabs(this);" class="selected">添加学校信息</a></li>
	                    </ul>
	                </div>
	            </div>
	        </div>
	        <!--区分是否提交-->
	        <input type="hidden" name="isPost" value="1"/>
	         <div class="tab-content">
	            <dl>
	                <dt><span style="color:red;">*</span>类型名称:</dt>
	                <dd class="ctrl">
	                    <input name="Sname" type="text" value="" id="atname" class="input normal" maxlength="30"/>
	                </dd>
	                <dd class="tip">
	                	<div id="pvttitleTip"></div>       
	                </dd>
	            </dl>
		        <!--工具栏-->
		        <dl>
	                <dd class="btndd">
			            <div class="btn-list">
			                <input type="button" name="btnSubmit" id="btnSubmit" value="添加信息"  onclick="add()" class="btn" />
			                <input name="btnReturn" type="button" value="返回上一页" class="btn yellow" onclick="javascript:history.back(-1);" />
			            </div> 
	                </dd>
	            </dl>
	        	<!--/工具栏-->
	        </div>
	    </form>
	</body>
</html>