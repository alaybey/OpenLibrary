package service;

import model.User;
import repository.UserRepository;
import repository.UserRepositoryImpl;
import sessionutil.SessionUtil;

public class LoginServiceImpl implements LoginService{

    private UserRepository userRepository;

    public LoginServiceImpl() {
        userRepository = new UserRepositoryImpl();
    }

    @Override
    public boolean login(String username, String password) {
        User user = null;
        try {
            user = finduser(username);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (validate(user, password)){
            SessionUtil.getSession().setAttribute("username", user.getUsername());
            return true;
        }
        return false;
    }

    private boolean validate(User user, String password){
        if (user == null)
            return false;
        return user.getPassword().equals(password);
    }

    @Override
    public void logout() {

    }

    @Override
    public User finduser(String username){
        return userRepository.getUserByName(username);
    }
}
