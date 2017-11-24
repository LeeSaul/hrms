<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/10/26
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><link rel="shortcut icon"type="image/x-icon" href="images/logo.ico"media="screen" />
    <title>简历</title>
    <style>
        #m{
            margin-left: 14%;
            margin-right: 30%;
            margin-top: 50px;
            text-align: center;
        }
        #login{
            float: right;
            margin-top: -8px;
            margin-right: -168px;
        }
        #t1{
            margin-left: 121px;
            margin-top: -10px;
        }
        #t2{
            border: solid #5d5d5d;
            border-radius: 6px;
            width: 1000px;
            height: 600px;
            overflow-y: auto;
        }
        table,tr,td{
            border-radius: 1px;
            border: solid #000000 1px;
        }
    </style>

</head>
<body>
<div id="m">
    <div id="login">
        <c:if test="${not empty tourist}">
            欢迎用户${tourist.tourName}登录
        </c:if>
        <a href="touristExitLogin" style="">退出</a>
    </div>

    <div id="t1">
        <a href="queryMyResume">填写简历</a>
        <a href="queryDeliveryByTourist">预览投递记录</a>
        <a href="queryRecruitment">招聘</a>
    </div>
    <div id="t2">
        <c:choose>
            <c:when test="${deliveries!=null&&deliveries.size()>0}">
                <table style="text-align: center;width: 100%" cellspacing="0px" cellpadding="0px">
                <tr>
                    <td>申请ID</td>
                    <td>简历状态</td>
                    <td>操作</td>
                </tr>
                <c:forEach items="${resume.deliveries}" var="delivery">
                    <tr>
                        <td>${delivery.id}</td>
                        <td>${delivery.status}</td>
                        <td>
                            <a href="queryDetailDeliveryById?id=${delivery.id}">查看详情</a>
                            <c:if test="${delivery eq '邀请面试'}">
                                <a href="ensureInvitation?id=${delivery.id}">确认面试</a>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                暂无投递记录
            </c:otherwise>
        </c:choose>
    </div>
</div>
</body>
</html>
