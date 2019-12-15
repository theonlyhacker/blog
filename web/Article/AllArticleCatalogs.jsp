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
<form action="AllArticleCatalogsServlet" method="post">
<%--    传入status判断是否为游客登录--%>
    <input type="hidden" name="status" value="${status}">
    <table class="table">
        <thead class="thead-light">
        <tr>
            <th colspan="4" style="text-align: center">文章目录</th>
            <th colspan="1" style="text-align: center">
                <input type="text" name="searchArticle" id="jiansuo">
                <button type="submit" class="btn btn-outline-secondary" style="line-height: 1;padding: 0.23rem 0.5rem">检索</button>
            </th>
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
        <c:forEach var="article" items="${list}" varStatus="sta">
            <tr class="text-right" style="" id="hanggao">
                <td>${article.idAuthor}</td>
                <td><a href="ArticleInfoServlet?id=${article.id}&status=${status}">${article.title}</a></td>
                <td>${article.type}</td>
                <td>${article.datetime}</td>
                <td>
                    <button type="button" class="btn btn-outline-secondary"
                            style="line-height: 1;padding: 0.23rem 0.5rem"><a
                            href="ArticleInfoServlet?id=${article.id}&status=${status}"
                            style="text-decoration: none;color:cornflowerblue">查看</a>
                    </button>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <c:choose>
                <c:when test="${status =='youke'}">
                    <th colspan="5" style="text-align: center">
                        <p>游客!欢迎您</p>
                        <h3><a href="index" style="text-decoration: none;color:red">点击返回主页面</a></h3>
                    </th>
                </c:when>
                <c:otherwise>
                    <th colspan="5" style="text-align: right">
                        <button type="button" class="btn btn-outline-secondary">
                            <a href="main" style="text-decoration: none;color: #5a6268">返回</a></button>
                    </th>
                </c:otherwise>
            </c:choose>

        </tr>
        </tbody>
    </table>
</form>
    <script type="text/javascript">
        /*function jiansuo() {
            var guanjianci = $("#jiansuo").val();
            $.ajax({
                type:"get",
                url:"",
                data:{}
            })
        }*/
        /*$(document).ready(function () {
            $('#hanggao').bootstrapTable({height: 160});
        });*/
    </script>
</body>
</html>
