<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/10/26
  Time: 13:23
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
    <script src="jquery/jquery-min.js"></script>
    <title>游客登录页面</title>
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
           $("#tourName").blur(function s1() {
               var tourName=$("#tourName").val();
               if (tourName==''){
                   $('form').attr('onsubmit','return false');
                   $("#tourName").attr("style","border-color: red");
               }else {
                   $('form').attr('onsubmit','return true');
                   $("#tourName").attr("style","border-color: black");
               }
           });
           $("#tourPassword").blur(function s2() {
               var tourPassword=$("#tourPassword").val();
               if (tourPassword==''){
                   $('form').attr('onsubmit','return false');
                   $("#tourPassword").attr("style","border-color: red");
               }else {
                   $('form').attr('onsubmit','return true');
                   $("#tourPassword").attr("style","border-color: black");
               }
           });
           sb=$("#check").click(function () {
               var tourName = $("#tourName").val();
               if (tourName == '') {
                   $('form').attr('onsubmit','return false');
                   $("#tourName").attr("style","border-color: red");
                   return false;
               }
               var tourPassword = $("#tourPassword").val();
               if (tourPassword == '') {
                   $('form').attr('onsubmit','return false');
                   $("#tourPassword").attr("style","border-color: red");
                   return false;
               }
               $('form').attr('onsubmit','return true');
               $("#tourName").attr("style","border-color: black");
               $("#tourPassword").attr("style","border-color: black");
               return true;
           })
       });
    </script>
</head>
<body>
<div>
    <a href="queryRecruitment" id="t1"><span>加入我们</span></a>
    <div id="t12">
        <a href="page/tour/tourRegister.jsp" ><span>注册</span></a>
        <%--<a href="page/tour/tourLogin.jsp"><span>游客登录</span></a>--%>
        <a href="isNeedLogin"><span>游客登录</span></a>
        <a href="companyLogin.jsp"><span>员工登录</span></a>
    </div>
</div>
<br/>
<div id="login">
    <form action="tourLogin" method="post"onsubmit="sb();">
        <br/>
        用户名：<input type="text" name="tourName" id="tourName" style="border-color: black"><br/><br/>
        密码：<input type="password" name="tourPassword" id="tourPassword"  style="border-color: black"><br/><br/>
        <input type="submit" value="登录" id="check"><br/><span style="color: red;font-size: x-small">${info}</span>
    </form>
</div>
</body>
</html>
