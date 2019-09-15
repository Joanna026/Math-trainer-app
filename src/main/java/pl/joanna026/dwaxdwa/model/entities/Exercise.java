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
    @NotEmpty
    private String correctAnswer;
    private Set<String> wrongAnswers = new HashSet<>();
}
