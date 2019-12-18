<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>ArticleType</title>
    <link href="static/bootstrap/bootstrap.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="static/jquery/jquery-3.4.1.min.js"></script>
    <script src="static/bootstrap/bootstrap.js"></script>
<%--    <link href="Article/article.css" rel="stylesheet" type="text/css">--%>
    <style>
        #ArticleType{
            display: none;
            position: absolute;
            top: 25%;
            left: 38%;
            width: auto;
            height: auto;
            padding: 10px;
            border: 5px solid gray;
            background-color:#b3d7ff;
            z-index: 1002;
            overflow: auto;
            text-align: center !important;
        }
    </style>
</head>
<body>
<form action="ArticleTypeServlet" method="post">
    <div>
        用户已有的文章类型
    </div>
    <div>
        <c:forEach items="${ArticleType}" var="list" varStatus="sta">
            <li class="list-group-item">${list.typeContent}
                <button type="button" class="btn btn-outline-secondary" style="line-height: 1;padding: 0.23rem 0.5rem"><a
                        href="delArticleServlet?typeId=${list.id}" style="text-decoration: none;color: red">删除</a>
                </button>
            </li>
        </c:forEach>
    </div>
    <div id="ArticleType">
        <label>添加文章类型</label>
        <input type="text" name="type">
        <button type="submit" class="btn btn-outline-secondary">确定</button>
        <button type="button" class="btn btn-outline-secondary canCle">取消</button>
    </div>
    <button type="button" class="btn btn-outline-secondary addType">添加类型</button>
    <button type="button" class="btn btn-outline-secondary"><a href="main" style="text-decoration: none;color: #5a6268;">返回</a></button>
</form>

<script>
    $(function () {
        $(".addType,.canCle").click(function () {
            if (document.getElementById('ArticleType').style.display == 'none') {
                document.getElementById('ArticleType').style.display = 'block';
            } else {
                document.getElementById('ArticleType').style.display = 'none';
            }
        })
    })

</script>
</body>
</html>
