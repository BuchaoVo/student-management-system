<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <link rel="icon" href="images/FINN.ico">
  <!-- my style CSS -->
  <link rel="stylesheet" type="text/css" href="css/mystyles.css">
  <link rel="stylesheet" type="text/css" href="css/all.css">
  <link rel="stylesheet" type="text/css" href="css/main.css">
  <script type="text/javascript" src="js/main.js"></script>
  <title>学生宿舍管理系统</title>
</head>
<body>
<%@ include file="header.jsp" %>
<div class="page">
  <header class="page_header">
    <h1>学生宿舍管理系统</h1>
  </header>
  <div class="cards-holder">
    <div class="card">
      <header class="card_header" data-background="">
        <h2>查看宿舍信息</h2>
      </header>
      <section class="card_content">
        <h2>学生与宿管均可查看</h2>
        <p>宿管可以查看学生用户账号密码，并且宿管可以查询学生信息。</p>
      </section>
    </div>

    <div class="card">
      <header class="card_header" data-background="">
        <h2>查看快件信息</h2>
      </header>
      <section class="card_content">
        <h2>学生与宿管均可查看</h2>
        <p>宿管可以查看所有人的快件信息并且可以提交取件人和取件人电话号码等。</p>
      </section>
    </div>

    <div class="card">
      <header class="card_header" data-background="">
        <h2>维修信息</h2>
      </header>
      <section class="card_content">
        <h2>学生与宿管均可查看</h2>
        <p>学生可以提交需要维修的物品，宿管可以修改维修物品的状态。</p>
      </section>
    </div>

    <div class="card">
      <header class="card_header" data-background="">
        <h2>离反校信息与晚归信息</h2>
      </header>
      <section class="card_content">
        <h2>学生宿管均可查看</h2>
        <p>学生仅可查看自己的离返校信息和晚归信息，宿管可以查看所有相关信息并且可以提交修改对应信息。</p>
      </section>
    </div>

    <div class="card">
      <header class="card_header" data-background="">
        <h2>水电费信息</h2>
      </header>
      <section class="card_content">
        <h2>学生宿管均可查看</h2>
        <p>学生仅仅可以查看水电费信息，宿管可以查看所有信息并且可以提交水电费缴费情况。</p>
      </section>
    </div>

  </div>
</div>
</body>
</html>