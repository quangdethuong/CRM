package Service;

import Respository.RolesRepository;
import Respository.UserRepository;
import model.RolesModel;
import model.UserModel;

import javax.management.relation.Role;
import java.util.List;

public class UserService {
    UserRepository userRepository = new UserRepository();

    RolesRepository rolesRepository = new RolesRepository();

    public List<UserModel> getAll(){
        return userRepository.getAll();
    }

    public UserModel findUserRole(String email){
        return userRepository.findUserRole(email);
    }

    public List<RolesModel> getAllRole(){
        return rolesRepository.getAll();
    }

    public boolean insertUser(String email, String passWord, String fullName, int role_id){
        return userRepository.insertUser(fullName, email, passWord, role_id);
    }

    public List<UserModel> getUser(String email, String password){

        return userRepository.findByEmailAndPassword(email , password);
    }

    public UserModel getUserById(int Id){
        UserModel user = userRepository.getUserById(Id);
        return user;
    }

    public boolean deleteUser(int id){
        return userRepository.deleteById(id);
    }
}
