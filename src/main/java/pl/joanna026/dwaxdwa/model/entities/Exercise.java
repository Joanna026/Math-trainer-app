package pl.joanna026.dwaxdwa.model.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "exercises")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String title;
    @NotEmpty
    private String content;
    @NotNull
    private Boolean type;
    @ManyToMany (mappedBy = "exercises")
    private List<ExerciseCollection> collectionList = new ArrayList<>();
    @NotEmpty
    private String correctAnswer;
    @Column
    @ElementCollection(targetClass = String.class)
    private List<String> wrongAnswers = new ArrayList<>();
    private Integer timeSec;
    private Integer repetitionNumber;
    @Transient
    private Integer repetitionNumberForStudent;

    public Exercise() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public List<ExerciseCollection> getCollectionList() {
        return collectionList;
    }

    public void setCollectionList(List<ExerciseCollection> collectionList) {
        this.collectionList = collectionList;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public List<String> getWrongAnswers() {
        return wrongAnswers;
    }

    public void setWrongAnswers(List<String> wrongAnswers) {
        this.wrongAnswers = wrongAnswers;
    }

    public Integer getTimeSec() {
        return timeSec;
    }

    public void setTimeSec(Integer timeSec) {
        this.timeSec = timeSec;
    }

    public Integer getRepetitionNumber() {
        return repetitionNumber;
    }

    public void setRepetitionNumber(Integer repetitionNumber) {
        this.repetitionNumber = repetitionNumber;
    }

    public Integer getRepetitionNumberForStudent() {
        return repetitionNumberForStudent;
    }

    public void setRepetitionNumberForStudent(Integer repetitionNumberForStudent) {
        this.repetitionNumberForStudent = repetitionNumberForStudent;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", type=" + type +
                '}';
    }
}
