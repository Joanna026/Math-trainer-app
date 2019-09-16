package pl.joanna026.dwaxdwa.model.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.joanna026.dwaxdwa.model.entities.Student;
import pl.joanna026.dwaxdwa.model.repositories.StudentRepository;
import pl.joanna026.dwaxdwa.model.utils.DTO;
import pl.joanna026.dwaxdwa.model.utils.StudentCreateDTO;
import pl.joanna026.dwaxdwa.model.utils.StudentUpdateDTO;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @PostMapping
    public void createStudent(@DTO(StudentCreateDTO.class) Student student) {
        studentRepository.save(student);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void editStudent(@DTO(StudentUpdateDTO.class)Student student) {
        studentRepository.save(student);
    }
}
