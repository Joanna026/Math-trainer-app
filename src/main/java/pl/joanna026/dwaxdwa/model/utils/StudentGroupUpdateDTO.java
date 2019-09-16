package pl.joanna026.dwaxdwa.model.utils;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class StudentGroupUpdateDTO {

    @Id
    @NotNull
    private Long id;
    @NotNull
    private String name;

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
