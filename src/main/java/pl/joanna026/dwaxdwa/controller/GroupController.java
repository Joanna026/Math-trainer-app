package pl.joanna026.dwaxdwa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.joanna026.dwaxdwa.persistence.dto.GroupDto;
import pl.joanna026.dwaxdwa.persistence.service.GroupService;

@CrossOrigin
@RestController
@RequestMapping("/api/groups")
public class GroupController {

	private GroupService groupService;

	@Autowired
	public GroupController(GroupService groupService) {
		this.groupService = groupService;
	}

	@GetMapping
	public List<GroupDto> getGroups() {
		return groupService.findAll();
	}

	@PostMapping
	public GroupDto saveGroup(@RequestBody GroupDto groupDto) {
		return groupService.save(groupDto);
	}

	@DeleteMapping("/{id}")
	public void deleteGroup(@PathVariable Long id) {
		groupService.delete(id);
	}

}
