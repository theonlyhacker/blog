<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>AllArticleCatalogs</title>
    <link href="static/bootstrap/bootstrap.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="static/jquery/jquery-3.4.1.min.js"></script>
</head>
<body>
<form action="" method="post">
    <table class="table">
        <thead class="thead-light">
        <tr>
            <th colspan="5" style="text-align: center">文章目录</th>
        </tr>
        </thead>

        <tbody>
        <tr style="text-align: center">
            <th scope="col">作者</th>
            <th scope="col">题目</th>
            <th scope="col">类型</th>
            <th scope="col">发布日期</th>
            <th scope="col">功能列表</th>
        </tr>
        <c:forEach var="article" items="${list}" varStatus="status">
            <tr class="text-right" style="" id="hanggao">
                <td>${article.idAuthor}</td>
                <td><a href="ArticleInfoServlet?id=${article.id}">${article.title}</a></td>
                <td>${article.type}</td>
                <td>${article.datetime}</td>
                <td>
                    <button type="button" class="btn btn-outline-secondary"
                            style="line-height: 1;padding: 0.23rem 0.5rem"><a
                            href="ArticleInfoServlet?id=${article.id}"
                            style="text-decoration: none;color:cornflowerblue">查看</a>
                    </button>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <th colspan="5" style="text-align: right">
                <button type="button" class="btn btn-outline-secondary">
                    <a href="main" style="text-decoration: none;color: #5a6268">返回</a></button>
            </th>
        </tr>
        </tbody>
    </table>
</form>
    <script type="text/javascript">
        /*$(document).ready(function () {
            $('#hanggao').bootstrapTable({height: 160});
        });*/
    </script>
</body>
</html>
