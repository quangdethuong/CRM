package controller;

import Service.UserService;
import model.UserModel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DashBoardController", value = "/dashboard")
public class DashBoardController extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();
        System.out.println(session.getAttribute("role_id") + "role dashboard");
//        if (session != null){
//           int role = (int) session.getAttribute("role_id");
//            session.setAttribute("role_id", role);
//            request.getRequestDispatcher("index.jsp").forward(request, response);
//            System.out.println(session.getAttribute("role_id") + "ss1");
//
//        }
//        else
//        {
//            HttpSession sessions = request.getSession(true);
//
//            String email = request.getParameter("email");
//            UserModel user = userService.findUserRole(email);
//            sessions.setAttribute("role_id", user.getRoleId());
//            System.out.println(sessions.getAttribute("role_id") +"ss2");
//            request.getRequestDispatcher("index.jsp").forward(request, response);
//
//        }
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
