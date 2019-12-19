<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<html>
<head>
    <title>个人主页</title>
    <link href="static/bootstrap/bootstrap.css" rel="stylesheet" type="text/css">
    <style>
        #img1 img {
            border-radius: 50%;
        }
    </style>
</head>
<body style="background-image: url('static/images/background/2de073d793b3cf43ea7f666e13555b79.jpeg');background-size: 100%">
<form action="" method="post">
    <input type="hidden" name="name" value="${name}">
    <div style="color: white" align="center">
        <h3>${userName}的个人主页</h3></div>
    <div id="conter" style="width: 100%;border: 1px">
        <div id="conterleft" style="width: 20%;float: left">
            <%--<div class="img1" style="margin: 10px auto"><img src="images/touxiang/e1043b1aba5e56f11c4c132cb39816d1.jpg"></div>--%>
            <div class="card" style="width: 18rem;">
                <img src="static/images/touxiang/e1043b1aba5e56f11c4c132cb39816d1.jpg" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">功能列表</h5>
                    <%-- <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>--%>
                </div>
                <ul class="list-group list-group-flush">
                    <c:if test="${status == 'admin'}">
                        <li class="list-group-item"><a href="AllPersonInfoServlet">管理用户</a></li>
                    </c:if>

                    <li class="list-group-item"><a href="personalInfoServlet">个人资料</a></li>
                    <li class="list-group-item"><a href="ArticleTypeServlet">类型管理</a></li>
                    <li class="list-group-item"><a href="AllArticleCatalogsServlet?status=${status}">文章广场</a></li>
                    <li class="list-group-item"><a href="ArticleCatalogServlet">文章目录</a></li>
                    <li class="list-group-item"><a href="addArticleServlet">发表文章</a></li>
                    <li class="list-group-item"><a href="index" style="text-decoration: none;color: black">退出</a>
                    </li>
                </ul>
            </div>
        </div>


        <div id="contermiddle" style="width: 60%;float: left">
            <div class="card">
                <div class="card-header">
                    Quote
                </div>
                <div class="card-body">
                    <blockquote class="blockquote mb-0">
                        <p>cogito ergo sum</p>
                        <footer class="blockquote-footer">Someone like it<cite title="Source Title"> and it's in my
                            heart.</cite></footer>
                    </blockquote>
                </div>
            </div>
        </div>
        <div id="conterright" style="width: 20%;float: right"></div>
    </div>
</form>
</body>
</html>
