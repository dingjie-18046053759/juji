<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>校区活动交友App - 后台管理中心</title>
	<meta http-equiv="Expires" content="0"/>
	<meta http-equiv="Pragma" content="no-cache"/>
	<meta http-equiv="Cache-control" content="no-cache"/>
	<meta http-equiv="Cache" content="no-cache"/>
    <link href="<%=basePath%>skin/default/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="<%=basePath%>js/jquery/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/jquery/jquery.nicescroll.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/layout.js"></script>
    <script type="text/javascript">
        //页面加载完成时
        $(function () {
            //检测IE
            if ('undefined' == typeof (document.body.style.maxHeight)) {
                window.location.href = 'ie6update.html';
            }
            loadMenuTree(true); //加载管理首页左边导航菜单
        });

        //页面尺寸改变时
        $(window).resize(function () {
            navresize();
        });
        //加载管理首页左边导航菜单
        function loadMenuTree(_islink) {
            //判断是否跳转链接
            var islink = false;
            if (arguments.length == 1 && _islink) {
                islink = true;
            }
            //初始化导航菜单
            initMenuTree(islink);
            initPopMenuTree();
            //设置左边导航滚动条
            $("#sidebar-nav").niceScroll({ touchbehavior: false, cursorcolor: "#7C7C7C", cursoropacitymax: 0.6, cursorwidth: 5 });
            $("#pop-menu .list-box").niceScroll({ touchbehavior: false, cursorcolor: "#7C7C7C", cursoropacitymax: 0.6, cursorwidth: 5 });
            $("#pop-menu .list-box").getNiceScroll().hide();
            //设置主导航菜单显示和隐藏
            navresize();
        }
        //初始化导航菜单
        function initMenuTree(islink) {
            //先清空NAV菜单内容
            $("#nav").html('');
            $("#sidebar-nav .list-box .list-group").each(function (i) {
                //添加菜单导航
                var navHtml = $('<li><i class="icon-' + i + '"></i><span>' + $(this).attr("name") + '</span></li>').appendTo($("#nav"));
                //默认选中第一项
                if (i == 0) {
                    $(this).show();
                    navHtml.addClass("selected");
                }
                //为菜单添加事件
                navHtml.click(function () {
                    $("#nav li").removeClass("selected");
                    $(this).addClass("selected");
                    $("#sidebar-nav .list-box .list-group").hide();
                    $("#sidebar-nav .list-box .list-group").eq($("#nav li").index($(this))).show();
                });
                //为H2添加事件
                $(this).children("h2").click(function () {
                    if ($(this).next("ul").css('display') != 'none') {
                        return false;
                    }
                    $(this).siblings("ul").slideUp(300);
                    $(this).next("ul").slideDown(300);
                    //展开第一个菜单
                    if ($(this).next("ul").children("li").first().children("ul").length > 0) {
                        //$(this).next("ul").children("li").first().children("a").children(".expandable").last().removeClass("close");
                        //$(this).next("ul").children("li").first().children("a").children(".expandable").last().addClass("open");
                        //$(this).next("ul").children("li").first().children("ul").first().show();
                    }
                });

                //首先隐藏所有的UL
                $(this).find("ul").hide();
                //绑定树菜单事件.开始
                $(this).find("ul").each(function (j) { //遍历所有的UL
                    //遍历UL第一层LI
                    $(this).children("li").each(function () {
                        liObj = $(this);
                        //插入选中的三角
                        var spanObj = liObj.children("a").children("span");
                        $('<div class="arrow"></div>').insertBefore(spanObj); //插入到span前面
                        //判断是否有子菜单和设置距左距离
                        var parentExpandableLen = liObj.parent().parent().children("a").children(".expandable").length; //父节点的左距离
                        if (liObj.children("ul").length > 0) { //如果有下级菜单
                            //删除链接，防止跳转
                            liObj.children("a").removeAttr("href");
                            //更改样式
                            liObj.children("a").addClass("pack");
                            //设置左距离
                            var lastExpandableObj;
                            for (var n = 0; n <= parentExpandableLen; n++) { //注意<=
                                lastExpandableObj = $('<div class="expandable"></div>').insertBefore(spanObj); //插入到span前面
                            }
                            //设置最后一个为闭合+号
                            lastExpandableObj.addClass("close");
                            //创建和设置文件夹图标
                            $('<div class="folder close"></div>').insertBefore(spanObj); //插入到span前面
                            //隐藏下级的UL
                            liObj.children("ul").hide();
                            //绑定单击事件
                            liObj.children("a").click(function () {
                                //搜索所有同级LI且有子菜单的左距离图标为+号及隐藏子菜单
                                $(this).parent().siblings().each(function () {
                                    //alert($(this).html());
                                    if ($(this).children("ul").length > 0) {
                                        //设置自身的左距离图标为+号
                                        $(this).children("a").children(".expandable").last().removeClass("open");
                                        $(this).children("a").children(".expandable").last().addClass("close");
                                        //隐藏自身子菜单
                                        $(this).children("ul").slideUp(300);
                                    }
                                });

                                //设置自身的左距离图标为-号
                                $(this).children(".expandable").last().removeClass("close");
                                $(this).children(".expandable").last().addClass("open");
                                //显示自身父节点的UL子菜单
                                $(this).parent().children("ul").slideDown(300);
                            });
                        } else {
                            //设置左距离
                            for (var n = 0; n < parentExpandableLen; n++) {
                                $('<div class="expandable"></div>').insertBefore(spanObj); //插入到span前面
                            }
                            //创建和设置文件夹图标
                            $('<div class="folder open"></div>').insertBefore(spanObj); //插入到span前面
                            //绑定单击事件
                            liObj.children("a").click(function () {
                                //删除所有的选中样式
                                $("#sidebar-nav .list-box .list-group ul li a").removeClass("selected");
                                //自身添加样式
                                $(this).addClass("selected");
                                //保存到cookie
                                addCookie("dt_manage_navigation_cookie", $(this).attr("navid"), 240);
                            });
                        }
                    });
                    //显示第一个UL
                    if (j == 0) {
                        $(this).show();
                        //展开第一个菜单
                        if ($(this).children("li").first().children("ul").length > 0) {
                            $(this).children("li").first().children("a").children(".expandable").last().removeClass("close");
                            $(this).children("li").first().children("a").children(".expandable").last().addClass("open");
                            $(this).children("li").first().children("ul").show();
                        }
                    }
                });
                //绑定树菜单事件.结束
            });
            //定位或跳转到相应的菜单
            linkMenuTree(islink);
        }
        //定位或跳转到相应的菜单
        function linkMenuTree(islink, navid) {
            //读取Cookie,如果存在该ID则定位到对应的导航
            var cookieObj;
            var argument = arguments.length;
            if (argument == 2) {
                cookieObj = $("#sidebar-nav").find('a[navid="' + navid + '"]');
            } else {
                cookieObj = $("#sidebar-nav").find('a[navid="' + getCookie("dt_manage_navigation_cookie") + '"]');
            }
            if (cookieObj.length > 0) {
                //显示所在的导航和组
                var indexNum = $("#sidebar-nav .list-box .list-group").index(cookieObj.parents(".list-group"));
                $("#nav li").removeClass("selected");
                $("#nav li").eq(indexNum).addClass("selected");
                cookieObj.parents(".list-group").siblings().hide();
                cookieObj.parents(".list-group").show();
                //遍历所有的LI父节点
                cookieObj.parents("li").each(function () {
                    //搜索所有同级LI且有子菜单的左距离图标为+号及隐藏子菜单
                    $(this).siblings().each(function () {
                        if ($(this).children("ul").length > 0) {
                            //设置自身的左距离图标为+号
                            $(this).children("a").children(".expandable").last().removeClass("open");
                            $(this).children("a").children(".expandable").last().addClass("close");
                            //隐藏自身子菜单
                            $(this).children("ul").hide();
                        }
                    });
                    //设置自身的左距离图标为-号
                    if ($(this).children("ul").length > 0) {
                        $(this).children("a").children(".expandable").last().removeClass("close");
                        $(this).children("a").children(".expandable").last().addClass("open");
                    }
                    //显示自身的UL
                    $(this).children("ul").show();
                });
                //显示最后一个父节点UL，隐藏兄弟UL
                cookieObj.parents("ul").eq(-1).show();
                cookieObj.parents("ul").eq(-1).siblings("ul").hide();
                //删除所有的选中样式
                $("#sidebar-nav .list-box .list-group ul li a").removeClass("selected");
                //自身添加样式
                cookieObj.addClass("selected");
                //检查是否需要保存到cookie
                if (argument == 2) {
                    addCookie("dt_manage_navigation_cookie", navid, 240);
                }
                //检查是否需要跳转链接
                if (islink == true) {
                    frames["mainframe"].location.href = cookieObj.attr("href");
                }
            } else if (argument == 2) {
                //删除所有的选中样式
                $("#sidebar-nav .list-box .list-group ul li a").removeClass("selected");
                //保存到cookie
                addCookie("dt_manage_navigation_cookie", "", 240);
            }
        }
        //初始化快捷导航菜单
        function initPopMenuTree() {
            var divWidth = $("#pop-menu .list-box .list-group").length * $("#pop-menu .list-box .list-group").outerWidth();
            var divHeight = $(window).height() * 0.6;
            //如果计算的宽度大于浏览器当前窗口可视宽度
            if (divWidth > ($(window).width() - 60)) {
                divWidth = $(window).width() - 60;
            }
            //计算实际的高度
            var groupHeight = 0;
            $("#pop-menu .list-box .list-group").each(function () {
                if ($(this).height() > groupHeight) {
                    groupHeight = $(this).height();
                }
            });
            if (divHeight > groupHeight) {
                divHeight = groupHeight;
            }
            $("#pop-menu .list-box .list-group").height(groupHeight);
            $("#pop-menu .pop-box").width(divWidth);
            $("#pop-menu .pop-box").height(divHeight);

            //遍历及加载事件
            $("#pop-menu .pop-box .list-box li").each(function () {
                var linkObj = $(this).children("a");
                linkObj.removeAttr("href");
                if ($(this).children("ul").length > 0) { //如果无下级菜单
                    linkObj.addClass("nolink");
                } else {
                    linkObj.addClass("link");
                    linkObj.click(function () {
                        linkMenuTree(true, linkObj.attr("navid")); //加载函数
                    });
                }
            });
        }
        //快捷菜单的显示与隐藏
        function triggerMenu(isShow) {
            if (isShow) {
                $("#pop-menu .list-box").getNiceScroll().show();
                $("#pop-menu").css("visibility", "visible");
            } else {
                $("#pop-menu .list-box").getNiceScroll().hide();
                $("#pop-menu").css("visibility", "hidden");
            }
        }
        //导航菜单显示和隐藏
        function navresize() {
            var docWidth = $(document).width();
            if (docWidth < 1004) {
                $(".nav li span").hide();
            } else {
                $(".nav li span").show();
            }
        }
    </script>
