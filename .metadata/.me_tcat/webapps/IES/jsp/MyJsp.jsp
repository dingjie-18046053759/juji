<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>搜电影</title>

    <script type="text/javascript">
        function changeSource1() {
            var but1 = document.getElementById('button1');
            but1.style.backgroundColor = '#2222ff';
            document.getElementById("iframe").src = "http://www.btpipi.com/e/" + document.getElementById('sss').value + "/";
        }

        function changeSource2() {
            var but2 = document.getElementById('button2');
            but2.style.backgroundColor = "#2222ff";
            document.getElementById("iframe").src = "http://www.13910.com/s/?kw=" + document.getElementById('sss').value;
        }
    </script>
</head>

<body>
<label for="sss"></label>
<input name="sss" type="text" id="sss" value="杀破狼"/>
<input type="submit" style="height:22px;width:70px;" value="BTpipi" onClick="changeSource1()" id="button1"/>
<input type="submit" style="height:22px;width:70px;" value="盘找我" onClick="changeSource2()" id="button2"/>
<br/>
<iframe id="iframe" align=middle marginwidth=0 vspace=-0 marginheight=0 src="http://www.baidu.com/" frameborder=no
width=100% scrolling=auto height=903></iframe>

</body>
</html>