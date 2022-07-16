package ru.ziiangirov.springprojects.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.ziiangirov.springprojects.model.User;
import ru.ziiangirov.springprojects.service.UserService;

import javax.validation.Valid;
import java.util.List;


@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public ModelAndView home() {
        List<User> listUsers = userService.getAll();
        ModelAndView mav = new ModelAndView("users");
        mav.addObject("listUsers", listUsers);
        return mav;
    }

    @GetMapping("/new")
    public String newCustomerForm(@ModelAttribute("user") User user) {
        return "add_form";
    }

    @PostMapping(value = "/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @RequestMapping(value = "/delete")
    public String deleteUserFromForm(@RequestParam long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public ModelAndView editCustomerForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("edit_form");
        User user = userService.getUser(id);
        mav.addObject("user", user);
        return mav;
    }
}
