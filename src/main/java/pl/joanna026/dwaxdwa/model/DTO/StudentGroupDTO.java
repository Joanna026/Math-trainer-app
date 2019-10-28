package pl.joanna026.dwaxdwa.model.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import pl.joanna026.dwaxdwa.model.entities.ExerciseCollection;
import pl.joanna026.dwaxdwa.model.entities.User;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
public class StudentGroupDTO {

    private Long id;
    @NotNull
    private String name;
    private List<UserDTO> studentList;
    private List<ExerciseCollectionDTO> obligatoryCollections = new ArrayList<>();
}
