package pl.joanna026.dwaxdwa.model.DTO;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ExerciseDTO {

    private Long id;
    @NotNull
    private String content;
    @NotNull
    private String correctAnswer;
    @NotNull
    private Boolean type;
    private Integer repetitionNumber;

}
