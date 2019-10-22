package pl.joanna026.dwaxdwa.model.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.joanna026.dwaxdwa.model.services.StudentGroupService;

@Controller
@RequestMapping("/admin/set")
public class SetCollectionToGroupController {

    private StudentGroupService studentGroupService;

    public SetCollectionToGroupController(StudentGroupService studentGroupService) {
        this.studentGroupService = studentGroupService;
    }

    @GetMapping
    public String prepareSetCollectionPage(@RequestParam Long groupId, Model model) {

        return ("/collectionChoice");
    }


    @PostMapping
    public String processSetCollectionPage(@RequestParam Long groupId, @RequestParam Long collectionId) {


        return ("redirect:/home");
    }
}
