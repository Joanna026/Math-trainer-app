package pl.joanna026.dwaxdwa.model.DTO;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class ExerciseUpdateDTO {

    @Id
    @NotNull
    private Long id;
    @NotNull
    private String content;
    @NotNull
    private String correctAnswer;
    @NotNull
    private Boolean type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }
}
