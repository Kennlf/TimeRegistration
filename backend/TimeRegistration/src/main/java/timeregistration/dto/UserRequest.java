package timeregistration.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import timeregistration.entities.Employee;
@NoArgsConstructor
@Getter
public class UserRequest {


    private int employeeNumber;
    private String username;
    private String password;

    public static Employee getUserEntity(UserRequest userRequest){
        return Employee.builder()
                .employeeNumber(userRequest.employeeNumber)
                .username(userRequest.username)
                .password(userRequest.password)
                .build();
    }



    public UserRequest(Employee employee){
        this.employeeNumber = employee.getEmployeeNumber();
        this.username = employee.getUsername();
        this.password = employee.getPassword();

    }
}
