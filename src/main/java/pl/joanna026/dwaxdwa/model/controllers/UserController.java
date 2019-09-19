package pl.joanna026.dwaxdwa.model.controllers;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.joanna026.dwaxdwa.model.entities.Role;
import pl.joanna026.dwaxdwa.model.entities.User;
import pl.joanna026.dwaxdwa.model.services.RoleService;
import pl.joanna026.dwaxdwa.model.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    public UserController(UserService userService, PasswordEncoder passwordEncoder, RoleService roleService) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
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
        user.setId(null);
        System.out.println(user);
        userService.saveUser(user);
        return "redirect:/login";
    }

}
