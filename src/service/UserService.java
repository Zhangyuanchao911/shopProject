package service;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {

    User login(String username, String password);
    List<User> listQuery();
    int add(User user);
    int update(User user);
    int delete(int id);
    User query(int id);
    List<User> listQueryFuzz(String value);
}
