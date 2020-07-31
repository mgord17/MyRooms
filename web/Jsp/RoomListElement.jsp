<%@ page import="Manager.RoomManager" %>
<%@ page import="Model.Room" %><%--
  Created by IntelliJ IDEA.
  User: Gordeza
  Date: 31-Jul-20
  Time: 6:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


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

                String imageString  = "\"" + "images/" + rm.getImg() + "\"";
            %>
            <img src=<%=imageString%>>
            <div>
                <label>Wifi:
                    <input type="checkbox" disabled="disabled" <%=isWifi%> id = "check">
                </label>

                <label>Tv:
                    <input type="checkbox" disabled="disabled" <%=isTv%> id = "check">
                </label>
            </div>
            <div>
                <label>BedCount:
                    <var id = "vr"><%=rm.getNumberOfBeds()%> </var>
                </label>

                <label>Hot water:
                    <input type="checkbox" disabled="disabled" <%=isWater%> id = "check">
                </label>
                <p>Price : <var><%=rm.getPricePerDay()%></var></p>
            </div>
<%--            <a href="Jsp/RoomInfo.jsp" >See More</a>--%>

            <form class="form-inline" id = "roomInf" action="RoomDataServlet" method="post">
                <input name="id" id ="id" type="text" value=<%="\"" + Integer.toString(rm.getRoomId()) + "\""%> readonly>
                <input type="submit" class="like" value="See More" />
            </form>
        </div>
    </div>




<script
        src="https://code.jquery.com/jquery-2.2.4.js"
        integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
        crossorigin="anonymous">
</script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

