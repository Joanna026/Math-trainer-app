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

import pl.joanna026.dwaxdwa.persistence.dto.ExerciseDto;
import pl.joanna026.dwaxdwa.persistence.service.ExerciseService;

@CrossOrigin
@RestController
@RequestMapping("/api/exercises")
public class ExerciseController {

	private ExerciseService exerciseService;

	@Autowired
	public ExerciseController(ExerciseService exerciseService) {
		this.exerciseService = exerciseService;
	}

	@GetMapping
	public List<ExerciseDto> getExercises() {
		return exerciseService.findAll();
	}

	@PostMapping
	public ExerciseDto saveExercise(@RequestBody ExerciseDto exerciseDto) {
		return exerciseService.save(exerciseDto);
	}

	@DeleteMapping("/{id}")
	public void deleteExercise(@PathVariable Long id) {
		exerciseService.delete(id);
	}
}
