package timeregistration.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import timeregistration.entities.Employee;

public class EmployeeResponse {

    @JsonProperty
    private int employeeNumber;
    @JsonProperty
    private String username;
    @JsonProperty
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
