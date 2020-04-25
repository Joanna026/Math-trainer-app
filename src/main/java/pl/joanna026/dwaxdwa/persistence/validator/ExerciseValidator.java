package pl.joanna026.dwaxdwa.persistence.validator;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.joanna026.dwaxdwa.common.BusinessException;
import pl.joanna026.dwaxdwa.persistence.dto.ExerciseDto;

@Component
public class ExerciseValidator {

	private Validator validator;

	@Autowired
	public ExerciseValidator(Validator validator) {
		this.validator = validator;
	}

	public void validate(ExerciseDto exerciseDto) throws BusinessException {
		if (exerciseDto == null) {
			throw new BusinessException("Unable to persist entity: Exercise");
		}
		Set<ConstraintViolation<ExerciseDto>> constraintViolations = validator
				.validate(exerciseDto);
		if (!constraintViolations.isEmpty()) {
			throw new ConstraintViolationException(constraintViolations);
		}

	}

}
