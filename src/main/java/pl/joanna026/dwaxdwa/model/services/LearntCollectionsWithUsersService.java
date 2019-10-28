package pl.joanna026.dwaxdwa.model.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.joanna026.dwaxdwa.model.DTO.LearntCollectionsWithUsersDTO;
import pl.joanna026.dwaxdwa.model.entities.LearntCollectionsWithUsers;
import pl.joanna026.dwaxdwa.model.repositories.LearntCollectionsWithUsersRepository;
import pl.joanna026.dwaxdwa.model.repositories.UserRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class LearntCollectionsWithUsersService {

    private final LearntCollectionsWithUsersRepository learntCollectionsWithUsersRepository;
    private final ModelMapper modelMapper;

    public LearntCollectionsWithUsersService(LearntCollectionsWithUsersRepository learntCollectionsWithUsersRepository, ModelMapper modelMapper) {
        this.learntCollectionsWithUsersRepository = learntCollectionsWithUsersRepository;
        this.modelMapper = modelMapper;
    }

    public void save(LearntCollectionsWithUsersDTO learntCollectionsWithUsersDTO) {
        learntCollectionsWithUsersRepository.save(toEntity(learntCollectionsWithUsersDTO));
    }

    public LearntCollectionsWithUsers findByUserAndCollection(Long userId, Long collectionId) {
        return learntCollectionsWithUsersRepository.findByStudentIdAndCollectionId(userId, collectionId);
    }

    private LearntCollectionsWithUsers toEntity(LearntCollectionsWithUsersDTO learntCollectionsWithUsersDTO) {
        return modelMapper.map(learntCollectionsWithUsersDTO, LearntCollectionsWithUsers.class);
    }

    private LearntCollectionsWithUsersDTO toDto(LearntCollectionsWithUsers learntCollectionsWithUsers) {
        return modelMapper.map(learntCollectionsWithUsers, LearntCollectionsWithUsersDTO.class);
    }
}
