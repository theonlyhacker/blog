<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<html>
<head>
    <title>注册页面</title>
    <link href="../static/bootstrap/bootstrap.css" rel="stylesheet" type="text/css">
    <style>
        tr {
            align: center;
            width: 300px;
            height: 40px;
        }

        td {
            font-size: 20px;
            align: center;
        }

        .userinput {
            display: block;
            width: auto;
            height: calc(1.5em + 0.75rem + 2px);
            padding: 0.375rem 0.75rem;
            font-size: 1rem;
            font-weight: 100;
            line-height: 1.5;
            color: #495057;
            background-color: #fff;
            background-clip: padding-box;
            border: 1px solid #ced4da;
            border-radius: 0.25rem;
            transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
        }
    </style>
    <link href="static/bootstrap/bootstrap.css" rel="stylesheet" type="text/css">

    <script type="text/javascript" src="static/jquery/jquery-3.4.1.min.js"></script>
    <script src="static/bootstrap/bootstrap.js"></script>

    <script>
        $(function () {
            $("#registerFrom").submit(function () {
                var error = true;
                $("#passhelp2").html("")
                if ($("#password1").val() == null || $("#password1").val() != $("#password2").val()) {
                    $("#passhelp2").html("密码为空或者两次密码不一致!!!请重新输入");
                    error = false;
                } else error = true;
                return error;
            })
        })

        function helpUserInfo() {
            $("#namehelp").css('display', 'inline');
        }

        function norUserhelp() {
            $("#namehelp").css('display', 'none');
        }

        function helpPasshelp() {
            $("#passhelp1").css('display', 'inline');
        }

        function norPasshelp() {
            $("#passhelp1").css('display', 'none');
        }

        /*实现遍历但是能能对Input有用?
        $("input[name*=user]").each(function () {

        })*/
    </script>
</head>
<body>
<div align="center" style="color: cadetblue;font-size: 50px;font-family: 'Courier New'">Welcome To My Blog's
    Registration Page
</div>
<br><br>
<form action="register" method="post" id="registerFrom">
    <div style="margin-left: 42%;height: 38px" class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text" id="basic-addon1" style="height: 38">用户名:</span><%--<span style="color: red">*</span>--%>
        </div>
        <input type="text" class="userinput" name="userName" id="" onmousemove="helpUserInfo(this)" value="${userName}"
               onmouseout="norUserhelp(this)"><span id="namehelp" style="color: #5a6268">*请输入用户名在4~10个字符之间!</span>
        <span style="color: red">${errorMsg}</span>
    </div>

    <div style="margin-left: 42%;height: 38" class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text" id="basic-addon2" style="height: 38">性&nbsp&nbsp&nbsp 别:</span>
        </div>
        <%--<input type="text" class="userinput" name="userSex" id="">--%>
        <div class="form-check form-check-inline" style="width: 10px"></div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="sex" id="inlineRadio1" value="男"
                   checked="checked">
            <label class="form-check-label" for="inlineRadio1">男</label>
        </div>
        <div class="form-check form-check-inline" style="width: 10px"></div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="sex" id="inlineRadio2" value="女">
            <label class="form-check-label" for="inlineRadio2">女</label>
        </div>
    </div>

    <div style="margin-left: 42%;height: 38" class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text" id="basic-addon3" style="height: 38">手机号:</span>
        </div>
        <input type="text" class="userinput" name="userTel" id="">
    </div>

    <div style="margin-left: 42%;height: 38" class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text" id="basic-addon4" style="height: 38">密&nbsp&nbsp&nbsp 码:</span>
        </div>
        <input type="password" class="userinput" name="Password" id="password1" onmousemove="helpPasshelp(this)"
               onmouseout="norPasshelp(this)"><span id="passhelp1" style="color: #5a6268">*请输入密码</span>
    </div>
    <div style="margin-left: 42%;height: 38" class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text" id="basic-addon5" style="height: 38">确认密码:</span>
        </div>
        <input type="password" class="userinput" id="password2"><span id="passhelp2" style="color: red;"></span>
    </div>
    <div align="center"><input type="submit" class="btn btn-outline-secondary" value="注册"></div>
</form>
</body>
</html>
