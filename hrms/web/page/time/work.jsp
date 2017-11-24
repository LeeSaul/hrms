<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/11/3
  Time: 11:10
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
    <script src="jquery/jquery-min.js"></script>
    <title>工作时间</title>
    <style>
        #main2{
            border: 1px solid #000000;
            border-radius: 1px;
            float: left;
            margin-left: 40px;
            margin-top: 12px;
            height: 503px;
            width: 971px;
        }
    </style>
    <script>
        $(function () {
            $(".workTime").blur(function () {
                var workTime=$(".workTime").val();
                if (workTime==""){
                    $(".workTime").attr("style","border-color: red");
                }else {
                    $(".workTime").attr("style","border-color: black");
                }
            });
            $(".offWorkTime").blur(function () {
                var offWorkTime=$(".offWorkTime").val();
                if (offWorkTime==""){
                    $(".offWorkTime").attr("style","border-color: red");
                }else {
                    $(".offWorkTime").attr("style","border-color: black");
                }
            });
            $(".overTime").blur(function () {
                var overTime=$(".overTime").val();
                if (overTime==""){
                    $(".overTime").attr("style","border-color: red");
                }else {
                    $(".overTime").attr("style","border-color: black");
                }
            });
            $(".overPay").blur(function () {
                var overPay=$(".overPay").val();
                if (overPay==""){
                    $(".overPay").attr("style","border-color: red");
                }else {
                    $(".overPay").attr("style","border-color: black");
                }
            });
            $(".days").blur(function () {
                var days=$(".days").val();
                if (days==""){
                    $(".days").attr("style","border-color: red");
                }else {
                    $(".days").attr("style","border-color: black");
                }
            });
            sb=$(".check").click(function () {
                var workTime=$(".workTime").val();
                var offWorkTime=$(".offWorkTime").val();
                var overTime=$(".overTime").val();
                var overPay=$(".overPay").val();
                var days=$(".days").val();

                if (workTime==""){
                    $(".workTime").attr("style","border-color: red");
                    return false;
                }
                if (offWorkTime==""){
                    $(".workTime").attr("style","border-color: black");
                    $(".offWorkTime").attr("style","border-color: red");
                    return false;
                }
                if (overTime==""){
                    $(".workTime").attr("style","border-color: black");
                    $(".offWorkTime").attr("style","border-color: black");
                    $(".overTime").attr("style","border-color: red");
                    return false;
                }
                if (overPay==""){
                    $(".workTime").attr("style","border-color: black");
                    $(".offWorkTime").attr("style","border-color: black");
                    $(".overTime").attr("style","border-color: black");
                    $(".overPay").attr("style","border-color: red");
                    return false;
                }
                if (days==""){
                    $(".workTime").attr("style","border-color: black");
                    $(".offWorkTime").attr("style","border-color: black");
                    $(".overTime").attr("style","border-color: black");
                    $(".overPay").attr("style","border-color: black");
                    $(".days").attr("style","border-color: red");
                    return false;
                }
                $(".workTime").attr("style","border-color: black");
                $(".offWorkTime").attr("style","border-color: black");
                $(".overTime").attr("style","border-color: black");
                $(".overPay").attr("style","border-color: black");
                $(".days").attr("style","border-color: black");
                return true;
            });
        })
    </script>
</head>
<body>
<div style="margin-right: 205px;margin-top: 70px;float: right">
    欢迎${emp.empName}登录
    <a href="empExit">退出</a>
</div>
<div>
    <jsp:include page="../menu6.jsp"/>
</div>
<div id="main2">
    ${info}
    <form action="saveWordTime" method="post" onsubmit="sb();">
        当前设置时间：<br/>
        上班时间：<input type="time" name="workTime" value="${work.workTime}" class="workTime"><br/>
        下班时间：<input type="time" name="offWorkTime" value="${work.offWorkTime}" class="offWorkTime"><br/>
        加班时间（工作日超过加班时间算加班）：<input type="time" name="overTime" value="${work.overTime}" class="overTime"><br/>
        加班补助：<input type="text" name="overPay" value="${work.overPay}" class="overPay"><br/>
        规定每个月工作时间（用于结算每天基本工资）：<input type="text" name="days" value="${work.days}" class="days">天<br/>
        <input type="submit" value="保存" class="check">
    </form>
</div>
</body>
</html>
