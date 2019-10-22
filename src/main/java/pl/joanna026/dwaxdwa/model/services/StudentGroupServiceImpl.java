package pl.joanna026.dwaxdwa.model.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.joanna026.dwaxdwa.model.entities.ExerciseCollection;
import pl.joanna026.dwaxdwa.model.entities.StudentGroup;
import pl.joanna026.dwaxdwa.model.repositories.StudentGroupRepository;
import pl.joanna026.dwaxdwa.model.utils.ExerciseCollectionUpdateDTO;
import pl.joanna026.dwaxdwa.model.utils.StudentGroupCreateDTO;
import pl.joanna026.dwaxdwa.model.utils.StudentGroupUpdateDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentGroupServiceImpl implements StudentGroupService {

    private final StudentGroupRepository studentGroupRepository;
    private final ModelMapper modelMapper;

    public StudentGroupServiceImpl(StudentGroupRepository studentGroupRepository, ModelMapper modelMapper) {
        this.studentGroupRepository = studentGroupRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<StudentGroup> findAll() {

        return  studentGroupRepository.findAll();

    }

    private StudentGroupCreateDTO convertToDto(StudentGroup studentGroup) {
        return modelMapper.map(studentGroup, StudentGroupCreateDTO.class);
    }

    private StudentGroupUpdateDTO convertToUpdateDto(StudentGroup studentGroup) {
        return modelMapper.map(studentGroup, StudentGroupUpdateDTO.class);
    }


    private StudentGroup convertToEnttity(StudentGroupCreateDTO studentGroupCreateDTO) {
        return modelMapper.map(studentGroupCreateDTO, StudentGroup.class);
    }


    @Override
    public List<StudentGroupUpdateDTO> findAllWithCollections() {

        List<StudentGroup> allWithCollections = studentGroupRepository.findAllWithCollections();
        List<StudentGroupUpdateDTO> allWithCollectionsDTO = new ArrayList<>();
        allWithCollections.forEach(c -> {
           allWithCollectionsDTO.add(convertToUpdateDto(c));
        });

        return allWithCollectionsDTO;
    }
}
