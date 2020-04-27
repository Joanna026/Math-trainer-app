package pl.joanna026.dwaxdwa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.joanna026.dwaxdwa.persistence.dto.TeacherDto;
import pl.joanna026.dwaxdwa.persistence.service.TeacherService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/teacher")
public class TeacherController {

    private TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public List<TeacherDto> getTeachers() {
        return  teacherService.findAll();
    }

    @PostMapping
    public TeacherDto saveTeacher(@RequestBody TeacherDto teacherDto) {
        return teacherService.save(teacherDto);
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable Long id) {
        teacherService.delete(id);
    }
}
