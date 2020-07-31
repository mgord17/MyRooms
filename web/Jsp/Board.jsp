<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="css/board.css">
<nav class="navbar  navbar-inverse navbar-fixed-top" id = "mainNav">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="index.jsp" class = "navbar-brand">Home</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="nav-item" >
                    <a href="#">About</a>
                </li>
                <li class="nav-item" >
                    <a href="#">Contact</a>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <%String logedName = (String)request.getSession().getAttribute("user");

                    if(logedName != null){ %>
                <li id = "rightside">
                    <form action="logoutServlet" method="post">
                        <i class="fas fa-user-circle" id = "icon"> <a href="Jsp/Account.jsp" id = "user"> <%=logedName%> </a></i>
                        <input type="submit" class="like" value="Log out" />
                    </form>
                </li>

                <%}else{ %>
                <li>
                    <form class="form-inline" id = "login" action="LoginServlet" method="post">
                        <input name="email" id ="email" type="email" placeholder="  Email"  required>
                        <input name="pass" id="password" placeholder="  Password" type="password" required >
                        <input type="submit" class="like" value="Log in" />
                    </form>
                </li>
                <li>
                    <a href="Jsp/SignUp.jsp" > Sign up</a>
                </li>
                <%}%>
            </ul>
        </div>
    </div>
</nav>
