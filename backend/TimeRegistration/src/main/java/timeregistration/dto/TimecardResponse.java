package timeregistration.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import timeregistration.entities.Timecard;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TimecardResponse {

    private int timecardNumber;
    private LocalDate date;
    //@JsonFormat(pattern = "hh:mm",shape = JsonFormat.Shape.STRING)
    private LocalTime startTime;
    //@JsonFormat(pattern = "hh:mm",shape = JsonFormat.Shape.STRING)
    private LocalTime endTime;
    private double dailyHour;
    private int employeeNumber;

    public TimecardResponse(Timecard timecard){
        this.timecardNumber = timecard.getTimecardNumber();
        this.date = timecard.getDate();
        this.startTime = timecard.getStartTime();
        this.endTime = timecard.getEndTime();
        this.dailyHour = timecard.getDailyHours();
        this.employeeNumber = timecard.getEmployee().getEmployeeNumber();
    }

}
