package pl.joanna026.dwaxdwa.model.DTO;

import lombok.Data;
import pl.joanna026.dwaxdwa.model.entities.Role;
import pl.joanna026.dwaxdwa.model.entities.StudentGroup;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
public class UserDTO {

    private Long id;
    @NotBlank
    private String username;
    @NotBlank
    private String password;

    private Boolean enabled;
    private Role authority;
    @NotBlank
    private String name;
    @NotBlank
    private String email;
    private StudentGroup group;
    private List<ExerciseCollectionDTO> availableExerciseCollection = new ArrayList<>();
    private List<LearntCollectionsWithUsersDTO> learntCollections = new ArrayList<>();
}
