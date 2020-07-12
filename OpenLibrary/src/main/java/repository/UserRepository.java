package repository;

import model.User;

public interface UserRepository {

    void addUser(User user);
    User getUser(int id);
    User updateUser(User user);
    void deleteUser(int id);
    User getUserByName(String username);


}
