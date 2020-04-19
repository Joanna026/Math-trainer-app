package pl.joanna026.dwaxdwa.persistence.dto;

import java.util.List;

public class UserDto extends AbstractDto {

	private String name;

	private String email;

	private GroupDto group;

	private List<ExerciseSetDto> exerciseSets;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public GroupDto getGroup() {
		return group;
	}

	public void setGroup(GroupDto group) {
		this.group = group;
	}

	public List<ExerciseSetDto> getExerciseSets() {
		return exerciseSets;
	}

	public void setExerciseSets(List<ExerciseSetDto> exerciseSets) {
		this.exerciseSets = exerciseSets;
	}

	public static class UserBuilder {

		UserDto userDto = new UserDto();

		public UserBuilder withId(Long id) {
			this.userDto.setId(id);
			return this;
		}

		public UserBuilder withName(String name) {
			this.userDto.setName(name);
			return this;
		}

		public UserBuilder withEmail(String email) {
			this.userDto.setEmail(email);
			return this;
		}

		public UserBuilder withGroup(GroupDto group) {
			this.userDto.setGroup(group);
			return this;
		}

		public UserBuilder withExerciseSets(List<ExerciseSetDto> sets) {
			this.userDto.setExerciseSets(sets);
			return this;
		}

		public UserDto build() {
			return this.userDto;
		}
	}

}
