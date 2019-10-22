package pl.joanna026.dwaxdwa.model.services;

import pl.joanna026.dwaxdwa.model.entities.StudentGroup;
import pl.joanna026.dwaxdwa.model.utils.StudentGroupUpdateDTO;

import java.util.List;

public interface StudentGroupService {

    List<StudentGroup> findAll();

    List<StudentGroupUpdateDTO> findAllWithCollections();

}
