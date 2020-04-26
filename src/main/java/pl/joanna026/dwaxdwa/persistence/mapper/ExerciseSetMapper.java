package pl.joanna026.dwaxdwa.persistence.mapper;

import org.modelmapper.ModelMapper;
import pl.joanna026.dwaxdwa.persistence.dto.ExerciseSetDto;
import pl.joanna026.dwaxdwa.persistence.entity.ExerciseSet;

public class ExerciseSetMapper extends AbstractMapper<ExerciseSetDto, ExerciseSet> {

    private ModelMapper modelMapper;

    @Override
    public ExerciseSetDto mapToDto(ExerciseSet exerciseSet) {
        return modelMapper.map(exerciseSet, ExerciseSetDto.class);
    }

    @Override
    public ExerciseSet mapToEntity(ExerciseSetDto exerciseSetDto) {
        return modelMapper.map(exerciseSetDto, ExerciseSet.class);
    }
}
