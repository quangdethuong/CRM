package controller;

import Service.JobService;
import Service.TaskService;
import Service.UserService;
import model.JobModel;
import model.StatusModel;
import model.TaskModel;
import model.UserModel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet(name = "TaskController", urlPatterns = {"/task", "/task/add", "/task/delete", "/task/update"})
public class TaskController extends HttpServlet {
    private UserService userService = new UserService();

    private TaskService taskService = new TaskService();
    private JobService jobService = new JobService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        switch (path) {
            case "/task":
                getAllTasks(req, resp);
                break;
            case "/task/add":
                addTask(req, resp);
                break;
            case "/task/delete":
                deleteTask(req, resp);
                break;
            case "/task/update":
                editTask(req, resp);
                break;
            default:
                break;
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        switch (path) {
            case "/task":
                getAllTasks(req, resp);
                break;
            case "/task/add":
                addTask(req, resp);
                break;

            case "/task/update":
                editTask(req, resp);
                break;
            default:
                break;
        }
    }


    private void editTask(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String erMsg = null;
        int id = Integer.parseInt(req.getParameter("id"));
        String method = req.getMethod();

        if(method.equalsIgnoreCase("post")){
            String name = req.getParameter("name");
            String startDay = req.getParameter("start_day");
            String endDay = req.getParameter("end_day");
            int userId = Integer.parseInt(req.getParameter("user_id"));
            int jobId = Integer.parseInt(req.getParameter("job_id"));
            int statusId = Integer.parseInt(req.getParameter("status_id"));

            // Định dạng ngày tháng đầu vào
            SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd/MM/yyyy");

            try {
                // Chuyển đổi chuỗi ngày thành đối tượng Date
                Date startDate = new Date(inputDateFormat.parse(startDay).getTime());
                Date endDate = new Date(inputDateFormat.parse(endDay).getTime());

                if (startDate.after(endDate)) {
                    erMsg = "Ngày bắt đầu không được lớn hơn ngày kết thúc.";
                    req.setAttribute("errorMessage", erMsg);

                } else {
                    boolean isSuccess = taskService.updateTask(id, name, startDate, endDate, userId, jobId, statusId);
                    if (isSuccess) {
                        resp.sendRedirect(req.getContextPath() + "/task");
                        return;
                    } else {
                        System.out.println("Thêm thất bại");
                    }
                }
            } catch (ParseException e) {
                System.out.println("Error parsing date: " + e.getMessage());
            }
        }
        List<UserModel> userList = userService.getAll();
        List<JobModel> jobList = jobService.getAllJobs();
        List<StatusModel> statusList = taskService.getAllStatus();
        TaskModel task = taskService.findById(id);
        req.setAttribute("task", task);
        req.setAttribute("isEdit", true);
        req.setAttribute("userList", userList);
        req.setAttribute("jobList", jobList);
        req.setAttribute("statusList", statusList);

        req.getRequestDispatcher("/task-add.jsp").forward(req, resp);
    }

    private void deleteTask(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        System.out.println("id: " + id);
        boolean isSuccess = taskService.deleteTask(id);
    }

    private void addTask(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String erMsg = null;
        String method = req.getMethod();
        List<UserModel> userModelList = userService.getAll();
        List<JobModel> jobModelList = jobService.getAllJobs();
        if(method.equalsIgnoreCase("post")){
            String name = req.getParameter("name");
            String startDay = req.getParameter("start_day");
            String endDay = req.getParameter("end_day");
            int userId = Integer.parseInt(req.getParameter("user_id"));
            int jobId = Integer.parseInt(req.getParameter("job_id"));

            // Định dạng ngày tháng đầu vào
            SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd/MM/yyyy");

            try {
                // Chuyển đổi chuỗi ngày thành đối tượng Date
                Date startDate = new Date(inputDateFormat.parse(startDay).getTime());
                Date endDate = new Date(inputDateFormat.parse(endDay).getTime());

                if (startDate.after(endDate)) {
                    erMsg = "Ngày bắt đầu không được lớn hơn ngày kết thúc.";
                } else {
                    boolean isSuccess = taskService.insertTask(name, startDate, endDate, userId, jobId);
                    if (isSuccess) {
                        resp.sendRedirect(req.getContextPath() + "/task");
                        return;
                    } else {
                        System.out.println("Thêm thất bại");
                    }
                }
            } catch (ParseException e) {
                System.out.println("Error parsing date: " + e.getMessage());
                erMsg = "Error parsing date: " + e.getMessage();
            }
        }
        req.setAttribute("userList", userModelList);
        req.setAttribute("jobList", jobModelList);
        req.setAttribute("erMsg", erMsg);
        req.getRequestDispatcher("/task-add.jsp").forward(req, resp);

    }

    private void getAllTasks(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("taskList", taskService.getAllTasks());
        req.getRequestDispatcher("/task.jsp").forward(req, resp);


    }
}
