package pl.joanna026.dwaxdwa.model.services;

import org.springframework.stereotype.Service;
import pl.joanna026.dwaxdwa.model.entities.Exercise;
import pl.joanna026.dwaxdwa.model.repositories.ExerciseRepository;

@Service
public class ExerciseServiceImpl implements ExerciseService{

    private final ExerciseRepository exerciseRepository;

    public ExerciseServiceImpl(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    public Exercise findById(Long id) {
        return null;
    }

    @Override
    public void save(Exercise exercise) {
        exercise.setId(null);
        exerciseRepository.save(exercise);
    }




}
