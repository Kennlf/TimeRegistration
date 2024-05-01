package timeregistration.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name= "timecard")
public class Timecard {

    @Id
    private int timecardNumber;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private double dailyHours;



}
