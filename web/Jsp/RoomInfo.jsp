<%@ page import="Model.Room" %>
<%@ page import="Manager.RoomManager" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.Account" %>
<%@ page import="Manager.AccountManager" %><%--
  Created by IntelliJ IDEA.
  User: Gordeza
  Date: 31-Jul-20
  Time: 8:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <title>Rent Rooms Daily</title>
    <script src="https://kit.fontawesome.com/83ff4f7960.js" crossorigin="anonymous"></script>
    <link href="https://fonts.googleapis.com/css2?family=Nunito:wght@200&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/83ff4f7960.js" crossorigin="anonymous"></script>
    <link rel = "shortcut icon" type = "image/png" href="images/shortcutIcon.png">
    <link rel="stylesheet" type="text/css" href="css/bootstrap3.css">

    <link rel="stylesheet" type="text/css" href="css/room.css">
</head>
<body>
<%
    Integer roomID = Integer.parseInt((String)request.getSession().getAttribute("room_id"));
    Room rm = RoomManager.getInstance().getRoom(roomID);
//    System.out.println(rm);

%>

<<jsp:include page="Board.jsp"/>


<div class="container">
    <div class="jumbotron" id = "welcoming">
        <label id  = "heading">You will find your dream apartent here</label>
    </div>
    <div class="jumbotron">
        <label id = "welcomeid"> </label>
        <div class="row" id = "mainGrid">
            <div class="col-lg-4 col-md-6 col-sm-6" >
                <div class="thumbnail" >
                    <a href="#" class = "pop">
                        <img class = "img-fluid popup " src=<%="\"images/" + rm.getImg() + "\""%> width="300" height="300">
                    </a>
                </div>
            </div>

            <%
                ArrayList<Account> accArr = AccountManager.getInstance().getAccounts();
                Account acc = null;
                for(Account cur : accArr){
                    if(cur.getId().equals(Integer.toString(rm.getAccountId()))) acc = cur;
                }
            %>

            <div class="col-lg-4 col-md-6 col-sm-6" id ="information2">
                <h1 id = "decl"> This room is provided by host <%=acc.getFirstName() + " " + acc.getLastName()%>  </h1>
                <h1 id = "decl"> Number <%=acc.getPhone()%>  </h1>
                <h1 id = "decl">  Email <%=acc.getEmail()%>  </h1>
            </div>




            <div class="col-lg-4 col-md-6 col-sm-6" id ="information2">
                <label>Number of beds: <%=rm.getNumberOfBeds()%> </label>
                <p></p>
                <label>Wifi: <%=rm.isWifi()%> </label>
                <p></p>
                <label>TV:  <%=rm.isTv()%> </label>
                <p></p>
                <label>Hot water: <%=rm.isHotWater()%></label>
                <p></p>
                <label id = "price">Price per day: <%=rm.getPricePerDay()%></label>
                <p></p>
                <label >resereved <br> <%=rm.getStartDate()%> - <%=rm.getEndDate()%></label>
            </div>

        </div>
        <%
            if(request.getSession().getAttribute("user") != null){
        %>
        <div class="row" id = "mainGrid">

            <div class="col-lg-4 col-md-6 col-sm-6" id ="information">
                <p id = "decl">Please select dates you want to place an order</p>
            </div>

            <div class="col-lg-4 col-md-6 col-sm-6" id ="information">
                <form>
                    <label>
                        From:
                        <input name = "frm" type= "date"  placeholder="From.." >
                    </label>
                    <label>To:
                        <input name = "to" type= "date"  placeholder="To.." >
                    </label>
                    <div></div>
                    <input type = "submit" class="Like" value="Order">
                </form>
            </div>
        </div>
        <%
            }
        %>
    </div>


</div>


<div class="container">
    <div class="aboutClass">
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

