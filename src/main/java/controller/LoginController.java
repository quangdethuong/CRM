package controller;

import Service.LoginService;
import config.MysqlConfig;
import model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "loginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {
    private LoginService loginService = new LoginService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Cookie[] cookies = req.getCookies();
//        String email = "";
//        String passWord = "";
//        System.out.println(cookies);
//        if (cookies != null) {
//            for (Cookie item : cookies) {
//                if (item.getName().equals("email")) {
//                    email = item.getValue();
//                }
//
//                if (item.getName().equals("password")) {
//                    passWord = item.getValue();
//                }
//            }
//        }
//        else {
//            req.getRequestDispatcher("login.jsp").forward(req, resp);
//
//        }
//        req.setAttribute("email", email);
//        req.setAttribute("password", passWord);

        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("email") != null) {
            String rememberMe = (String) session.getAttribute("rememberMe");
            String email = rememberMe.equals("true") ? (String) session.getAttribute("email") : "";
            String password = rememberMe.equals("true") ? (String) session.getAttribute("password") : "";
            req.setAttribute("email", email);
            req.setAttribute("password", password);
        } else {
            req.getRequestDispatcher("login.jsp").forward(req, resp);

        }
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = null;
        //        Bước 1 : Lấy tham số username và password người dùng nhập
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");
        System.out.println(remember);
        boolean isSuccess = loginService.checkLogin(email, password);
        if (isSuccess) {
//            Cookie cUserName = new Cookie("email", email);
//            Cookie cPassWord = new Cookie("password", password);
//            resp.addCookie(cUserName);
//            resp.addCookie(cPassWord);
            HttpSession session = req.getSession();
            session.setAttribute("email", email);
            if (remember != null) {
                session.setAttribute("rememberMe", "true");
                session.setAttribute("password", password);
                session.setMaxInactiveInterval(30 * 24 * 60 * 60); // 30 days
            } else {
                session.setAttribute("rememberMe", "false");
                session.setMaxInactiveInterval(30 * 60); // 30 minutes
            }
            String contextPath = req.getContextPath();
            resp.sendRedirect(contextPath + "/dashboard");

        } else {
//            resp.sendRedirect("404.html");
            System.out.println("wrong pass");
            req.setAttribute("wrongLogin", "Wrong email or password");
            System.out.println(req.getAttribute("wrongLogin"));
            req.getRequestDispatcher("login.jsp").forward(req, resp);

        }


    }
}
