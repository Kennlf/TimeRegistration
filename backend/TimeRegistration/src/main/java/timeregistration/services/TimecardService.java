package timeregistration.services;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import timeregistration.dto.EmployeeRequest;
import timeregistration.dto.EmployeeResponse;
import timeregistration.dto.TimecardRequest;
import timeregistration.dto.TimecardResponse;
import timeregistration.entities.Employee;
import timeregistration.entities.Timecard;
import timeregistration.repositories.EmployeeRepository;
import timeregistration.repositories.TimecardRepository;

@Service
public class TimecardService {


    private TimecardRepository timecardRepository;
    private EmployeeRepository employeeRepository;

    public TimecardService(TimecardRepository timecardRepository, EmployeeRepository employeeRepository) {
        this.timecardRepository = timecardRepository;
        this.employeeRepository = employeeRepository;
    }

    public TimecardResponse addTimeCard(TimecardRequest timecardRequest, int employeeNumber) {
        //opret userobject og tilføj til timecard og gem.
        Employee employee = employeeRepository.findById(employeeNumber).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Denne medarbejder kunne ikke findes"));
        Timecard newTimecard = TimecardRequest.getTimecardEntity(timecardRequest);
        newTimecard.setEmployee(employee);
        newTimecard = timecardRepository.save(newTimecard);

        return new TimecardResponse(newTimecard);
    }


    /*public TimecardResponse updateTimecard(TimecardRequest body, int employeeNumber) {
        //int employeeNumber = body.getEmployeeNumber? Bør vi bare sende det hele i body og så hive det ud af.

        //Skal rettes til at finde specifikt kort på både employeenumber og dato
        Timecard timecard = timecardRepository.findById(employeeNumber).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Dette Timecard kunne ikke findes."));

        Employee employee = employeeRepository.findById(employeeNumber).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Denne medarbjeder kunne ikke findes."));

        timecard.setTimecardNumber(body.getTimecardNumber());
        timecard.setDate(body.getDate());
        timecard.setStartTime(body.getStartTime());
        timecard.setEndTime(body.getEndTime());
        timecard.setDailyHours(body.getDailyHours());
        timecard.setEmployee(employee);
        Timecard newcard = timecardRepository.save(timecard);
        return new TimecardResponse(newcard);
    }*/
}
