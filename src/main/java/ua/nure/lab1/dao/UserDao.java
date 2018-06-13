package ua.nure.lab1.dao;

import ua.nure.lab1.domain.entity.User;

import java.util.List;

public interface UserDao {
    User createUser(User user);
    User updateUser(User user);
    List<User> getAllUsers();
    User getById(int id);
}
