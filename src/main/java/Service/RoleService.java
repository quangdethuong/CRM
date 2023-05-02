package Service;

import Respository.RolesRepository;
import model.RolesModel;

import java.util.List;

public class RoleService {
     RolesRepository rolesRepository = new RolesRepository();

    public List<RolesModel> getAll(){
        return rolesRepository.getAll();
    }
}
