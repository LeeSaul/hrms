<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/11/7
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="shortcut icon"type="image/x-icon" href="images/logo.ico"media="screen" />
    <title>上月薪资结算</title>
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
                <c:if test="${salaries!=null&&salaries.size()>0}">
                var tb="";
                <c:forEach items="${salaries}" var="sa">
                var n="${sa.employee.realName}";
                if(n==name){
                    tb+="<tr>";
                    tb+="<td>${sa.employee.department.depName}</td>"
                        +"<td>${sa.employee.realName}</td>"
                        +"<td>${sa.basicWage}</td>"
                        +"<td>${sa.socialSecurity}</td>"
                        +"<td>${sa.overTimePay}</td>"
                        +"<td>${sa.performancePay}</td>"
                        +"<td>${sa.rePunPay}</td>"
                        +"<td>${sa.realWage}</td>"
                        +"<td>${sa.createDate}</td>";
                    tb+="</tr>";
                }
                if(name==""){
                    tb+="<tr>";
                    tb+="<td>${sa.employee.department.depName}</td>"
                        +"<td>${sa.employee.realName}</td>"
                        +"<td>${sa.basicWage}</td>"
                        +"<td>${sa.socialSecurity}</td>"
                        +"<td>${sa.socialSecurity}</td>"
                        +"<td>${sa.overTimePay}</td>"
                        +"<td>${sa.performancePay}</td>"
                        +"<td>${sa.rePunPay}</td>"
                        +"<td>${sa.realWage}</td>"
                        +"<td>${sa.createDate}</td>";
                    tb+="</tr>";
                }
                </c:forEach>
                $("tbody").html(tb);
                </c:if>
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
    <jsp:include page="../menu5.jsp"/>
</div>

<div id="main2">
    <div id="nameSearch">
        <%--<input type="date" id="date"><button id="dateClick">搜索</button>--%>
        <input type="text" id="username" placeholder="员工姓名"><button id="nameClick">搜索</button>
    </div>
    <br/>
    <div id="record">
        <c:choose>
            <c:when test="${salaries!=null&&salaries.size()>0}">
                <table style="text-align: center;width: 100%" cellspacing="0px" cellpadding="0px">
                   <thead>
                   <tr>
                       <td>部门：</td>
                       <td>姓名：</td>
                       <td>基本工资：</td>
                       <td>社保：</td>
                       <td>加班工资：</td>
                       <td>绩效：</td>
                       <td>考勤罚金：</td>
                       <td>实发工资：</td>
                       <td>月份：</td>
                   </tr>
                   </thead>
                    <tbody>
                    <c:forEach items="${salaries}" var="sa">
                        <tr>
                            <td>${sa.employee.department.depName}</td>
                            <td>${sa.employee.realName}</td>
                            <td>${sa.basicWage}</td>
                            <td>${sa.socialSecurity}</td>
                            <td>${sa.overTimePay}</td>
                            <td>${sa.performancePay}</td>
                            <td>${sa.rePunPay}</td>
                            <td>${sa.realWage}</td>
                            <td>${sa.createDate}</td>
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
