<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/11/2
  Time: 8:47
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
    <title>培训列表</title>
    <style>
        #main2{
            border: 1px solid #000000;
            border-radius: 1px;
            float: left;
            margin-left: 40px;
            margin-top: 12px;
            height: 503px;
            width: 850px;
            overflow-y: auto;
            overflow-x: auto;
        }
    </style>
</head>
<body>
<div style="margin-right: 318px;margin-top: 70px;float: right">
    欢迎${emp.empName}登录
    <a href="empExit">退出</a>
</div>
<div>
    <jsp:include page="../menu4.jsp"/>
</div>
<div id="main2">
    ${info}
    <div id="tablediv">
        <c:choose>
            <c:when test="${not empty trains}">
                <table style="text-align: center;width: 1100px" cellspacing="0px" cellpadding="0px">
                    <tr>
                        <td>培训主题</td>
                            <%--<td>培训内容</td>--%>
                        <td>开始时间</td>
                        <td>结束时间</td>
                        <td>发布时间</td>
                        <td colspan="4">操作</td>
                    </tr>
                    <c:forEach items="${trains}" var="train">
                        <tr>
                        <td>${train.title}</td>
                        <%--<td>${train.content}</td>--%>
                        <td>${train.startTime}</td>
                        <td>${train.endTime}</td>
                        <td>${train.createTime}</td>
                        <td>
                            <a href="updateTrainJsp?id=${train.id}">更改培训信息</a>
                            <a href="arrangePersonJsp?id=${train.id}">重新安排培训人员</a>
                            <a href="queryTransById?id=${train.id}">查看培训信息</a>
                            <a href="deleteTrain?id=${train.id}">删除</a>
                        </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
        </c:choose>
    </div>
</div>
</body>
</html>
