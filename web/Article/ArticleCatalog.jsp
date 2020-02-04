<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>ArticleCatalog</title>
    <link href="static/bootstrap/bootstrap.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="static/jquery/jquery-3.4.1.min.js"></script>
</head>
<body>
<%--可以取得List大小的函数--%>
<%--${fn:length(list)}<br>--%>

<form action="" method="post">
    <%-- <table class="table">
         <thead class="thead-dark">
         <tr>
             <th scope="col">#</th>
             <th scope="col">题目</th>
             <th scope="col">类型</th>
             <th scope="col">发布日期</th>
         </tr>
         </thead>
         <tbody>
         <tr>
             <th scope="row">1</th>
             <td>Mark</td>
             <td>Otto</td>
             <td>@mdo</td>
         </tr>
         </tbody>
     </table>--%>

    <table class="table">
        <thead class="thead-light">
        <tr>
            <th colspan="5" style="text-align: center">自己的文章目录</th>
        </tr>
        </thead>

        <tbody>
        <tr style="text-align: right">
            <th scope="col">题目</th>
            <th scope="col">类型</th>
            <th scope="col">状态</th>
            <th scope="col">生成日期</th>
            <th scope="col">功能列表</th>
        </tr>
        <c:forEach var="article" items="${list}" varStatus="sta">
            <tr class="text-right" style="" id="hanggao">
                <td><a href="ArticleInfoServlet?id=${article.id}&status=${status}">${article.title}</a></td>
                <td>${article.type}</td>
                    <%--这里先全部写成已发布的状态，等以后写出保存等功能的时候再修改 2019.12.6--%>
                <td>已发布</td>
                <td>${article.datetime}</td>
                <td>
                    <button type="button" class="btn btn-outline-secondary"
                            style="line-height: 1;padding: 0.23rem 0.5rem"><a
                            href="ArticleInfoServlet?id=${article.id}&status=${status}"
                            style="text-decoration: none;color:cornflowerblue">查看</a>
                    </button>
                    <button type="button" class="btn btn-outline-secondary"
                            style="line-height: 1;padding: 0.23rem 0.5rem"><a
                            href="delArticleServlet?id=${article.id}" style="text-decoration: none;color: red">删除</a>
                    </button>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <th colspan="5" style="text-align: right">
                <%--<button type="button" class="btn btn-outline-secondary">
                    <a href="main" style="text-decoration: none;color: #5a6268">返回</a></button>--%>
                <button type="button" class="btn btn-outline-secondary" onclick="javascript:history.go(-1)">返回</button>
            </th>
        </tr>
        </tbody>
    </table>
    <script type="text/javascript">
        /*$(document).ready(function () {
            $('#hanggao').bootstrapTable({height: 160});
        });*/
    </script>
</form>
</body>
</html>
