package controller;

import Service.RoleService;
import model.RolesModel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "RolesController", urlPatterns = {"/role", "/role/add","/role/delete"})
public class RolesController extends HttpServlet {
    private RoleService roleService = new RoleService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String path = request.getServletPath();
        switch (path) {
            case "/role":
                getAllRole(request, response);
                break;
            case "/role/add":
                addRole(request, response);
                break;
            case "/role/delete":
                deleteRole(request, response);
                break;
            default:
                break;
        }


    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String path = request.getServletPath();
        switch (path) {
            case "/role":
                getAllRole(request, response);
                break;
            case "/role/add":
                addRole(request, response);
                break;
            default:
                break;

        }
    }

    private void addRole(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getMethod();
        response.setContentType("text/html; charset=UTF-8");

        request.setCharacterEncoding("UTF-8");
        if (method.equalsIgnoreCase("post")) {
            String role = request.getParameter("roleName");
            String des = request.getParameter("des");
            roleService.addRole(role, des);
        }
        request.getRequestDispatcher("/role-add.jsp").forward(request, response);
//            response.sendRedirect(request.getContextPath() + "/role");
    }

    private void getAllRole(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        List<RolesModel> rolesModelList = roleService.getAll();
        request.setAttribute("rolesList", rolesModelList);
//        HttpSession session = request.getSession();
//        System.out.println(session.getAttribute("role_id") + " Role controller");

        request.getRequestDispatcher("role-table.jsp").forward(request, response);
    }

    private void deleteRole(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean isSuccess = roleService.deleteRole(id);
    }
}
