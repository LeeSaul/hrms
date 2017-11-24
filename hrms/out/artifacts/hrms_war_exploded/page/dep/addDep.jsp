<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/10/27
  Time: 9:26
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
    <title>添加员工</title>
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
                var depName=$(".depName").val();
                if (depName==""){
                    $(".depName").attr("style","border-color: red");
                }else {
                    $(".depName").attr("style","border-color: black");
                }
            });
            $(".depType").blur(function () {
                var depType=$(".depType").val();
                if (depType==""){
                    $(".depType").attr("style","border-color: red");
                }else {
                    $(".depType").attr("style","border-color: black");
                }
            });
            $(".depDescription").blur(function () {
                var depDescription=$(".depDescription").val();
                if (depDescription==""){
                    $(".depDescription").attr("style","border-color: red");
                }else {
                    $(".depDescription").attr("style","border-color: black");
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
<div id="main2">
    <form action="addDep" method="post" onsubmit="sb()">
        部门名称：<input type="text" name="depName" class="depName"><br />
        部门类型：<input type="text" name="depType" class="depType"><br/>
        <br/>
        部门描述：
        <textarea name="depDescription"style="resize: none" rows="8" cols="50" class="depDescription">
    </textarea>
        <input type="submit" value="保存" class="check">
    </form>
</div>
<br/>
</body>
</html>
