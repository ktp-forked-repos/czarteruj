package pl.miroslawbrz.czarteruj.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.miroslawbrz.czarteruj.model.User;
import pl.miroslawbrz.czarteruj.service.UserService;
import pl.miroslawbrz.czarteruj.validators.RegisterValidator;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "registerForm";
    }

    @PostMapping("/addUser")
    public String addUser(User user, BindingResult bindingResult, Model model) {

        User userExist = userService.findUserByEmail(user.getEmail());

        new RegisterValidator().validateEmailExist(userExist, bindingResult);
        new RegisterValidator().validate(user, bindingResult);

        if(bindingResult.hasErrors())
            return "registerForm";
        else {

            userService.addWithDefaultRole(user);
            return "registerSuccess";
        }
    }

}