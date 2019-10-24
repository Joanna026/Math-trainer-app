package pl.joanna026.dwaxdwa.model.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.joanna026.dwaxdwa.model.entities.LearntCollectionsWithUsers;
import pl.joanna026.dwaxdwa.model.services.UserService;
import pl.joanna026.dwaxdwa.model.DTO.UserDTO;

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

        UserDTO userDTO = userService.findByUsername(principal.getName());
        List<LearntCollectionsWithUsers> learntExerciseCollections = userDTO.getLearntCollections();
        model.addAttribute("name", userDTO.getName());
        model.addAttribute("collections", learntExerciseCollections);
        return "learntCollections";
    }

}
