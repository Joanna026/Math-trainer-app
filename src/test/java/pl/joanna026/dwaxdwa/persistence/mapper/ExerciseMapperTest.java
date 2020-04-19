package pl.joanna026.dwaxdwa.persistence.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pl.joanna026.dwaxdwa.DwaxdwaApplication;
import pl.joanna026.dwaxdwa.persistence.dto.ExerciseDto;
import pl.joanna026.dwaxdwa.persistence.dto.ExerciseDto.ExerciseBuilder;
import pl.joanna026.dwaxdwa.persistence.entity.Exercise;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { DwaxdwaApplication.class })
@Transactional
public class ExerciseMapperTest {

	@Autowired
	private ExerciseMapper exerciseMapper;

	private ExerciseBuilder exerciseBuilder = new ExerciseBuilder();

	private ExerciseDto exerciseDto;

	@Before
	public void init() {
		exerciseDto = exerciseBuilder.withId(2L).withAnswer("5").withOpen(false)
				.withRepeatNumber(4).build();
	}

	@Test
	public void shouldMapAllFieldsCorrectlyToEntity() {
		// given

		// when
		Exercise exercise = exerciseMapper.mapToEntity(exerciseDto);

		// then
		assertThat(exercise.getId()).isEqualTo(exerciseDto.getId());
		assertThat(exercise.getAnswer()).isEqualTo(exerciseDto.getAnswer());
		assertThat(exercise.isOpen()).isEqualTo(exerciseDto.isOpen());
		assertThat(exercise.getRepeatNumber()).isEqualTo(exerciseDto.getRepeatNumber());
		assertThat(exercise.getWrongAnswers()).isNull();
	}

	@Test
	public void shouldMapAllFieldsCorrectlyToDto() {
		// given
		Exercise exercise = exerciseMapper.mapToEntity(exerciseDto);

		// when
		ExerciseDto dto = exerciseMapper.mapToDto(exercise);

		// then
		assertThat(dto.getId()).isEqualTo(exercise.getId());
		assertThat(dto.getAnswer()).isEqualTo(exercise.getAnswer());
		assertThat(dto.isOpen()).isEqualTo(exercise.isOpen());
		assertThat(dto.getRepeatNumber()).isEqualTo(exercise.getRepeatNumber());
		assertThat(dto.getWrongAnswers()).isNull();
	}

	@Test
	public void shouldMapCorrectlyAllDtoListElementsToEntity() {
		// given
		ExerciseDto dto1 = exerciseBuilder.withId(3L).withAnswer("9").withOpen(false)
				.withRepeatNumber(1).build();
		ExerciseDto[] array = new ExerciseDto[] { exerciseDto, dto1 };
		List<ExerciseDto> dtoList = Arrays.asList(array);

		// when
		List<Exercise> entityList = exerciseMapper.mapToEntity(dtoList);

		// then
		assertThat(entityList).hasSize(2);
		assertThat(entityList.get(0).getId()).isEqualTo(exerciseDto.getId());
		assertThat(entityList.get(1).getId()).isEqualTo(dto1.getId());
	}

	@Test
	public void shouldMapCorrectlyAllEntityListElementsToDto() {
		// given
		ExerciseDto dto2 = exerciseBuilder.withId(4L).withAnswer("9").withOpen(false)
				.withRepeatNumber(1).build();
		Exercise entity = exerciseMapper.mapToEntity(dto2);
		Exercise exercise = exerciseMapper.mapToEntity(exerciseDto);
		Exercise[] array = new Exercise[] { entity, exercise };
		List<Exercise> list = Arrays.asList(array);

		// when
		List<ExerciseDto> dtoList = exerciseMapper.mapToDto(list);

		// then
		assertThat(dtoList).hasSize(2);
		assertThat(dtoList.get(0).getId()).isEqualTo(entity.getId());
		assertThat(dtoList.get(1).getId()).isEqualTo(exercise.getId());
	}
}
