package pl.joanna026.dwaxdwa.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.joanna026.dwaxdwa.model.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
