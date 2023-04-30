package Respository;

import config.MysqlConfig;
import model.RolesModel;
import model.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
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
                RolesModel rolesModel = new RolesModel();
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


}
