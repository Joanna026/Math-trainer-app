package pl.joanna026.dwaxdwa.persistence.validator;

import org.springframework.stereotype.Component;
import pl.joanna026.dwaxdwa.common.BusinessException;
import pl.joanna026.dwaxdwa.persistence.dto.ExerciseSetDto;
import pl.joanna026.dwaxdwa.persistence.dto.UserDto;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.Set;

@Component
public class UserValidator {

    private Validator validator;

    public void validate(UserDto userDto) throws BusinessException {
        if (userDto == null) {
            throw new BusinessException("Unable to persist entity: User");
        }
        Set<ConstraintViolation<UserDto>> constraintViolations = validator
                .validate(userDto);
        if (!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(constraintViolations);
        }
    }
}
