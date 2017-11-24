<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/10/31
  Time: 10:39
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
            $(".basicWage").blur(function () {
                var basicWage=$(".basicWage").val();
                if (basicWage==""){
                    $(".basicWage").attr("style","border-color: red");
                }else {
                    $(".basicWage").attr("style","border-color: black");
                }
            });
            $(".proportion").blur(function () {
                var proportion=$(".proportion").val();
                if (proportion==""){
                    $(".proportion").attr("style","border-color: red");
                }else {
                    $(".proportion").attr("style","border-color: black");
                }
            });
            sb=$(".check").click(function () {
                var basicWage=$(".basicWage").val();
                var proportion=$(".proportion").val();
                if (basicWage==""){
                    $(".basicWage").attr("style","border-color: red");
                    return false;
                }
                if (proportion==""){
                    $(".basicWage").attr("style","border-color: black");
                    $(".proportion").attr("style","border-color: red");
                    return false;
                }
                $(".basicWage").attr("style","border-color: black");
                $(".proportion").attr("style","border-color: black");
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
    部门ID：${depId}
    职位ID：${opId}
    <hr>
    <c:choose>
        <c:when test="${deliveries!=null&&deliveries.size()>0}">
            <table style="text-align: center;width:  1100px;" cellspacing="0px" cellpadding="0px">
                <tr>
                    <td>姓名</td>
                    <td>申请职位</td>
                    <td>默认员工账号</td>
                    <td>默认密码</td>
                    <td>账户类型</td>
                    <td>薪资</td>
                    <td>个人交社保占总工资比例</td>
                    <td>操作</td>
                </tr>
                <c:forEach items="${deliveries}" var="del">
                    <tr>
                        <form action="addEmp" method="post" onsubmit="sb()">
                            <input type="text" value="${depId}" name="depId" hidden="hidden">
                            <input type="text" value="${opId}" name="positionId" hidden="hidden">
                            <input type="text" value="${del.resume.resumeName}" name="realName" hidden="hidden">
                            <td>${del.resume.resumeName}</td>
                            <td>${del.resume.job}</td>
                            <td>20180101${del.resume.id}</td>
                            <input type="text" name="empName" value="20180101${del.resume.id}" hidden="hidden">
                            <td>123456</td><input type="text" name="empPassword" value="123456" hidden="hidden">
                            <input type="text" name="resumeId" value="${del.resume.id}" hidden="hidden">
                            <td>
                                <input type="radio" name="empType" value=1 checked="checked">普通用户 <input type="radio" name="empType" value=0>管理员
                            </td>
                            <input type="text" name="empStatus" value="可用" hidden="hidden">
                            <input type="text" name="deId" value="${del.id}" hidden="hidden">
                            <td>
                                <input type="text" name="basicWage" class="basicWage">
                            </td>
                            <td>
                                <input type="text" name="proportion" value="10" class="proportion">%（默认10%缴纳社保）
                            </td>
                            <td>
                                <input type="submit" value="添加" class="check">
                                <a href="queryResumeById?id=${del.resume.id}&depId=${depId}&opId=${opId}&num=1">查看简历</a>
                            </td>
                        </form>
                    </tr>
                </c:forEach>
            </table>
        </c:when>
    </c:choose>
</div>
</body>
</html>
