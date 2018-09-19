package pl.coderslab.receiver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.receiver.model.User;
import pl.coderslab.receiver.repository.UserRepository;
import pl.coderslab.receiver.service.UserService;
import pl.coderslab.receiver.service.UserServiceImpl;

@Controller
public class LoginController
{
    @Autowired
    UserService userService = new UserServiceImpl();

    @GetMapping("/login")
    public String login ()
    {
        return "login";
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register (Model model)
    {
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerPost (@ModelAttribute User user)
    {
        userService.saveUser(user);
        return "login";
    }
}
