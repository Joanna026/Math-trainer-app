package pl.joanna026.dwaxdwa.model.utils;

import lombok.Data;
import pl.joanna026.dwaxdwa.model.entities.ExerciseCollection;
import pl.joanna026.dwaxdwa.model.entities.LearntCollectionsWithUsers;
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
    private List<ExerciseCollection> availableExerciseCollection = new ArrayList<>();
    private List<LearntCollectionsWithUsers> learntCollections = new ArrayList<>();
}
