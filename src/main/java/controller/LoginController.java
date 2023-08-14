package controller;

import Service.LoginService;
import Service.UserService;
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

    private UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        String email = "";
        String passWord = "";
        System.out.println(cookies);
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
        HttpSession session = req.getSession();

        //        Bước 1 : Lấy tham số username và password người dùng nhập
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");
        UserModel user = null;
        user = userService.findUserRole(email);
        if(user != null){
            session.setAttribute("role_id", user.getRoleId());

        }
        else {
            req.setAttribute("wrongLogin", "Wrong email or password");
            System.out.println(req.getAttribute("wrongLogin"));
            req.getRequestDispatcher("login.jsp").forward(req, resp);
            return;
        }
        session.setAttribute("user2", user);
        session.setAttribute("user2Id", user.getId());
        System.out.println(remember);
        boolean isSuccess = loginService.checkLogin(email, password);
        List<UserModel> userModelList = userService.getUser(email, password);
        session.setAttribute("user", userModelList);
        if (remember != null && isSuccess) {
            Cookie cUserName = new Cookie("email", email);
            Cookie cPassWord = new Cookie("password", password);
            resp.addCookie(cUserName);
            resp.addCookie(cPassWord);
            session.setAttribute("email", email);
            session.setAttribute("password", password);

            String contextPath = req.getContextPath();
            resp.sendRedirect(contextPath + "/dashboard");
        } else if (isSuccess) {
            session.setAttribute("email", email);
            session.setAttribute("password", password);

            session.setAttribute("role_id", user.getRoleId());

            String contextPath = req.getContextPath();
            resp.sendRedirect(contextPath + "/dashboard");
        } else {
            System.out.println("wrong pass");
            req.setAttribute("wrongLogin", "Wrong email or password");
            System.out.println(req.getAttribute("wrongLogin"));
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }



    }
}