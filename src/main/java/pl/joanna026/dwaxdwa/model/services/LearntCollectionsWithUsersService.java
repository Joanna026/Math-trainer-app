package pl.joanna026.dwaxdwa.model.services;

import pl.joanna026.dwaxdwa.model.entities.LearntCollectionsWithUsers;

public interface LearntCollectionsWithUsersService {

    void save(LearntCollectionsWithUsers learntCollectionsWithUsers);

    LearntCollectionsWithUsers findByUserAndCollection(Long userId, Long collectionId);
}
