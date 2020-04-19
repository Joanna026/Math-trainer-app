package pl.joanna026.dwaxdwa.persistence.entity;

import java.time.LocalDateTime;
import java.util.List;

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

	private List<Exercise> exercises;

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

	public List<Exercise> getExercises() {
		return exercises;
	}

	public void setExercises(List<Exercise> exercises) {
		this.exercises = exercises;
	}

}
