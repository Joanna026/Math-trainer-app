package pl.joanna026.dwaxdwa.persistence.service;

import pl.joanna026.dwaxdwa.persistence.dto.TeacherDto;

import java.util.List;

public interface TeacherService {

    List<TeacherDto> findAll();

    TeacherDto findById(Long id);

    TeacherDto save(TeacherDto teacherDto);

    TeacherDto update(TeacherDto teacherDto);

    void delete(Long id);
}
