package pl.joanna026.dwaxdwa.model.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.joanna026.dwaxdwa.model.entities.ExerciseCollection;
import pl.joanna026.dwaxdwa.model.entities.LearntCollectionsWithUsers;
import pl.joanna026.dwaxdwa.model.entities.User;
import pl.joanna026.dwaxdwa.model.services.ExerciseCollectionService;
import pl.joanna026.dwaxdwa.model.services.LearntCollectionsWithUsersService;
import pl.joanna026.dwaxdwa.model.services.UserService;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/student/learnt")
public class LearntCollectionsController {

    private final ExerciseCollectionService exerciseCollectionService;
    private final LearntCollectionsWithUsersService learntCollectionsWithUsersService;
    private final UserService userService;


    public LearntCollectionsController(ExerciseCollectionService exerciseCollectionService, LearntCollectionsWithUsersService learntCollectionsWithUsersService, UserService userService) {
        this.exerciseCollectionService = exerciseCollectionService;
        this.learntCollectionsWithUsersService = learntCollectionsWithUsersService;
        this.userService = userService;
    }


    @GetMapping("/{collectionId}")
    public String moveCollectionToLearnt(Principal principal, Model model, @PathVariable Long collectionId) {

        User user  = userService.findByUsername(principal.getName());
        List<LearntCollectionsWithUsers> learntExerciseCollectionsList = user.getLearntCollections();
        Optional<ExerciseCollection> optionalCollection = exerciseCollectionService.findById(collectionId);
        optionalCollection.ifPresent(collection-> {
            LearntCollectionsWithUsers learntCollection = new LearntCollectionsWithUsers();
            learntCollection.setStudentId(user.getId());
            learntCollection.setCollectionId(collectionId);
            learntCollection.setCollectionName(collection.getName());

            LearntCollectionsWithUsers userLearntCollection = learntCollectionsWithUsersService.findByUserAndCollection(user.getId(), collectionId);
            if(!learntExerciseCollectionsList.contains(userLearntCollection)) {
                learntCollectionsWithUsersService.save(learntCollection);
                learntExerciseCollectionsList.add(userLearntCollection);
                user.setLearntCollections(learntExerciseCollectionsList);
                userService.save(user);
            }

        });
        model.addAttribute("name", user.getName());

        return "congrats";
    }

}
