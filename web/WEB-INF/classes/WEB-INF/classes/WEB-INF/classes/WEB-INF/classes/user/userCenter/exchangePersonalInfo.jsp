<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>exchangePersonal</title>
    <link href="static/bootstrap/bootstrap.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="static/jquery/jquery-3.4.1.min.js"></script>
</head>
<body>
    <form action="exchangePersonalInfoServlet" method="post">
        <div id="contermoddile" style="margin-left: 25%;width: 60%">
            <h3 style="color: coral;font-family: SansSerif;" align="center">个人信息</h3>
            <div class="form-group row">
                <label for="Username" class="col-sm-2 col-form-label">Username</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="userName" id="username" value="${user.username}" readonly>
                </div>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="sex" id="inlineRadio1" value="男" ${user.sex=="男"?"checked":""}>
                <label class="form-check-label" for="inlineRadio1">男</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="sex" id="inlineRadio2" value="女" ${user.sex=="女"?"checked":""}>
                <label class="form-check-label" for="inlineRadio2">女</label>
            </div>
            <div class="form-group row">
                <label for="Email" class="col-sm-2 col-form-label">Tel</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="userTel" id="Email" value="${user.tel}">
                </div>
            </div>
            <div class="form-group row">
                <label for="Password" class="col-sm-2 col-form-label">Password</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="Password" id="Password" value="${user.password}">
                </div>
            </div>
            <div style="margin-top: 45%">
                <input type="submit" class="btn btn-outline-secondary" value="提交">
                <button type="button" class="btn btn-outline-secondary" id="save" click="save()">保存</button>
                <button type="button" class="btn btn-outline-secondary"><a href="personalInfoServlet" style="text-decoration: none;color: #5a6268;">返回</a></button>
            </div>
        </div>
    </form>
</body>
</html>
