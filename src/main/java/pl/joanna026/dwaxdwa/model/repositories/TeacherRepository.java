package pl.joanna026.dwaxdwa.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.joanna026.dwaxdwa.model.entities.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
