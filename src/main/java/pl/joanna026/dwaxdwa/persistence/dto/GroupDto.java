package pl.joanna026.dwaxdwa.persistence.dto;

public class GroupDto extends AbstractDto {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private static class GroupBuilder {

		GroupDto groupDto = new GroupDto();

		public GroupBuilder withId(Long id) {
			this.groupDto.setId(id);
			return this;
		}

		public GroupBuilder withName(String name) {
			this.groupDto.setName(name);
			return this;
		}

		public GroupDto build() {
			return this.groupDto;
		}
	}
}
