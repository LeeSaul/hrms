<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/11/7
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        String contextPath = request.getContextPath();
        String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+
                contextPath+"/";
    %>
    <base href="<%= basePath%>">
    <title>考勤记录</title>
    <link rel="shortcut icon"type="image/x-icon" href="images/logo.ico"media="screen" />
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
        #record{
            height: 400px;
            margin-top: 10px;
        }
        table,tr,td{
            border: 1px solid #000000;
            border-radius: 1px;
        }
        #nameSearch{
            float: right;
            margin-right: 70px;
            margin-top: 12px;
        }
    </style>

    <script>
        $(function () {
            $("#nameClick").click(function () {
                var name=$("#username").val();
                <c:if test="${attendances!=null&&attendances.size()>0}">
                var tb="";
                    <c:forEach items="${attendances}" var="att">
                    var n="${att.employee.realName}";
                    if(n==name){
                        tb+="<tr>";
                        tb+="<td>${att.employee.department.depName}</td>"
                            +"<td>${att.employee.realName}</td>"
                            +"<td>${att.startTime}</td>"
                            +"<td>${att.endTime}</td>";
                        tb+="</tr>";
                    }
                    if(name==""){
                        tb+="<tr>";
                        tb+="<td>${att.employee.department.depName}</td>"
                            +"<td>${att.employee.realName}</td>"
                            +"<td>${att.startTime}</td>"
                            +"<td>${att.endTime}</td>";
                        tb+="</tr>";
                    }
                    </c:forEach>
                $("tbody").html(tb);
                </c:if>
            });

            //日期查找
            $("#dateClick").click(function () {
                var date=$("#date").val();
                var date1=Date.parse(date);
                console.log(date1);
                <c:if test="${attendances!=null&&attendances.size()>0}">
                var tb="";
                <c:forEach items="${attendances}" var="att">
                    var d="${att.startTime.day}";
                    console.log("="+d);
                    if(!d.indexOf(date)){
                        tb+="<tr>";
                        tb+="<td>${att.employee.department.depName}</td>"
                            +"<td>${att.employee.realName}</td>"
                            +"<td>${att.startTime}</td>"
                            +"<td>${att.endTime}</td>";
                        tb+="</tr>";
                    }
                    if (date=null){
                        console.log(d+"===");
                        tb+="<tr>";
                        tb+="<td>${att.employee.department.depName}</td>"
                            +"<td>${att.employee.realName}</td>"
                            +"<td>${att.startTime}</td>"
                            +"<td>${att.endTime}</td>";
                        tb+="</tr>";
                    }
                </c:forEach>
                $("tbody").html(tb);
                </c:if>
            })
        })
    </script>
</head>
<body>
<div style="margin-right: 205px;margin-top: 70px;float: right">
    欢迎${emp.empName}登录
    <a href="empExit">退出</a>
</div>
<div>
    <jsp:include page="../menu5.jsp"/>
</div>
<div id="main2">
    <div id="nameSearch">
        <%--<input type="date" id="date"><button id="dateClick">搜索</button>--%>
        <input type="text" id="username" placeholder="员工姓名"><button id="nameClick">搜索</button>
    </div>
    ${info}
    <div id="record">
        <c:choose>
            <c:when test="${not empty attendances}">
                <table style="text-align: center;width: 100%" cellspacing="0px" cellpadding="0px">
                    <thead>
                        <tr>
                            <td>部门</td>
                            <td>员工姓名</td>
                            <td>上班打卡时间</td>
                            <td>下班打卡时间</td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${attendances}" var="att">
                            <tr>
                                <td>${att.employee.department.depName}</td>
                                <td>${att.employee.realName}</td>
                                <td>${att.startTime}</td>
                                <td>${att.endTime}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:when>
        </c:choose>
    </div>
</div>
</body>
</html>
