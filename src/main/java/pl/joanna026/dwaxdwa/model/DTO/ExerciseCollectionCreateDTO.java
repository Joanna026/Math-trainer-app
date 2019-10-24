package pl.joanna026.dwaxdwa.model.DTO;

import pl.joanna026.dwaxdwa.model.entities.Exercise;

import javax.validation.constraints.NotNull;
import java.util.List;

public class ExerciseCollectionCreateDTO {

    @NotNull
    private String name;
    private List<Exercise> exercises;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }
}
