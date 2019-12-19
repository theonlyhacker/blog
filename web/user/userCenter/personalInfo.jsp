<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
<head>
    <title>PersonalInfo</title>
    <link href="static/bootstrap/bootstrap.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="static/jquery/jquery-3.4.1.min.js"></script>
</head>
<body style="background-image: url('static/images/background/bb77e103a43edbe8f9e1cf40f337ae8b.jpeg');background-size: 100%">
<form action="personalInfoServlet" method="post">
    <h3 style="color: coral;font-family: SansSerif;" align="center">个人信息</h3>
    <div id="contermoddile" style="margin-left: 25%;width: 60%">
        <div class="form-group row">
            <label for="userName" class="col-sm-2 col-form-label">Username</label>
            <div class="col-sm-10">
                <input type="text" readonly class="form-control" id="userName" name="name" value="${user.username}">
            </div>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="sex" id="sex1" value="男" ${user.sex=="男"?"checked":""}
                   disabled>
            <label class="form-check-label" for="sex1">男</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="sex" id="sex2" value="女" ${user.sex=="女"?"checked":""}
                   disabled>
            <label class="form-check-label" for="sex2">女</label>
        </div>
        <div class="form-group row">
            <label for="tel" class="col-sm-2 col-form-label">Tel</label>
            <div class="col-sm-10">
                <input type="text" readonly class="form-control" id="tel" name="tel" value="${user.tel}">
            </div>
        </div>
        <c:if test="${status !='thevistor'}">
            <div class="form-group row">
                <label for="Password" class="col-sm-2 col-form-label">Password</label>
                <div class="col-sm-10">
                    <input type="text" readonly class="form-control" id="Password" value="${user.password}">
                </div>
            </div>
            <button type="button" class="btn btn-outline-secondary"><a href="exchangePersonalInfoServlet"
                                                                       style="text-decoration: none;color: #5a6268;">修改</a>
            </button>
        </c:if>
        <button type="button" class="btn btn-outline-secondary"><a href="main"
                                                                   style="text-decoration: none;color: #5a6268;">返回</a>
        </button>

        <%--2019/10/17对默认不修改的元素取消掉input的功能<div class="form-group row">
                <label for="inputUsername" class="col-sm-2 col-form-label">Username</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputUsername">
                </div>
            </div>--%>
    </div>
</form>

</body>
</html>
