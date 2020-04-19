package pl.joanna026.dwaxdwa.persistence.dto;

import java.time.LocalDateTime;
import java.util.List;

public class ExerciseSetDto extends AbstractDto {

	private String name;

	private boolean done;

	private LocalDateTime assignDate;

	private LocalDateTime requiredDate;

	private LocalDateTime doneDateTime;

	private List<ExerciseDto> exercises;

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

	public List<ExerciseDto> getExercises() {
		return exercises;
	}

	public void setExercises(List<ExerciseDto> exercises) {
		this.exercises = exercises;
	}

}
