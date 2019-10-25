package pl.joanna026.dwaxdwa.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "exercise_collection")
@Getter @Setter
public class ExerciseCollection extends BaseEntity{


    private String name;
    @ManyToMany
    private List<Exercise> exercises = new ArrayList<>();

    public ExerciseCollection() {
    }


    @Override
    public String toString() {
        return "ExerciseCollection{" +
                "name='" + name + '\'' +
                ", exercises=" + exercises +
                '}';
    }
}
