package pl.joanna026.dwaxdwa.model.controllers;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.joanna026.dwaxdwa.model.DTO.UserDTO;
import pl.joanna026.dwaxdwa.model.services.RoleService;
import pl.joanna026.dwaxdwa.model.services.TokenService;
import pl.joanna026.dwaxdwa.model.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final TokenService tokenService;

    public UserController(UserService userService, TokenService tokenService) {
        this.userService = userService;
        this.tokenService = tokenService;
    }

    @GetMapping ("/create")
    public String createUser() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("user2");
        userDTO.setPassword("pass2");
        userService.saveUser(userDTO);
        return "ok";
    }

    @GetMapping("/add")
    public String prepareRegisterPage(Model model) {
        model.addAttribute(new UserDTO());
        return "register";
    }

    @PostMapping("/add")
    public String processRegisterPage(UserDTO userDTO){

        userDTO.setId(null);
        userService.saveUser(userDTO);
        return "confirmationRequest";
    }

    @RequestMapping("/activate")
    public String processActivationLink(@RequestParam String token) {

        tokenService.findUserByTokenAndEnable(token);

        return "redirect:/login";
    }
}
