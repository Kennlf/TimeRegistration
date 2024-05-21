package timeregistration.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.ToString;
import timeregistration.entities.Timecard;

import java.time.LocalDate;
import java.time.LocalTime;

@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TimecardResponse {

    private int timecardNumber;
    private LocalDate date;
    //@JsonFormat(pattern = "hh:mm",shape = JsonFormat.Shape.STRING)
    private double startTime;
    //@JsonFormat(pattern = "hh:mm",shape = JsonFormat.Shape.STRING)
    private double endTime;
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
