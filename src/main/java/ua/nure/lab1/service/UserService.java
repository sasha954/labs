package ua.nure.lab1.service;

import java.util.List;
import ua.nure.lab1.domain.entity.User;

public interface UserService {
    User createUser(User user);
    User updateUser(User user);
    List<User> getAllUsers();
    User getById(int id);
}
