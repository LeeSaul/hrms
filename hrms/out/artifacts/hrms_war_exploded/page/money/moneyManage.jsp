<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/11/4
  Time: 20:10
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
    <title>薪资管理</title>
    <script src="jquery/jquery-min.js"></script>
    <script>
        $(function () {
            $("#checkWork").click(function () {
                $.ajax({
                    url:"checkWork",
                    type:"post",
                    success:function () {
                        alert("生成成功");
                    }
                });
            });
        });
    </script>
    <script>
        $(function () {
            $(".social").blur(function () {
                var social=$(".social").val();
                if (social==""){
                    $(".social").attr("style","border-color: red");
                }else {
                    $(".social").attr("style","border-color: black");
                }
            });
            sb=$(".check").click(function () {
                var social=$(".social").val();
                if (social==""){
                    $(".social").attr("style","border-color: red");
                    return false;
                }
                $(".social").attr("style","border-color: black");
                return true;
            });
        })
    </script>
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
    <jsp:include page="../menu5.jsp"/>
</div>
<div id="main2">
    <a href=""></a>
    <button id="checkWork">生成上个月奖罚表</button>
    <form action="updateSocialPay" method="get" onsubmit="sb()">
        社保占工资比：<input type="text" value="${proportion}" name="social" class="social">%
        <input type="submit" value="修改" class="check">
    </form>
    <a href="countMoney">结算薪资</a>
    <%--<a href="queryLastAttendance">查看上个月考勤记录</a>
    <a href="queryCurrentMonth">查看本月考勤记录</a>
    <a href="queryRewardsPun">查看上个月奖惩记录</a>
    <a href="querySalary">查看上个月员工工资</a>--%>
</div>
</body>
</html>
