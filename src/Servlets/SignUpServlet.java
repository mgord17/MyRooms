package Servlets;

import Manager.AccountManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@WebServlet(name = "SignUpServlet", urlPatterns = {"/SignUpServlet"})
public class SignUpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = (String)request.getParameter("name");
        String lastName = (String)request.getParameter("lastname");
        String day = (String)request.getParameter("Day");
        String month = (String)request.getParameter("Month");
        String year = (String)request.getParameter("Year");
        String birthDate = year + "-" + month + "-" + day;
        String email = (String)request.getParameter("email");
        String username = (String)request.getParameter("user");
        String password = (String)request.getParameter("pass");
        String phone = (String)request.getParameter("phone");
        AccountManager manager = AccountManager.getInstance();
        boolean failed = true;
        try {
            if(manager.createAccount(firstName, lastName, birthDate, email, username, password, phone)){
                request.getSession().setAttribute("user", username);
                request.getSession().setAttribute("email", email);
                request.getSession().setAttribute("password", password);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                failed = false;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        if(failed) request.getRequestDispatcher("Jsp/signUpFailed.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
