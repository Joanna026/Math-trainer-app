package pl.joanna026.dwaxdwa.model.services;

import org.springframework.stereotype.Service;
import pl.joanna026.dwaxdwa.model.entities.ExerciseCollection;
import pl.joanna026.dwaxdwa.model.repositories.ExerciseCollectionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseCollectionServiceImpl implements ExerciseCollectionService {

    private final ExerciseCollectionRepository exerciseCollectionRepository;

    public ExerciseCollectionServiceImpl(ExerciseCollectionRepository exerciseCollectionRepository) {
        this.exerciseCollectionRepository = exerciseCollectionRepository;
    }

    @Override
    public Optional<ExerciseCollection> findById(Long id) {
        return exerciseCollectionRepository.findById(id);
    }

    @Override
    public List<ExerciseCollection> findBy() {

        return exerciseCollectionRepository.findBy();
    }
}
