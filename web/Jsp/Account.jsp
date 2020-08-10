<%@ page import="Model.Account" %>
<%@ page import="Manager.AccountManager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Room</title>
    <script src="https://kit.fontawesome.com/83ff4f7960.js" crossorigin="anonymous"></script>

    <link href="https://fonts.googleapis.com/css2?family=Nunito:wght@200&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/83ff4f7960.js" crossorigin="anonymous"></script>

    <link rel = "shortcut icon" type = "image/png" href="../images/shortcutIcon.png">
    <link rel="stylesheet" type="text/css" href="../css/bootstrap3.css">
    <link rel="stylesheet" type="text/css" href="../css/acc.css">
</head>
<body>

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
            <a href="../index.jsp" class = "navbar-brand">Home</a>
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
                <li id = "rightside">
                    <br>
                    <form action="../logoutServlet" method="post">
                        <input type="submit" class="like" value="Log out" />
                    </form>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">
    <div class="jumbotron" id = "welcoming">
        <label class  = "heading">Account Information</label>
    </div>
    <div class="jumbotron">
        <label id = "welcomeid"> </label>
        <div class="row" id = "mainGrid">
            <div class="col" id ="information2">
                <%
                    Account curAcc = AccountManager.getInstance().getAcc((String)request.getSession().getAttribute("email"),
                            (String)request.getSession().getAttribute("password"));
                    System.out.println(curAcc);
                %>
                <label>First name: <%=curAcc.getFirstName()%></label><br>
                <label>Last name: <%=curAcc.getLastName()%></label><br>
                <label>Date of Birth: <%=curAcc.getBirthDate()%></label><br>
                <label>Email: <%=curAcc.getEmail()%></label><br>
                <label>Username: <%=curAcc.getUsername()%></label><br>
                <label>Phone: <%=curAcc.getPhone()%></label><br>
                <a href="EditAccount.jsp">Edit Account</a>
                <form action="../DeleteAccountServlet" method="post">
                    <input type="submit" value="Delete Account">
                </form>
            </div>
        </div>

        <label class = "heading">Add room</label>

        <form action="../AddRoomServlet" method="post">
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
            <input type="submit">
        </form>

    </div>

    <jsp:include page="roomList.jsp"/>
    <br>
    <div class="row">
    </div>
    <div class="container">
        <div class="aboutClass" id = "about">
            <h1> For More information please contact us on mail: contact@apartsrent.com </h1>
        </div>
    </div>
    </div>

    <!-- Creates the bootstrap modal where the image will appear -->
    <div class="modal fade" id="imagemodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title" id="myModalLabel">Image preview</h4>
                </div>
                <div class="modal-body">
                    <img src="" class="imagepreview" style="width: 400px; height: 264px;" >
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>

    <script
            src="https://code.jquery.com/jquery-2.2.4.js"
            integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
            crossorigin="anonymous">
    </script>

    <script>
        $(".pop").on("click", function() {
            $('.imagepreview').attr('src', $(this).find('img').attr('src')); // here asign the image to the modal when the user click the enlarge link
            $('#imagemodal').modal('show'); // imagemodal is the id attribute assigned to the bootstrap modal, then i use the show function
        });
    </script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>