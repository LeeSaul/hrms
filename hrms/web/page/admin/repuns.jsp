<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/11/7
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="shortcut icon"type="image/x-icon" href="images/logo.ico"media="screen" />
    <title>奖惩记录</title>
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
            overflow-x: auto;
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
            margin-right: 56px;
            margin-top: 4px;
        }
    </style>
    <script src="jquery/jquery-min.js"></script>
    <script>
        $(function () {
            $("#nameClick").click(function () {
                var name=$("#username").val();
                <c:if test="${repuns!=null&&repuns.size()>0}">
                var tb="";
                <c:forEach items="${repuns}" var="re">
                var n="${re.employee.realName}";
                if(n==name){
                    tb+="<tr>";
                    tb+="<td>${re.department.depName}</td>"
                        +"<td>${re.employee.realName}</td>"
                        +"<td>${re.rewardsFine}</td>"
                        +"<td>${re.caption}</td>"
                        +"<td>${re.createTime}</td>";
                    tb+="</tr>";
                }
                if(name==""){
                    tb+="<tr>";
                    tb+="<td>${re.department.depName}</td>"
                        +"<td>${re.employee.realName}</td>"
                        +"<td>${re.rewardsFine}</td>"
                        +"<td>${re.caption}</td>"
                        +"<td>${re.createTime}</td>";
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
    <span>员工考勤奖惩记录</span>
    <div id="nameSearch">
        <%--<input type="date" id="date"><button id="dateClick">搜索</button>--%>
        <input type="text" id="username" placeholder="员工姓名"><button id="nameClick">搜索</button>
    </div>
    <br/>
    <div id="record">
        <c:choose>
            <c:when test="${not empty repuns}">
                <table cellpadding="0px" cellspacing="0px" style="text-align: center;width: 100%">
                    <thead>
                        <tr>
                            <td>部门</td>
                            <td>员工姓名</td>
                            <td>奖罚金</td>
                            <td>说明</td>
                            <td>时间</td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${repuns}" var="re">
                            <tr>
                                <td>${re.department.depName}</td>
                                <td>${re.employee.realName}</td>
                                <td>${re.rewardsFine}</td>
                                <td>${re.caption}</td>
                                <td>${re.createTime}</td>
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
