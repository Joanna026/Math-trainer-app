package pl.joanna026.dwaxdwa.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.joanna026.dwaxdwa.model.entities.LearntCollectionsWithUsers;

public interface LearntCollectionsWithUsersRepository extends JpaRepository<LearntCollectionsWithUsers, Long> {

    LearntCollectionsWithUsers findByStudentIdAndCollectionId(Long studentId, Long collectionId);
}
