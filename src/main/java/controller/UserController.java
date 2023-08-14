package controller;

import Dto.UserDetailDTO;
import Service.UserService;
import model.RolesModel;
import model.UserModel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserController", urlPatterns = {"/user", "/user/add", "/user/delete", "/user/update","/user/details"})
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
            case "/user/update":
                updateUser(request, response);
                break;
            case "/user/details":
                userDetail(request, response);
                break;
            default:

                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String path = request.getServletPath();
        System.out.println(path);

        switch (path) {
            case "/user":
                getAllUser(request, response);
                break;
            case "/user/add":
                addUser(request, response);
                break;
            case "/user/update":
                updateUser(request, response);
                break;
            default:

                break;
        }
    }


    private void getAllUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        List<UserModel> userModelList = userService.getAll();
        request.setAttribute("userList", userModelList);

        request.getRequestDispatcher("/user-table.jsp").forward(request, response);
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

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getMethod();

        System.out.println(request.getParameter("newFullName"));
        System.out.println(request.getParameter("emailupdate"));

        if (method.equalsIgnoreCase("post")) {
            int newid = Integer.parseInt(request.getParameter("oldId"));
            String newEmail = (String) request.getParameter("emailupdate");
            String newFullName = (String) request.getParameter("newFullName");
            String newAvatar = (String) request.getParameter("newAvatar");
            int newRole = Integer.parseInt(request.getParameter("newRole"));

//            if (newEmail.isEmpty() || newFullName.isEmpty() || newAvatar.isEmpty()){
//                request.setAttribute("msg-valid","Please dont't give blank fields");
//                response.sendRedirect(request.getContextPath() + "/user/update?id="+ newid);
//                return;

            boolean isSuccess = userService.udpateUser(newid, newEmail, newFullName, newAvatar, newRole);
            if (!isSuccess) {
                request.setAttribute("msg-fail", "Update Fail.");
            } else {
                request.setAttribute("msg-done", "Update done.");
                System.out.println(newid);
                System.out.println(newFullName);
                System.out.println(newEmail);
                response.sendRedirect(request.getContextPath() + "/user");
                //               response.sendRedirect(request.getContextPath() + "/user/update?id="+ newid);
            }


        } else {
            int id = Integer.parseInt(request.getParameter("id"));

            List<RolesModel> rolesModelList = userService.getAllRole();
            UserModel user = userService.getUserById(id);
            request.setAttribute("userUpdate", user);

            request.setAttribute("listRole", rolesModelList);
//        request.getAttribute("user2");
            request.getRequestDispatcher("/user-update.jsp").forward(request, response);
        }


    }

    private void deteleUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);

        boolean isSuccess = userService.deleteUser(id);
    }

    private void userProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = (int) request.getAttribute("user2Id");
        System.out.println(id);
        boolean isSuccess = userService.deleteUser(id);
    }


    private void userDetail(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(req.getParameter("id"));
        System.out.println(id);
        UserDetailDTO userDetail = userService.findByUserId(id);
        req.setAttribute("userDetail", userDetail);
        req.getRequestDispatcher("/user-details.jsp").forward(req, resp);
    }
}
