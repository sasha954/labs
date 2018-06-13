package ua.nure.lab1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ua.nure.lab1.dao.UserDao;
import ua.nure.lab1.domain.entity.User;
import ua.nure.lab1.service.UserService;

import java.util.List;


public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public User getById(int id) {
        return null;
    }
}
