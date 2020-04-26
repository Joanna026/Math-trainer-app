package pl.joanna026.dwaxdwa.persistence.validator;

import org.springframework.stereotype.Component;
import pl.joanna026.dwaxdwa.common.BusinessException;
import pl.joanna026.dwaxdwa.persistence.dto.ExerciseSetDto;
import pl.joanna026.dwaxdwa.persistence.dto.TeacherDto;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.Set;

@Component
public class ExerciseSetValidator {

    private Validator validator;

    public void validate(ExerciseSetDto exerciseSetDto) throws BusinessException {
        if (exerciseSetDto == null) {
            throw new BusinessException("Unable to persist entity: ExerciseSet");
        }
        Set<ConstraintViolation<ExerciseSetDto>> constraintViolations = validator
                .validate(exerciseSetDto);
        if (!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(constraintViolations);
        }
    }

    }
