package pl.joanna026.dwaxdwa.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter @Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column
    private Boolean enabled;
    @OneToOne
    private Role authority;
    private String name;
    @Column (unique = true)
    private String email;
    @ManyToOne
    private StudentGroup group;
    @ManyToMany
    private List<ExerciseCollection> availableExerciseCollection = new ArrayList<>();
    @ElementCollection(targetClass = LearntCollectionsWithUsers.class)
    private List<LearntCollectionsWithUsers> learntCollections = new ArrayList<>();


    public User() {
    }
}
