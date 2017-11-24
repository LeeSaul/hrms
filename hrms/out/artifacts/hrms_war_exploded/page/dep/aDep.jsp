<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/11/1
  Time: 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="shortcut icon"type="image/x-icon" href="images/logo.ico"media="screen" />
    <%
        String contextPath = request.getContextPath();
        String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+
                contextPath+"/";
    %>
    <base href="<%= basePath%>">
    <title>职位</title>
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
    部门ID：${department.id}<br/>
    部门名称：${department.depName}<br/>
    部门类型：${department.depType}<br/>
    部门描述：${department.depDescription}<br/>
    部门创建时间：${department.depCreatedate}<br/>
    <hr>
    <a href="addOptionJsp?id=${department.id}">添加职位</a>
    <br/>
        ${info}
    <div id="tablediv">
    <c:choose>
    <c:when test="${department.depOptions!=null&&department.depOptions.size()>0}">
                <table style="text-align: center;width: 100%" cellspacing="0px" cellpadding="0px">
                    <tr>
                        <td>职位ID：</td>
                        <td>职位名称：</td>
                        <td>职位描述：</td>
                        <td colspan="4">操作：</td>
                    </tr>
                    <c:forEach items="${department.depOptions}" var="op">
                        <tr>
                            <td>${op.id}</td>
                            <td>${op.optionName}</td>
                            <td>${op.optionDesc}</td>
                            <td>
                                <a href="queryEmpByOpId?positionId=${op.id}">查看该职位人员</a>
                                <a href="updateOptionByIdJsp?id=${op.id}">更改职位</a>
                                <a href="deleteOption?positionId=${op.id}&depId=${department.id}">删除职位</a>
                                <a href="addEmpJsp?depId=${department.id}&opId=${op.id}">添加人员</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>

        <c:otherwise>
                当前部门下没有任何职位
            </c:otherwise>
    </c:choose>
    </div>
</div>
</body>
</html>