</head>

<body class="indexbody">
    <form id="form1">
        <!--/全局菜单-->

        <div class="header">
            <div class="header-box"> 
                <h1 class="logo"></h1>
                <ul id="nav" class="nav">
	                <li class="selected"><i class="icon-0"></i><span>内容</span></li>
                </ul>
                <div class="nav-right">
                    <div class="icon-info">
                        <span>您好，<br />管理员
                        </span>
                    </div>
                    <div class="icon-option">
                        <i></i>
                        <div class="drop-box">
                            <div class="arrow"></div>
                            <ul class="drop-item">
                                <li><a href="<%=basePath%>mgr/center.do" target="mainframe">管理中心</a></li>
                                <li><a onclick="linkMenuTree(false, '');" href="admin/updPwd.jsp" target="mainframe">修改密码</a></li>
                                <li><a id="lbtnExit" href="<%=basePath%>mgr/logout.do">注销登录</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="main-sidebar">
            <div id="sidebar-nav" class="sidebar-nav">
                <div class="list-box">
                <!-- 顶级菜单 -->
                    <div class="list-group" name="上次登录日期:【2016-03-24】 -- 登录次数:【1】" style="display: block;">
	                    <h2>数据设置<i></i></h2>
	                    <ul style="display: block;">
	                        <li>
	                            <a navid="channel_admin" class="item pack">
	                                <span>基础数据</span>
	                            </a>
	                            <ul style="display: block;">
	                                <li>
	                                    <a navid="channel_admin_list" href="<%=basePath%>backActivity/aTypeList.do" target="mainframe" class="item">
	                                        <span>活动类型</span>
	                                    </a>
	                                </li>
	                                <li>
	                                    <a navid="channel_admin_list" href="<%=basePath%>backActivity/aSchoolList.do" target="mainframe" class="item">
	                                        <span>学校列表</span>
	                                    </a>
	                                </li>
	                                <li>
	                                    <a navid="channel_admin_list" href="<%=basePath%>backActivity/activityList.do" target="mainframe" class="item">
	                                        <span>活动列表</span>
	                                    </a>
	                                </li>
	                            </ul>
	                        </li>
	                     </ul>
                    </div> 
                    
                    <script type="text/javascript">
                     $(function(){
                	     $("#nav li").removeClass("selected").eq(0).addClass("selected");
                	     $(".list-group").hide().eq(0).show();
                	     //删除所有的选中样式
                         $("#sidebar-nav .list-box .list-group>ul>li>ul>li>a").removeClass("selected");
                         //自身添加样式
                         //$(this).addClass("selected");
                         frames["mainframe"].location.href = "<%=basePath%>backActivity/index.do";
                     })
                    </script>
                </div>
            </div>
        </div>

        <div class="main-container">
            <iframe id="mainframe" name="mainframe" frameborder="0" src="<%=basePath%>backActivity/index.do"></iframe>
        </div>
    </form>
</body>
</html>