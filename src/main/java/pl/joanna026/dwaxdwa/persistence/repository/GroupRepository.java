package pl.joanna026.dwaxdwa.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import pl.joanna026.dwaxdwa.persistence.entity.Group;

public interface GroupRepository extends CrudRepository<Group, Long> {
}
