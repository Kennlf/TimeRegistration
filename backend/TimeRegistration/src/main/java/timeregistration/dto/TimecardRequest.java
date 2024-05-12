package timeregistration.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDate;
import  java.time.LocalTime;

import timeregistration.entities.Employee;
import timeregistration.entities.Timecard;


@NoArgsConstructor
@Getter
@AllArgsConstructor
@Builder
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TimecardRequest {

    private int timecardNumber;
    private LocalDate date;
    //@JsonFormat(shape = JsonFormat.Shape.STRING)
    private float startTime;
    //@JsonFormat(shape = JsonFormat.Shape.STRING)
    private float endTime;
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





