<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/10/27
  Time: 14:57
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
    <title>添加招聘信息</title>
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

    <script>
        $(function () {
            $(".workingPlace").blur(function () {
                var workingPlace=$(".workingPlace").val();
                if (workingPlace==""){
                    $(".workingPlace").attr("style","border-color: red");
                }else {
                    $(".workingPlace").attr("style","border-color: black");
                }
            });
            $(".salary").blur(function () {
                var salary=$(".salary").val();
                if (salary==""){
                    $(".salary").attr("style","border-color: red");
                }else {
                    $(".salary").attr("style","border-color: black");
                }
            });
            $(".positionType").blur(function () {
                var positionType=$(".positionType").val();
                if (positionType==""){
                    $(".positionType").attr("style","border-color: red");
                }else {
                    $(".positionType").attr("style","border-color: black");
                }
            });
            $(".description").blur(function () {
                var description=$(".description").val();
                if (description==""){
                    $(".description").attr("style","border-color: red");
                }else {
                    $(".description").attr("style","border-color: black");
                }
            });
            $(".otherInfo").blur(function () {
                var otherInfo=$(".otherInfo").val();
                if (otherInfo==""){
                    $(".otherInfo").attr("style","border-color: red");
                }else {
                    $(".otherInfo").attr("style","border-color: black");
                }
            });
            sb=$(".check").click(function () {
                var workingPlace=$(".workingPlace").val();
                var salary=$(".salary").val();
                var positionType=$(".positionType").val();
                var description=$(".description").val();
                var otherInfo=$(".otherInfo").val();

                if (workingPlace==""){
                    $(".workingPlace").attr("style","border-color: red");
                    return false;
                }
                if (salary==""){
                    $(".workingPlace").attr("style","border-color: black");
                    $(".salary").attr("style","border-color: red");
                    return false;
                }
                if (positionType==""){
                    $(".workingPlace").attr("style","border-color: black");
                    $(".salary").attr("style","border-color: black");
                    $(".positionType").attr("style","border-color: red");
                    return false;
                }
                if (description==""){
                    $(".workingPlace").attr("style","border-color: black");
                    $(".salary").attr("style","border-color: black");
                    $(".positionType").attr("style","border-color: black");
                    $(".description").attr("style","border-color: red");
                    return false;
                }
                if (otherInfo==""){
                    $(".workingPlace").attr("style","border-color: black");
                    $(".salary").attr("style","border-color: black");
                    $(".positionType").attr("style","border-color: black");
                    $(".description").attr("style","border-color: black");
                    $(".otherInfo").attr("style","border-color: red");
                    return false;
                }
                $(".workingPlace").attr("style","border-color: black");
                $(".salary").attr("style","border-color: black");
                $(".positionType").attr("style","border-color: black");
                $(".description").attr("style","border-color: black");
                $(".otherInfo").attr("style","border-color: black");
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
    <jsp:include page="../menu2.jsp"/>
</div>
<div id="main2">
    <form action="addRecruitment" method="post" onsubmit="sb();">
        工作地点：<input type="text" name="workingPlace" class="workingPlace"><br/>
        期望薪资：<input type="text" name="salary" class="salary"><br/>
        职位类型：<input type="text" name="positionType" class="positionType"><br/>
        职位描述：<input type="text" name="description" class="description"><br/>
        其他要求：<input type="text" name="otherInfo" class="otherInfo"><br/>
        <input type="submit" value="保存" class="check">
    </form>
</div>
</body>
</html>
