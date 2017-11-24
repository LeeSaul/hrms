<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/10/27
  Time: 9:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><link rel="shortcut icon"type="image/x-icon" href="images/logo.ico"media="screen" />
    <%
        String contextPath = request.getContextPath();
        String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+
                contextPath+"/";
    %>
    <base href="<%= basePath%>">
    <title>员工登录</title>
    <script src="jquery/jquery-min.js"></script>
    <style>
        body{
            background-image: url("images/bg.jpg");
            background-size: 100% 100%;
        }
        #t1{
            float: left;
            margin-left: 100px;
        }
        #t12{
            float: right;
            margin-right: 200px;
        }
        span{
            font-size: x-large;
            color: black;
        }
        a{
            text-decoration: none;
        }
        #login{
            clear: both;
            width: 23%;
            text-align: center;
            height: 170px;
            border: solid 1px black;
            border-radius: 5px;
            margin-left: 68%;
            margin-top: 13%;
        }
    </style>
    <script>
        $(function () {
            $("#name").blur(function s1() {
                var name=$("#tourName").val();
                if (name==''){
                    $('form').attr('onsubmit','return false');
                    $("#name").attr("style","border-color: red");
                }else {
                    $('form').attr('onsubmit','return true');
                    $("#name").attr("style","border-color: black");
                }
            });
            $("#pass").blur(function s2() {
                var pass=$("#pass").val();
                if (pass==''){
                    $('form').attr('onsubmit','return false');
                    $("#pass").attr("style","border-color: red");
                }else {
                    $('form').attr('onsubmit','return true');
                    $("#pass").attr("style","border-color: black");
                }
            });

            sb=$("#check").click(function () {
                var name = $("#name").val();
                if (name == '') {
                    $('form').attr('onsubmit','return false');
                    $("#name").attr("style","border-color: red");
                    return false;
                }
                var pass = $("#pass").val();
                if (pass == '') {
                    $('form').attr('onsubmit','return false');
                    $("#pass").attr("style","border-color: red");
                    return false;
                }
                $('form').attr('onsubmit','return true');
                $("#name").attr("style","border-color: black");
                $("#pass").attr("style","border-color: black");
                return true;
            })
        })
    </script>
</head>
<body>
<div>
    <a href="queryRecruitment" id="t1"><span>加入我们</span></a>
    <div id="t12">
        <a href="page/tour/tourRegister.jsp" ><span>注册</span></a>
        <a href="isNeedLogin"><span>游客登录</span></a>
        <a href="companyLogin.jsp"><span>员工登录</span></a>
    </div>
</div>
<br/>
<div id="login">
<form action="companyLogin" method="post" onsubmit="sb()">
    <br/>
    用户名：<input type="text" name="empName" id="name"><br/><br/>
    密码：<input type="password" name="empPassword" id="pass"><br/><br/>
    <input type="radio" name="empType" value="1" checked="checked">员工
    <input type="radio" name="empType" value="0">管理员 <br/><br/>
    <input type="submit" value="登录" id="check"><br/>
    <span style="color: red;font-size: x-small">${info}</span>
</form>
</div>
</body>
</html>
