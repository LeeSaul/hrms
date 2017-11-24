<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/10/31
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="shortcut icon"type="image/x-icon" href="images/logo.ico"media="screen" />
    <title>添加职位页面</title>
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
            $(".optionName").blur(function () {
                var optionName=$(".optionName").val();
                if (optionName==""){
                    $(".optionName").attr("style","border-color: red");
                }else {
                    $(".optionName").attr("style","border-color: black");
                }
            });
            $(".optionDesc").blur(function () {
                var optionDesc=$(".optionDesc").val();
                if (optionDesc==""){
                    $(".optionDesc").attr("style","border-color: red");
                }else {
                    $(".optionDesc").attr("style","border-color: black");
                }
            });
            sb=$(".check").click(function () {
                var optionName=$(".optionName").val();
                var optionDesc=$(".optionDesc").val();
                if (optionName==""){
                    $(".optionName").attr("style","border-color: red");
                    return false;
                }
                if (optionDesc==""){
                    $(".optionName").attr("style","border-color: black");
                    $(".optionDesc").attr("style","border-color: red");
                    return false;
                }
                $(".optionName").attr("style","border-color: black");
                $(".optionDesc").attr("style","border-color: black");
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
    <jsp:include page="../menu3.jsp"/>
</div>
<div id="main2">
    <form action="addOption" onsubmit="sb()">
        <input type="text" name="depId" value="${depId}" hidden="hidden">
        职位名称：<input type="text" name="optionName" class="optionName"><br/>
        职位描述：<input type="text" name="optionDesc" class="optionDesc"><br/>
        <input type="submit" value="添加" class="check"><br/>
    </form>
</div>
<br/>
<a href="queryAllDep">部门管理主页</a>
</body>
</html>
