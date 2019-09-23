package pl.joanna026.dwaxdwa.model.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.joanna026.dwaxdwa.model.services.StudentGroupService;

@Controller
@RequestMapping("/admin/groups")
public class ListOfGroupsController {

    private final StudentGroupService studentGroupService;


    public ListOfGroupsController(StudentGroupService studentGroupService) {
        this.studentGroupService = studentGroupService;
    }   

    @GetMapping("/all")
    public String prepareGroupListPage(Model model) {
        model.addAttribute("groups", studentGroupService.findAll());
        return ("groupList");
    }
}
