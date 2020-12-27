<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 蘑菇先生
  Date: 2020/12/21
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="images/FINN.ico">

    <title>学生宿舍管理系统</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/dashboard.css" rel="stylesheet">
</head>

<body>
<%
    String studentname = (String) request.getSession().getAttribute("studentname");
    if(studentname == null)
    {
        response.sendRedirect("index.jsp");
    }
%>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand text-primary" href="index.jsp">学生宿舍管理系统</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav justify-content-end">
                <li class="nav-item active">
                    <a class="navbar-right" href="student_information.jsp">正在登陆的用户为：${sessionScope.studentname}(学生)</a>
                </li>
                <li class="nav-item active">
                    <a class="navbar-right" href="${pageContext.request.contextPath}/LoginOutServlet" onclick="return logout()">退出</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar hidden-xs">
            <ul class="nav nav-sidebar">
                <li><a href="student_information.jsp">宿舍信息</a></li>
                <li><a href="student_express.jsp">快件信息</a></li>
                <li><a href="student_guarantee.jsp">维修信息</a></li>
                <li><a href="student_leavereturn.jsp">学生离校与返校</a></li>
                <li><a href="student_laterecord.jsp">晚归记录</a></li>
                <li class="active"><a href="student_fee.jsp">水电费信息</a></li>
            </ul>
        </div>
        <div class="visible-xs">
            <li><a href="student_information.jsp">宿舍信息</a></li>
            <li><a href="student_express.jsp">快件信息</a></li>
            <li><a href="student_guarantee.jsp">维修信息</a></li>
            <li><a href="student_leavereturn.jsp">学生离校与返校</a></li>
            <li><a href="student_laterecord.jsp">晚归记录</a></li>
            <li><a href="student_fee.jsp">水电费信息</a></li>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h2 class="sub-header">水电费查询</h2>
            <div class="table-responsive">
                <table class="table table-striped" >
                    <thead>
                    <tr>
                        <th>月份</th>
                        <th>宿舍号</th>
                        <th>用电量</th>
                        <th>电费</th>
                        <th>用水量</th>
                        <th>水费</th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${sessionScope.fee}" var="fee">
                        <tr>
                            <td>${fee.month}</td>
                            <td>${fee.dormitoryid}</td>
                            <td>${fee.electricfee}</td>
                            <td>${fee.electricnum}</td>
                            <td>${fee.waterfee}</td>
                            <td>${fee.waternum}</td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>

</body>
</html>

