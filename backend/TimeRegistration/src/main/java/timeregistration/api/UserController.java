package timeregistration.api;

import org.springframework.web.bind.annotation.*;
import timeregistration.dto.UserRequest;
import timeregistration.dto.UserResponse;
import timeregistration.services.UserService;

@RestController
@RequestMapping("api/user")
@CrossOrigin
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public UserResponse addUser(@RequestBody UserRequest body){
        return userService.addUser(body);
    }


}
