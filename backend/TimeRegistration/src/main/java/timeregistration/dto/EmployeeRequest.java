package timeregistration.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import timeregistration.entities.Employee;
@NoArgsConstructor
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeRequest {

    private int employeeNumber;
    private String email;
    private String password;

    public static Employee getEmployeeEntity(EmployeeRequest employeeRequest){
        return Employee.builder()
                .employeeNumber(employeeRequest.employeeNumber)
                .email(employeeRequest.email)
                .password(employeeRequest.password)
                .build();
    }

    public EmployeeRequest(Employee employee){
        this.employeeNumber = employee.getEmployeeNumber();
        this.email = employee.getEmail();
        this.password = employee.getPassword();
    }
}
