package timeregistration.dto;

import lombok.NoArgsConstructor;
import timeregistration.entities.User;

@NoArgsConstructor
public class UserRequest {


    private int employeeNumber;
    private String username;
    private String password;

    public static User getUserEntity(UserRequest userRequest){
        return User.builder()
                .employeeNumber(userRequest.employeeNumber)
                .username(userRequest.username)
                .password(userRequest.password)
                .build();
    }



    public UserRequest(User user){
        this.employeeNumber = user.getEmployeeNumber();
        this.username = user.getUsername();
        this.password = user.getPassword();

    }
}
