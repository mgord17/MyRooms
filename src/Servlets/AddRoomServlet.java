package Servlets;

import DB.MyDBInfo;
import Manager.AccountManager;
import Manager.RoomManager;
import Model.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.security.*;
import java.util.Date;

@WebServlet(name = "AddRoomServlet", urlPatterns = {"/AddRoomServlet"})
public class AddRoomServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AccountManager am = AccountManager.getInstance();
        String email = (String)request.getSession().getAttribute("email");
        String password = (String)request.getSession().getAttribute("password");
        try {
            int id = Integer.parseInt(am.getAcc(email,password).getId());
            RoomManager rm = RoomManager.getInstance();
//            int year = Integer.parseInt(request.getParameter("Year"));
//            int month = Integer.parseInt(request.getParameter("Month"));
//            int day = Integer.parseInt(request.getParameter("Day"));
//            Date start = new Date(year,month,day);
//            int year1 = Integer.parseInt(request.getParameter("Year2"));
//            int month1 = Integer.parseInt(request.getParameter("Month2"));
//            int day1 = Integer.parseInt(request.getParameter("Day2"));
//            Date end = new Date(year1,month1,day1);
            int price =Integer.parseInt(request.getParameter("price"));
            int nBeds =Integer.parseInt(request.getParameter("nBeds"));
            boolean wifi = true;
            boolean tv = true;
            boolean hotWater = true;
            if(request.getParameter("check1") == null)  wifi = false;
            if(request.getParameter("check2") == null) tv = false;
            if(request.getParameter("check3") == null) hotWater = false;

            rm.addRoom(new Date(), new Date(), price,request.getParameter("img"),id,nBeds,wifi,tv,hotWater);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
