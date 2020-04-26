package pl.joanna026.dwaxdwa.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.joanna026.dwaxdwa.persistence.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
