package pl.joanna026.dwaxdwa.model.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.joanna026.dwaxdwa.model.DTO.ExerciseDTO;
import pl.joanna026.dwaxdwa.model.entities.Exercise;
import pl.joanna026.dwaxdwa.model.repositories.ExerciseRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
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

    public ExerciseDTO findById(Long id) {
        return toDto(exerciseRepository.findById(id).orElseGet(() -> {
            return null;
        }));
    }

    public void save(ExerciseDTO exerciseDTO) {
        exerciseDTO.setId(null);
        exerciseRepository.save(toEntity(exerciseDTO));
    }

    public List<ExerciseDTO> findAll() {
        List<Exercise> allExercises = exerciseRepository.findAll();
        List<ExerciseDTO> allDTO = new ArrayList<>();

        allExercises.forEach(exercise -> {
            allDTO.add(toDto(exercise));
        });
        return allDTO;
    }

    private ExerciseDTO toDto(Exercise exercise){
        return modelMapper.map(exercise, ExerciseDTO.class);
    }

    private Exercise toEntity(ExerciseDTO exerciseDTO){
        return modelMapper.map(exerciseDTO, Exercise.class);
    }
}
