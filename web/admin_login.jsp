<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="icon" href="images/FINN.ico">
    <!-- my style CSS -->
    <link rel="stylesheet" type="text/css" href="css/mystyles.css">
    <link rel="stylesheet" type="text/css" href="css/all.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <script type="text/javascript" src="js/main.js"></script>
    <title>宿管登陆页面</title>
    <style type="text/css">
        .msg{
            color: red;
        }
    </style>
</head>
<body>
    <%@ include file="header.jsp" %>
	<div id="login">
      <div>
          <div class="form-group" align="center">
              <a href="index.jsp">
                  <img src="${pageContext.request.contextPath}/images/FINN.ico" >
              </a>
          </div>
          <div class="form-group" align="center" >宿管登录</div>
      </div>

      <form action="${pageContext.request.contextPath}/AdminLoginServlet" method="post">
        <div class="form-group">
          <input type="text" class="form-control" id="username" name="username" placeholder = "输入用户名">
            <span class="msg">${requestScope.NAMEMSG}${requestScope.NAMEERROR}</span>
        </div>
        <div class="form-group">

            <input type="password" class="form-control" id="password" name="password" placeholder = "输入密码">
            <span class="msg">${requestScope.PWDERROR}${requestScope.PWDMSG}</span>
        </div>
        <div align="center">
            <button type="submit" class="btn btn-primary">登录</button>
        </div>
      </form>
    </div>

</body>
</html>