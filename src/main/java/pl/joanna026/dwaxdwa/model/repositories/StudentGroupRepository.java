package pl.joanna026.dwaxdwa.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.joanna026.dwaxdwa.model.entities.ExerciseCollection;
import pl.joanna026.dwaxdwa.model.entities.StudentGroup;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.awt.print.Book;
import java.util.List;

@Transactional
public interface StudentGroupRepository extends JpaRepository<StudentGroup, Long> {

    @Query(value="SELECT * FROM student_groups sg LEFT JOIN student_groups_obligatory_collections on sg.id",
    nativeQuery=true)
    List<StudentGroup> findAllWithCollections();
}
