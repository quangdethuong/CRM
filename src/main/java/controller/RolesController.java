package controller;

import Service.RoleService;
import model.RolesModel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "RolesController", value = "/role")
public class RolesController extends HttpServlet {
    private RoleService roleService = new RoleService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<RolesModel> rolesModelList = roleService.getAll();
        request.setAttribute("rolesList", rolesModelList );
        request.getRequestDispatcher("role-table.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
