package controller;

import Service.UserService;
import model.RolesModel;
import model.UserModel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserController", urlPatterns = {"/user", "/user/add", "/user/delete"})
public class UserController extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String path = request.getServletPath();
        switch (path) {
            case "/user":

                getAllUser(request, response);
                break;
            case "/user/add":

                addUser(request, response);
                break;
            case "/user/delete":
                deteleUser(request, response);
                break;
            default:

                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String path = request.getServletPath();

        switch (path) {
            case "/user":
                getAllUser(request, response);
                break;
            case "/user/add":
                addUser(request, response);
                break;
            default:

                break;
        }
    }


    private void getAllUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        List<UserModel> userModelList = userService.getAll();
        request.setAttribute("userList", userModelList);
        request.getRequestDispatcher("user-table.jsp").forward(request, response);
    }

    private void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String method = request.getMethod();
        List<RolesModel> rolesModelList = userService.getAllRole();
        if (method.equalsIgnoreCase("post")) {

            String fullName = request.getParameter("fullName");
            String email = request.getParameter("email");
            String passWord = request.getParameter("passWord");
            int role = Integer.parseInt(request.getParameter("role"));

            userService.insertUser(email, passWord, fullName, role);
        }
        request.setAttribute("listRole", rolesModelList);
        request.getRequestDispatcher("/user-add.jsp").forward(request, response);
    }

    private void deteleUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean isSuccess = userService.deleteUser(id);
    }
}
