<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
Created by IntelliJ IDEA.
User: user
Date: 2017/11/3
Time: 16:25
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="shortcut icon"type="image/x-icon" href="images/logo.ico"media="screen" />
    <title>考勤记录</title>
    <script src="jquery/jquery-min.js"></script>
    <script>
        $(function () {
            $("#clock").click(function () {
                $.ajax({
                    url:"clock",
                    type:"post",
                    success:function (msg) {
                        alert(msg);
//                        $("#clockInfo").html(msg);
                    }
                })
            })
        });
        //看是否有培训信息
        $(function () {
            $.ajax({
                url:"queryTrainByEmpId",
                type:"post",
                dataType:'json',
                success:function (msg) {
                    console.log(msg);
                    if (msg!=null){
                        $("#info").html("培训通知");
                    }
                }
            })
        });
    </script>
    <style>
        #m{
            margin-left: 14%;
            margin-right: 30%;
            margin-top: 50px;
            text-align: center;
        }
        #login{
            float: right;
            margin-top: 0px;
            margin-right: -168px;
        }
        #t1{
            margin-left: 90px;
            margin-top: -10px;
        }
        #t2{
            border: solid #5d5d5d;
            border-radius: 6px;
            width: 1000px;
            height: 600px;
            overflow-y:auto;
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
        <c:if test="${not empty emp}">
            欢迎${emp.empName}登录
        </c:if>
        <a href="empExit">退出</a>
    </div>

    <div id="t1">
        <span id="clockInfo"></span>
        <button id="clock" style="margin-left: -100px;margin-bottom: 10px">打卡</button>
        <a href="queryAttendanceByIdOfAMonth" style="margin-left: 10px">查看上个月打卡记录</a>
        <a href="queryCurrentMonthById">查询当月打卡记录</a>
        <a href="queryPhone">查看通讯录</a>
        <a id="info" href="queryTrain"></a>
        <a href="page/emp/suggestManage.jsp">意见管理</a>
        <a href="updateEmpJsp">个人资料</a>
        <a href="queryLastSalary">查看上月工资</a>
        <a href="page/emp/updatePassword.jsp">修改密码</a>
    </div>
    <div id="t2">
        <h3>员工考勤记录</h3>
        <c:choose>
            <c:when test="${not empty attendances}">
                <table style="text-align: center;width: 100%" cellspacing="0px" cellpadding="0px">
                    <tr>
                        <td>上班打卡时间</td>
                        <td>下班打卡时间</td>
                    </tr>
                    <c:forEach items="${attendances}" var="att">
                        <tr>
                            <td>${att.startTime}</td>
                            <td>${att.endTime}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
        </c:choose>
    </div>
</div>
</body>
</html>
