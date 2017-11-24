<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/11/2
  Time: 8:08
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
    <title>培训首页</title>
</head>
<body>
<a href="page/train/addTrain.jsp">添加培训信息</a>
<a href="queryAllTrain">查看培训信息</a>
</body>
</html>
