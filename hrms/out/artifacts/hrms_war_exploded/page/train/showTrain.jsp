<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/11/7
  Time: 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><link rel="shortcut icon"type="image/x-icon" href="images/logo.ico"media="screen" />
    <title>培训页</title>
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
<div style="margin-right: 318px;margin-top: 70px;float: right">
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
        安排名单：
        <c:choose>
            <c:when test="${noticeList!=null&&noticeList.size()>0}">
                <c:forEach items="${noticeList}" var="no">
                    ${no.employee.realName}
                </c:forEach>
            </c:when>
            <c:otherwise>
                暂未安排任何人员
            </c:otherwise>
        </c:choose>
    </div>
</div>
</body>
</html>
