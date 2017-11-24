<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/11/8
  Time: 16:01
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
    <title>菜单</title>
    <script src="jquery/jquery-min.js"></script>
    <script>
        $(function () {
            var i=0;
            var j=0;
            var k=0;
            var o=0;
            var p=0;
            var q=0;
            $("#m1").hide();
//            $("#m2").hide();
            $("#m3").hide();
            $("#m4").hide();
            $("#m5").hide();
            $("#m6").hide();
            $("#t1").click(function () {
                if (i%2==0){
                    $("#t1").html("-简历管理");
                    $("#m1").show();
                }else {
                    $("#t1").html("+简历管理");
                    $("#m1").hide();
                }
                i++;
            });

            $("#t2").click(function () {
                if (j%2==1){
                    $("#t2").html("-招聘管理");
                    $("#m2").show();
                }else {
                    $("#t2").html("+招聘管理")
                    $("#m2").hide();
                }
                j++;
            });

            $("#t3").click(function () {
                if (k%2==0){
                    $("#t3").html("-部门管理");
                    $("#m3").show();
                }else {
                    $("#t3").html("+部门管理")
                    $("#m3").hide();
                }
                k++;
            });


            $("#t4").click(function () {
                if (o%2==0){
                    $("#t4").html("-培训管理");
                    $("#m4").show();
                }else {
                    $("#t4").html("+培训管理")
                    $("#m4").hide();
                }
                o++;
            });

            $("#t5").click(function () {
                if (p%2==0){
                    $("#t5").html("-薪资管理");
                    $("#m5").show();
                }else {
                    $("#t5").html("+薪资管理")
                    $("#m5").hide();
                }
                p++;
            });

            $("#t6").click(function () {
                if (q%2==0){
                    $("#t6").html("-其他");
                    $("#m6").show();
                }else {
                    $("#t6").html("+其他")
                    $("#m6").hide();
                }
                q++;
            });

        });
    </script>
    <style>
        #title{
            margin-left: -23px;
            margin-top: 15px;
            text-align: center;
            /* border: solid #000000;
             border-radius: 1px;*/
        }
        #t1,#t2,#t3,#t4,#t5,#t6{
            font-size: large;
            font-weight: bold;
        }
        a{
            text-decoration: none;
            color: black;
            margin-left: 14px;
            padding: 10px ;
        }
        #main{
            float: left;
            width: 216px;
            height: 500px;
            margin-left: 10px;
            margin-top: 100px;
            border: solid #5d5d5d;
            border-radius: 1px;
        }
        #bd{
            margin-left: 27px;
            margin-top: 35px;
        }
        #tablediv{
            width: 850px;
            height: 400px;
            margin-top: 10px;
        }
        table,tr,td{
            border: 1px solid #000000;
            border-radius: 1px;
        }
    </style>
</head>
<body>
<div id="main">
    <h2 id="title"><a href="page/admin/adminIndex.jsp">人力资源管理系统</a></h2>
    <div id="bd">
        <span id="t1">-简历管理</span><br/>
        <div id="m1">
            <a href="queryAllResume">全部</a><br/>
            <a href="queryResumeByStatus?status=notRed">未查看</a><br/>
            <a href="queryResumeByStatus?status=red">已阅</a><br/>
            <a href="queryResumeByStatus?status=send">已邀请</a><br/>
            <a href="queryResumeByStatus?status=confirm">已确认</a><br/>
            <a href="queryResumeByStatus?status=hire">已录取</a><br/>
            <a href="queryResumeByStatus?status=refuse">已拒绝</a><br/>
        </div>

        <br/>
        <span id="t2">-招聘管理</span><br/>
        <div id="m2">
            <a href="page/recruitment/addRecruitment.jsp">添加招聘信息</a><br/>
            <a href="queryAllRecruitment">查看已发布招聘信息</a><br/>
        </div>

        <br/>
        <span id="t3">+部门管理</span><br/>
        <div id="m3">
            <a href="queryAllDep">部门信息</a><br/>
            <a href="page/dep/addDep.jsp">添加部门</a><br/>
            <a href="queryAllDepEmp">所有人员</a><br/>
        </div>
        <br/>
        <span id="t4">+培训管理</span><br/>
        <div id="m4">
            <a href="page/train/addTrain.jsp">添加培训信息</a><br/>
            <a href="queryAllTrain">查看培训信息</a><br/>
        </div>
        <br/>
        <span id="t5">+薪资管理</span><br/>
        <div id="m5">
            <a href="queryProportion">基本配置</a><br/>
            <a href="queryLastAttendance">查看上个月考勤记录</a><br/>
            <a href="queryCurrentMonth">查看本月考勤记录</a><br/>
            <a href="queryRewardsPun">查看上个月奖惩记录</a><br/>
            <a href="querySalary">查看上个月员工工资</a><br/>
        </div>
        <br/>
        <span id="t6">+其他</span><br/>
        <div id="m6">
            <a href="queryWorkTime">设置工作时间</a><br/>
            <a href="queryDismissEmp">查看已辞退员工</a><br/>
            <a href="queryAllSuggest">意见管理</a><br/>
        </div>
    </div>
</div>
</body>
</html>
