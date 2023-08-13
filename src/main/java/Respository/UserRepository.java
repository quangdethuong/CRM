package Respository;

import Dto.TaskDTO;
import Dto.UserDetailDTO;
import config.MysqlConfig;
import model.RolesModel;
import model.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    //Select *  from users u inner join roles r on u.role_id  = r.id WHERE u.email  = "admin@gmail.com"
    public UserModel findUserRole(String email) {
        Connection connection = null;
        UserModel userModel = null;
        try {
            String sql = "Select u.id , u.email,u.fullname,u.role_id  from users u inner join roles r on u.role_id  = r.id WHERE u.email  =  ?";
            PreparedStatement statement = MysqlConfig.getConnection().prepareStatement(sql);
            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                //Duyệt từng dòng dữ liệu
                userModel = new UserModel();
                //Lấy giá trị của cột chỉ định và lưu vào đối tượng
                userModel.setId(resultSet.getInt("id"));
                userModel.setEmail(resultSet.getString("email"));
                userModel.setFullname(resultSet.getString("fullname"));
                userModel.setRoleId(resultSet.getInt("role_id"));


            }
        } catch (Exception e) {
            System.out.println("error find user role" + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    System.out.println("Lỗi đóng kết nối find user role" + e.getMessage());
                }
            }
        }
        return userModel;
    }


    public UserModel getUserById(int id) {
        Connection connection = null;
        UserModel userModel = null;
        try {
            String sql = "Select * from users u inner join roles r on u.role_id  = r.id WHERE u.id  =  ?";
            PreparedStatement statement = MysqlConfig.getConnection().prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                //Duyệt từng dòng dữ liệu
                userModel = new UserModel();
                //Lấy giá trị của cột chỉ định và lưu vào đối tượng
                userModel.setId(resultSet.getInt("id"));
                userModel.setEmail(resultSet.getString("email"));
                userModel.setFullname(resultSet.getString("fullname"));
                userModel.setAvatar(resultSet.getString("avatar"));
                userModel.setRoleId(resultSet.getInt("role_id"));
                userModel.setRoleName(resultSet.getString("name"));


            }
        } catch (Exception e) {
            System.out.println("error find user with id " + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    System.out.println("Lỗi đóng kết nối find user with id" + e.getMessage());
                }
            }
        }
        return userModel;
    }


    public UserDetailDTO findByUserId(int userId) {
        Connection connection = null;
        UserDetailDTO userDetailDto = new UserDetailDTO();
        List<TaskDTO> taskDtoList = new ArrayList<>();

        try {
            connection = MysqlConfig.getConnection();
            String userSql = "SELECT fullname as user_name, email as email, avatar as avatar FROM users WHERE id = ?";
            PreparedStatement userStatement = connection.prepareStatement(userSql);
            userStatement.setInt(1, userId);
            ResultSet userResult = userStatement.executeQuery();

            if (userResult.next()) {
                userDetailDto.setUserName(userResult.getString("user_name"));
                userDetailDto.setUserEmail(userResult.getString("email"));
                userDetailDto.setUserAvatar(userResult.getString("avatar"));
            }

            String taskSql = "SELECT t.*, j.name as job_name, s.id as status_id FROM tasks t INNER JOIN jobs j ON t.job_id = j.id INNER JOIN status s ON t.status_id = s.id WHERE t.user_id = ?";
            PreparedStatement taskStatement = connection.prepareStatement(taskSql);
            taskStatement.setInt(1, userId);
            ResultSet taskResult = taskStatement.executeQuery();

            while (taskResult.next()) {
                TaskDTO taskDto = new TaskDTO();
                taskDto.setId(taskResult.getInt("id"));
                taskDto.setName(taskResult.getString("name"));
                taskDto.setStartDay(taskResult.getDate("start_date"));
                taskDto.setEndDay(taskResult.getDate("end_date"));
                taskDto.setJobName(taskResult.getString("job_name"));
                taskDto.setStatusId(taskResult.getInt("status_id"));
                taskDtoList.add(taskDto);
            }

            userDetailDto.setTaskDtoList(taskDtoList);

        } catch (Exception e) {
            System.out.println("Error findByUserId: " + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    System.out.println("Error close findByUserId: " + e.getMessage());
                }
            }
        }

        return userDetailDto;
    }

    public List<UserModel> findByEmailAndPassword(String email, String password) {
        Connection connection = null;
        List<UserModel> userModelList = new ArrayList<>();
        try {
            String sql = "select * from users u where u.email = ? and u.password = ?";
            PreparedStatement statement = MysqlConfig.getConnection().prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                //Duyệt từng dòng dữ liệu
                UserModel userModel = new UserModel();
                //Lấy giá trị của cột chỉ định và lưu vào đối tượng
                userModel.setId(resultSet.getInt("id"));
                userModel.setEmail(resultSet.getString("email"));
                userModel.setFullname(resultSet.getString("fullname"));
                userModel.setRoleId(resultSet.getInt("role_id"));

                userModelList.add(userModel);
            }
        } catch (Exception e) {
            System.out.println("error find by email and password" + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    System.out.println("Lỗi đóng kết nối find by email and password " + e.getMessage());
                }
            }
        }
        return userModelList;
    }

    public List<UserModel> getAll() {
        Connection connection = null;
        List<UserModel> userModelList = new ArrayList<>();
        try {
            String sql = "Select * from users u inner join roles r on u.role_id  = r.id ";
            PreparedStatement statement = MysqlConfig.getConnection().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                //Duyệt từng dòng dữ liệu
                UserModel userModel = new UserModel();
                //Lấy giá trị của cột chỉ định và lưu vào đối tượng
                userModel.setId(resultSet.getInt("id"));
                userModel.setEmail(resultSet.getString("email"));
                userModel.setFullname(resultSet.getString("fullname"));
                userModel.setRoleId(resultSet.getInt("role_id"));
                userModel.setRoleName(resultSet.getString("name"));
                userModelList.add(userModel);
            }
        } catch (Exception e) {
            System.out.println("error getAll User" + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    System.out.println("Lỗi đóng kết nối getAll User " + e.getMessage());
                }
            }
        }
        return userModelList;
    }

    public boolean insertUser(String fullName, String email, String password, int role_id) {
        Connection connection = null;
        boolean isSucess = false;
        try {
            connection = MysqlConfig.getConnection();
            String sql = "INSERT into users (email,password,fullname, role_id) values (?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, password);
            statement.setString(3, fullName);
            statement.setInt(4, role_id);
            isSucess = statement.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("error query insertUser" + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    System.out.println("Lỗi đóng kết nối query insertUser " + e.getMessage());
                }
            }
        }
        return isSucess;
    }

    public boolean updateUser(int id, String newEmail, String newFullName, String avatar, int roleId) {
        Connection connection = null;
        boolean isSuccess = false;
        try {
            connection = MysqlConfig.getConnection();
            String sql = "UPDATE users SET email = ?, fullname = ?, avatar= ?,  role_id = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, newEmail);
            statement.setString(2, newFullName);
            statement.setString(3, avatar);
            statement.setInt(4, roleId);
            statement.setInt(5, id);
            isSuccess = statement.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error updateUser: " + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    System.out.println("Error closing connection in updateUser: " + e.getMessage());
                }
            }
            return isSuccess;
        }
    }

    public Boolean deleteById(int id) {
        Connection connection = null;
        boolean isSucess = false;

        try {
            connection = MysqlConfig.getConnection();
            String sql = "Delete From users u where u.id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            isSucess = statement.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("error mutation deleteUser" + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    System.out.println("Lỗi đóng kết nối mutation deleteUser " + e.getMessage());
                }
            }
        }
        return isSucess;
    }

}
