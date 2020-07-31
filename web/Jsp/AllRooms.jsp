<%@ page import="Manager.RoomManager" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.Room" %><%--
  Created by IntelliJ IDEA.
  User: Gordeza
  Date: 31-Jul-20
  Time: 6:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    ArrayList<Room> arr = RoomManager.getInstance().getRooms();
    int num = 0;
    String st = "<div class=\"row\">";
    String end = "</div>";
    for(Room rm : arr){
        if(num%3==0) st = "<div class=\"row\">";
        else st = "";
        request.setAttribute("room_id", rm.getRoomId());
%>
<%=st%>
<jsp:include page="RoomListElement.jsp"/>

<%
        if(num%3==2 || num==(arr.size()-1)) end = "</div>";
        else end = "";
%>
<%=end%>
<%
        num++;
    }
%>