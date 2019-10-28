package pl.joanna026.dwaxdwa.model.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.joanna026.dwaxdwa.model.DTO.ExerciseCollectionDTO;
import pl.joanna026.dwaxdwa.model.DTO.LearntCollectionsWithUsersDTO;
import pl.joanna026.dwaxdwa.model.entities.ExerciseCollection;
import pl.joanna026.dwaxdwa.model.entities.LearntCollectionsWithUsers;
import pl.joanna026.dwaxdwa.model.services.ExerciseCollectionService;
import pl.joanna026.dwaxdwa.model.services.LearntCollectionsWithUsersService;
import pl.joanna026.dwaxdwa.model.services.UserService;
import pl.joanna026.dwaxdwa.model.DTO.UserDTO;

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

        UserDTO userDTO  = userService.findByUsername(principal.getName());
        List<LearntCollectionsWithUsersDTO> learntExerciseCollectionsList = userDTO.getLearntCollections();
        ExerciseCollectionDTO exerciseCollectionDTO = exerciseCollectionService.findById(collectionId);

            LearntCollectionsWithUsersDTO justLearntCollectionWithUsers = new LearntCollectionsWithUsersDTO();
            justLearntCollectionWithUsers.setStudentId(userDTO.getId());
            justLearntCollectionWithUsers.setCollectionId(collectionId);
            justLearntCollectionWithUsers.setCollectionName(exerciseCollectionDTO.getName());

            LearntCollectionsWithUsers userLearntCollection =
                    learntCollectionsWithUsersService.findByUserAndCollection(userDTO.getId(), collectionId);
            if(!learntExerciseCollectionsList.contains(userLearntCollection)) {
                learntCollectionsWithUsersService.save(justLearntCollectionWithUsers);
                learntExerciseCollectionsList.add(justLearntCollectionWithUsers);
                userDTO.setLearntCollections(learntExerciseCollectionsList);
                userService.save(userDTO);
            }
//
//            LearntCollectionsWithUsers userLearntCollection = learntCollectionsWithUsersService.findByUserAndCollection(user.getId(), collectionId);
//            if(!learntExerciseCollectionsList.contains(userLearntCollection)) {
//
//                learntCollectionsWithUsersService.save(userLearntCollection);
//                learntExerciseCollectionsList.add(userLearntCollection);
//                user.setLearntCollections(learntExerciseCollectionsList);
//                userService.save(user);
//            }

        model.addAttribute("name", userDTO.getName());

        return "congrats";
    }

}
