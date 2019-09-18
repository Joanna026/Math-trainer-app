package pl.joanna026.dwaxdwa.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.joanna026.dwaxdwa.model.entities.Exercise;
import pl.joanna026.dwaxdwa.model.entities.ExerciseCollection;

import java.util.List;

public interface ExerciseCollectionRepository extends JpaRepository<ExerciseCollection, Long> {

}
