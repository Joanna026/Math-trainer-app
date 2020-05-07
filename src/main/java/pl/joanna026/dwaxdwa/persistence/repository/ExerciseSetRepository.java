package pl.joanna026.dwaxdwa.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.joanna026.dwaxdwa.persistence.entity.ExerciseSet;

@Repository
public interface ExerciseSetRepository extends JpaRepository<ExerciseSet, Long> {
}
