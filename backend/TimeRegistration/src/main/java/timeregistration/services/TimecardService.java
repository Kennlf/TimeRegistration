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

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public TimecardResponse getSingleTimecard(int timecardId){
        Timecard timecard = timecardRepository.findById(timecardId).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Dette kort findes ikke"));

        return new TimecardResponse(timecard);

    }

    public List<TimecardResponse> getAllTimecards(){
        List<Timecard> timecards = timecardRepository.findAll();
        List<TimecardResponse> response = timecards
                .stream().map(TimecardResponse::new)
                .collect(Collectors.toList());
        return response;
    }

    public List<TimecardResponse> getEmployeeAll(int id) {
        Optional <Employee> employee = employeeRepository.findById(id);
        List<Timecard> employeeTimecards = timecardRepository.findTimecardsByEmployee(employee);
        List<TimecardResponse> response = employeeTimecards
                .stream().map(TimecardResponse::new)
                .collect(Collectors.toList());
        return response;
    }
}
