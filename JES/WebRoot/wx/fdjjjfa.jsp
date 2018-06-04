<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width,user-scalable=no,initial-scale=1" />
		<title>炬集发电机组物联网解决方案</title>
	</head>

	<body style="font-size: 15px;">
		<h3>方案概述</h3>
		<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;炬集发电机组物联网系统有带控制模块的发电机组、DTU数传设备、炬集云平台、GIS监控系统、手机APP等组成。</p>
		<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;首先由控制模块负责采集发电机组各种数据，然后通过DTU将数据上传到炬集云平台进行存储、整理、分析、处理后，再通过GIS监控系统使用数据，实现远程智能化管理：实时查看设备运行数据、地理信息、告警消息、指令操控、手机APP联动。</p>
		<img alt="" width="100%" height="100%" src="<%=path %>/wx/images/jjfa1.png">
		<br>
		<h3>方案价值</h3>
		<p>1、全局设备监管、足不出户、帷幄千里之外</p>
		<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;不管在全球任何地方，只要有网络，就可以采用手机或PC电脑远程监测发电机组的运行数据，控制发电机组的运行。除监测机组基本信息外，还进行更全面的监测，如励磁电压；电桥输出电压；轴承温度；绕组温度等。更全面的监测只为更好的检查机组的健康状况。</p>
		<br>
		<p>2、降低售后成本、提升配件销量、减少库存备货</p>
		<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;远程故障诊断专利技术，避免过度出差服务避免因用户错误操作或操作不当造成的问题而出差，甚至于可以在用户的协助下，直接远程解决一些故障。通过零件的生命周期管理，及时提醒用户做好维护保养。推荐使用原厂零件，实现二次配件和服务的销售。通过健康检查，及时发现用户机组的早期故障，提醒用户做好检修。推荐使用原厂零件，实现二次配件和服务的销售。</p>
		<br>
		<p>3、数据统计分析、分析用户习惯、改良设备性能</p>
		<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;对发电机组实时且更全面的监测，智能抓取数据，如励磁电压；电桥输出电压；轴承温度；绕组温度的数据。实现远程故障诊断和早期故障检查。众多数据汇总并以图表形式展示出来。</p>
		<br>
		<p>4、提升产品竞争力、增加产品卖点、提高企业形象</p>
		<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;故障捕获和故障场景回放技术，完美重放故障发生前的每个瞬间数据，快速解决故障问题。实现机组真正远程故障诊断。</p>
		<br>
		<p>5、生命周期管理，在线监测、保养提醒、关注设备后市场</p>
		<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;强大的智能数据抓取专利技术， 通过抓取马达起动前后的蓄电池电压，空载10秒钟的电压和转速，励磁电压、电调输出电压、轴承温度等，实现健康检查和早期故障检查，让用户可以根据健康状况做好维护保养，保证机组的稳定运行，延长发电机组的寿命</p>
	</body>
</html>