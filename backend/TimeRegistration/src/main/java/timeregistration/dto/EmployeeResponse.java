package timeregistration.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import timeregistration.entities.Employee;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeResponse {

    private int employeeNumber;
    private String username;
    private String password;

    public EmployeeResponse(Employee employee){
        this.employeeNumber = employee.getEmployeeNumber();
        this.username = employee.getUsername();
        this.password = employee.getPassword();
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
}
