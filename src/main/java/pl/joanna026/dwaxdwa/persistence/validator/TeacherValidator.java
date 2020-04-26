package pl.joanna026.dwaxdwa.persistence.validator;

import org.springframework.stereotype.Component;
import pl.joanna026.dwaxdwa.common.BusinessException;
import pl.joanna026.dwaxdwa.persistence.dto.TeacherDto;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.Set;

@Component
public class TeacherValidator {

    private Validator validator;

    public void validate(TeacherDto teacherDto) throws BusinessException {
        if (teacherDto == null) {
            throw new BusinessException("Unable to persist entity: Teacher");
        }
        Set<ConstraintViolation<TeacherDto>> constraintViolations = validator
                .validate(teacherDto);
        if (!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(constraintViolations);
        }
    }
}
