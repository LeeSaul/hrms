<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/10/31
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        String contextPath = request.getContextPath();
        String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+
                contextPath+"/";
    %>
    <base href="<%= basePath%>">
    <script src="jquery/jquery-min.js"></script>
    <link rel="shortcut icon"type="image/x-icon" href="images/logo.ico"media="screen" />
    <title>投递记录</title>
    <style>
        #main2{
            border: 1px solid #000000;
            border-radius: 1px;
            float: left;
            margin-left: 40px;
            margin-top: 12px;
            height: 503px;
            width: 971px;
            overflow-y: auto;
        }
    </style>
</head>
<body>
<div style="margin-right: 205px;margin-top: 70px;float: right">
    欢迎${emp.empName}登录
    <a href="empExit">退出</a>
</div>
<div>
    <jsp:include page="../menu1.jsp"/>
</div>
<div id="main2">
    ${info}<br/>
    招聘信息：<br/>
    简历状态：${delivery.status}<br/>
    招聘职位：${delivery.recruitment.positionType}<br/>
    工作地：${delivery.recruitment.workingPlace}<br/>
    发布日期：${delivery.recruitment.createDate}
    <hr>
    申请者信息：<br/>
    姓名：${delivery.resume.resumeName}<br/>
    年龄：${delivery.resume.gender}<br/>
    学历：${delivery.resume.education}<br/>
    手机号：${delivery.resume.phone}<br/>
    邮箱：${delivery.resume.email}<br/>
    出生日期：${delivery.resume.birthdate}<br/>
    出生地：${delivery.resume.birthplace}<br/>
    兴趣爱好：${delivery.resume.hobbies}<br/>
    项目经验：${delivery.resume.projectExperience}<br/>
    <c:choose>
        <c:when test="${delivery.status=='已查看'}">
            <a href="sendInvitation?id=${delivery.id}">通知面试</a>
            <a href="sendRefuse?id=${delivery.id}">不符合条件</a>
        </c:when>
        <c:when test="${delivery.status=='等待面试'}">
            <a href="sendHired?id=${delivery.id}">录取</a>
            <a href="sendRefuse?id=${delivery.id}">不符合条件</a>
        </c:when>
        <c:otherwise>
            <a href="sendHired?id=${delivery.id}">录用</a>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
