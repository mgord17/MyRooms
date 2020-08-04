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

@WebServlet(name = "DeleteRoomServlet", urlPatterns = {"/DeleteRoomServlet"})
public class DeleteRoomServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoomManager rm = RoomManager.getInstance();
        String ID = (String)request.getParameter("id");
        rm.deleteRoom(Integer.parseInt(ID));

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
