<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<html>
<head>
    <title>updateArticle</title>
    <link href="static/bootstrap/bootstrap.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="static/jquery/jquery-3.4.1.min.js"></script>
</head>
<body>
<form action="updateArticleServlet" method="post">
    <input type="hidden" name="id" value="${article.id}">
    <div id="contermiddle" style="width: 60%;float: left;margin-left: 25%">
        <div class="form-group">
            <label for="Ariticleclass">文章类型:</label>
            <select class="form-control" id="Ariticleclass" name="articleType" style="width: 200">
                <option aria-checked="true" value="${article.type}">${article.type}</option>
                <c:forEach var="list" items="${ArticleType}" varStatus="sta">
                    <option value="${list.typeContent}">${list.typeContent}</option>
                </c:forEach>
                <%--<option value="军事">军事</option>
                <option value="文化">文化</option>
                <option value="历史">历史</option>
                <option value="杂谈">杂谈</option>--%>
            </select>
        </div>
        <div class="form-group">
            <label for="title">Title:</label>
            <input type="text" class="form-control" name="title" id="title" value="${article.title}">
        </div>
        <div class="form-group">
            <label for="Textarea">内容:</label>
            <textarea class="form-control" id="Textarea" name="content" rows="3"
                      style="height: 400">${article.content}</textarea>
        </div>
        <div>
            <input type="submit" class="btn btn-outline-secondary" value="更新">
            <%--<button type="button" class="btn btn-outline-secondary"><a
                    href="ArticleCatalogServlet" style="text-decoration: none;color: #5a6268;">返回</a>
            </button>--%>
            <button type="button" class="btn btn-outline-secondary" onclick="javascript:history.go(-1)">返回</button>
        </div>
    </div>
</form>
</body>
</html>
