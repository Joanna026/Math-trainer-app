package pl.joanna026.dwaxdwa.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "exercises")
@Getter @Setter
public class Exercise extends BaseEntity {


    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;
    private Boolean type;
    @ManyToMany (mappedBy = "exercises")
    private List<ExerciseCollection> collectionList = new ArrayList<>();
    @Column(nullable = false)
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

    @Override
    public String toString() {

        return "Exercise{" +
                super.toString() +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", type=" + type +
                '}';
    }
}
