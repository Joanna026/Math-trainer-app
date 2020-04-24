package pl.joanna026.dwaxdwa.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import pl.joanna026.dwaxdwa.persistence.entity.Exercise;

public interface ExerciseRepository extends CrudRepository<Exercise, Long> {
}
