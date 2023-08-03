package Filter;

import Service.UserService;
import model.UserModel;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AdminFilter",urlPatterns = {"/user/*", "/role/*"})
public class AdminFilter implements Filter {


    public void init(FilterConfig config) throws ServletException {


    }

    public void destroy() {
    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //      cho phep di vao link ma ng dung request


        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;



        int role =(int) req.getSession().getAttribute("role_id");
        switch (role){
            case 1:
                chain.doFilter(request,response);
                break;
            case 2:
                if(req.getServletPath().startsWith("/groupwork") || req.getServletPath().startsWith("/user")){
                    chain.doFilter(request,response);
                    break;
                }
                if(req.getServletPath().startsWith("/role")){
                    req.getRequestDispatcher("404.html").forward(request, response);
                    return;

                }
                break;
            default:
                req.getRequestDispatcher("404.html").forward(request, response);
                break;

        }
//        String email = (String) req.getSession().getAttribute("email");
//        int role =  (int) req.getSession().getAttribute("role_id");
//            System.out.println(role + " admin");
//            if (role == 1){
//                chain.doFilter(request,response);
//
//            }
//            else {
//                req.getRequestDispatcher("404.html").forward(request, response);
//            }



    }
}
