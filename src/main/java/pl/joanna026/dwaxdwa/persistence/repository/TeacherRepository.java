package pl.joanna026.dwaxdwa.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import pl.joanna026.dwaxdwa.persistence.entity.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {
}