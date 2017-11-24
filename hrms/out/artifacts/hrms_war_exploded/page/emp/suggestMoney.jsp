<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/11/8
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="shortcut icon"type="image/x-icon" href="images/logo.ico"media="screen" />
    <title>同意复议</title>
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
    <jsp:include page="../menu4.jsp"/>
</div>
<div id="main2">
    <form action="addExtraSalary" method="get">
        加工资：<input type="text" name="salary"><br/>
        <input type="text" name="empId" value="${empId}" hidden="hidden">
        <input type="text" name="id" value="${id}" hidden="hidden">
        <input type="submit" value="确定">
    </form>
</div>
</body>
</html>
