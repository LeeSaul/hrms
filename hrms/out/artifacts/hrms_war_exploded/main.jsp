<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/10/26
  Time: 8:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <link rel="shortcut icon"type="image/x-icon" href="images/logo.ico"media="screen" />
    <%
      String contextPath = request.getContextPath();
      String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+
              contextPath+"/";
    %>
    <title>主页面</title>
    <base href="<%= basePath%>">

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
    </style>
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
</body>
</html>
