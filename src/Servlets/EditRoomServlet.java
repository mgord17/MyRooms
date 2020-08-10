package Servlets;

import Manager.AccountManager;
import Manager.RoomManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

@WebServlet(name = "EditRoomServlet", urlPatterns = {"/EditRoomServlet"})
public class EditRoomServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoomManager rm = RoomManager.getInstance();
//        System.out.println("************");
//        System.out.println("************");
//        System.out.println("************");

        try {
            int roomId = Integer.parseInt((String)request.getSession().getAttribute("id"));
//            System.out.println(request.getSession().getAttribute("id"));
//            int year = Integer.parseInt(request.getParameter("Year"));
//            int month = Integer.parseInt(request.getParameter("Month"));
//            int day = Integer.parseInt(request.getParameter("Day"));
//            Date start = new Date(year,month,day);
////            System.out.println(start);
//            int year1 = Integer.parseInt(request.getParameter("Year2"));
//            int month1 = Integer.parseInt(request.getParameter("Month2"));
//            int day1 = Integer.parseInt(request.getParameter("Day2"));
//            Date end = new Date(year1,month1,day1);
//            System.out.println(end);
            int price =Integer.parseInt(request.getParameter("price"));
//            System.out.println(price);
            int nBeds =Integer.parseInt(request.getParameter("nBeds"));
//            System.out.println(nBeds);
            boolean wifi = true;
            boolean tv = true;
            boolean hotWater = true;
            if(request.getParameter("check1") == null)  wifi = false;
            if(request.getParameter("check2") == null) tv = false;
            if(request.getParameter("check3") == null) hotWater = false;
            AccountManager am = AccountManager.getInstance();

            String email = (String)request.getSession().getAttribute("email");
            String password = (String)request.getSession().getAttribute("password");
            int AccId = Integer.parseInt(am.getAcc(email,password).getId());
//            System.out.println(AccId);
            rm.updateRoom(roomId, new Date(), new Date(), price, request.getParameter("img"), AccId, nBeds, wifi, tv, hotWater);
//            System.out.println("aqaaaa");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("id", request.getParameter("id"));
        request.getRequestDispatcher("Jsp/EditRoom.jsp").forward(request, response);
    }
}
