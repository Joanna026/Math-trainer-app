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

	private static class ExerciseBuilder {

		ExerciseDto exerciseDto = new ExerciseDto();

		public ExerciseBuilder withId(Long id) {
			this.exerciseDto.setId(id);
			return this;
		}
	}

}
