<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/10/27
  Time: 16:08
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
    <title>招聘信息</title>
    <link href="css/simplefoucs_lrtk.css" rel="stylesheet" />
    <script src="jquery/jquery-min.js"></script>
    <script src="jquery/simplefoucs.js" type="text/javascript"></script>
    <style>
        table,tr,td{
            border-radius: 1px;
            border: solid 2px black;
        }
        a{
            text-decoration: none;
        }

        #header{
            /*background-color: #f0f2f5;*/
            height: 45px;
            width: 100%;
        }
        #header-nav{
            width: 1180px;
            height: 30px;
            margin-left: 120px;
            margin-top: 10px;
        }
        #titleimg{
            margin-left: 10px;
            margin-top: 10px;
            width: 100px;
            height: 100px;
        }
        #phone{
            float: left;
            font-size: 10px;
            margin-left: 180px;
            margin-top: 17px;
            margin-right: -266px
        }
        #iotek{
            float: left;
            color: #2aa0d6;
            font-size: x-large;
            font-weight: bold;
            margin-left: 272px;
            margin-top: 10px;
        }
        #iotek2{
            float: left;
            color: #2aa0d6;
            font-size: large;
            font-weight: normal;
            margin-left: 5px;
            margin-top: 14px;
        }
        #jiaru{
            margin-left: 132px;
            margin-top: 30px;
        }
        #t1{
            margin-left: 9%;
            margin-top: 4%;
        }
        .type{
            font-size: x-large;
            font-weight: bold;
            color: black;
        }
    </style>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h3 id="phone">客服热线：400-000-1234</h3>
        <h2 id="iotek">IOTEK</h2><h2 id="iotek2">一站式IT人力资源服务平台</h2>
        <div style="float: right;margin-right: 184px;margin-top: 18px">
            <a href="queryRecruitment" id="t11"><span>加入我们</span></a>
            <a href="page/tour/tourRegister.jsp" id="t22"><span>注册</span></a>
            <a href="isNeedLogin"><span>游客登录</span></a>
            <a href="companyLogin.jsp" id="t44"><span>员工登录</span></a>
        </div>
    </div>
</div>
<div id="body2">
    <div class="bannerbox">
        <div id="focus">
            <ul>
                <li><img src="images/banner1.png" width="1172px" height="445px" alt="" /></li>
                <li><img src="images/banner2.png" width="1172px" height="445px" alt="" /></li>
                <li><img src="images/banner3.png" width="1172px" height="445px" alt="" /></li>
                <!--<li><a href="http://www.lanrentuku.com/" target="_blank">
                    <img src="images/bn4.jpg" alt="" /></a></li>-->
            </ul>
        </div>
    </div>
    <div>
        <h2 id="jiaru">加入我们</h2>
    </div>
    <div id="t1">
        <%--<table cellpadding="0px" cellspacing="0px" style="text-align: center">
            <tr>
                <td>工作地点</td>
                <td>薪资</td>
                <td>职位类型</td>
                <td>发布时间</td>
                <td>操作</td>
            </tr>--%>
                <c:forEach items="${recruitments}" var="recruit">
                    <%--<tr>--%>
                    <%--<td>${recruit.workingPlace}</td>--%>
                    <%--<td>${recruit.salary}</td>--%>

                    <%--<td>${recruit.createDate}</td>--%>
                    <%--<td>--%>
                    <a href="queryRecruitmentById?id=${recruit.id}" class="type">${recruit.positionType}</a><br/>
                    <%--</td>--%>
                    <%--</tr>--%>
                </c:forEach>
        <%--</table>--%>
    </div>
    <div>

    </div>
</div>
</body>
</html>
