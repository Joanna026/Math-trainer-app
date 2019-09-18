package pl.joanna026.dwaxdwa.model.services;

import pl.joanna026.dwaxdwa.model.entities.ExerciseCollection;

import java.util.Optional;

public interface ExerciseCollectionService {

    Optional<ExerciseCollection> findById(Long id);
}
