package timeregistration.dto;

import timeregistration.entities.Employee;

public class EmployeeResponse {

    private int employeeNumber;
    private String username;
    private String password;

    public EmployeeResponse(Employee employee){
        this.employeeNumber = employee.getEmployeeNumber();
        this.username = employee.getUsername();
        this.password = employee.getPassword();
    }
}
