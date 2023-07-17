package project.example.registration.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.example.registration.dtos.UserDto;
import project.example.registration.services.UserService;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/user_register")
    public String registrationForm(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "registration";
    }

    @PostMapping("/user_register")
    public String registerUser(@ModelAttribute("userDto") UserDto userDto, Model model) {
        userService.registerUser(userDto);
        return "login";
    }

    @GetMapping("/user_login")
    public String loginForm(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "home";
    }


   @GetMapping ("pharmacy_home")
   public String pharmacyHome() {
       return "home";
   }

    @GetMapping ("login")
    public String login() {
        return "login";
    }


    @PostMapping("/user_login")
    public String loginUser(@ModelAttribute("userDto") UserDto userDto, Model model) {
        boolean loginSuccessful = userService.loginUser(userDto);
        if (loginSuccessful) {
            return "redirect:/pharmacy_home";

        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }

}



