<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/10/27
  Time: 12:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="shortcut icon"type="image/x-icon" href="images/logo.ico"media="screen" />
    <%
        String contextPath = request.getContextPath();
        String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+
                contextPath+"/";
    %>
    <base href="<%= basePath%>">
    <title>主页</title>
    <script src="jquery/jquery-min.js"></script>
    <style>
        #main2{
            border: 1px solid #000000;
            border-radius: 1px;
            float: left;
            margin-left: 40px;
            margin-top: 100px;
            height: 502px;
            width: 700px;
        }
    </style>
</head>
<body>
<%--<a href="page/resume/cvIndex.jsp">简历管理</a>
<a href="page/recruitment/recruitmentManager.jsp">招聘管理</a>
<a href="queryAllDep">部门信息</a>
<a href="page/train/trainIndex.jsp">培训信息管理</a>
<a href="queryProportion">薪资管理</a>
<a href="queryWorkTime">设置工作时间</a>
<a href="queryDismissEmp">查看已辞退员工</a>
<a href="queryAllSuggest">意见管理</a>--%>
<div style="margin-right: 205px;margin-top: 70px;float: right">
    欢迎${emp.empName}登录
    <a href="empExit">退出</a>
</div>
<div>
    <jsp:include page="../menu.jsp"/>
</div>
<%--<div id="c1">
    <jsp:include page="../../welcome.jsp"/>
</div>--%>

<div id="main2">
    <img src="images/w.jpg" style="height: 502px;width: 971px;">
</div>
</body>
</html>
