<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/10/27
  Time: 13:31
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
    <script src="jquery/jquery-min.js"></script>
    <script>
        $(function () {
            $("#sta").click(function () {
                var status=document.getElementsByName("status");
                var s="";
                for (var i = 0; i < status.length; i++) {
                    var obj = status[i];
                    if(obj.select){
                        console.log("---");
                    }
                }
                $.ajax({
                    url:"queryResumeByStatus",
                    type:"post",
                    dateType:"status="+s,
                    success:function (msg) {
                        console.log("===");
                        console.log(msg)
                    }
                });
            })
        })
    </script>
    <title>简历</title>
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
    <jsp:include page="../menu1.jsp"/>
</div>
<div id="main2">
    <div id="tablediv">
        <c:choose>
            <c:when test="${not empty deliveries}">
                <table style="text-align: center;width: 970px" cellspacing="0px" cellpadding="0px">
                    <tr>
                        <td>申请者</td>
                        <td>申请职位</td>
                        <td>状态</td>
                        <td>操作</td>
                    </tr>
                    <c:forEach items="${deliveries}" var="delivery">
                        <tr>
                            <td>${delivery.resume.resumeName}</td>
                            <td>${delivery.recruitment.positionType}</td>
                            <td>${delivery.status}</td>
                            <td>
                                <a href="queryDetailDelivery?id=${delivery.id}">查看详情</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                暂无
            </c:otherwise>
        </c:choose>
    </div>
    <a href="page/emp/empIndex.jsp"></a>
</div>
</body>
</html>
