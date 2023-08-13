package Respository;
import Dto.TaskDTO;
import config.MysqlConfig;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class TaskRepository {

    public List<TaskDTO> findAll() {
        Connection connection = null;
        List<TaskDTO> taskDtoList = new ArrayList<>();
        try {
            connection = MysqlConfig.getConnection();
            String sql = "SELECT t.*, u.fullname as user_name, j.name as job_name ,s.name as status_name FROM tasks t JOIN users u ON t.user_id = u.id JOIN jobs j ON t.job_id = j.id JOIN status s ON t.status_id = s.id";
            PreparedStatement stateMent = connection.prepareStatement(sql);
            // Thực thi câu query
            ResultSet resultSet = stateMent.executeQuery();
            while (resultSet.next()) {
                TaskDTO taskDto = new TaskDTO();
                taskDto.setId(resultSet.getInt("id"));
                taskDto.setName(resultSet.getString("name"));
                taskDto.setStartDay(resultSet.getDate("start_date"));
                taskDto.setEndDay(resultSet.getDate("end_date"));
                taskDto.setUserName(resultSet.getString("user_name"));
                taskDto.setJobName(resultSet.getString("job_name"));
                taskDto.setStatusDesc(resultSet.getString("status_name"));
                taskDtoList.add(taskDto);
            }
        } catch (Exception e) {
            System.out.println("Error getTasks: " + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    System.out.println("Error close getTasks: " + e.getMessage());
                }
            }
        }
        return taskDtoList;
    }


    public boolean insertTask(String name, Date startDay, Date endDay, int userId, int jobId) {
        Connection connection = null;
        boolean isSuccess = false;
        try {
            connection = MysqlConfig.getConnection();
            String sql = "insert into tasks(name, start_date, end_date, user_id,job_id,status_id) values(?,?,?,?,?,?)";
            PreparedStatement stateMent = connection.prepareStatement(sql);
            stateMent.setString(1, name);
            stateMent.setDate(2, startDay);
            stateMent.setDate(3, endDay);
            stateMent.setInt(4, userId);
            stateMent.setInt(5, jobId);
            stateMent.setInt(6, 1);
            // Thực thi câu query
            isSuccess = stateMent.executeUpdate() > 0;


        } catch (Exception e) {
            System.out.println("Error insertTask: " + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    System.out.println("Error close insertTask: " + e.getMessage());
                }
            }
        }
        return isSuccess;
    }

    public boolean deleteById(int id) {
        Connection connection = null;
        boolean isSuccess = false;
        try {
            connection = MysqlConfig.getConnection();
            String sql = "DELETE FROM tasks t WHERE t.id =?";
            PreparedStatement stateMent = connection.prepareStatement(sql);
            // Thực thi câu query
            stateMent.setInt(1, id);
            isSuccess = stateMent.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error deleteById: " + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    System.out.println("Error close deleteById: " + e.getMessage());
                }
            }
        }
        return isSuccess;
    }
}
