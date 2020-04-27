package pl.joanna026.dwaxdwa.persistence.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.joanna026.dwaxdwa.common.BusinessException;
import pl.joanna026.dwaxdwa.persistence.dto.ExerciseSetDto;
import pl.joanna026.dwaxdwa.persistence.entity.ExerciseSet;
import pl.joanna026.dwaxdwa.persistence.entity.Group;
import pl.joanna026.dwaxdwa.persistence.mapper.ExerciseSetMapper;
import pl.joanna026.dwaxdwa.persistence.repository.ExerciseSetRepository;
import pl.joanna026.dwaxdwa.persistence.service.ExerciseSetService;
import pl.joanna026.dwaxdwa.persistence.validator.ExerciseSetValidator;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ExerciseSetServiceImpl implements ExerciseSetService {

    private ExerciseSetRepository exerciseSetRepository;

    private ExerciseSetValidator exerciseSetValidator;

    private ExerciseSetMapper exerciseSetMapper;

    @Autowired
    public ExerciseSetServiceImpl(ExerciseSetRepository exerciseSetRepository,
                                  ExerciseSetValidator exerciseSetValidator,
                                  ExerciseSetMapper exerciseSetMapper) {
        this.exerciseSetRepository = exerciseSetRepository;
        this.exerciseSetValidator = exerciseSetValidator;
        this.exerciseSetMapper = exerciseSetMapper;
    }

    @Override
    public List<ExerciseSetDto> findAll() {
        return exerciseSetMapper.mapToDto(exerciseSetRepository.findAll());
    }

    @Override
    public ExerciseSetDto findById(Long id) {
        if (id == null) {
            throw new BusinessException("Given id cannot be null");
        }
        ExerciseSet exerciseSet = exerciseSetRepository.findById(id)
                .orElseThrow(() -> new BusinessException(
                        "Exercise set with id " + id + "not found in repository"));
        return exerciseSetMapper.mapToDto(exerciseSet);
    }

    @Override
    public ExerciseSetDto save(ExerciseSetDto exerciseSetDto) {
        exerciseSetValidator.validate(exerciseSetDto);
        ExerciseSet exerciseSet = exerciseSetMapper.mapToEntity(exerciseSetDto);
        return exerciseSetMapper.mapToDto(exerciseSetRepository.save(exerciseSet));
    }

    @Override
    public ExerciseSetDto update(ExerciseSetDto exerciseSetDto) {
        return save(exerciseSetDto);
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            throw new BusinessException("Given id cannot be null");
        }
        ExerciseSet exerciseSet = exerciseSetRepository.findById(id)
                .orElseThrow(() -> new BusinessException(
                        "Exercise set with id " + id + "not found in repository"));
        exerciseSetRepository.deleteById(exerciseSet.getId());
    }
}
