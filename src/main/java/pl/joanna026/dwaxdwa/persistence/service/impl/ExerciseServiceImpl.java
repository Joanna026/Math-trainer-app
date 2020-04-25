package pl.joanna026.dwaxdwa.persistence.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import pl.joanna026.dwaxdwa.common.BusinessException;
import pl.joanna026.dwaxdwa.persistence.dto.ExerciseDto;
import pl.joanna026.dwaxdwa.persistence.entity.Exercise;
import pl.joanna026.dwaxdwa.persistence.mapper.ExerciseMapper;
import pl.joanna026.dwaxdwa.persistence.repository.ExerciseRepository;
import pl.joanna026.dwaxdwa.persistence.service.ExerciseService;
import pl.joanna026.dwaxdwa.persistence.validator.ExerciseValidator;

@Service
@Transactional
public class ExerciseServiceImpl implements ExerciseService {

	private ExerciseRepository exerciseRepository;

	private ExerciseMapper exerciseMapper;

	private ExerciseValidator exerciseValidator;

	public ExerciseServiceImpl(ExerciseRepository exerciseRepository,
			ExerciseMapper exerciseMapper, ExerciseValidator exerciseValidator) {
		this.exerciseRepository = exerciseRepository;
		this.exerciseMapper = exerciseMapper;
		this.exerciseValidator = exerciseValidator;
	}

	@Override
	public ExerciseDto findById(Long id) {
		if (id == null) {
			throw new BusinessException("Given id cannot be null");
		}
		Exercise exercise = exerciseRepository.findById(id)
				.orElseThrow(() -> new BusinessException(
						"Exercise with id " + id + "not found in repository"));
		return exerciseMapper.mapToDto(exercise);
	}

	@Override
	public List<ExerciseDto> findAll() {
		return exerciseMapper.mapToDto(exerciseRepository.findAll());
	}

	@Override
	public ExerciseDto save(ExerciseDto exerciseDto) {
		exerciseValidator.validate(exerciseDto);
		Exercise exerciseToSave = exerciseMapper.mapToEntity(exerciseDto);
		return exerciseMapper.mapToDto(exerciseRepository.save(exerciseToSave));
	}

	@Override
	public ExerciseDto update(ExerciseDto exerciseDto) {
		return save(exerciseDto);
	}

	@Override
	public void delete(Long id) {
		if (id == null) {
			throw new BusinessException("Given id cannot be null");
		}
		Exercise exercise = exerciseRepository.findById(id)
				.orElseThrow(() -> new BusinessException(
						"Exercise with id " + id + "not found in repository"));
		exerciseRepository.deleteById(exercise.getId());
	}

}
