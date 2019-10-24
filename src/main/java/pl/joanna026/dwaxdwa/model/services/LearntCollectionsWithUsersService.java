package pl.joanna026.dwaxdwa.model.services;

import org.springframework.stereotype.Service;
import pl.joanna026.dwaxdwa.model.entities.LearntCollectionsWithUsers;
import pl.joanna026.dwaxdwa.model.repositories.LearntCollectionsWithUsersRepository;
import pl.joanna026.dwaxdwa.model.repositories.UserRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class LearntCollectionsWithUsersService {

    private final LearntCollectionsWithUsersRepository learntCollectionsWithUsersRepository;

    public LearntCollectionsWithUsersService(UserRepository userRepository, LearntCollectionsWithUsersRepository learntCollectionsWithUsersRepository) {
        this.learntCollectionsWithUsersRepository = learntCollectionsWithUsersRepository;
    }

    public void save(LearntCollectionsWithUsers learntCollectionsWithUsers) {
        learntCollectionsWithUsersRepository.save(learntCollectionsWithUsers);
    }

    public LearntCollectionsWithUsers findByUserAndCollection(Long userId, Long collectionId) {
        return learntCollectionsWithUsersRepository.findByStudentIdAndCollectionId(userId, collectionId);
    }
}
