package pl.joanna026.dwaxdwa.persistence.validator;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.joanna026.dwaxdwa.common.BusinessException;
import pl.joanna026.dwaxdwa.persistence.dto.GroupDto;

@Component
public class GroupValidator {

	private Validator validator;

	@Autowired
	public GroupValidator(Validator validator) {
		this.validator = validator;
	}

	public void validate(GroupDto groupDto) throws BusinessException {
		if (groupDto == null) {
			throw new BusinessException("Unable to persist entity: Group");
		}
		Set<ConstraintViolation<GroupDto>> constraintViolations = validator
				.validate(groupDto);
		if (!constraintViolations.isEmpty()) {
			throw new ConstraintViolationException(constraintViolations);
		}
	}

}
