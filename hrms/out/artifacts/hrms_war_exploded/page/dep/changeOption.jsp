<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/11/1
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="shortcut icon"type="image/x-icon" href="images/logo.ico"media="screen" />
    <title>换岗页面</title>
    <%
        String contextPath = request.getContextPath();
        String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+
                contextPath+"/";
    %>
    <base href="<%= basePath%>">
    <script src="jquery/jquery-min.js"></script>

    <script>
        var myData;
        $(function () {
            $.ajax({
                url:'queryAllDepAndOption',
                type:'post',
                dataType:'json',
                success:function (msg) {
//                    JSON.parse(msg);
//                    console.log(msg);
                    myData=msg;
                    var dep='';
                    console.log(msg);
                    for (var i = 0; i < myData.length; i++) {
                        var obj = myData[i].depName;
                        console.log(obj);
                        dep=dep+"<option value='"+myData[i].id+"'>"+obj+"</option>";
                    }
                    $("#depName").html(dep);
                    addOp(myData[0].id);
                }
            })
        })
        function addOp(depId) {
            var op='';
//            var opId;
            for (var i = 0; i < myData.length; i++) {
                var obi = myData[i];
                if (depId==obi.id){
//                    opId=obi.depOptions[0].id;
                    for (var j = 0; j < obi.depOptions.length; j++) {
                        //obj代表职位的集合
                        var obj = obi.depOptions[j];
                        op=op+"<option value='"+obj.id+"'>"+obj.optionName+"</option>";
                    }
                }
            }
            if(op==''){
                op="<option value='0'>暂无"+"</option>"
            }
            $("#opName").html(op);
        }
    </script>
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
    ${info}
    <form action="changeOp">
        部门：<select name="depId" id="depName" onchange="addOp(this.value)">
        <option value="-1">请选择</option>
    </select>

        职位：<select name="opId" id="opName">
        <option value="-1">请选择</option>
    </select><br/>
        <input type="text" name="empId" value="${empId}" hidden="hidden">
        <input type="submit"  value="换岗">
    </form>
</div>
</body>
</html>
