package pl.joanna026.dwaxdwa.model.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "students")
public class Student extends User {

    @Column(nullable = false)
    private String name;
    @Column (nullable = false, unique = true)
    private String email;
    @ManyToOne
    private StudentGroup group;
    @ManyToMany
    private List<ExerciseCollection> availableExerciseCollection = new ArrayList<>();
    @ManyToMany
    private Map<ExerciseCollection, Timestamp> learntExerciseCollectionsWithFinishTime = new HashMap<>();
    @ManyToMany
    private Map<Exercise, Boolean> exerciseCollectionInUse = new HashMap<>();
}