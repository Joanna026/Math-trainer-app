package pl.joanna026.dwaxdwa.model.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.joanna026.dwaxdwa.model.entities.Teacher;
import pl.joanna026.dwaxdwa.model.repositories.TeacherRepository;
import pl.joanna026.dwaxdwa.model.utils.DTO;
import pl.joanna026.dwaxdwa.model.utils.TeacherCreateDTO;
import pl.joanna026.dwaxdwa.model.utils.TeacherUpdateDTO;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private TeacherRepository teacherRepository;

    public TeacherController(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @GetMapping
    public List<Teacher> getTeachers() {
        return  teacherRepository.findAll();
    }

    @PostMapping
    public void createTeacher(@DTO(TeacherCreateDTO.class) Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void editTeacher(@DTO(TeacherUpdateDTO.class)Teacher teacher) {
        teacherRepository.save(teacher);
    }
}
