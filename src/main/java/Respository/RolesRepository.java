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
}
