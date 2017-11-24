<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/11/2
  Time: 10:57
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
    <script src="jquery/jquery-min.js"></script>
    <base href="<%= basePath%>">
    <title>安排人员</title>
    <style>
        #main2{
            border: 1px solid #000000;
            border-radius: 1px;
            float: left;
            margin-left: 40px;
            margin-top: 12px;
            height: 503px;
            width: 850px;
        }
    </style>
</head>
<body>
<div style="margin-right: 312px;margin-top: 70px;float: right">
    欢迎${emp.empName}登录
    <a href="empExit">退出</a>
</div>
<div>
    <jsp:include page="../menu4.jsp"/>
</div>
<div id="main2">
    <div id="train">
        培训主题：${train.title}<br/>
        培训内容：${train.content}<br/>
        开始时间：${train.startTime}<br/>
        结束时间：${train.endTime}<br/>
        发布时间：${train.createTime}<br/>
    </div>
    <hr>
    <div>
        <form action="arrangePerson" method="post">
            <input type="text" name="trainId" value="${train.id}" hidden="hidden">
            <c:choose>
                <c:when test="${departments!=null&&departments.size()>0}" >
                    <c:forEach items="${departments}" var="dep">
                        <h3>部门名：${dep.depName}</h3>
                        <table>
                            <c:if test="${dep.employees!=null&&dep.employees.size()>0}">
                                <tr>
                                    <c:forEach items="${dep.employees}" var="em">
                                        <td>
                                            <input type="checkbox" name="emId" value="${em.id}">${em.realName}
                                        </td>
                                    </c:forEach>
                                </tr>
                            </c:if>
                            <c:if test="${dep.employees==null||dep.employees.size()==0}">
                                该部门没有人
                            </c:if>
                        </table>
                    </c:forEach>
                </c:when>
            </c:choose>
            <input type="submit" value="保存">
        </form>
    </div>
</div>
</body>
</html>
