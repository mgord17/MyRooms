package Servlets;

import Manager.AccountManager;
import Manager.RoomManager;
import Model.Account;
import Model.Room;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

@WebServlet(name = "DeleteAccountServlet", urlPatterns = {"/DeleteAccountServlet"})
public class DeleteAccountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = (String)request.getSession().getAttribute("email");
        String password = (String)request.getSession().getAttribute("password");
        AccountManager am = AccountManager.getInstance();
        try {
            RoomManager rm = RoomManager.getInstance();
            ArrayList<Room> arr = rm.getRooms();
            Account curAcc = AccountManager.getInstance().getAcc(email, password);
            for(Room room : arr) {
                if (room.getAccountId() != Integer.parseInt(curAcc.getId())) continue;
                rm.deleteRoom(room.getRoomId());
            }
            am.deleteAccount(email, password);
            request.getSession().setAttribute("user", null);
            request.getSession().setAttribute("email", null);
            request.getSession().setAttribute("password", null);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
