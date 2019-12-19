<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<html>
<head>
    <title>登录失败</title>
</head>
<body>
<div>
    <a href="loginServlet"><h3 style="color: red">登录失败,点击重新登录</h3></a>
</div>
</body>
</html>
