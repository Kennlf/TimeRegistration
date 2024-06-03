package timeregistration.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import timeregistration.entities.Employee;
import timeregistration.entities.Timecard;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TimecardRepository extends JpaRepository<Timecard, Integer> {

    Timecard findByDateAndEmployee_EmployeeNumber(LocalDate date, int employeeNumber);

    List<Timecard> findTimecardsByEmployee (Optional<Employee> employeeNumber);
}
