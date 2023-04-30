package controller;

import Service.LoginService;
import config.MysqlConfig;
import model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        Cookie[] cookies = req.getCookies();
        String email = "";
        String passWord = "";
        for (Cookie item : cookies) {
            if (item.getName().equals("email")) {
                email = item.getValue();
            }

            if (item.getName().equals("password")) {
                passWord = item.getValue();
            }
        }
        req.setAttribute("email", email);
        req.setAttribute("password", passWord);
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = null;
        //        Bước 1 : Lấy tham số username và password người dùng nhập
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");
        boolean isSuccess = loginService.checkLogin(email, password ,remember);

        if (isSuccess) {
            Cookie cUserName = new Cookie("email", email);
            Cookie cPassWord = new Cookie("password", password);
            resp.addCookie(cUserName);
            resp.addCookie(cPassWord);
            String contextPath = req.getContextPath();
            resp.sendRedirect(contextPath + "/dashboard");
        }
        else {
            resp.sendRedirect("404.html");
        }



    }
}
