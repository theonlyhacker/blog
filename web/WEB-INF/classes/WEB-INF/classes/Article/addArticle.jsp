<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
    <title>addArticle</title>
    <link href="static/bootstrap/bootstrap.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="static/jquery/jquery-3.4.1.min.js"></script>
    <script>
        $(function () {
            $("#writeAriticleForm").submit(function () {
                var title = $("#title").val();
                if(title == null|| title == ""){
                    alert("title不能为空!");
                    return false;
                }
                else return true;
            })
        })
        function save() {
            alert("保存成功!");
            window.location.href="/peopleindex.jsp";
        }
    </script>
</head>
<body>
<form action="addArticleServlet" method="post" id="writeAriticleForm">
    <div id="contermiddle" style="width: 60%;float: left;margin-left: 25%">
        <h3 style="color: #7abaff;font-family: SansSerif;" align="center">添加文章</h3>
        <div class="form-group">
            <label for="Ariticleclass">文章类型:</label>
            <select class="form-control" id="Ariticleclass" name="articleType" style="width: 200">
                <option aria-checked="true" value="科技">科技</option>
                <option value="军事">军事</option>
                <option value="文化">文化</option>
                <option value="历史">历史</option>
                <option value="杂谈">杂谈</option>
            </select>
        </div>
        <div class="form-group">
            <label for="title">Title:</label>
            <input type="text" class="form-control" name="title" id="title" placeholder="Title不能为空">
        </div>
        <div class="form-group">
            <label for="Textarea">内容:</label>
            <textarea class="form-control" id="Textarea" name="content" rows="3" style="height: 400"></textarea>
        </div>
        <div>
            <input type="submit" class="btn btn-outline-secondary" value="提交">
            <button type="button" class="btn btn-outline-secondary" id="save" click="save()">保存</button>
            <button type="button" class="btn btn-outline-secondary"><a href="main" style="text-decoration: none;color: #5a6268;">返回</a></button>
        </div>
    </div>
</form>
</body>
</html>

