package timeregistration.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;
import timeregistration.entities.Employee;
import timeregistration.entities.Timecard;
import timeregistration.repositories.EmployeeRepository;
import timeregistration.repositories.TimecardRepository;
import timeregistration.services.EmployeeService;
import timeregistration.services.TimecardService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Setup implements ApplicationRunner {
    EmployeeService employeeService;
    EmployeeRepository employeeRepository;
    TimecardService timecardService;
    TimecardRepository timecardRepository;

    public Setup(EmployeeService employeeService, EmployeeRepository employeeRepository, TimecardService timecardService, TimecardRepository timecardRepository) {
        this.employeeService = employeeService;
        this.employeeRepository = employeeRepository;
        this.timecardService = timecardService;
        this.timecardRepository = timecardRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception{

        List<Timecard> emptyList = new ArrayList<>();
        Employee employee1 = new Employee(123, "RonWeasly", "qwerty", emptyList);
        Employee employee2 = new Employee(321, "Terkel", "qqqq", emptyList);
        Employee employee3 = new Employee(555, "JohnDoe", "ihateron", emptyList);

        employeeRepository.save(employee1);
        employeeRepository.save(employee2);
        employeeRepository.save(employee3);

    }
}
