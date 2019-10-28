package pl.joanna026.dwaxdwa.model.DTO;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class LearntCollectionsWithUsersDTO {

    @NotNull
    private Long studentId;
    @NotNull
    private Long collectionId;
    private String collectionName;
    @NotNull
    private LocalDateTime finishedAt;
}
