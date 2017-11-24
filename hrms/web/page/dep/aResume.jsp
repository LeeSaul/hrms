<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/11/1
  Time: 15:21
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
    <base href="<%= basePath%>">
    <title>简历详情</title>
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
    <jsp:include page="../menu3.jsp"/>
</div>
<div id="main2">
    申请者信息：<br/>
    姓名：${resume.resumeName}<br/>
    年龄：${resume.gender}<br/>
    基本工资：${employee.basicWage}<br/>
    学历：${resume.education}<br/>
    手机号：${resume.phone}<br/>
    邮箱：${resume.email}<br/>
    出生日期：${resume.birthdate}<br/>
    出生地：${resume.birthplace}<br/>
    兴趣爱好：${resume.hobbies}<br/>
    项目经验：${resume.projectExperience}<br/>
    <c:choose>
        <c:when test="${num==1}">
            <a href="addEmpJsp?depId=${depId}&opId=${opId}">返回</a>
        </c:when>
        <c:when test="${num==2}">
            <a href="queryEmpByOpId?positionId=${opId}">返回</a>
        </c:when>
    </c:choose>
</div>
</body>
</html>
