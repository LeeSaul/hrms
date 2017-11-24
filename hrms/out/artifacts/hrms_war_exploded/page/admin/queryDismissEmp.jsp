<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/11/5
  Time: 14:57
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
    <link rel="shortcut icon"type="image/x-icon" href="images/logo.ico"media="screen" />
    <title>已删除员工</title>
    <style>
        #main2{
            border: 1px solid #000000;
            border-radius: 1px;
            float: left;
            margin-left: 40px;
            margin-top: 12px;
            height: 503px;
            width: 971px;overflow-y: auto;
        }
    </style>
</head>
<body>
<div style="margin-right: 205px;margin-top: 70px;float: right">
    欢迎${emp.empName}登录
    <a href="empExit">退出</a>
</div>
<div>
    <jsp:include page="../menu6.jsp"/>
</div>
<div id="main2">
    <c:choose>
        <c:when test="${employees!=null&&employees.size()>0}">
            <table style="text-align: center;width: 100%" cellspacing="0px" cellpadding="0px">
                <tr>
                    <td>账户名：</td>
                    <td>账号密码：</td>
                    <td>真实姓名：</td>
                    <td>账号类型：</td>
                    <td>状态：</td>
                    <td>操作</td>
                </tr>
                <c:forEach items="${employees}" var="emp">
                    <tr>
                        <td>${emp.empName}</td>
                        <td>${emp.empPassword}</td>
                        <td>${emp.realName}</td>
                        <td>${emp.empType}</td>
                        <td>${emp.empStatus}</td>
                        <td><a href="recoveryEmp?id=${emp.id}">恢复员工账号</a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>
        <c:otherwise>
            暂无
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
