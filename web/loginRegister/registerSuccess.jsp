<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<html>
<head>
    <title>注册成功</title>
</head>
<body>
<a href="index"><h3 style="color: red">注册成功,点击进行登录</h3></a>
</body>
</html>
