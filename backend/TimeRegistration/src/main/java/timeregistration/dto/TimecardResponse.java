package timeregistration.dto;

import timeregistration.entities.Timecard;

import java.time.LocalDate;
import java.time.LocalTime;

public class TimecardResponse {

    private int timecardNumber;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private double dailyHour;

    public TimecardResponse(Timecard timecard){
        this.timecardNumber = timecard.getTimecardNumber();
        this.date = timecard.getDate();
        this.startTime = timecard.getStartTime();
        this.endTime = timecard.getEndTime();
        this.dailyHour = timecard.getDailyHours();
    }

}
