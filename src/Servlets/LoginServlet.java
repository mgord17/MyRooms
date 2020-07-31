package Servlets;

import Manager.AccountManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("pass");
        AccountManager manager = AccountManager.getInstance();
        boolean failed = true;
        try {
            if(manager.loginIntoAccount(email,password)){
                request.getSession().setAttribute("user", manager.getAcc(email,password).getUsername());
                request.getSession().setAttribute("email", email);
                request.getSession().setAttribute("password", password);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                failed = false;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        if(failed) request.getRequestDispatcher("Jsp/loginFailed.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
