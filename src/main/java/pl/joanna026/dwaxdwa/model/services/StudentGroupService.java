package pl.joanna026.dwaxdwa.model.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.joanna026.dwaxdwa.model.DTO.StudentGroupDTO;
import pl.joanna026.dwaxdwa.model.entities.StudentGroup;
import pl.joanna026.dwaxdwa.model.repositories.StudentGroupRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StudentGroupService {

    private final StudentGroupRepository studentGroupRepository;
    private final ModelMapper modelMapper;

    public StudentGroupService(StudentGroupRepository studentGroupRepository, ModelMapper modelMapper) {
        this.studentGroupRepository = studentGroupRepository;
        this.modelMapper = modelMapper;
    }

    public List<StudentGroupDTO> findAll() {

        List<StudentGroup> allGroups = studentGroupRepository.findAll();
        List<StudentGroupDTO> allGroupsDTO = new ArrayList<>(1);
        allGroups.forEach(group -> {
            allGroupsDTO.add(toDto(group));
        });
        return allGroupsDTO;
    }


    public List<StudentGroupDTO> findAllWithCollections() {

        List<StudentGroup> allWithCollections = studentGroupRepository.findAllWithCollections();
        List<StudentGroupDTO> allWithCollectionsDTO = new ArrayList<>();
        allWithCollections.forEach(c -> {
            allWithCollectionsDTO.add(toDto(c));
        });
        return allWithCollectionsDTO;
    }

    private StudentGroupDTO toDto(StudentGroup studentGroup) {
        return modelMapper.map(studentGroup, StudentGroupDTO.class);
    }

    private StudentGroup toEntity(StudentGroupDTO studentGroupDTO) {
        return modelMapper.map(studentGroupDTO, StudentGroup.class);
    }

    public void save(StudentGroupDTO studentGroupDTO) {
        studentGroupRepository.save(toEntity(studentGroupDTO));
    }
}
