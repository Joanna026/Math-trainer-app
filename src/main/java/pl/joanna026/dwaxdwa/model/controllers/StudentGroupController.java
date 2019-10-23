package pl.joanna026.dwaxdwa.model.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.joanna026.dwaxdwa.model.entities.StudentGroup;
import pl.joanna026.dwaxdwa.model.repositories.StudentGroupRepository;

import java.util.List;

@RestController
@RequestMapping("/group")
public class StudentGroupController {

    private StudentGroupRepository studentGroupRepository;

    public StudentGroupController(StudentGroupRepository studentGroupRepository) {
        this.studentGroupRepository = studentGroupRepository;
    }

    @GetMapping
    public List<StudentGroup> getStudentGroups() {
        return studentGroupRepository.findAll();
    }

    @PostMapping
    public void createStudentGroup(StudentGroup studentGroup) {
        studentGroupRepository.save(studentGroup);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void editStudentGroup(StudentGroup studentGroup) {
        studentGroupRepository.save(studentGroup);
    }
}
