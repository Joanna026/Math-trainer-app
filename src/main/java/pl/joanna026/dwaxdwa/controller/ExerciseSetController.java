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

import pl.joanna026.dwaxdwa.persistence.dto.ExerciseSetDto;
import pl.joanna026.dwaxdwa.persistence.service.ExerciseSetService;

@CrossOrigin
@RestController
@RequestMapping("/api/sets")
public class ExerciseSetController {

	private ExerciseSetService exerciseSetService;

	@Autowired
	public ExerciseSetController(ExerciseSetService exerciseSetService) {
		this.exerciseSetService = exerciseSetService;
	}

	@GetMapping
	public List<ExerciseSetDto> getExerciseSets() {
		return exerciseSetService.findAll();
	}

	@PostMapping
	public ExerciseSetDto savExerciseSet(@RequestBody ExerciseSetDto exerciseSetDto) {
		return exerciseSetService.save(exerciseSetDto);
	}

	@DeleteMapping("/{id}")
	public void deleteExerciseSet(@PathVariable Long id) {
		exerciseSetService.delete(id);
	}

}
