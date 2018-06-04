<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="<%=basePath%>js/jquery/jquery-1.10.2.min.js"></script>
	<script type="text/javascript">
     jQuery(document).ready(function(){ 
        checkCallOrder();
     });
     
     var num = 0;
     function checkCallOrder(){
    	 
    	 $.ajax({
             type: "get",
             url: "http://127.0.0.1:8080/CallCenterSystem/TestJsonController/findOrder.do",
             dataType: "jsonp",
             jsonp: "callback",
             jsonpCallback:"jsonpCallback",
             success: function(json){
                 //alert('json:' + json);
                 $("#numshow").html(num);
                 
             },
             error: function(){
                 alert('fail');
             }
         });
     }
     function jsonpCallback(data){
    	 //alert(data.RetMsg);
    	 num++;
         setTimeout(function(){checkCallOrder()}, 1000);
     }
     
     </script>
  </head>
  
  <body>
    <h1>当前请求次数：</h1><h1 id="numshow">0</h1>
  </body>
</html>
