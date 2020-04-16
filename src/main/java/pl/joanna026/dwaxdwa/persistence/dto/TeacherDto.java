package pl.joanna026.dwaxdwa.persistence.dto;

public class TeacherDto extends AbstractDto {

	private String name;

	private String email;

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

	private static class TeacherBuilder {

		TeacherDto teacherDto = new TeacherDto();

		public TeacherBuilder withId(Long id) {
			this.teacherDto.setId(id);
			return this;
		}

		public TeacherBuilder withName(String name) {
			this.teacherDto.setName(name);
			return this;
		}

		public TeacherBuilder withEmail(String email) {
			this.teacherDto.setEmail(email);
			return this;
		}

		public TeacherDto build() {
			return this.teacherDto;
		}
	}

}
