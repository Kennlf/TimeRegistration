package timeregistration.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;
import timeregistration.repositories.EmployeeRepository;
import timeregistration.services.EmployeeService;

@Controller
public class Setup implements ApplicationRunner {
    EmployeeService employeeService;
    EmployeeRepository employeeRepository;

    public Setup(EmployeeService employeeService, EmployeeRepository employeeRepository) {
        this.employeeService = employeeService;
        this.employeeRepository = employeeRepository;
    }
    @Override
    public void run(ApplicationArguments args) throws Exception{

    }
}
