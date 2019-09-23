package pl.joanna026.dwaxdwa.model.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.joanna026.dwaxdwa.model.entities.LearntCollectionsWithUsers;
import pl.joanna026.dwaxdwa.model.entities.User;
import pl.joanna026.dwaxdwa.model.services.UserService;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/student/learnt/all")
public class LearntListDisplayController {

    private final UserService userService;

    public LearntListDisplayController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String prepareLearntCollectionsPage(Principal principal, Model model) {

        User user = userService.findByUsername(principal.getName());
        List<LearntCollectionsWithUsers> learntExerciseCollections = user.getLearntCollections();
        model.addAttribute("name", user.getName());
        model.addAttribute("collections", learntExerciseCollections);
        return "learntCollections";
    }

}
