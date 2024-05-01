package timeregistration.dto;

import lombok.NoArgsConstructor;
import java.time.LocalDate;
import  java.time.LocalTime;
import timeregistration.entities.Timecard;

@NoArgsConstructor
public class TimecardRequest {

    private int timecardNumber;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private double dailyHours;

    public static Timecard getTimecardEntity(TimecardRequest timecardRequest){
        return Timecard.builder()
                .timecardNumber(timecardRequest.timecardNumber)
                .date(timecardRequest.date)
                .startTime(timecardRequest.startTime)
                .endTime(timecardRequest.endTime)
                .dailyHours(timecardRequest.dailyHours)
                .build();
    }

    public TimecardRequest(Timecard timecard){
        this.timecardNumber = timecard.getTimecardNumber();
        this.date = timecard.getDate();
        this.startTime = timecard.getStartTime();
        this.endTime = timecard.getEndTime();
        this.dailyHours = timecard.getDailyHours();
    }
}
