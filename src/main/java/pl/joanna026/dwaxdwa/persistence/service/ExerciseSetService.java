package pl.joanna026.dwaxdwa.persistence.service;

import pl.joanna026.dwaxdwa.persistence.dto.ExerciseSetDto;

import java.util.List;

public interface ExerciseSetService {

    List<ExerciseSetDto> findAll();

    ExerciseSetDto findById(Long id);

    ExerciseSetDto save(ExerciseSetDto exerciseSetDto);

    ExerciseSetDto update(ExerciseSetDto exerciseSetDto);

    void delete(Long id);
}
