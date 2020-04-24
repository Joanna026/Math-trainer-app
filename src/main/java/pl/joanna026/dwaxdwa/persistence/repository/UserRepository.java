package pl.joanna026.dwaxdwa.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import pl.joanna026.dwaxdwa.persistence.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
