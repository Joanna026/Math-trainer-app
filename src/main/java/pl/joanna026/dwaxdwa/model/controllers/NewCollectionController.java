package pl.joanna026.dwaxdwa.model.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.joanna026.dwaxdwa.model.DTO.ExerciseCollectionDTO;
import pl.joanna026.dwaxdwa.model.DTO.ExerciseDTO;
import pl.joanna026.dwaxdwa.model.entities.Exercise;
import pl.joanna026.dwaxdwa.model.services.ExerciseCollectionService;
import pl.joanna026.dwaxdwa.model.services.ExerciseService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin/collection")
public class NewCollectionController {

    private final ExerciseCollectionService exerciseCollectionService;
    private final ExerciseService exerciseService;

    public NewCollectionController(ExerciseCollectionService exerciseCollectionService, ExerciseService exerciseService) {
        this.exerciseCollectionService = exerciseCollectionService;
        this.exerciseService = exerciseService;
    }


    @GetMapping("/add")
    public String prepareNewCollectionForm(Model model) {
        model.addAttribute("exercisesList", exerciseService.findAll());
        model.addAttribute("collectionDto", new ExerciseCollectionDTO());
        return "collectionForm";
    }

    @PostMapping("/add")
    public String processNewCollectionForm(@Valid ExerciseCollectionDTO collectionDto, BindingResult result,
                                           @RequestParam List<Long> exerciseId) {
        if (result.hasErrors()) {
            return ("collectionForm");
        }
        List<ExerciseDTO> exercisesToAdd = new ArrayList<>();

        for (Long id : exerciseId) {
            exercisesToAdd.add(exerciseService.findById(id));
        }
        collectionDto.setExercises(exercisesToAdd);
        exerciseCollectionService.save(collectionDto);
        return "redirect:/all/collections";
    }
}
