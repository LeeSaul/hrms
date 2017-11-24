<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/10/31
  Time: 9:52
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
    <title>欢迎界面</title>
</head>
<body>
<h2>欢迎来到人力资源管理系统</h2>
</body>
</html>
