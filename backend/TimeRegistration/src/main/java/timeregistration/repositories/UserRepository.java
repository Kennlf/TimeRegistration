package timeregistration.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import timeregistration.entities.Employee;

public interface UserRepository extends JpaRepository<Employee, Integer> {
}
