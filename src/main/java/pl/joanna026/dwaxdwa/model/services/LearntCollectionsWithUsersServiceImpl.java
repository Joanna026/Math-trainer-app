package pl.joanna026.dwaxdwa.model.services;

import org.springframework.stereotype.Service;
import pl.joanna026.dwaxdwa.model.entities.LearntCollectionsWithUsers;
import pl.joanna026.dwaxdwa.model.repositories.LearntCollectionsWithUsersRepository;
import pl.joanna026.dwaxdwa.model.repositories.UserRepository;

@Service
public class LearntCollectionsWithUsersServiceImpl implements LearntCollectionsWithUsersService {

    private final LearntCollectionsWithUsersRepository learntCollectionsWithUsersRepository;

    public LearntCollectionsWithUsersServiceImpl(UserRepository userRepository, LearntCollectionsWithUsersRepository learntCollectionsWithUsersRepository) {
        this.learntCollectionsWithUsersRepository = learntCollectionsWithUsersRepository;
    }

    @Override
    public void save(LearntCollectionsWithUsers learntCollectionsWithUsers) {
        learntCollectionsWithUsersRepository.save(learntCollectionsWithUsers);
    }

    @Override
    public LearntCollectionsWithUsers findByUserAndCollection(Long userId, Long collectionId) {
        return learntCollectionsWithUsersRepository.findByStudentIdAndCollectionId(userId, collectionId);
    }
}
