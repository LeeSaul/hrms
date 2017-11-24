<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/11/5
  Time: 9:17
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
    <title>招聘信息</title>
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
    <jsp:include page="../menu2.jsp"/>
</div>
<div id="main2">
    <div id="tablediv">
        <c:choose>
            <c:when test="${not empty recruitments}">
                <table  style="text-align: center;width: 970px" cellspacing="0px" cellpadding="0px">
                    <tr>
                        <td>薪水</td>
                        <td>工作地点</td>
                        <td>职位类型</td>
                        <td>描述</td>
                        <td>发布日期</td>
                        <td>其他</td>
                        <td colspan="3">操作</td>
                    </tr>
                    <c:forEach items="${recruitments}" var="rec">
                        <tr>
                            <td>${rec.salary}</td>
                            <td>${rec.workingPlace}</td>
                            <td>${rec.positionType}</td>
                            <td>${rec.description}</td>
                            <td>${rec.createDate}</td>
                            <td>${rec.otherInfo}</td>
                            <td><a href="updateRecByIdJsp?id=${rec.id}">更新招聘信息</a></td>
                            <td><a href="queryARec?id=${rec.id}">查看已投递简历</a></td>
                            <td><a href="deleteRecById?id=${rec.id}">删除招聘信息</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
        </c:choose>
    </div>
</div>
</body>
</html>
