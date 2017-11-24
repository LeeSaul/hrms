<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/11/1
  Time: 12:19
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
    <title>更新职位</title>
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
            $(".depName").blur(function () {
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
                var depName=$(".depName").val();
                var depType=$(".depType").val();
                var description=$(".description").val();
                if (depName==""){
                    $(".depName").attr("style","border-color: red");
                    return false;
                }
                if (depType==""){
                    $(".depName").attr("style","border-color: black");
                    $(".depType").attr("style","border-color: red");
                    return false;
                }
                if (description==""){
                    $(".depName").attr("style","border-color: black");
                    $(".depType").attr("style","border-color: black");
                    $(".description").attr("style","border-color: red");
                    return false;
                }
                $(".depName").attr("style","border-color: black");
                $(".depType").attr("style","border-color: black");
                $(".description").attr("style","border-color: black");
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
<br/>
<div id="main2">
    部门信息
    <form action="updateOption" method="post" onsubmit="sb()">
        <input type="text" name="id" hidden="hidden" value="${depOption.id}">
        <input type="text" name="depId" hidden="hidden" value="${depOption.depId}">
        职位名：<input type="text" name="optionName" value="${depOption.optionName}" class="optionName"><br/>
        职位描述：<input type="text" name="optionDesc" value="${depOption.optionDesc}" class="optionDesc"><br/>
        <input type="submit" value="更改" class="check">
    </form>
</div>
</body>
</html>
