package Service;

import Respository.UserRepository;
import model.UserModel;

import java.util.List;

public class UserService {
    UserRepository userRepository = new UserRepository();

    public List<UserModel> getAll(){
        return userRepository.getAll();
    }
}
