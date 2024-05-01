package timeregistration.dto;

import lombok.NoArgsConstructor;
import timeregistration.entities.User;

@NoArgsConstructor
public class UserReqeust {


    private int employeeNumber;
    private String username;
    private String password;

    public static User getUserEntity(UserReqeust userReqeust){
        return User.builder()
                .employeeNumber(userReqeust.employeeNumber)
                .username(userReqeust.username)
                .password(userReqeust.password)
                .build();
    }



    public UserReqeust(User user){
        this.employeeNumber = user.getEmployeeNumber();
        this.username = user.getUsername();
        this.password = user.getPassword();

    }
}
