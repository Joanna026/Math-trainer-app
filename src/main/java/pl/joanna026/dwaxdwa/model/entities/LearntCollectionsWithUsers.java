package pl.joanna026.dwaxdwa.model.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name="learnt_collections")
public class LearntCollectionsWithUsers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long studentId;
    private Long collectionId;
    private LocalDateTime finishedAt;
}
