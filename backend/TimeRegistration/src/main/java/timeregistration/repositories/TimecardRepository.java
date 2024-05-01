package timeregistration.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import timeregistration.entities.Timecard;

public interface TimecardRepository extends JpaRepository<Timecard, Integer> {
}
