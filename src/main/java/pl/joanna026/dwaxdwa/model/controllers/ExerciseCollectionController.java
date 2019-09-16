package pl.joanna026.dwaxdwa.model.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.joanna026.dwaxdwa.model.entities.ExerciseCollection;
import pl.joanna026.dwaxdwa.model.repositories.ExerciseCollectionRepository;
import pl.joanna026.dwaxdwa.model.utils.DTO;
import pl.joanna026.dwaxdwa.model.utils.ExerciseCollectionCreateDTO;

import java.util.List;

@RestController
@RequestMapping("/collection")
public class ExerciseCollectionController {

    private ExerciseCollectionRepository exerciseCollectionRepository;

    public ExerciseCollectionController(ExerciseCollectionRepository exerciseCollectionRepository) {
        this.exerciseCollectionRepository = exerciseCollectionRepository;
    }

    @GetMapping
    public List<ExerciseCollection> getExerciseCollections() {
        return exerciseCollectionRepository.findAll();
    }

    @PostMapping
    public void createExerciseCollection(@DTO(ExerciseCollectionCreateDTO.class)ExerciseCollection exerciseCollection) {
        exerciseCollectionRepository.save(exerciseCollection);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void editExerciseCollection(@DTO(ExerciseCollectionCreateDTO.class)ExerciseCollection exerciseCollection) {
        exerciseCollectionRepository.save(exerciseCollection);
    }
}

