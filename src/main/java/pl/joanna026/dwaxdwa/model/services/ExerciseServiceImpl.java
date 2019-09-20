package pl.joanna026.dwaxdwa.model.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.joanna026.dwaxdwa.model.entities.Exercise;
import pl.joanna026.dwaxdwa.model.entities.ExerciseCollection;
import pl.joanna026.dwaxdwa.model.repositories.ExerciseRepository;
import pl.joanna026.dwaxdwa.model.utils.ExerciseCollectionCreateDTO;
import pl.joanna026.dwaxdwa.model.utils.ExerciseCreateDTO;

import java.util.List;

@Service
public class ExerciseServiceImpl implements ExerciseService{

    private final ExerciseRepository exerciseRepository;
    private final ModelMapper modelMapper;

    public ExerciseServiceImpl(ExerciseRepository exerciseRepository, ModelMapper modelMapper) {
        this.exerciseRepository = exerciseRepository;
        this.modelMapper = modelMapper;
    }

    private ExerciseCreateDTO convertToDto(Exercise exercise) {
        return modelMapper.map(exercise, ExerciseCreateDTO.class);
    }

    private Exercise convertToEntity(ExerciseCreateDTO exerciseCreateDTO) {
        return modelMapper.map(exerciseCreateDTO, Exercise.class);
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

    @Override
    public List<Exercise> findAll() {
        return exerciseRepository.findAll();
    }
}
