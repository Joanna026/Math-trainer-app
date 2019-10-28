package pl.joanna026.dwaxdwa.model.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.joanna026.dwaxdwa.model.DTO.StudentGroupDTO;
import pl.joanna026.dwaxdwa.model.services.StudentGroupService;

import java.util.List;

@RestController
@RequestMapping("/group")
public class StudentGroupController {

    private StudentGroupService studentGroupService;

    public StudentGroupController(StudentGroupService studentGroupService) {
        this.studentGroupService = studentGroupService;
    }


    @GetMapping
    public List<StudentGroupDTO> getStudentGroups() {
        return studentGroupService.findAll();
    }

    @PostMapping
    public void createStudentGroup(StudentGroupDTO studentGroupDTO) {
        studentGroupService.save(studentGroupDTO);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void editStudentGroup(StudentGroupDTO studentGroupDTO) {
        studentGroupService.save(studentGroupDTO);
    }
}
