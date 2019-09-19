package pl.joanna026.dwaxdwa.model.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Role getAuthority() {
        return authority;
    }

    public void setAuthority(Role authority) {
        this.authority = authority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public StudentGroup getGroup() {
        return group;
    }

    public void setGroup(StudentGroup group) {
        this.group = group;
    }


    public List<ExerciseCollection> getAvailableExerciseCollection() {
        return availableExerciseCollection;
    }

    public void setAvailableExerciseCollection(List<ExerciseCollection> availableExerciseCollection) {
        this.availableExerciseCollection = availableExerciseCollection;
    }

    public List<LearntCollectionsWithUsers> getLearntCollections() {
        return learntCollections;
    }

    public void setLearntCollections(List<LearntCollectionsWithUsers> learntCollections) {
        this.learntCollections = learntCollections;
    }
}
