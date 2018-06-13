package ua.nure.lab1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.nure.lab1.domain.entity.User;
import ua.nure.lab1.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ModelAndView getUsers() {
        ModelAndView modelAndView = new ModelAndView("user");

        List<User> users = userService.getAllUsers();

        modelAndView.addObject("userList", users);

        return modelAndView;
    }
}
