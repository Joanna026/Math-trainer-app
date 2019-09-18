package pl.joanna026.dwaxdwa.model.utils;

import javax.validation.constraints.NotNull;

public class LearntCollectionsWithUsersUpdateDTO {

    @NotNull
    private String content;
    @NotNull
    private String correctAnswer;

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
}
