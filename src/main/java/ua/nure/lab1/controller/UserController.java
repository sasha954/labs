package ua.nure.lab1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.nure.lab1.domain.entity.Role;
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
        Role[] roles = Role.values();

        modelAndView.addObject("userList", users)
                .addObject("roles", roles);

        return modelAndView;
    }

    @PostMapping
    public ModelAndView createUser(User user) {
        userService.createUser(user);

        return new ModelAndView("redirect:/users");
    }


    @PostMapping("/update")
    public ModelAndView updateUser(User user) {
        userService.updateUser(user);

        return new ModelAndView("redirect:/users");
    }
}
