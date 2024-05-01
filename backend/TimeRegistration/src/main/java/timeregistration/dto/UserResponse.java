package timeregistration.dto;

import timeregistration.entities.User;

public class UserResponse {

    private int employeeNumber;
    private String username;
    private String password;

    public UserResponse(User user){
        this.employeeNumber = user.getEmployeeNumber();
        this.username = user.getUsername();
        this.password = user.getPassword();
    }
}
