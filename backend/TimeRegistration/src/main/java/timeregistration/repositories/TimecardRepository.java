package timeregistration.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import timeregistration.entities.Timecard;

import java.time.LocalDate;

public interface TimecardRepository extends JpaRepository<Timecard, Integer> {

    Timecard findByDateAndEmployee_EmployeeNumber(LocalDate date, int employeeNumber);
}
