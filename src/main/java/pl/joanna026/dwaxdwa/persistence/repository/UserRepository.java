package pl.joanna026.dwaxdwa.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.joanna026.dwaxdwa.persistence.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
