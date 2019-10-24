package pl.joanna026.dwaxdwa.model.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.joanna026.dwaxdwa.model.entities.Exercise;
import pl.joanna026.dwaxdwa.model.repositories.ExerciseRepository;
import pl.joanna026.dwaxdwa.model.DTO.ExerciseCreateDTO;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;
    private final ModelMapper modelMapper;

    public ExerciseService(ExerciseRepository exerciseRepository, ModelMapper modelMapper) {
        this.exerciseRepository = exerciseRepository;
        this.modelMapper = modelMapper;
    }

    private ExerciseCreateDTO convertToDto(Exercise exercise) {
        return modelMapper.map(exercise, ExerciseCreateDTO.class);
    }

    private Exercise convertToEntity(ExerciseCreateDTO exerciseCreateDTO) {
        return modelMapper.map(exerciseCreateDTO, Exercise.class);
    }

    public Exercise findById(Long id) {
        return null;
    }

    public void save(Exercise exercise) {
        exercise.setId(null);
        exerciseRepository.save(exercise);
    }

    public List<Exercise> findAll() {
        return exerciseRepository.findAll();
    }
}
