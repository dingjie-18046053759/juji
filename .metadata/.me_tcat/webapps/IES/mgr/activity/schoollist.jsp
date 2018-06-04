<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
           <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("url", basePath+request.getAttribute("url"));
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="/WEB-INF/MyPage.tld" prefix="pt"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>学校列表</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	    <script type="text/javascript" src="<%=basePath%>js/jquery/jquery-1.10.2.min.js"></script>
    	<script type="text/javascript" src="<%=basePath%>js/jquery/jquery.lazyload.min.js"></script>
	    <script type="text/javascript" src="<%=basePath%>js/layout.js"></script>
	    <script type="text/javascript" src="<%=basePath%>js/artDialog/artDialog.js?skin=aero"></script>
	    <script type="text/javascript" src="<%=basePath%>js/artDialog/jquery.artDialog.js"></script>
	    <script type="text/javascript" src="<%=basePath%>js/sys_dialog.js"></script>
	    <script type="text/javascript" src="<%=basePath%>js/Common.js"></script>
	    
	    <link href="<%=basePath%>skin/default/style.css" rel="stylesheet" type="text/css" />
	    <link rel="stylesheet" href="<%=basePath%>css/page.css"/>
	    <script type="text/javascript">
	    	$(document).ready(function(){
	    	});
	    	
	    	function deleteData(sid){
	    		if (confirm("确定要删除该数据吗？")){
	    			$.ajax({
					     url : "<%=basePath%>backActivity/aSchoolDel.do",
					     data : "sid="+sid,
					     async : false,
					     type : "post",
					     dataType : "json",
					     success : function(data) {
					         if (data.msg.indexOf("成功") != -1){
					        	 window.location.reload();
					         } else {
					        	 alert(data.msg);
					         }
					     },
					     error : function() {
					       alert("对不起，出现错误!");
					     }
					});
	    		}
	    	}
	    	
	    </script>
	</head>
	<body class="mainbody">
        <!--导航栏-->
        <div class="location">
            <a href="javascript:history.back(-1);" class="back"><i></i><span>返回上一页</span></a>
            <a href="<%=basePath%>mgr/index.jsp" class="home"><i></i><span>首页</span></a>
            <i class="arrow"></i>
            <span>基础问卷列表</span>
        </div>
        <!--/导航栏-->
        <!--工具栏-->		        
        <div class="toolbar-wrap">
            <div id="floatHead" class="toolbar">
                <div class="l-list">
                    <ul class="icon-list">
                        <li><a class="add" href="<%=basePath%>backActivity/activity/schoolCreate.do"><i></i><span>新增</span></a></li>
                        <li><a class="all" href="javascript:;" onclick="checkAll(this)"><i></i><span>全选</span></a></li>	                        
                    </ul>
                </div>
                <div class="r-list l-list">
					<form name="form1" method="post" action="<%=basePath%>mgr/person/list.do" id="form1">						
					
						<ul class="icon-list" style="margin-right:0px">
			                <li><a class="xjt" href="javascript:void(0);"><span>活动类型:</span></a></li>
			            </ul>
			            <input name="name" id="name" type="text" maxlength="20" class="keyword" placeholder="请输入活动类型名称" />
			
				        <a id="lbtnSearch" class="btn-search" onclick="doSearch()">查询</a>
					</form>
                </div>
            </div>
        </div>
        <!--/工具栏-->
        <!--文字列表-->
		
        <table width="100%" border="0" cellspacing="0" cellpadding="0" class="ltable" id="tableContent">
            <tr>
                <th width="70">选择</th>
                <th align="left">学校名称</th>
                <th align="left">操作</th>
            </tr>
			<c:forEach items="${data.list}" var="obj">
	            <tr id="tr${obj.sid }">
	                <td align="center" class="checkall"><input type="checkbox" name="ids" value="${obj.sid }"/> </td>
	                <td>${obj.sname }</td>
	                <td align="center">
		                <a href="javascript:deleteData('${obj.sid}')">删除</a>
	        		</td>
	            </tr>
		</c:forEach>

        </table>

        <!--/文字列表-->
        <!--图片列表-->
        <!--/图片列表-->
        <!--内容底部-->
        <pt:page  count="${data.count }" pageIndex="${data.page }" url="${url}" pageMax="${data.total }"/>
        <!--/内容底部-->
	</body>
</html>