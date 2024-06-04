package timeregistration.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import timeregistration.entities.Employee;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeResponse {

    private int employeeNumber;
    private String email;
    private String password;

    public EmployeeResponse(Employee employee){
        this.employeeNumber = employee.getEmployeeNumber();
        this.email = employee.getEmail();
        this.password = employee.getPassword();
    }

}
