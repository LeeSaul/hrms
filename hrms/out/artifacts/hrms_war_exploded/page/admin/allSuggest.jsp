<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/11/8
  Time: 9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>意见管理</title>
    <link rel="shortcut icon"type="image/x-icon" href="images/logo.ico"media="screen" />
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
    <jsp:include page="../menu6.jsp"/>
</div>
<div id="main2">
    <c:choose>
        <c:when test="${suggests!=null&&suggests.size()>0}">
            <table style="text-align: center;width: 100%" cellspacing="0px" cellpadding="0px">
                <tr>
                    <td>内容</td>
                    <td>状态</td>
                    <td>操作</td>
                </tr>
                <c:forEach items="${suggests}" var="su">
                    <tr>
                        <td>${su.suggestInfo}</td>
                        <td>${su.status}</td>
                        <td>
                            <a href="agreeSuggest?id=${su.id}&empId=${su.empId}">通过</a>
                            <a href="refuseSuggest?id=${su.id}">拒绝</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>
        <c:otherwise>
            暂无复议
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
