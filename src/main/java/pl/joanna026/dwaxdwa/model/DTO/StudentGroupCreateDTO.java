package pl.joanna026.dwaxdwa.model.DTO;

import javax.validation.constraints.NotNull;

public class StudentGroupCreateDTO {

    @NotNull
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}