<%--
  Created by IntelliJ IDEA.
  User: Gordeza
  Date: 04-Aug-20
  Time: 9:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Room</title>
    <script src="https://kit.fontawesome.com/83ff4f7960.js" crossorigin="anonymous"></script>
    <link rel = "shortcut icon" type = "image/png" href="../images/shortcutIcon.png">
    <link rel="stylesheet" type="text/css" href="../css/bootstrap3.css">
    <link rel="stylesheet" type="text/css" href="../css/signUp.css">
    <link href="https://fonts.googleapis.com/css2?family=Quicksand&display=swap" rel="stylesheet">
</head>
<body>
<nav class="navbar  navbar-inverse navbar-fixed-top" id = "mainNav">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="../index.jsp" class = "navbar-brand">Home</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="nav-item" >
                <li><a href="#">About</a></li>
                </li>
                <li class="nav-item" >
                <li><a href="#">Contact</a></li>
                </li>
            </ul>
        </div>
    </div>
</nav>

<br><br>
<br><br>
<br><br>
<h1>Leave empty fields you don't want to change</h1>
<form action="../EditAccountServlet" method="post">

    <div>
        <label>First Name:</label>
        <input type="text" placeholder="  First Name" name="first_name">
    </div>
    <div>
        <label>Last Name:</label>
        <input type="text" placeholder="  Last Name" name="last_name">
    </div>
    <div>
        <label>Username:</label>
        <input type="text" placeholder="  Username" name="username">
    </div>
    <div>
        <label>Phone:</label>
        <input type="text" placeholder="  Phone" name="phone">
    </div>
    <div>
        <label>Password:</label>
        <br>
        <input type="password" placeholder="  Password" name="password" pattern=".{7,15}" title="7 to 15 characters">
    </div>

    <input type="submit" value="Save Changes">
</form>
</body>
</html>
