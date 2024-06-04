package timeregistration.api;

import org.springframework.web.bind.annotation.*;
import timeregistration.dto.EmployeeRequest;
import timeregistration.dto.EmployeeResponse;
import timeregistration.services.EmployeeService;

@RestController
@RequestMapping("api/user")
@CrossOrigin
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @PostMapping("/register")
    public EmployeeResponse addEmployee(@RequestBody EmployeeRequest body){

        return employeeService.addEmployee(body);
    }

    @PostMapping("/update/{employeeNumber}")
    public EmployeeResponse updateEmployee(@RequestBody EmployeeRequest body, @PathVariable int employeeNumber){
        return  employeeService.updateEmployee(body, employeeNumber);
    }
}
