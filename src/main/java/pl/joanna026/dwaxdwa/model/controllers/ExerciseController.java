package pl.joanna026.dwaxdwa.model.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.joanna026.dwaxdwa.model.entities.Exercise;
import pl.joanna026.dwaxdwa.model.repositories.ExerciseRepository;
import pl.joanna026.dwaxdwa.model.utils.DTO;
import pl.joanna026.dwaxdwa.model.utils.ExerciseCreateDTO;

import java.util.List;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {

    private ExerciseRepository exerciseRepository;

    public ExerciseController(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @GetMapping
    public List<Exercise> getExercises() {
        return exerciseRepository.findAll();
    }

    @PostMapping
    public void createExercise(@DTO(ExerciseCreateDTO.class)Exercise exercise) {
        exerciseRepository.save(exercise);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void editExercise(@DTO(ExerciseCreateDTO.class)Exercise exercise) {
        exerciseRepository.save(exercise);
    }

}
