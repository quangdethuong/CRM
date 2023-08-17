package controller;

import Dto.UserDetailDTO;
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


@WebServlet(name = "ProfileController", urlPatterns = {"/profile", "/profile/update"})
public class ProfileController extends HttpServlet {

    private UserService userService = new UserService();
    private TaskService taskService = new TaskService();
    private JobService jobService = new JobService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        switch (path) {
            case "/profile":
                getProfile(req, resp);
                break;
            case "/profile/update":
                updateProfile(req, resp);
                break;

            default:
                break;
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        switch (path) {
            case "/profile":
                getProfile(req, resp);
                break;
            case "/profile/update":
                updateProfile(req, resp);
                break;

            default:
                break;
        }
    }

    private void getProfile(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(req.getParameter("id"));
        System.out.println(id);
        UserDetailDTO userProfile = userService.findByUserId(id);

        req.setAttribute("userProfile", userProfile);
        req.getRequestDispatcher("/profile.jsp").forward(req, resp);
    }

    private void updateProfile(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String erMsg = null;
        int id = Integer.parseInt(req.getParameter("id"));
        String method = req.getMethod();
        List<UserModel> userList = userService.getAll();
        List<JobModel> jobList = jobService.getAllJobs();
        List<StatusModel> statusList = taskService.getAllStatus();
        TaskModel task = taskService.findById(id);

        if (method.equalsIgnoreCase("post")) {
            String name = req.getParameter("nameProfile");
            String startDay = req.getParameter("start_dayProfile");
            String endDay = req.getParameter("end_dayProfile");
            int userId = Integer.parseInt(req.getParameter("user_idProfile"));
            int jobId = Integer.parseInt(req.getParameter("job_idProfile"));
            int statusId = Integer.parseInt(req.getParameter("status_idProfile"));

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
                        int uid = task.getUserId();
                        resp.sendRedirect(req.getContextPath() + "/profile?id=" + uid);
                        return;
                    } else {
                        System.out.println("Thêm thất bại");
                    }
                }
            } catch (ParseException e) {
                System.out.println("Error parsing date: " + e.getMessage());
            }
        }


        req.setAttribute("task", task);
        req.setAttribute("isEdit", true);
        req.setAttribute("userList", userList);
        req.setAttribute("jobList", jobList);
        req.setAttribute("statusList", statusList);

        req.getRequestDispatcher("/profile-edit.jsp").forward(req, resp);
    }
}
