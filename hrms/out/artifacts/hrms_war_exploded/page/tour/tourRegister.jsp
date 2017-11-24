<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/10/26
  Time: 13:39
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
    <title>注册页面</title>
    <script src="jquery/jquery-min.js"></script>
    <script>
        $(function () {
            $("#tourName").blur(function () {
                $.ajax({
                    url:"queryTouristName",
                    type:"post",
                    data:"tourName="+$("#tourName").val(),
                    success:function (msg) {
                        var tourname=$("#tourName").val();
                        if (msg=='已存在'||tourname==''){
                            $('form').attr('onsubmit','return false');
                            $("#tourName").attr("style","border-color: red");
//                            $("#error").html(msg);
                        }else {
                            $('form').attr('onsubmit','return true');
                            $("#tourName").attr("style","border-color: black");
                            $("#tourPassword").attr("style","border-color: black");
//                            $("#error").html("");
                        }
                    }
                });
            });
            $("#tourPassword").blur(function () {
                var tourPassword=$("#tourPassword").val();
                if (tourPassword==''){
                    $('form').attr('onsubmit','return false');
                    $("#tourPassword").attr("style","border-color: red");
                }else {
                    $('form').attr('onsubmit','return true');
                    $("#tourPassword").attr("style","border-color: black");
                }
            })
            checkName=$("#check").click(function () {
                var tourname=$("#tourName").val();
                var tourPassword=$("#tourPassword").val();
                if (tourname==''){
                    $("#tourName").attr("style","border-color: red");
                    return false;
                }
                if (tourPassword==''){
                    $("#tourPassword").attr("style","border-color: red");
                    return false;
                }
                $("#tourName").attr("style","border-color: black");
                $("#tourPassword").attr("style","border-color: black");
                return true;
            })
        });
    </script>
    <style>
        body{
            background-image: url("images/bg.jpg");
            background-size: 100% 100%;
        }
        #t1{
            float: left;
            margin-left: 100px;
        }
        #t12{
            float: right;
            margin-right: 200px;
        }
        span{
            font-size: x-large;
            color: black;
        }
        a{
            text-decoration: none;
        }
        #register{
            clear: none;
            width: 23%;
            text-align: center;
            height: 170px;
            border: solid 1px black;
            border-radius: 5px;
            margin-left: 68%;
            margin-top: 13%;
        }
        #error{
            color: red;
        }
        #tourName{
            margin-left: 10px;
        }
        #tourPassword{
            margin-left: 10px;
        }
    </style>

</head>
<body>
<div>
    <a href="queryRecruitment" id="t1"><span>加入我们</span></a>
    <div id="t12">
        <a href="page/tour/tourRegister.jsp" ><span>注册</span></a>
        <a href="isNeedLogin"><span>游客登录</span></a>
        <a href="companyLogin.jsp"><span>员工登录</span></a>
    </div>
</div>
<br>
<div id="register">
    <form action="tourRegister" method="post" onsubmit="checkName()"><br/><br/>
        用户名：<input type="text" name="tourName" id="tourName"><span id="error"></span><br/><br/>
        密&nbsp;&nbsp;码：<input type="password" name="tourPassword" id="tourPassword"><br/><br/>
        <input type="submit" value="注册" style="margin-left: 63px" id="check">
    </form>
</div>

</body>
</html>
