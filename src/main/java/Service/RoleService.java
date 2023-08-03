package Service;

import Respository.RolesRepository;
import model.RolesModel;

import java.util.List;

public class RoleService {
     RolesRepository rolesRepository = new RolesRepository();

    public List<RolesModel> getAll(){
        return rolesRepository.getAll();
    }

    public boolean addRole(String role, String des){
        return rolesRepository.insertRole(role, des);
    }

    public boolean deleteRole(int id){
        return rolesRepository.deleteRoleById(id);
    }

}
