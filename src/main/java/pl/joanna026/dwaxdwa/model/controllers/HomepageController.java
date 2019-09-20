package pl.joanna026.dwaxdwa.model.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

//    @GetMapping("/change")
//    @ResponseBody
//    public String change(){
//       User user = userService.findByUsername("user");
//
//        user.setPassword("pass");
//        userService.saveUser(user);
//        return "ok";
//    }

    @GetMapping
    public String prepareHomepage(Principal principal, Model model) {
        User user = userService.findByUsername(principal.getName());
        List<ExerciseCollection> availableExerciseCollections = user.getAvailableExerciseCollection();
        model.addAttribute("collections", availableExerciseCollections);
        return "homepage";
    }

    @PostMapping
    public String processHomepage(@RequestParam Long collectionId, Principal principal) {

        userService.removeFromAvailableCollections(principal, collectionId);
        return "redirect:/student/home";
    }

}
