<%@ page import="Model.Account" %>
<%@ page import="Manager.AccountManager" %><%--
  Created by IntelliJ IDEA.
  User: Gordeza
  Date: 31-Jul-20
  Time: 10:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Account</title>
    <script src="https://kit.fontawesome.com/83ff4f7960.js" crossorigin="anonymous"></script>

    <link href="https://fonts.googleapis.com/css2?family=Nunito:wght@200&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/83ff4f7960.js" crossorigin="anonymous"></script>


    <link rel = "shortcut icon" type = "image/png" href="../images/shortcutIcon.png"> <link rel="stylesheet" type="text/css" href="../css/bootstrap3.css">
    <link rel="stylesheet" type="text/css" href="../css/acc.css">

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
                    <a href="#">About</a>
                </li>
                <li class="nav-item" >
                    <a href="#">Contact</a>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li id = "rightside">

<div class="container">
    <div class="jumbotron" id = "welcoming">
        <label id  = "heading">Account Information</label>
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
                <label>First name: <%=curAcc.getFirstName()%></label>
                <p></p>
                <label>Last name: <%=curAcc.getLastName()%></label>
                <p></p>
                <label>Date of Birth: <%=curAcc.getBirthDate()%></label>
                <p></p>
                <label>Email: <%=curAcc.getEmail()%></label>
                <p></p>
                <label>Username: <%=curAcc.getUsername()%></label>
                <p></p>
                <label>Phone: <%=curAcc.getPhone()%></label>
                <p></p>
            </div>

        </div>


        <label id  = "heading">Add room</label>
            <form class="form-inline" id = "formUpload" action="AddRoomServlet" method="post">
                <input name="email" id ="email" type="email" placeholder="  Email"  required>
                <input name="price" id="price" placeholder="price per day" type="text" required >
                <input name="number of beds" id="beds" placeholder="number of beds" type="text" required >
                <input name="wifi" id="wifi" placeholder="wifi" type="checkbox" required >
                <input name="tv" id="tv" placeholder="tv" type="checkbox" required >
                <input name="water" id="water" placeholder="hot water" type="checkbox" required >
                <input type="submit" class="like" value="Upload" />
            </form>
    </div>


    <label for="img">Select image:</label>
    <input type="file" id="img" name="img" accept="image/*">
    <input type="submit">
    </form>
</div>



<div class="container">
    <div class="aboutClass" id = "about">
        <h1> For More information please contact us on mail: contact@apartsrent.com </h1>
    </div>
</div></div>
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
