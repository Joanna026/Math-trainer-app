package pl.joanna026.dwaxdwa.persistence.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ExerciseSet extends AbstractEntity {

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private boolean done;

	@Column
	private LocalDateTime assignDate;

	@Column
	private LocalDateTime requiredDate;

	@Column
	private LocalDateTime doneDateTime;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public LocalDateTime getAssignDate() {
		return assignDate;
	}

	public void setAssignDate(LocalDateTime assignDate) {
		this.assignDate = assignDate;
	}

	public LocalDateTime getRequiredDate() {
		return requiredDate;
	}

	public void setRequiredDate(LocalDateTime requiredDate) {
		this.requiredDate = requiredDate;
	}

	public LocalDateTime getDoneDateTime() {
		return doneDateTime;
	}

	public void setDoneDateTime(LocalDateTime doneDateTime) {
		this.doneDateTime = doneDateTime;
	}

}
