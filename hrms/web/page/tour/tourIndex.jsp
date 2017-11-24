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
<head><link rel="shortcut icon"type="image/x-icon" href="images/logo.ico"media="screen" />
    <%
        String contextPath = request.getContextPath();
        String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+
                contextPath+"/";
    %>
    <base href="<%= basePath%>">
    <title>成功</title>
    <style>
        #m{
            margin-left: 14%;
            margin-right: 30%;
            margin-top: 50px;
            text-align: center;
        }
        #login{
            float: right;
            margin-top: -8px;
            margin-right: -168px;
        }
        #t1{
            margin-left: 121px;
            margin-top: -10px;
        }
        #t2{
            border: solid #5d5d5d;
            border-radius: 6px;
            width: 1000px;
            height: 600px;
        }
    </style>

</head>
<body>
<div id="m">
    <div id="login">
        <c:if test="${not empty tourist}">
            欢迎用户${tourist.tourName}登录
        </c:if>
        <a href="touristExitLogin" style="margin-left: 10px;margin-top: 10px;">退出</a>
    </div>

    <div id="t1">
        <a href="queryMyResume">填写简历</a>
        <a href="queryDeliveryByTourist">预览投递记录</a>
        <a href="queryRecruitment">招聘</a>
    </div>
    <div id="t2">

    </div>
</div>
</body>
</html>
