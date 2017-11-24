<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/10/28
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="shortcut icon"type="image/x-icon" href="images/logo.ico"media="screen" />
    <title>简历详情页面</title>
    <%
        String contextPath = request.getContextPath();
        String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+
                contextPath+"/";
    %>
    <base href="<%= basePath%>">
</head>
<body>
${info}
<table style="text-align: left;ign: center;width: 100%" cellspacing="0px" cellpadding="0px">
${resume.age}
${resume.gender}
${resume.phone}
<c:choose>
    <c:when test="${status.equals('已查看')}">
        <a href="sendInvitation">发送邀请</a>
    </c:when>
    <c:when test="${status.equals('等待面试')}">
        <a href="hiring?id=${resume.id}">确认录用</a>
    </c:when>
</c:choose>
</table>
</body>
</html>
