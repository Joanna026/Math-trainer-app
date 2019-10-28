package pl.joanna026.dwaxdwa.model.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.joanna026.dwaxdwa.model.DTO.ExerciseDTO;
import pl.joanna026.dwaxdwa.model.entities.Exercise;
import pl.joanna026.dwaxdwa.model.services.ExerciseService;

@Controller
@RequestMapping("/admin/exercise")
public class NewExerciseController {

    private final ExerciseService exerciseService;

    public NewExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }


    @GetMapping("/add")
    public String prepareNewExerciseFormPage(Model model) {
        model.addAttribute(new ExerciseDTO());
        return "exerciseForm";
    }


    @PostMapping("/add")
    public String processNewExerciseForm(ExerciseDTO exerciseDTO) {
        exerciseService.save(exerciseDTO);
        return "redirect:/home";
    }
}
