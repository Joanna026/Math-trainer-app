package pl.joanna026.dwaxdwa.model.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "exercise_collection")
public class ExerciseCollection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String name;
    @ManyToMany
    private List<Exercise> exerciseList = new ArrayList<>();
}
