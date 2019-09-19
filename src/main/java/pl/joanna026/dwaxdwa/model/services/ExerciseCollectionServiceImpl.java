package pl.joanna026.dwaxdwa.model.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.joanna026.dwaxdwa.model.entities.ExerciseCollection;
import pl.joanna026.dwaxdwa.model.repositories.ExerciseCollectionRepository;
import pl.joanna026.dwaxdwa.model.utils.ExerciseCollectionCreateDTO;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ExerciseCollectionServiceImpl implements ExerciseCollectionService {

    private final ModelMapper modelMapper;
    private final ExerciseCollectionRepository exerciseCollectionRepository;

    public ExerciseCollectionServiceImpl(ModelMapper modelMapper, ExerciseCollectionRepository exerciseCollectionRepository) {
        this.modelMapper = modelMapper;
        this.exerciseCollectionRepository = exerciseCollectionRepository;
    }

    private ExerciseCollection convertToEntity(ExerciseCollectionCreateDTO collectionDto) {
        return modelMapper.map(collectionDto, ExerciseCollection.class);
    }

    @Override
    public Optional<ExerciseCollection> findById(Long id) {
        return exerciseCollectionRepository.findById(id);
    }

    @Override
    public List<ExerciseCollection> findBy() {

        return exerciseCollectionRepository.findBy();
    }

    @Override
    public void save(ExerciseCollectionCreateDTO collectionDto) {
        ExerciseCollection collectionToAdd = convertToEntity(collectionDto);
        exerciseCollectionRepository.save(collectionToAdd);
    }
}
