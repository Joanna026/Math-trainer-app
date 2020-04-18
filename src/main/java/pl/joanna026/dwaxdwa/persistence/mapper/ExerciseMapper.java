package pl.joanna026.dwaxdwa.persistence.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import pl.joanna026.dwaxdwa.persistence.dto.ExerciseDto;
import pl.joanna026.dwaxdwa.persistence.entity.Exercise;

@Component
public class ExerciseMapper extends AbstractMapper<ExerciseDto, Exercise> {

	private final ModelMapper modelMapper = new ModelMapper();

	@Override
	public ExerciseDto mapToDto(Exercise exercise) {
		return modelMapper.map(exercise, ExerciseDto.class);
	}

	@Override
	public Exercise mapToEntity(ExerciseDto dto) {
		return modelMapper.map(dto, Exercise.class);
	}

}
