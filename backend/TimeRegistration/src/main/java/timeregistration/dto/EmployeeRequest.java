package timeregistration.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import timeregistration.entities.Employee;
@NoArgsConstructor
@Getter
public class EmployeeRequest {

    private int employeeNumber;
    private String username;
    private String password;

    public static Employee getEmployeeEntity(EmployeeRequest employeeRequest){
        return Employee.builder()
                .employeeNumber(employeeRequest.employeeNumber)
                .username(employeeRequest.username)
                .password(employeeRequest.password)
                .build();
    }

    public EmployeeRequest(Employee employee){
        this.employeeNumber = employee.getEmployeeNumber();
        this.username = employee.getUsername();
        this.password = employee.getPassword();
    }
}