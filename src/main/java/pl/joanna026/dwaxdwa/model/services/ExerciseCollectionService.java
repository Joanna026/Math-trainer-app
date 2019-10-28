package pl.joanna026.dwaxdwa.model.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.joanna026.dwaxdwa.model.DTO.ExerciseCollectionDTO;
import pl.joanna026.dwaxdwa.model.entities.ExerciseCollection;
import pl.joanna026.dwaxdwa.model.repositories.ExerciseCollectionRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ExerciseCollectionService {

    private final ModelMapper modelMapper;
    private final ExerciseCollectionRepository exerciseCollectionRepository;

    public ExerciseCollectionService(ModelMapper modelMapper, ExerciseCollectionRepository exerciseCollectionRepository) {
        this.modelMapper = modelMapper;
        this.exerciseCollectionRepository = exerciseCollectionRepository;
    }

    public ExerciseCollectionDTO findById(Long id) {
        return toDto(exerciseCollectionRepository.findById(id).orElseGet(() -> {
            return null;
        }));
    }

    public List<ExerciseCollection> findBy() {

        return exerciseCollectionRepository.findBy();
    }

    public void save(ExerciseCollectionDTO exerciseCollectionDTO) {
        exerciseCollectionRepository.save(toEntity(exerciseCollectionDTO));
    }

    private ExerciseCollection toEntity(ExerciseCollectionDTO exerciseCollectionDTO) {
        return modelMapper.map(exerciseCollectionDTO, ExerciseCollection.class);
    }

    private ExerciseCollectionDTO toDto(ExerciseCollection exerciseCollection) {
        return modelMapper.map(exerciseCollection, ExerciseCollectionDTO.class);
    }
}
