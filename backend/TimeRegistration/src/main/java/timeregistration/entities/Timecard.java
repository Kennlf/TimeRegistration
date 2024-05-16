package timeregistration.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name= "timecard")
public class Timecard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int timecardNumber;
    private LocalDate date;
    private double startTime;
    private double endTime;
    private double dailyHours;

    @ManyToOne
    private Employee employee;



}

