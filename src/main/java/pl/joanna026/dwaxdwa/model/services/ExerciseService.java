package pl.joanna026.dwaxdwa.model.services;

import pl.joanna026.dwaxdwa.model.entities.Exercise;

import java.util.List;

public interface ExerciseService  {

    Exercise findById(Long id);

    void save(Exercise exercise);

    List<Exercise> findAll();
}
