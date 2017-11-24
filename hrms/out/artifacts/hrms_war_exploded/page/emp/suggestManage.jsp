<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/11/8
  Time: 8:51
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
    <title>意见管理</title>
    <title>员工主界面</title>
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
        <a href="page/emp/addSuggest.jsp">薪资复议</a>
        <a href="querySuggest">复议情况</a>
    </div>
</div>
</body>
</html>
