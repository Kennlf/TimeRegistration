package timeregistration.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import timeregistration.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
