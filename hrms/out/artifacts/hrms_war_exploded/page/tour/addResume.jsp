<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
Created by IntelliJ IDEA.
User: user
Date: 2017/10/26
Time: 14:27
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
    <script src="jquery/jquery-min.js"></script>
    <base href="<%= basePath%>">
    <title>添加简历</title>
    <style>
        #m{
            margin-left: 14%;
            margin-right: 30%;
            margin-top: 50px;
        }
        #login{
            float: right;
            margin-top: -8px;
            margin-right: -168px;
        }
        #t1{
            margin-left: 352px;
            margin-top: -10px;
        }
        #t2{
            border: solid #5d5d5d;
            border-radius: 6px;
            width: 1000px;
            height: 600px;
            overflow-y: auto;
        }
        .basic{
            margin-left: 0px;
            margin-top: -13px;
        }
        .maininfo{
            margin-left: 10px;
            margin-top: 10px;
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
        <c:if test="${not empty tourist}">
            欢迎用户${tourist.tourName}登录
        </c:if>
        <a href="touristExitLogin" style="">退出</a>
    </div>

    <div id="t1">
        <a href="queryMyResume">填写简历</a>
        <a href="queryDeliveryByTourist">预览投递记录</a>
        <a href="queryRecruitment">招聘</a>
    </div>
    <div id="t2">
        <c:choose>
            <c:when test="${not empty resume}">
                <form action="updateResume" method="post" onsubmit="sb()">
                    <div class="basic">
                        <hr>
                        <span>基础信息：</span><br/><br/>
                        <input type="text" name="touristId" value="${tourist.id}" hidden="hidden">
                        <span>*</span>姓名：<input type="text" name="resumeName" value="${resume.resumeName}" class="resumeName"><br/>
                        <span>*</span>年龄：<input type="number" name="age" value="${resume.age}" class="age"><br/>
                        <span>*</span>性别：<input type="radio" name="gender" value="男" checked="checked">男<input type="radio" name="gender" value="女">女<br/>
                        <span>*</span>联系方式：<input type="text" name="phone" value="${resume.phone}" class="phone"><br/>
                        <span>*</span>邮箱：<input type="text" name="email" value="${resume.email}" class="email"><br/>
                        <span>*</span>出生日期：<input type="date" name="birthdate" value="${resume.birthdate}" class="birthdate"><br/>
                        <span>*</span>出生地：<input type="text" name="birthplace" value="${resume.birthplace}" class="birthplace"><br/>
                        <span>*</span>申请职位：<input type="text" name="job" value="${resume.job}" class="job"><br/>
                        <span>*</span>学历：<input type="text" name="education" value="${resume.education}" class="education"  ><br/>
                        技能：<input type="text" name="specialSkill" value="${resume.specialSkill}"><br/>
                        爱好：<input type="text" name="hobbies" value="${resume.hobbies}"><br/>
                        奖学金：<input type="text" name="awards" value="${resume.awards}"><br/>
                        <span>*</span>婚姻状况：<input type="radio" name="marry" value="未婚" checked="checked">未婚<input type="radio" name="marry" value="已婚">已婚<input type="radio" name="marry" value="离异">离异<br/>
                    </div>
                    <div class="maininfo">
                        <span></span>自我评价：<br/><textarea name="selfEvaluation" style="resize: none" cols="80" rows="8">${resume.selfEvaluation}</textarea><br/>
                        <hr>
                        <span>工作经历：</span><br/>
                        <textarea name="workExperience" style="resize: none" cols="80" rows="8">${resume.workExperience}</textarea><br/>
                        <hr>
                        <span>项目经验：</span><br/>
                        <textarea name="projectExperience" style="resize: none" cols="80" rows="8">${resume.projectExperience}</textarea><br/>
                        <hr>
                        <span>教育经历：</span><br/>
                        <textarea name="educationExperience" style="resize: none" cols="80" rows="8">${resume.educationExperience}</textarea><br/>
                    </div>
                    <br/>
                    <input type="submit" value="修改简历" style="margin-left: 250px" class="check">
                </form>
            </c:when>
            <c:otherwise >
                <form action="addResume" method="post" onsubmit="sb()">
                    <hr>
                    <div class="basic">
                        <span>基础信息</span><br/>
                        <input type="text" name="touristId" value="${tourist.id}" hidden="hidden">
                        <span>*</span>姓名：<input type="text" name="resumeName" class="resumeName"><br/>
                        <span>*</span>年龄：<input type="number" name="age"><br/>
                        <span>*</span>性别：<input type="radio" name="gender" value="男" checked="checked">男<input type="radio" name="gender" value="女">女<br/>
                        <span>*</span>联系方式：<input type="text" name="phone"><br/>
                        <span>*</span>邮箱：<input type="text" name="email"><br/>
                        <span>*</span>出生日期：<input type="date" name="birthdate"><br/>
                        <span>*</span>出生地：<input type="text" name="birthplace"><br/>
                        <span>*</span>申请职位：<input type="text" name="job"><br/>
                        <span>*</span>学历：<input type="text" name="education"><br/>
                        技能：<input type="text" name="specialSkill"><br/>
                        爱好：<input type="text" name="hobbies"><br/>
                        奖学金：<input type="text" name="awards"><br/>
                        <span>*</span>婚姻状况：<input type="radio" name="marry" value="未婚" checked="checked">未婚<input type="radio" name="marry" value="已婚">已婚<input type="radio" name="marry" value="离异">离异<br/>
                    </div>
                    <div class="maininfo">
                        <span></span>自我评价：<br/><textarea name="selfEvaluation" style="resize: none" cols="80" rows="8"></textarea><br/>
                        <hr>
                        <span></span><span>工作经历：</span><br/>
                        <textarea name="workExperience" style="resize: none" cols="80" rows="8"></textarea><br/>
                        <hr>
                        <span>项目经验：</span><br/>
                        <textarea name="projectExperience" style="resize: none" cols="80" rows="8"></textarea><br/>
                        <hr>
                        <span>教育经历：</span><br/>
                        <textarea name="educationExperience" style="resize: none" cols="80" rows="8"></textarea><br/>
                    </div>
                    <input type="submit" value="添加简历" style="margin-left: 250px" class="check">
                </form>
            </c:otherwise>
        </c:choose>
    </div>
</div>
</body>
</html>
