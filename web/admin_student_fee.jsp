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
    String dormadminname = (String) request.getSession().getAttribute("dormadminname");
    if(dormadminname == null)
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
                    <a class="navbar-right" href="student_information.jsp">正在登陆的用户为：${sessionScope.dormadminname}(宿管)</a>
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
                <li><a href="admin_student_information.jsp">宿舍信息</a></li>
                <li><a href="admin_student_expess.jsp">快件信息</a></li>
                <li><a href="admin_student_guarantee.jsp">维修信息</a></li>
                <li><a href="admin_student_leavereturn.jsp">学生离校与返校</a></li>
                <li><a href="admin_student_laterecord.jsp">晚归记录</a></li>
                <li class="active"><a href="admin_student_fee.jsp">水电费信息</a></li>
            </ul>
        </div>
        <div class="visible-xs">
            <li><a href="admin_student_information.jsp">宿舍信息</a></li>
            <li><a href="admin_student_expess.jsp">快件信息</a></li>
            <li><a href="admin_student_guarantee.jsp">维修信息</a></li>
            <li><a href="admin_student_leavereturn.jsp">学生离校与返校</a></li>
            <li><a href="admin_student_laterecord.jsp">晚归记录</a></li>
            <li><a href="admin_student_fee.jsp">水电费信息</a></li>
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
                        <c:forEach items="${sessionScope.fees}" var="fees">
                            <tr>
                                <td>${fees.month}</td>
                                <td>${fees.dormitoryid}</td>
                                <td>${fees.electricfee}</td>
                                <td>${fees.electricnum}</td>
                                <td>${fees.waterfee}</td>
                                <td>${fees.waternum}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/AdminFeeServlet" method="post">
                <input type="hidden" name="per" value="rec">
                <div class="form-group">
                    <label class="col-sm-2 control-label">月份</label>
                    <div class="col-lg-4">
                        <input type="text" class="form-control" placeholder="输入月份" name="month">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">宿舍号</label>
                    <div class="col-lg-4">
                        <input type="text" class="form-control" placeholder="输入宿舍号" name="dormitoryid">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">用电量</label>
                    <div class="col-lg-4">
                        <input type="text" class="form-control" placeholder="输入用电量" name="electricfee">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">电费</label>
                    <div class="col-lg-4">
                        <input type="text" class="form-control" placeholder="输入电费" name="electricnum">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">用水量</label>
                    <div class="col-lg-4">
                        <input type="text" class="form-control" placeholder="输入用水量" name="waterfee">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">水费</label>
                    <div class="col-lg-4">
                        <input type="text" class="form-control" placeholder="输入水费" name="waternum">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default" name="submit" value="submit">提交</button>
                        <button type="submit" class="btn btn-default" name="submit" value="modify">修改</button>
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

