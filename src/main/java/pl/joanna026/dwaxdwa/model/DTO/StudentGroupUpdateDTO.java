package pl.joanna026.dwaxdwa.model.DTO;

import pl.joanna026.dwaxdwa.model.entities.ExerciseCollection;
import pl.joanna026.dwaxdwa.model.entities.User;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class StudentGroupUpdateDTO {

    @Id
    @NotNull
    private Long id;
    @NotNull
    private String name;
    private List<User> studentList;
    private List<ExerciseCollection> obligatoryCollections = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
