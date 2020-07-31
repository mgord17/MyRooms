<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/28/2020
  Time: 3:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
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

<div class="container-fluid" px-0>

    <div class = "jumbotron">
        <form action="../SignUpServlet" method="post">
            <div>
                <label>We will help you to find the aparment of your dreams</label>
            </div>


            <div>
                <label>Name:
                    <input name="name" type="text" id="name" placeholder=" Enter first name" required>
                </label>
            </div>

            <div>
                <label>Last name:
                    <input name="lastname" id= "lastname" type="text" placeholder=" Enter last name" required>
                </label>
            </div>

            <div>
                <label>Email:
                    <input name="email" id="email" type="email"  placeholder=" Enter email" required>
                </label>
            </div>

            <div>
                <label>Username:
                    <input name="user" id="username" type="text"  placeholder=" Enter username" required>
                </label>
            </div>

            <div>
                <label>Password:
                    <input name="pass" id="password" type="password" placeholder=" Enter password" required pattern=".{7,15}" required title="7 to 15 characters">
                </label>
            </div>

            <div>
                <label>Phone:
                    <input name="phone" id="phone" type="number" placeholder=" Enter phone number" required>
                </label>
            </div>

            <p>
                <label>Birthday:
                    <select name="Month" id = "dt">
                        <option>Month</option>
                        <option value="00">January</option>
                        <option value="01">Febuary</option>
                        <option value="02">March</option>
                        <option value="03">April</option>
                        <option value="04">May</option>
                        <option value="05">June</option>
                        <option value="06">July</option>
                        <option value="07">August</option>
                        <option value="08">September</option>
                        <option value="09">October</option>
                        <option value="10">Novebmer</option>
                        <option value="11">December</option>
                    </select>

                    <select name="Day" id = "day">
                        <option>Day</option>
                        <% for(int i=1; i<=31; i++){
                            String day = Integer.toString(i); %>
                        <option value = <%=day%>><%=day%></option>
                        <% } %>

                    </select>
                    <select name="Year" id= "ye">
                        <option >Year</option>
                        <% for(int i=1900; i<2004; i++){
                            String year = Integer.toString(i); %>
                        <option value = <%=year%> > <%=year%> </option>
                        <% } %>
                    </select>
                </label>
            </p>

            <p>
                <label for="agr" id = "agreement">I agree to the terms and conditions
                    <input id = "agr" name="agreed" type="checkbox" required>
                </label>
            </p>
            <input type="submit" class="like" value="Register">
        </form>
    </div>
</div>
<script
        src="https://code.jquery.com/jquery-2.2.4.js"
        integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>
