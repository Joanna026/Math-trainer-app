package pl.joanna026.dwaxdwa.model.DTO;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
public class ExerciseCollectionDTO {

    private Long id;
    @NotNull
    private String name;
    private List<ExerciseDTO> exercises = new ArrayList<>();
}
