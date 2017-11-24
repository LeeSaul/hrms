 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/10/29
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="shortcut icon"type="image/x-icon" href="images/logo.ico"media="screen" />
    <title>部门列表</title>
    <%
        String contextPath = request.getContextPath();
        String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+
                contextPath+"/";
    %>
    <base href="<%= basePath%>">
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
    <jsp:include page="../menu3.jsp"/>
</div>
<div id="main2">
    <div id="tablediv">
        ${info}
        <c:choose>
            <c:when test="${departments!=null&&departments.size()>0}">
                <table style="text-align: center;width: 970px" cellspacing="0px" cellpadding="0px">
                    <tr>
                        <td>部门ID</td>
                        <td>部门名</td>
                        <td>类型</td>
                        <td>说明</td>
                        <td colspan="3">操作</td>
                    </tr>
                    <c:forEach items="${departments}" var="dep">
                        <tr>
                            <td>${dep.id}</td>
                            <td>${dep.depName}</td>
                            <td>${dep.depType}</td>
                            <td>${dep.depDescription}</td>
                            <td>
                                    <%--包括这个部门下所有职位，以及每个职位对应的人--%>
                                <a href="queryDepById?id=${dep.id}">查看详情</a>
                                <a href="addOptionJsp?id=${dep.id}">添加职位</a>
                                <a href="deleteDepById?id=${dep.id}">删除部门</a>
                                <a href="updateDepByIdJsp?id=${dep.id}">更新部门信息</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                <br/>
                暂无任何部门
            </c:otherwise>
        </c:choose>
    </div>
</div>
</body>
</html>
