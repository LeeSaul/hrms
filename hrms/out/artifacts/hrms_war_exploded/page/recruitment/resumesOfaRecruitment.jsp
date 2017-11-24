<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/11/5
  Time: 9:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><link rel="shortcut icon"type="image/x-icon" href="images/logo.ico"media="screen" />
    <title>投递信息</title>
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
    <c:choose>
        <c:when test="${resumes!=null&&resumes.size()>0}">
           <table style="text-align: center;width: 100%" cellspacing="0px" cellpadding="0px">
                <tr>
                    <td>姓名</td>
                    <td>年龄</td>
                    <td>学历</td>
                    <td>手机号</td>
                    <td>邮箱</td>
                    <td>操作</td>
                </tr>
                <c:forEach items="${resumes}" var="resume">
                    <tr>
                        <td>${resume.resumeName}</td>
                        <td>${resume.age}</td>
                        <td>${resume.gender}</td>
                        <td>${resume.phone}</td>
                        <td>${resume.email}</td>
                        <td><a href="queryAResume?id=${resume.id}">查看详情</a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>
        <c:otherwise>
            暂无投递记录
        </c:otherwise>
    </c:choose>
</div>
<a href="queryAllRecruitment">返回招聘主页</a>
</body>
</html>
