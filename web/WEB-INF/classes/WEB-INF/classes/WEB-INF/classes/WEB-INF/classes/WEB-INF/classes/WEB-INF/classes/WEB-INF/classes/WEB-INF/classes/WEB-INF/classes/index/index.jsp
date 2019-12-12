<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
<base href="<%=basePath%>">
<title>index</title>
<link href="static/bootstrap/bootstrap.css" rel="stylesheet"
	type="text/css">
<script type="text/javascript" src="static/jquery/jquery-3.4.1.min.js"></script>
<script src="static/bootstrap/bootstrap.js"></script>
<%--    --%>
<style>
a {
	color: black;
}
</style>
<%--    --%>
</head>

<body id="body1"
	style="background-image: url('static/images/background/904f49ad0a7ec79bcaf14d0de0ba1d2c.jpg');background-size: 100%">
	<%--images/background/904f49ad0a7ec79bcaf14d0de0ba1d2c.jpg'--%>
	<div
		style="color: #0f6674;height: 10%;width: 100%;font-size: 50px;font-family: 'Courier New'"
		align="center">Welcome to LiuChao's Blog</div>
	<div style="margin-top: 200px" align="center">
		<button type="button" class="btn btn-outline-secondary">
			<a href="login"
				style="text-decoration: none;color:black;padding-bottom: auto;padding-top: auto">登录</a>
		</button>
		<button type="button" class="btn btn-outline-secondary">
			<a href="register" style="text-decoration: none;color:black;">注册</a>
		</button>
		<button type="button" class="btn btn-outline-success">
			<a href="" style="text-decoration: none;color:black;">游客登录</a>
		</button>
	</div>

</body>
<script>
	var i = 0;
	var arr = new Array();
	arr[0] = 'static/images/background/904f49ad0a7ec79bcaf14d0de0ba1d2c.jpg';
	arr[1] = 'static/images/background/553af94fd704c19548209ab54d8e928e.jpg';
	arr[2] = 'static/images/background/dc4117d319482e112a73cea53122cd56.jpg';
	arr[3] = 'static/images/background/021095fcb679684a8eafc3029272f27a.jpeg';
	setInterval(changeback, 3000);
	function changeback() {
		if (i == arr.length - 1) {
			i = 0;
		} else {
			i++;
		}
		$("#body1").css("background-image", "url(" + arr[i] + ")");
	}
	$(function() {
		//alert(arr[1])
	})
</script>
</html>
