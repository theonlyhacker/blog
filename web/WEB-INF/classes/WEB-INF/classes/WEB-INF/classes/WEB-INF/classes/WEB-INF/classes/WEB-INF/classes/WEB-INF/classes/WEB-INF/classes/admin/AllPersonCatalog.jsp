<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>AllPersonCatalog</title>
    <link href="static/bootstrap/bootstrap.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="static/jquery/jquery-3.4.1.min.js"></script>
    <script src="static/bootstrap/bootstrap.js"></script>
    <link href="main/personInfo/AllPerson.css" rel="stylesheet" type="text/css">
   </head>
<body>
<div>

</div>
<div>
    <div>

       <div class="operate">
           <div id="addUserTable" class="addUserTable ">
               <div style="text-align: center !important;">
                   <label>添加用户表单</label>
               </div>
               <br>
               <div style="text-align: right!important;">
                   <label>userName:<input type="text" id="userName"></label><br>
                   <label>password:<input type="text" id="password"></label><br>
                   <label>Tel:<input type="text" id="tel"></label>
               </div>
               <div style="text-align: center !important;">

                   <div>sex:<input type="radio" name="sex" value="男">男
                       <input type="radio" name="sex" value="女">女
                   </div>

                   <div>status:<input type="radio" name="status" value="admin">管理员
                       <input type="radio" name="status" id="status2" value="normal">普通用户
                   </div>

                   <button type="button" class="btn btn-outline-secondary" onclick="addUser()">确认</button>
                   <button type="button" class="btn btn-outline-secondary adduser2">取消</button>
               </div>
           </div>

           <div class="updateUserTable">
               <div style="text-align: center !important;">
                   <label>修改用户表单</label>
               </div>
               <br>
               <div style="text-align: right!important;">
                   <label>userName:<input type="text" id="userName1"></label><br>
                   <label>password:<input type="text" id="password1"></label><br>
                   <label>Tel:<input type="text" id="tel1"></label>
               </div>
               <div style="text-align: center !important;">

                   <div>sex:<input type="radio" name="sex" value="男">男
                       <input type="radio" name="sex" value="女">女
                   </div>

                   <div>status:<input type="radio" name="status" value="admin">管理员
                       <input type="radio" name="status" id="status3" value="normal">普通用户
                   </div>

                   <button type="button" class="btn btn-outline-secondary" onclick="">确认</button>
                   <button type="button" class="btn btn-outline-secondary adduser2">取消</button>
               </div>
           </div>

       </div>


        <div class="showUser">
            <form action="" method="post">
                <table class="table">
                    <thead class="thead-light">
                    <tr>
                        <th colspan="5" style="text-align: center">所有用户列表</th>
                    </tr>
                    </thead>

                    <tbody>
                    <tr style="text-align: right">
                        <th scope="col">用户名</th>
                        <th scope="col">状态</th>
                        <th scope="col">注册日期</th>
                        <th scope="col">
                            <button type="button" class="btn btn-outline-secondary adduser"
                                    style="line-height: 1;padding: 0.23rem 0.5rem">添加
                            </button>
                            功能列表
                        </th>
                    </tr>


                    <c:forEach var="user" items="${allUsers}" varStatus="status">
                        <tr class="text-right" style="">
                            <td><a href="personalInfoServlet?userId=${user.userid}"
                                   style="text-decoration: none">${user.username}</a></td>
                            <td>${user.status}</td>
                            <td>${user.registerDate}</td>
                            <td>
                                <button type="button" class="btn btn-outline-secondary updateUser"
                                        style="line-height: 1;padding: 0.23rem 0.5rem"
                                        onclick="updateUser('${user.userid}')">修改
                                        <%--<a
                                        href="personalInfoServlet?Id=${user.userid}"
                                        style="text-decoration: none">修改</a>--%>
                                </button>
                                <c:choose>
                                    <c:when test="${user.status == 'normal'}">
                                        <button type="button" class="btn btn-outline-secondary"
                                                style="line-height: 1;padding: 0.23rem 0.5rem"><a
                                                href="prohibitPersonServlet?id=${user.userid}&status=disable"
                                                style="text-decoration: none;color:cornflowerblue">禁用</a>
                                        </button>
                                    </c:when>
                                    <c:when test="${user.status == 'admin'}">

                                    </c:when>
                                    <c:otherwise>
                                        <button type="button" class="btn btn-outline-secondary"
                                                style="line-height: 1;padding: 0.23rem 0.5rem"><a
                                                href="prohibitPersonServlet?id=${user.userid}&status=normal"
                                                style="text-decoration: none;color:cornflowerblue">恢复</a>
                                        </button>
                                    </c:otherwise>
                                </c:choose>

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
        </div>
    </div>
</div>
<script>
    $(function () {
        $(".adduser,.adduser2").click(function () {
            if (document.getElementById('addUserTable').style.display == 'none') {
                document.getElementById('addUserTable').style.display = 'block';
            } else {
                document.getElementById('addUserTable').style.display = 'none';
            }
        })
        /*考虑到代码量的问题，直接添加一个onclick方法代码量更少
        $(".queRen").click(function () {
             addUser();
         })*/

        /*$(".updateUser").click(function () {

        })*/

    })

    function updateUser(id) {
        var id1 = id;
        $.ajax({
            url: "personalInfoServlet?Id=" + id1,
            type: "get",
            data: {},
            datatype: "text/json",
            success: function (data) {
                var str = JSON.stringify(data);
                var div = $('.updateUser');
                div.empty();
                div.append();
            }
        })
    }

    function addUser() {
        var userName = $('#userName').val();
        var password = $('#password').val();
        var tel = $('#tel').val();
        var sex = $('input[name=sex]:checked').val();
        var status = $('input[name=status]:checked').val();
        $.ajax({
            type: "post",
            url: "register",
            data: {
                "userName": userName,
                "Password": password,
                "userTel": tel,
                "sex": sex,
                "status": status
            },
            success: function (data) {
                if (data) {
                    alert("添加成功")
                }
            },
            error: function () {
                alert("添加出现意外，具体看后台日志");
            }
        })
    }

</script>
</body>
</html>
