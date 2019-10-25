package pl.joanna026.dwaxdwa.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name="learnt_collections")
@Getter @Setter
public class LearntCollectionsWithUsers extends BaseEntity{

    private Long studentId;
    private Long collectionId;
    private String collectionName;
    private LocalDateTime finishedAt;

    public LearntCollectionsWithUsers() {
        this.finishedAt = LocalDateTime.now();
    }

}
