package Respository;

import config.MysqlConfig;
import model.RolesModel;
import model.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RolesRepository {


    public boolean insertRole(String role, String des) {
        Connection connection = null;
        boolean isSucess = false;
        try {
            connection = MysqlConfig.getConnection();
            String sql = "INSERT INTO roles(name, description ) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, role);
            statement.setString(2, des);

            isSucess = statement.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error insertRole: " + e.getMessage());
        } finally {
            // Try catch chạy xong sẽ chạy vào finally
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    System.out.println("Lỗi đóng kết nối insertRole: " + e.getMessage());
                }
            }

        }
        return isSucess;
    }
    public List<RolesModel> getAll() {
        Connection connection = null;
        List<RolesModel> rolesModelList = new ArrayList<>();
        try {
            String sql = "SELECT * from roles r";
            PreparedStatement statement = MysqlConfig.getConnection().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                //Duyệt từng dòng dữ liệu
                RolesModel rolesModel = new RolesModel();
                //Lấy giá trị của cột chỉ định và lưu vào đối tượng
                rolesModel.setId(resultSet.getInt("id"));
                rolesModel.setName(resultSet.getString("name"));
                rolesModel.setDescription(resultSet.getString("description"));
                rolesModelList.add(rolesModel);
            }
        } catch (Exception e) {
            System.out.println("error find role" + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    System.out.println("Lỗi đóng kết nối role " + e.getMessage());
                }
            }
        }
        return rolesModelList;
    }


    public Boolean deleteRoleById(int id) {
        Connection connection = null;
        boolean isSucess = false;

        try {
            connection = MysqlConfig.getConnection();
            String sql = "Delete From roles r where r.id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            isSucess = statement.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("error mutation deleteUser" + e.getMessage());
        }
        finally {
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
