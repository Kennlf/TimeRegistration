package timeregistration.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import timeregistration.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
