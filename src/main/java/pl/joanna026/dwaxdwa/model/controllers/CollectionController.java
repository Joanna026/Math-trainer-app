package pl.joanna026.dwaxdwa.model.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.joanna026.dwaxdwa.model.entities.Exercise;
import pl.joanna026.dwaxdwa.model.entities.ExerciseCollection;
import pl.joanna026.dwaxdwa.model.entities.User;
import pl.joanna026.dwaxdwa.model.services.ExerciseCollectionService;
import pl.joanna026.dwaxdwa.model.services.UserService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/student/collection")
public class CollectionController {

    private final UserService userService;
    private final ExerciseCollectionService exerciseCollectionService;

    public CollectionController(UserService userService, ExerciseCollectionService exerciseCollectionService) {
        this.userService = userService;
        this.exerciseCollectionService = exerciseCollectionService;
    }

    @GetMapping("/all")
    public String prepareCollectionsByUserPage(String username, Model model) {
        User user = userService.findByUsername(username);
        List<ExerciseCollection> availableExerciseCollections = user.getAvailableExerciseCollection();
        model.addAttribute("collections", availableExerciseCollections);
        return "collectionList";
    }

    @PostMapping("/all")
    public String prepareSolveExercisePage(Long collectionId) {

       return "redirect:/exercise?collectionId="+collectionId;
    }


}
