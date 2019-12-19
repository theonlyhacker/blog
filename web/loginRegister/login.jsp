<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<html>
<head>
    <title>博客</title>
    <link href="static/bootstrap/bootstrap.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="loginRegister/login.css" type="text/css">
    <script type="text/javascript" src="static/jquery/jquery-3.4.1.min.js"></script>
    <script src="static/bootstrap/bootstrap.js"></script>
</head>

<body>
<div id="blog" align="center" style="font-size: 50px;font-family: 'Courier New'">Welcome To My Blog</div>
<form action="login" method="post">
    <div style="margin-left: 42%;height: 38" class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text" id="basic-addon1" style="height: 38">用户名</span>
        </div>
        <input type="text" class="userinput" name="userName" id="username" placeholder="请输入用户名" onblur="check(this)"
               value="${user.username}"><%--<span id="name1" style="color: red;font-size: 15px;font-family: 'DejaVu Sans', Arial, Helvetica, sans-serif">*不能为空值</span>--%>
    </div>
    <div style="margin-left: 42%;height: 38" class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text" id="basic-addon2" style="height: 38">密&nbsp&nbsp&nbsp&nbsp码</span>
        </div>
        <input type="password" class="userinput" name="password" id="userpassword" placeholder="请输入密码"><span
            style="color: red;height: 20px;width: 300px;font-size: 15px">${errorMsg}</span>
        <%--<span id="pass1" style="color: red;font-size: 15px;font-family: 'DejaVu Sans', Arial, Helvetica, sans-serif">*不能为空值</span>--%>
    </div>
    <br><br>
    <%-- 用户名:<input type="text" name="userName" id="username" style="color: black;height: 25px;width: 200px" onblur="check(this)" placeholder="请输入用户名"/><span id="name1" style="color: red;font-size: 15px;font-family: 'DejaVu Sans', Arial, Helvetica, sans-serif">*不能为空值</span><br>
     密&nbsp&nbsp&nbsp&nbsp码:<input type="password" name="password" id="userpassword" style="color: black;height: 25px;width: 200px" onblur="check(this)"/><span id="pass1" style="color: red;font-size: 15px;font-family: 'DejaVu Sans', Arial, Helvetica, sans-serif">*不能为空值</span><br>

   </div>--%>
    <div align="center"><input type="submit" class="btn btn-outline-secondary" value="登录"></div>
</form>
<script>
    /***check函数暂时取消使用2019/10/15***/
    // function check() {
    //     $("#name1").css('display','none');
    //     $("#pass1").css('display','none');
    //     if($("#username").val() == null||$("#username").val() == ""||$("#username").val() == "null"){
    //         //document.getElementById("name1").style.display ="inline";
    //         $("#name1").css('display','inlne');
    //     }
    //     if($("#userpassword").val() == null||$("#userpassword").val() ==""){
    //         //$("#pass1").toggle();要用这个的话，就需要加个else了，代码量感觉没有下降
    //         $("#pass1").css('display','inline');
    //     }
    // }
</script>
</body>
</html>
