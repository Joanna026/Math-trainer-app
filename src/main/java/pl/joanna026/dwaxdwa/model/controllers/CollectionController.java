package pl.joanna026.dwaxdwa.model.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.joanna026.dwaxdwa.model.entities.ExerciseCollection;
import pl.joanna026.dwaxdwa.model.services.UserService;
import pl.joanna026.dwaxdwa.model.DTO.UserDTO;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/all/collections")
public class CollectionController {

    private final ExerciseCollectionService exerciseCollectionService;
    private final UserService userService;


    public CollectionController(ExerciseCollectionService exerciseCollectionService, UserService userService) {
        this.exerciseCollectionService = exerciseCollectionService;
        this.userService = userService;
    }

    @GetMapping
    public String prepareAllCollectionsPage(Model model, Principal principal) {
        UserDTO userDTO = userService.findByUsername(principal.getName());
        model.addAttribute("name", userDTO.getName());
        List<ExerciseCollection> exerciseCollections = exerciseCollectionService.findBy();
        for (ExerciseCollection collection : exerciseCollections) {
            model.addAttribute("collections", exerciseCollections);
        }
        return "collectionList";
    }

    @PostMapping
    public String processAllCollectionsPage(Principal principal, @RequestParam Long collectionId) {

        userService.addToAvailableCollections(principal,collectionId);
       return "redirect:/home";
    }


}
