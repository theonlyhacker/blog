<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>ArticleInfo</title>
    <link href="static/bootstrap/bootstrap.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="static/jquery/jquery-3.4.1.min.js"></script>
</head>
<body>
<form action="ArticleInfoServlet" method="post" id="ArticleForm">
    <input type="hidden" name="articleId" value="${article.id}">
    <input type="hidden" name="authorId" value="${article.idAuthor}">
    <input type="hidden" name="ReviewTargetId" value="0">
    <div id="contermiddle" style="width: 60%;float: left;margin-left: 25%">
        <div class="form-group">
            <label for="Ariticleclass">文章类型:</label>
            <select class="form-control" id="Ariticleclass" readonly="readonly" name="articleType" style="width: 200">
                <option aria-checked="true" value="${article.type}" readonly="readonly">${article.type}</option>
            </select>
        </div>
        <div class="form-group">
            <label for="title">Title:</label>
            <input type="text" class="form-control" name="title" id="title" value="${article.title}" readonly>
        </div>
        <div class="form-group">
            <label for="Textarea">内容:</label>
            <textarea class="form-control" id="Textarea" name="content" readonly rows="3"
                      style="height: 400">${article.content}</textarea>
        </div>
        <div>
            <c:choose>
                <c:when test="${article.idAuthor == userIdd}">
                    <button type="button" class="btn btn-outline-secondary"><a
                            href="updateArticleServlet?id=${article.id}"
                            style="text-decoration: none;color: #5a6268;">修改</a>
                    </button>
                    <button type="button" class="btn btn-outline-secondary"><a href="ArticleCatalogServlet"
                                                                               style="text-decoration: none;color: #5a6268;">返回</a>
                    </button>
                </c:when>
                <c:otherwise>
                    <button type="button" class="btn btn-outline-secondary"><a href="AllArticleCatalogsServlet"
                                                                               style="text-decoration: none;color: #5a6268;">返回</a>
                    </button>
                </c:otherwise>
            </c:choose>
        </div>

        <div class="form-group">
            <table class="table" id="table1">
                <tr>
                    <th colspan="3"><textarea class="form-control" name="newReview"></textarea></th>
                </tr>
                <tr>
                    <th colspan="3" id="addReview">
                        <input type="submit" class="btn btn-outline-secondary" value="评论">
                    </th>
                </tr>
                <tr>
                    <th colspan="3"><label>相关评论</label></th>
                </tr>

                <c:forEach var="review" items="${reviewsList}" varStatus="status">
                    <tr>
                        <th><a href="personalInfoServlet?userId=${review.reviewUserId}">${review.reviewName}</a></th>
                        <th>${review.reviewDate}</th>
                        <th>
                            <button type="button" class="btn btn-outline-secondary" id=""
                                    onclick="showReviews('${review.reviewId}')"
                                    style="line-height: 1;padding: 0.23rem 0.5rem">回复
                            </button>
                        </th>
                    </tr>
                    <tr>
                        <th colspan="3">
                            <p class="form-control" style="border: none">${review.reviewContent}</p>
                            <c:forEach var="list" items="${commentsList}" varStatus="status">
                                <c:if test="${review.reviewId eq list.reviewTargetId}">
                                    <p class="form-control" style="margin-left: 8%;border: none">
                                        <a href="personalInfoServlet?userId=${list.reviewUserId}"
                                           style="text-decoration: none">${list.reviewName}&nbsp</a>回复&nbsp
                                        <a href="personalInfoServlet?userId=${list.reviewUserId}"
                                           style="text-decoration: none">${list.reviewCName}</a>
                                        :${list.reviewContent}&nbsp&nbsp&nbsp时间:${list.reviewDate}
                                    </p>
                                </c:if>
                            </c:forEach>
                            <br>
                            <div id="${review.reviewId}" style="display: none">
                                <textarea class="form-control" name="${review.reviewId}"></textarea>
                                <button type="button" class="btn btn-outline-secondary"
                                        onclick="addComments('${review.reviewId}')">提交
                                </button>
                                    <%--                                <input type="button" class="btn btn-outline-secondary" onsubmit="test()" value="回复">--%>
                            </div>
                        </th>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

</form>
<script>
    function showReviews(a) {
        // var qw = a;
        /*$.getJSON("ArticleInfoServlet",{commentid:a},function (msg) {
            msg = msg[0];
            if(msg.length>0){
                for(var j=0;j<msg.length;j++){
                    $('#


        ${review.reviewId}').append('<div><span>'+msg[j].reviewName+'</span> ' +
                        '回复 <span>'+msg[j].reviewCName+'</span>:' + msg[j].reviewContent+'</div>')
                }
            }
        })*/
        if (document.getElementById(a).style.display !== 'none') {
            document.getElementById(a).style.display = 'none';
        } else {
            document.getElementById(a).style.display = '';
        }
    }

    function addComments(b) {
        var newReview = $("textarea[name='" + b + "']").val();
        var ReviewTargetId = b;

        $.ajax({
            type: "post",
            dateType: "text",
            url: "ArticleInfoServlet",
            data: {
                "articleId": "${article.id}",
                "newReview": newReview,
                "ReviewTargetId": ReviewTargetId,
                "authorId": "${article.idAuthor}",
            },
            success: function (data) {
                //data == "true"
                if (data) {
                    alert("评论成功");//这里评论成功应该是评论已经评论在下面了
                    //2019.12.12 正在重新改路径啥的
                    //而不是刷新该页面或者是返回上一个页面才能显示新的评论，但目前还没有写出来，目前的思路是用json封装直接在添加
                }
            },
            error: function () {
                alert("评论出现意外");
            }
        })
    }

    /*$(function () {
        $('#ArticleForm').submit(function () {

        })
    })*/
</script>
</body>
</html>
