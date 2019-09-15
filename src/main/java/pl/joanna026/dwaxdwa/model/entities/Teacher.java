package pl.joanna026.dwaxdwa.model.entities;

import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

public class Teacher extends User {

    @ManyToMany
    private List<StudentGroup> groupList = new ArrayList<>();
}
