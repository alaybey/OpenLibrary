package service;

import model.User;
import repository.UserRepository;
import repository.UserRepositoryImpl;

public class RegisterServiceImpl implements RegisterService {

    private UserRepository userRepository;

    public RegisterServiceImpl(){
        userRepository = new UserRepositoryImpl();
    }


    @Override
    public boolean registerUser(String username, String password) {
        User user = userRepository.getUserByName(username);
        user = (user == null) ? new User(username,password, User.Role.USER) : null ;
        createUser(user);
        return user != null;
    }

    private void createUser(User user) {
        if( user != null)
            userRepository.addUser(user);
    }

}
