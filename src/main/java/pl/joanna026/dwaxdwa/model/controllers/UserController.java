package pl.joanna026.dwaxdwa.model.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.joanna026.dwaxdwa.model.entities.User;
import pl.joanna026.dwaxdwa.model.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping ("/create")
    public String createUser() {
        User user = new User();
        user.setUsername("user2");
        user.setPassword("pass2");
        userService.saveUser(user);
        return "ok";
    }

    @GetMapping("/add")
    public String prepareRegisterPage(Model model) {
        model.addAttribute(new User());
        return "register";
    }

    @PostMapping("/add")
    public String processRegisterPage(User user){
        userService.saveUser(user);
        return "home";
    }

}
