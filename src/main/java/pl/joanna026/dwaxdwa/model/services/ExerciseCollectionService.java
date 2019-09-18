package pl.joanna026.dwaxdwa.model.services;

import pl.joanna026.dwaxdwa.model.entities.ExerciseCollection;

import java.util.List;
import java.util.Optional;

public interface ExerciseCollectionService {

    Optional<ExerciseCollection> findById(Long id);

   List<ExerciseCollection> findBy();
}
