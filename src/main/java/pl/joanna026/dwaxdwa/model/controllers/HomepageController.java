package pl.joanna026.dwaxdwa.model.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.joanna026.dwaxdwa.model.entities.ExerciseCollection;
import pl.joanna026.dwaxdwa.model.entities.User;
import pl.joanna026.dwaxdwa.model.services.UserService;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/student/home")
public class HomepageController {

    private final UserService userService;

    public HomepageController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String prepareHomepage(Principal principal, Model model) {
        Optional<User> optionalUser = Optional.ofNullable(userService.findByUsername(principal.getName()));
        optionalUser.ifPresent(user -> {
            List<ExerciseCollection> availableExerciseCollection = user.getAvailableExerciseCollection();
            model.addAttribute("collections", availableExerciseCollection);
        });
        return "homepage";
    }
}
