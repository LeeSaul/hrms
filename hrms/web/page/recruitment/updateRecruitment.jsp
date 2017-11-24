<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/11/5
  Time: 9:30
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
    <title>更新招聘信息页面</title>
    <script src="jquery/jquery-min.js"></script>
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
            var workingPlace=$(".workingPlace").val();
            var salary=$(".salary").val();
            var positionType=$(".positionType").val();
            var description=$(".description").val();
            var otherInfo=$(".otherInfo").val();
            $(".workingPlace").blur(function () {
                var workingPlace=$(".workingPlace").val();
                if (workingPlace==""){
                    $(".workingPlace").attr("style","border-color: red");
                }else {
                    $(".workingPlace").attr("style","border-color: black");
                }
            });
            $(".salary").blur(function () {
                var age=$(".salary").val();
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
                var otherInfo=$(".birthdate").val();
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
    <div>
        <form action="updateRecById" method="get" onsubmit="sb()">
            <input type="text"name="id" value="${recruitment.id}" hidden="hidden">
            工作地点：<input type="text" value="${recruitment.workingPlace}" name="workingPlace" class="workingPlace"><br/>
            薪水：<input type="text" value="${recruitment.salary}" name="salary" class="salary"><br/>
            职位：<input type="text" value="${recruitment.positionType}" name="positionType" class="positionType"><br/>
            描述：<input type="text" value="${recruitment.description}" name="description" class="description"><br/>
            其他：<input type="text" value="${recruitment.otherInfo}" name="otherInfo" class="otherInfo"><br/>
            <input type="submit" value="更改" class="check">
        </form>
    </div>
</div>
</body>
</html>
