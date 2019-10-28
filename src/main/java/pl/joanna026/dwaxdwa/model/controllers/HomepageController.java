package pl.joanna026.dwaxdwa.model.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.joanna026.dwaxdwa.model.DTO.ExerciseCollectionDTO;
import pl.joanna026.dwaxdwa.model.DTO.UserDTO;
import pl.joanna026.dwaxdwa.model.services.StudentGroupService;
import pl.joanna026.dwaxdwa.model.services.UserService;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/home")
public class HomepageController {

    private final UserService userService;
    private final StudentGroupService studentGroupService;


    public HomepageController(UserService userService, StudentGroupService studentGroupService) {
        this.userService = userService;
        this.studentGroupService = studentGroupService;
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
        UserDTO userDTO = userService.findByUsername(principal.getName());
        List<ExerciseCollectionDTO> availableExerciseCollections = userDTO.getAvailableExerciseCollection();
        model.addAttribute("name", userDTO.getName());
        model.addAttribute("collections", availableExerciseCollections);
        model.addAttribute("groups", studentGroupService.findAllWithCollections());
        return "homepage";
    }

    @PostMapping
    public String processHomepage(@RequestParam Long collectionId, Principal principal) {

        userService.removeFromAvailableCollections(principal, collectionId);
        return "redirect:/home";
    }

}
