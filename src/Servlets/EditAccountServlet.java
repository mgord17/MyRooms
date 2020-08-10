package Servlets;

import Manager.AccountManager;
import Model.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@WebServlet(name = "EditAccountServlet", urlPatterns = {"/EditAccountServlet"})
public class EditAccountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fname = (String)request.getParameter("first_name");
        System.out.println(fname);
        String lname = (String)request.getParameter("last_name");
        System.out.println(lname);
        String username = (String)request.getParameter("username");
        System.out.println(username);
        String phone = (String)request.getParameter("phone");
        System.out.println(phone);
        String password = (String)request.getParameter("password");
        System.out.println(password);
        String email = (String)request.getSession().getAttribute("email");

        System.out.println(email);

        Account acc = new Account("", "", "", "", email, "", "", "");
        AccountManager am = AccountManager.getInstance();
        try {
            if(fname != null && fname.equals("") == false) {
                am.updateAccount(acc, "first_name", fname);
            }
            if(lname != null && lname.equals("") == false) {
                am.updateAccount(acc, "last_name", lname);
            }
            if(username != null && username.equals("") == false) {
                am.updateAccount(acc, "username", username);
                request.getSession().setAttribute("user", username);
            }
            if(phone != null && phone.equals("") == false) {
                am.updateAccount(acc, "phone", phone);
            }

            if(password != null && password.equals("") == false) {
                am.updateAccount(acc, "password", password);
                request.getSession().setAttribute("password", password);
            }
            System.out.println("password: " + request.getSession().getAttribute("password"));
            request.getRequestDispatcher("index.jsp").forward(request, response);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
