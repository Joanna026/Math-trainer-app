package pl.joanna026.dwaxdwa.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.joanna026.dwaxdwa.model.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

}
