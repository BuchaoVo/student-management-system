<%--
  Created by IntelliJ IDEA.
  User: 蘑菇先生
  Date: 2020/12/21
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    <script type="text/javascript">
        function logout(){
            if(!confirm("真的要退出吗？")){
                window["event"].returnValue = false;
            }
        }
    </script>
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
                <li class="active"><a href="student_leavereturn.jsp">学生离校与返校</a></li>
                <li><a href="student_laterecord.jsp">晚归记录</a></li>
                <li><a href="student_fee.jsp">水电费查询</a></li>
            </ul>
        </div>
        <div class="visible-xs">
            <li><a href="student_information.jsp">宿舍信息</a></li>
            <li><a href="student_express.jsp">快件信息</a></li>
            <li><a href="student_guarantee.jsp">维修信息</a></li>
            <li><a href="student_leavereturn.jsp">学生离校与返校</a></li>
            <li><a href="student_laterecord.jsp">晚归记录</a></li>
            <li><a href="student_fee.jsp">水电费查询</a></li>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h2 class="sub-header">学生离校与返校</h2>
            <div class="table-responsive">
                <table class="table table-striped" >
                    <thead>
                    <tr>
                        <th>姓名</th>
                        <th>宿舍号</th>
                        <th>离校时间</th>
                        <th>返校时间</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${sessionScope.leavereturn}" var="leavereturn">
                        <tr>
                            <td>${leavereturn.studentname}</td>
                            <td>${leavereturn.dormitoryid}</td>
                            <td>${leavereturn.leavetime}</td>
                            <td>${leavereturn.returntime}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/StudentLeavereturnServlet" method="post">
                <input type="hidden" name="per" value="lr">
                <div class="form-group">
                    <label class="col-sm-2 control-label">宿舍号</label>
                    <div class="col-lg-4">
                        <input type="text" class="form-control" placeholder="输入宿舍号" name="dormitoryid">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">离校时间</label>
                    <div class="col-lg-4">
                        <input type="text" class="form-control" placeholder="输入离校时间" name="leavetime">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">返校时间</label>
                    <div class="col-lg-4">
                        <input type="text" class="form-control" placeholder="输入返校时间" name="returntime">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">提交</button>
                    </div>
                </div>
            </form>
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

