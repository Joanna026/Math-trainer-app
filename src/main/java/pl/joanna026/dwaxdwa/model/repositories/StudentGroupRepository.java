package pl.joanna026.dwaxdwa.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.joanna026.dwaxdwa.model.entities.StudentGroup;

public interface StudentGroupRepository extends JpaRepository<StudentGroup, Long> {
}
