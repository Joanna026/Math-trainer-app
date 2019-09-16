package pl.joanna026.dwaxdwa.model.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.*;

@Entity
@Table(name = "students")
public class Student{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column
    private Boolean logEnable;
    @ManyToOne
    private Role role;

    @Column(nullable = false)
    private String name;
    @Column (nullable = false, unique = true)
    private String email;
    @ManyToOne
    private StudentGroup group;
    @ManyToMany
    private List<ExerciseCollection> availableExerciseCollection = new ArrayList<>();
//    private Map<ExerciseCollection, Timestamp> learntExerciseCollectionsWithFinishTime = new HashMap<>();
//    private Map<Exercise, Boolean> exerciseCollectionInUse = new HashMap<>();

    public Student() {
        setLogEnable(false);
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

    public Boolean getLogEnable() {
        return logEnable;
    }

    public void setLogEnable(Boolean logEnable) {
        this.logEnable = logEnable;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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

//    public Map<ExerciseCollection, Timestamp> getLearntExerciseCollectionsWithFinishTime() {
//        return learntExerciseCollectionsWithFinishTime;
//    }
//
//    public void setLearntExerciseCollectionsWithFinishTime(Map<ExerciseCollection, Timestamp> learntExerciseCollectionsWithFinishTime) {
//        this.learntExerciseCollectionsWithFinishTime = learntExerciseCollectionsWithFinishTime;
//    }

//    public Map<Exercise, Boolean> getExerciseCollectionInUse() {
//        return exerciseCollectionInUse;
//    }

//    public void setExerciseCollectionInUse(Map<Exercise, Boolean> exerciseCollectionInUse) {
//        this.exerciseCollectionInUse = exerciseCollectionInUse;
//    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", group=" + group +
                ", availableExerciseCollection=" + availableExerciseCollection +
                '}';
    }
}