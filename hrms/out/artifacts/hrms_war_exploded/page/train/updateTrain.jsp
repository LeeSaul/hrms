<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/11/2
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><link rel="shortcut icon"type="image/x-icon" href="images/logo.ico"media="screen" />
    <title>更新培训</title>
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
    <script src="jquery/jquery-min.js"></script>
    <script>
        $(function () {
            $(".title").blur(function () {
                var title=$(".title").val();
                if (title==""){
                    $(".title").attr("style","border-color: red");
                }else {
                    $(".title").attr("style","border-color: black");
                }
            });
            $(".content").blur(function () {
                var content=$(".content").val();
                if (content==""){
                    $(".content").attr("style","border-color: red");
                }else {
                    $(".content").attr("style","border-color: black");
                }
            });
            $(".startTime").blur(function () {
                var startTime=$(".startTime").val();
                if (startTime==""){
                    $(".startTime").attr("style","border-color: red");
                }else {
                    $(".startTime").attr("style","border-color: black");
                }
            });
            $(".endTime").blur(function () {
                var endTime=$(".endTime").val();
                if (endTime==""){
                    $(".endTime").attr("style","border-color: red");
                }else {
                    $(".endTime").attr("style","border-color: black");
                }
            });
            sb=$(".check").click(function () {
                var title=$(".title").val();
                var content=$(".content").val();
                var startTime=$(".startTime").val();
                var endTime=$(".endTime").val();
                if (title==""){
                    $(".title").attr("style","border-color: red");
                    return false;
                }
                if (content==""){
                    $(".title").attr("style","border-color: black");
                    $(".content").attr("style","border-color: red");
                    return false;
                }
                if (startTime==""){
                    $(".title").attr("style","border-color: black");
                    $(".content").attr("style","border-color: black");
                    $(".startTime").attr("style","border-color: red");
                    return false;
                }
                if (endTime==""){
                    $(".title").attr("style","border-color: black");
                    $(".content").attr("style","border-color: black");
                    $(".startTime").attr("style","border-color: black");
                    $(".endTime").attr("style","border-color: red");
                    return false;
                }
                $(".title").attr("style","border-color: black");
                $(".content").attr("style","border-color: black");
                $(".startTime").attr("style","border-color: black");
                $(".endTime").attr("style","border-color: black");
                return true;
            });
        })
    </script>
</head>
<body>
<div style="margin-right: 312px;margin-top: 70px;float: right">
    欢迎${emp.empName}登录
    <a href="empExit">退出</a>
</div>
<div>
    <jsp:include page="../menu4.jsp"/>
</div>

<div id="main2">
    <form action="updateTrain" method="post" onsubmit="sb()">
        <input type="text" name="id" value="${train.id}" hidden="hidden">
        主题：<input type="text" value="${train.title}" name="title" class="title"><br/>
        内容：<textarea cols="30" rows="10" style="resize: none" name="content" class="content">${train.content}</textarea><br/>
        开始时间：<input type="datetime-local" value="${train.startTime}" name="startTime" class="startTime"><br/>
        结束时间：<input type="datetime-local" value="${train.endTime}" name="endTime" class="endTime"><br/>
        发布时间：${train.createTime}<br/>
        <input type="submit" value="修改" class="check">
    </form>
</div>
</body>
</html>
