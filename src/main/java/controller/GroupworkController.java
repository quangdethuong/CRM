package controller;

import Service.JobService;
import model.JobModel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(name = "GroupworkController", urlPatterns = {"/job","/job/add","/job/delete", "/job/update"})
public class GroupworkController extends HttpServlet {

    private JobService jobService = new JobService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        switch (path) {
            case "/job":
                getAllJobs(req, resp);
                break;
            case "/job/add":
                addJob(req, resp);
                break;
            case "/job/delete":
                deleteJob(req, resp);
                break;
            case "/job/update":
                updateJob(req, resp);
                break;
            default:
                break;
        }
    }




    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        switch (path) {
            case "/job":
                getAllJobs(req, resp);
                break;
            case "/job/add":
                addJob(req, resp);
                break;

            case "/job/update":
                updateJob(req, resp);
                break;
            default:
                break;
        }
    }

    private void updateJob(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {req.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(req.getParameter("id"));
        String method = req.getMethod();

        if(method.equalsIgnoreCase("post")){
            String name = req.getParameter("name");
            String startDay = req.getParameter("start_day");
            String endDay = req.getParameter("end_day");

            // Định dạng ngày tháng đầu vào
            SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd/MM/yyyy");

            try {
                // Chuyển đổi chuỗi ngày thành đối tượng Date
                Date startDate = new Date(inputDateFormat.parse(startDay).getTime());
                Date endDate = new Date(inputDateFormat.parse(endDay).getTime());

                if (startDate.after(endDate)) {
                    req.setAttribute("errorMessage", "Ngày bắt đầu không được lớn hơn ngày kết thúc.");
                } else {
                    boolean isSuccess = jobService.updateJob(id, name, startDate, endDate);
                    if (isSuccess) {
                        resp.sendRedirect(req.getContextPath() + "/job");
                        return;
                    } else {
                        System.out.println("Cập nhật thất bại");
                    }
                }

            } catch (ParseException e) {
                System.out.println("Error parsing date: " + e.getMessage());
                req.setAttribute("errorMessage", "Error parsing date: " + e.getMessage());
            }
        }

        JobModel job = jobService.findById(id);
        req.setAttribute("isEdit", true);
        req.setAttribute("job", job);
        req.getRequestDispatcher("/groupwork-add.jsp").forward(req, resp);
    }

    private void addJob(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.setCharacterEncoding("utf-8");
        String method = req.getMethod();
        String errorMessage = null;
        if(method.equalsIgnoreCase("post")){
            String name = req.getParameter("name");
            String startDay = req.getParameter("start_day");
            String endDay = req.getParameter("end_day");

            // Định dạng ngày tháng đầu vào
            SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd/MM/yyyy");

            try {
                // Chuyển đổi chuỗi ngày thành đối tượng Date
                Date startDate = new Date(inputDateFormat.parse(startDay).getTime());
                Date endDate = new Date(inputDateFormat.parse(endDay).getTime());

                if (startDate.after(endDate)) {
                    errorMessage = "Ngày bắt đầu không được lớn hơn ngày kết thúc.";
                } else {
                    boolean isSuccess = jobService.insertJob(name, startDate, endDate);
                    if (isSuccess) {
                        resp.sendRedirect(req.getContextPath() + "/job");
                        return;
                    } else {
                        System.out.println("Thêm thất bại");
                    }
                }

            } catch (ParseException e) {
                System.out.println("Error parsing date: " + e.getMessage());
                errorMessage = "Error parsing date: " + e.getMessage();
            }
        }
        req.setAttribute("errorMessage", errorMessage);
        req.getRequestDispatcher("/groupwork-add.jsp").forward(req, resp);
    }

    private void getAllJobs(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException   {
        req.setAttribute("jobLists", jobService.getAllJobs());
        req.getRequestDispatcher("/groupwork.jsp").forward(req, resp);
    }


    private void deleteJob(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        boolean isSuccess = jobService.deleteJob(id);
    }
}
