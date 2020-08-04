<%--
  Created by IntelliJ IDEA.
  User: Gordeza
  Date: 04-Aug-20
  Time: 3:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="Model.Room" %>
<%@ page import="Manager.RoomManager" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.Account" %>
<%@ page import="Manager.AccountManager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    ArrayList<Room> arr = RoomManager.getInstance().getRooms();
    String email = (String)request.getSession().getAttribute("email");
    String password = (String)request.getSession().getAttribute("password");
    Account curAcc = AccountManager.getInstance().getAcc(email, password);
    int num = 0;
    String st = "<div class=\"row\">";
    String end = "</div>";
    for(Room room : arr){
        if(room.getAccountId() != Integer.parseInt(curAcc.getId())) continue;
        if(num%3==0) st = "<div class=\"row\">";
        else st = "";
        request.setAttribute("room_id", room.getRoomId());
%>
<%=st%>

    <div class="col-lg-4 col-md-6 col-sm-6">
        <div class="thumbnail">
            <%
                Integer room_id = (Integer)request.getAttribute("room_id");
                Room rm = RoomManager.getInstance().getRoom(room_id);
                String isTv = "checked=\"checked\"";
                String isWifi = "checked=\"checked\"";
                String isWater = "checked=\"checked\"";
                if(rm.isWifi() == false) isWifi = "";
                if(rm.isTv() == false) isTv = "";
                if(rm.isHotWater() == false) isWater = "";

                String imageString  = "\"" + "../images/" + rm.getImg() + "\"";
            %>
            <img src=<%=imageString%>>
            <div>
                <label style="color:gray;">Wifi:
                    <input type="checkbox" disabled="disabled" <%=isWifi%> id = "check">
                </label>

                <label style="color:gray;">Tv:
                    <input type="checkbox" disabled="disabled" <%=isTv%> id = "check">
                </label>
            </div>
            <div>
                <label style="color:gray;">BedCount:
                    <var id = "vr"><%=rm.getNumberOfBeds()%> </var>
                </label>

                <label style="color:gray;">Hot water:
                    <input type="checkbox" disabled="disabled" <%=isWater%> id = "check">
                </label>
                <p>Price : <var><%=rm.getPricePerDay()%></var></p>
            </div>

            <form class="form-inline" id = "roomInf" action="../RoomDataServlet" method="post">

                <input name="id" style="visibility: hidden; width: 0px;" id ="id" value=<%="\"" + Integer.toString(rm.getRoomId()) + "\""%> readonly>
                <input type="submit" class="like" value="See More" />
            </form>
            <form class="form-inline" id = "roomInf" action="../DeleteRoomServlet" method="post">

                <input name="id" style="visibility: hidden; width: 0px;" id ="id" value=<%="\"" + Integer.toString(rm.getRoomId()) + "\""%> readonly>

                <input type="submit" class="like" value="Delete Room" />
            </form>
            <form class="form-inline" id = "roomInf" action="../EditRoomServlet" method="get">

                <input name="id" style="visibility: hidden; width: 0px;" id ="id" value=<%="\"" + Integer.toString(rm.getRoomId()) + "\""%> readonly>

                <input type="submit" class="like" value="Edit Room" />
            </form>
        </div>
    </div>




<script
        src="https://code.jquery.com/jquery-2.2.4.js"
        integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
        crossorigin="anonymous">
</script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>



<%
    if(num%3==2 || num==(arr.size()-1)) end = "</div>";
    else end = "";
%>
<%=end%>
<%
        num++;
    }
%>
