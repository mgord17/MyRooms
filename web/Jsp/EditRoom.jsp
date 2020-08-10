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
    <link rel="stylesheet" type="text/css" href="css/bootstrap3.css">
    <link rel="stylesheet" type="text/css" href="css/signUp.css">
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
            <a href="index.jsp" class = "navbar-brand">Home</a>
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

<form action="EditRoomServlet" method="post">
    <div>
        <label>Price per day:</label>
        <input type="text" placeholder="  Price" name="price">
    </div>
    <label>Number of beds:</label>
    <input type="text" placeholder="  Number of beds" name="nBeds">
    <div>
        <label>Wifi:</label>
        <input type="checkbox" name="check1">
    </div>
    <div>
        <label>Tv:</label>
        <input type="checkbox" name ="check2">
    </div>

    <div>
        <label>Hot water:</label>
        <input type="checkbox" name="check3">
    </div>
    <%-- ---------------------------------------------------------------------------------------------------- --%>
    <%--
    <p>
        <label style="color:white;">from:
            <select name="Month" id = "dt" style="color:gray; border-radius: 10px;">
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

            <select name="Day" id = "day" style="color:gray; border-radius: 10px;">
                <option>Day</option>
                <% for(int i=1; i<=31; i++){
                    String day = Integer.toString(i); %>
                <option value = <%=day%>><%=day%></option>
                <% } %>

            </select>
            <select name="Year" id= "ye" style="color:gray; border-radius: 10px;">
                <option >Year</option>
                <% for(int i=2020; i<2100; i++){
                    String year = Integer.toString(i); %>
                <option value = <%=year%> > <%=year%> </option>
                <% } %>
            </select>
        </label>
    </p>

    <p>
        <label style="color:white;">to:
            <select name="Month2" id = "dt1" style="color:gray; border-radius: 10px;">
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

            <select name="Day2" id = "day2" style="color:gray; border-radius: 10px;">
                <option>Day</option>
                <% for(int i=1; i<=31; i++){
                    String day = Integer.toString(i); %>
                <option value = <%=day%>><%=day%></option>
                <% } %>

            </select>
            <select name="Year2" id= "ye2" style="color:gray; border-radius: 10px;">
                <option >Year</option>
                <% for(int i=2020; i<2100; i++){
                    String year = Integer.toString(i); %>
                <option value = <%=year%> > <%=year%> </option>
                <% } %>
            </select>
        </label>
    </p>
    --%>
    <%-- ---------------------------------------------------------------------------------------------------- --%>

    <label for="img">Select image:</label>
    <input type="file" id="img" name="img" accept="image/*">
    <input type="submit" value="Save Changes">
</form>
</body>
</html>
