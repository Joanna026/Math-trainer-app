package pl.joanna026.dwaxdwa.persistence.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import pl.joanna026.dwaxdwa.persistence.dto.TeacherDto;
import pl.joanna026.dwaxdwa.persistence.entity.Teacher;

@Component
public class TeacherMapper extends AbstractMapper<TeacherDto, Teacher> {

	private final ModelMapper modelMapper = new ModelMapper();

	@Override
	public TeacherDto mapToDto(Teacher teacher) {
		return modelMapper.map(teacher, TeacherDto.class);
	}

	@Override
	public Teacher mapToEntity(TeacherDto dto) {
		return modelMapper.map(dto, Teacher.class);
	}
}
