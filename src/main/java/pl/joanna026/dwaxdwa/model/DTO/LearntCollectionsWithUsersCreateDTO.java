package pl.joanna026.dwaxdwa.model.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class LearntCollectionsWithUsersCreateDTO {

    @NotNull
    private Long studentId;
    @NotNull
    private Long collectionId;

    @JsonIgnore
    private final LocalDateTime finishedAt = LocalDateTime.now();

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Long collectionId) {
        this.collectionId = collectionId;
    }

    public LocalDateTime getFinishedAt() {
        return finishedAt;
    }

}
