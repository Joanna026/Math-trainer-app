package pl.joanna026.dwaxdwa.model.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.joanna026.dwaxdwa.model.DTO.UserDTO;
import pl.joanna026.dwaxdwa.model.entities.ExerciseCollection;
import pl.joanna026.dwaxdwa.model.services.ExerciseCollectionService;
import pl.joanna026.dwaxdwa.model.services.StudentGroupService;
import pl.joanna026.dwaxdwa.model.services.UserService;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/admin/set")
public class SetCollectionToGroupController {

    private StudentGroupService studentGroupService;
    private final ExerciseCollectionService exerciseCollectionService;
    private final UserService userService;

    public SetCollectionToGroupController(StudentGroupService studentGroupService, ExerciseCollectionService exerciseCollectionService, UserService userService) {
        this.studentGroupService = studentGroupService;
        this.exerciseCollectionService = exerciseCollectionService;
        this.userService = userService;
    }

    @GetMapping
    public String prepareSetCollectionPage(@RequestParam Long groupId, Model model, Principal principal) {
        UserDTO userDTO = userService.findByUsername(principal.getName());
        model.addAttribute("name", userDTO.getName());
        model.addAttribute("groupId", groupId);
        List<ExerciseCollection> exerciseCollections = exerciseCollectionService.findBy();
        model.addAttribute("collections", exerciseCollections);
        return ("collectionChoice");
    }


    @PostMapping
    public String processSetCollectionPage(@RequestParam Long groupId, @RequestParam Long collectionId) {


        return ("redirect:/home");
    }
}
