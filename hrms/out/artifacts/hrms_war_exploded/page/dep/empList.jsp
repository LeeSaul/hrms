<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/11/1
  Time: 12:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="shortcut icon"type="image/x-icon" href="images/logo.ico"media="screen" />
    <title>职位员工</title>
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
    部门信息<br/>
    部门Id：${department.id}<br/>
    部门名：${department.depName}<br/>
    部门类型：${department.depType}<br/>
    部门描述：${department.depDescription}<br/>
    部门创建时间：${department.depCreatedate}<br/>
    <hr>
    职位信息： <br/>
    职位ID：${depOption.depId}<br/>
    职位名：${depOption.optionName}<br/>
    职位描述：${depOption.optionDesc}<br/>
    <hr>
    ${info}
    <c:choose>
        <c:when test="${employees!=null&&employees.size()>0}">
            <table style="text-align: center;width: 100%" cellspacing="0px" cellpadding="0px">
                <tr>
                    <td>账号名</td>
                    <td>员工密码</td>
                    <td>员工状态</td>
                    <td>员工类型</td>
                    <td>操作</td>
                </tr>
                <c:forEach items="${employees}" var="emp">
                    <tr>
                        <td>${emp.empName}</td>
                        <td>${emp.empPassword}</td>
                        <td>${emp.empStatus}</td>
                        <td>${emp.empType=='1'?'员工':'管理员'}</td>
                        <td>
                            <a href="queryResumeById?id=${emp.resumeId}&num=2&opId=${depOption.id}&depId=${department.id}">查看资料</a>
                            <a href="changeJsp?empId=${emp.id}">换岗</a>
                            <a href="deleteEmp?empId=${emp.id}&opId=${depOption.id}">删除员工</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>
    </c:choose>
</div>
</body>
</html>
