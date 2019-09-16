package pl.joanna026.dwaxdwa.model.utils;

import javax.validation.constraints.NotNull;

public class ExerciseCollectionCreateDTO {

    @NotNull
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
