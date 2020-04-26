package pl.joanna026.dwaxdwa.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import pl.joanna026.dwaxdwa.persistence.entity.ExerciseSet;

public interface ExerciseSetRepository extends JpaRepository<ExerciseSet, Long> {
}
