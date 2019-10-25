package pl.joanna026.dwaxdwa.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student_groups")
@Getter @Setter
public class StudentGroup extends BaseEntity{


    @Column(nullable = false)
    private String name;
    @OneToMany (mappedBy = "group")
    private List<User> studentList = new ArrayList<>();
    @ManyToMany
    private List<ExerciseCollection> obligatoryCollections = new ArrayList<>();

    public StudentGroup() {
    }


    @Override
    public String toString() {
        return "StudentGroup{" +
                "name='" + name + '\'' +
                ", studentList=" + studentList +
                '}';
    }
}
