<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/11/13
  Time: 8:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工</title>
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
        <c:choose>
            <c:when test="${departments!=null&&departments.size()>0}">
                <table style="text-align: center;width: 970px" cellspacing="0px" cellpadding="0px">
                    <tr>
                        <td>部门ID</td>
                        <td>部门名</td>
                        <td>姓名</td>
                        <td>账户名</td>
                        <td>密码</td>
                        <td>状态</td>
                        <td>基本工资</td>
                    </tr>
                    <c:forEach items="${departments}" var="dep">
                        <c:if test="${dep.employees!=null}">
                            <c:forEach items="${dep.employees}" var="em">
                                <tr>
                                    <td>${dep.id}</td>
                                    <td>${dep.depName}</td>
                                    <td>${em.realName}</td>
                                    <td>${em.empName}</td>
                                    <td>${em.empPassword}</td>
                                    <td>${em.empStatus}</td>
                                    <td>${em.basicWage}</td>
                                </tr>
                            </c:forEach>
                        </c:if>
                    </c:forEach>
                </table>
            </c:when>
        </c:choose>
    </div>
</div>
</body>
</html>
