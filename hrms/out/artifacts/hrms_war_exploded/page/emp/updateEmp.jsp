<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/11/8
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="shortcut icon"type="image/x-icon" href="images/logo.ico"media="screen" />
    <title>更新简历</title>
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
            text-align: left;
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
            overflow-y: auto;
        }
    </style>
    <script>
        $(function () {
            var email=$(".email").val();
            var birthdate=$(".birthdate").val();
            var birthplace=$(".birthplace").val();
            var job=$(".job").val();
            var education=$(".education").val();
            $(".resumeName").blur(function () {
                var resumeName=$(".resumeName").val();
                if (resumeName==""){
                    $(".resumeName").attr("style","border-color: red");
                }else {
                    $(".resumeName").attr("style","border-color: black");
                }
            });
            $(".age").blur(function () {
                var age=$(".age").val();
                if (age==""){
                    $(".age").attr("style","border-color: red");
                }else {
                    $(".age").attr("style","border-color: black");
                }
            });
            $(".phone").blur(function () {
                var phone=$(".phone").val();
                if (phone==""){
                    $(".phone").attr("style","border-color: red");
                }else {
                    $(".phone").attr("style","border-color: black");
                }
            });
            $(".email").blur(function () {
                var email=$(".email").val();
                if (email==""){
                    $(".email").attr("style","border-color: red");
                }else {
                    $(".email").attr("style","border-color: black");
                }
            });
            $(".birthdate").blur(function () {
                var birthdate=$(".birthdate").val();
                if (birthdate==""){
                    $(".birthdate").attr("style","border-color: red");
                }else {
                    $(".birthdate").attr("style","border-color: black");
                }
            });
            $(".birthplace").blur(function () {
                var birthplace=$(".birthplace").val();
                if (birthplace==""){
                    $(".birthplace").attr("style","border-color: red");
                }else {
                    $(".birthplace").attr("style","border-color: black");
                }
            });
            $(".job").blur(function () {
                var job=$(".job").val();
                if (job==""){
                    $(".job").attr("style","border-color: red");
                }else {
                    $(".job").attr("style","border-color: black");
                }
            });
            $(".education").blur(function () {
                var education=$(".education").val();
                if (education==""){
                    $(".education").attr("style","border-color: red");
                }else {
                    $(".education").attr("style","border-color: black");
                }
            });
            sb=$(".check").click(function () {
                var resumeName=$(".resumeName").val();
                var age=$(".age").val();
                var phone=$(".phone").val();
                var email=$(".email").val();
                var birthdate=$(".birthdate").val();
                var birthplace=$(".birthplace").val();
                var job=$(".job").val();
                var education=$(".education").val();
                if (resumeName==""){
                    $(".resumeName").attr("style","border-color: red");
                    return false;
                }
                if (age==""){
                    $(".resumeName").attr("style","border-color: black");
                    $(".age").attr("style","border-color: red");
                    return false;
                }
                if (phone==""){
                    $(".resumeName").attr("style","border-color: black");
                    $(".age").attr("style","border-color: black");
                    $(".phone").attr("style","border-color: red");
                    return false;
                }
                if (email==""){
                    $(".resumeName").attr("style","border-color: black");
                    $(".age").attr("style","border-color: black");
                    $(".phone").attr("style","border-color: black");
                    $(".email").attr("style","border-color: red");
                    return false;
                }
                if (birthdate==""){
                    $(".resumeName").attr("style","border-color: black");
                    $(".age").attr("style","border-color: black");
                    $(".phone").attr("style","border-color: black");
                    $(".email").attr("style","border-color: black");
                    $(".birthdate").attr("style","border-color: red");
                    return false;
                }
                if (birthplace==""){
                    $(".resumeName").attr("style","border-color: black");
                    $(".age").attr("style","border-color: black");
                    $(".phone").attr("style","border-color: black");
                    $(".email").attr("style","border-color: black");
                    $(".birthdate").attr("style","border-color: black");
                    $(".birthplace").attr("style","border-color: red");
                    return false;
                }
                if (job==""){
                    $(".resumeName").attr("style","border-color: black");
                    $(".age").attr("style","border-color: black");
                    $(".phone").attr("style","border-color: black");
                    $(".email").attr("style","border-color: black");
                    $(".birthdate").attr("style","border-color: black");
                    $(".birthplace").attr("style","border-color: black");
                    $(".job").attr("style","border-color: red");
                    return false;
                }
                if (education==""){
                    $(".resumeName").attr("style","border-color: black");
                    $(".age").attr("style","border-color: black");
                    $(".phone").attr("style","border-color: black");
                    $(".email").attr("style","border-color: black");
                    $(".birthdate").attr("style","border-color: black");
                    $(".birthplace").attr("style","border-color: black");
                    $(".job").attr("style","border-color: black");
                    $(".education").attr("style","border-color: red");
                    return false;
                }
                $(".resumeName").attr("style","border-color: black");
                $(".age").attr("style","border-color: black");
                $(".phone").attr("style","border-color: black");
                $(".email").attr("style","border-color: black");
                $(".birthdate").attr("style","border-color: black");
                $(".birthplace").attr("style","border-color: black");
                $(".job").attr("style","border-color: black");
                $(".education").attr("style","border-color: black");
                return true;
            });
        })
    </script>
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
        <form action="updateEmpResume" method="post" style="margin-left: 10px" onsubmit="sb();">
            <hr>
            <span>基础信息：</span><br/>
            <input type="text" name="id" value="${resume.id}" hidden="hidden">
            <span>*</span>姓名：<input type="text" name="resumeName" value="${resume.resumeName}" class="resumeName"><br/>
            <span>*</span>年龄：<input type="number" name="age" value="${resume.age}" class="age"><br/>
            <span>*</span>性别：<input type="radio" name="gender" value="男" checked="checked">男<input type="radio" name="gender" value="女">女<br/>
            <span>*</span>联系方式：<input type="text" name="phone" value="${resume.phone}" class="phone"><br/>
            <span>*</span>邮箱：<input type="text" name="email" value="${resume.email}" class="email"><br/>
            <span>*</span>出生日期：<input type="date" name="birthdate" value="${resume.birthdate}" class="birthdate"><br/>
            <span>*</span>出生地：<input type="text" name="birthplace" value="${resume.birthplace}" class="birthplace"><br/>
            <span>*</span>申请职位：<input type="text" name="job" value="${resume.job}" class="job"><br/>
            <span>*</span>学历：<input type="text" name="education" value="${resume.education}" class="education"><br/>
            技能：<input type="text" name="specialSkill" value="${resume.specialSkill}"><br/>
            爱好：<input type="text" name="hobbies" value="${resume.hobbies}"><br/>
            奖学金：<input type="text" name="awards" value="${resume.awards}"><br/>
            婚姻状况：<input type="radio" name="marry" value="未婚" checked="checked">未婚<input type="radio" name="marry" value="已婚">已婚<input type="radio" name="marry" value="离异">离异<br/>
            自我评价：<br/><textarea name="selfEvaluation" style="resize: none" cols="80" rows="8">${resume.selfEvaluation}</textarea><br/>
            <hr>
            工作经历：</span><br/>
            <textarea name="workExperience" style="resize: none" cols="80" rows="8">${resume.workExperience}</textarea><br/>
            <hr>
            <span>项目经验：</span><br/>
            <textarea name="projectExperience" style="resize: none" cols="80" rows="8">${resume.projectExperience}</textarea><br/>
            <hr>
            <span>教育经历：</span><br/>
            <textarea name="educationExperience" style="resize: none" cols="80" rows="8">${resume.educationExperience}</textarea><br/>
            <input type="submit" value="修改简历" class="check">
        </form>
    </div>
</div>
</body>
</html>
