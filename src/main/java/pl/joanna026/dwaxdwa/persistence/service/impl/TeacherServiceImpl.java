package pl.joanna026.dwaxdwa.persistence.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.joanna026.dwaxdwa.common.BusinessException;
import pl.joanna026.dwaxdwa.persistence.dto.TeacherDto;
import pl.joanna026.dwaxdwa.persistence.entity.Teacher;
import pl.joanna026.dwaxdwa.persistence.mapper.TeacherMapper;
import pl.joanna026.dwaxdwa.persistence.repository.TeacherRepository;
import pl.joanna026.dwaxdwa.persistence.service.TeacherService;
import pl.joanna026.dwaxdwa.persistence.validator.TeacherValidator;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {

    private TeacherRepository teacherRepository;

    private TeacherMapper teacherMapper;

    private TeacherValidator teacherValidator;

    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository, TeacherMapper teacherMapper, TeacherValidator teacherValidator) {
        this.teacherRepository = teacherRepository;
        this.teacherMapper = teacherMapper;
        this.teacherValidator = teacherValidator;
    }

    @Override
    public List<TeacherDto> findAll() {
        return teacherMapper.mapToDto(teacherRepository.findAll());
    }

    @Override
    public TeacherDto findById(Long id) {
        if(id == null) {
            throw new BusinessException("Given id cannot be null");
        }
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new BusinessException(
                        "Teacher with id " + id + "not found in repository"
                ));
        return teacherMapper.mapToDto(teacher);
    }

    @Override
    public TeacherDto save(TeacherDto teacherDto) {
        teacherValidator.validate(teacherDto);
        Teacher teacher = teacherMapper.mapToEntity(teacherDto);
        return teacherMapper.mapToDto(teacherRepository.save(teacher));
    }

    @Override
    public TeacherDto update(TeacherDto teacherDto) {
        return save(teacherDto);
    }

    @Override
    public void delete(Long id) {
        if(id == null) {
            throw new BusinessException("Given id cannot be null");
        }
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new BusinessException(
                        "Teacher with id " + id + "not found in repository"
                ));
        teacherRepository.deleteById(teacher.getId());
    }
}
