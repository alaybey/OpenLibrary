package service;

import model.User;

public interface LoginService {

    boolean login(String username, String password);
    void logout();
    User finduser(String username);

    }
