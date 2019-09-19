package pl.joanna026.dwaxdwa.model.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.joanna026.dwaxdwa.model.services.ExerciseCollectionService;
import pl.joanna026.dwaxdwa.model.utils.ExerciseCollectionCreateDTO;

import javax.validation.Valid;

@Controller
@RequestMapping("/student/collection")
public class NewCollectionController {

    private final ExerciseCollectionService exerciseCollectionService;

    public NewCollectionController(ExerciseCollectionService exerciseCollectionService) {
        this.exerciseCollectionService = exerciseCollectionService;
    }


    @GetMapping("/add")
    public String prepareNewCollectionForm(Model model) {
        model.addAttribute("collectionDto", new ExerciseCollectionCreateDTO());
        return "collectionForm";
    }

    @PostMapping("/add")
    public String processNewCollectionForm(@Valid ExerciseCollectionCreateDTO collectionDto, BindingResult result) {
        if (result.hasErrors()) {
            return ("collectionForm");
        }
        exerciseCollectionService.save(collectionDto);
        return "redirect:/student/home";
    }
}
