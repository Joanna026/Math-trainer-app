package pl.joanna026.dwaxdwa.persistence.dto;

public class ExerciseDto extends AbstractDto {

	private String answer;

	private boolean isOpen;

	private String[] wrongAnswers;

	private Integer repeatNumber;

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public String[] getWrongAnswers() {
		return wrongAnswers;
	}

	public void setWrongAnswers(String[] wrongAnswers) {
		this.wrongAnswers = wrongAnswers;
	}

	public Integer getRepeatNumber() {
		return repeatNumber;
	}

	public void setRepeatNumber(Integer repeatNumber) {
		this.repeatNumber = repeatNumber;
	}

	public static class ExerciseBuilder {

		ExerciseDto exerciseDto = new ExerciseDto();

		public ExerciseBuilder withId(Long id) {
			this.exerciseDto.setId(id);
			return this;
		}

		public ExerciseBuilder withAnswer(String answer) {
			this.exerciseDto.setAnswer(answer);
			return this;
		}

		public ExerciseBuilder withOpen(boolean isOpen) {
			this.exerciseDto.setOpen(isOpen);
			return this;
		}

		public ExerciseBuilder withWrongAnswers(String[] answers) {
			this.exerciseDto.setWrongAnswers(answers);
			return this;
		}

		public ExerciseBuilder withRepeatNumber(Integer number) {
			this.exerciseDto.setRepeatNumber(number);
			return this;
		}

		public ExerciseDto build() {
			return this.exerciseDto;
		}
	}

}
