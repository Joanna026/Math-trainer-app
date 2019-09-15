package pl.joanna026.dwaxdwa.model.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student_groups")
public class StudentGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String name;
    @OneToMany (mappedBy = "group")
    private List<Student> studentList = new ArrayList<>();
}
