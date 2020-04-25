package pl.joanna026.dwaxdwa.persistence.service;

import java.util.List;

import pl.joanna026.dwaxdwa.persistence.dto.ExerciseDto;

public interface ExerciseService {

	ExerciseDto findById(Long id);

	List<ExerciseDto> findAll();

	ExerciseDto save(ExerciseDto exerciseDto);

	ExerciseDto update(ExerciseDto exerciseDto);

	void delete(Long id);
}
