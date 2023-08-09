package Service;

import Respository.UserRepository;
import model.UserModel;

import java.util.List;

public class LoginService {
    UserRepository userRepository = new UserRepository();

    public Boolean checkLogin(String email, String password){
        List<UserModel> userModelList = userRepository.findByEmailAndPassword(email , password);
        return userModelList.size() > 0;
    }




}
