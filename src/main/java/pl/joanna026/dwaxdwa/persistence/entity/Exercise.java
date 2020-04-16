package pl.joanna026.dwaxdwa.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Exercise extends AbstractEntity {

	@Column(nullable = false)
	private String answer;

	@Column(nullable = false)
	private boolean isOpen;

	private String[] wrongAnswers;

	@Column(nullable = false)
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

}
