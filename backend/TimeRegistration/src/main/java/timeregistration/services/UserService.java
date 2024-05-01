package timeregistration.services;


import org.springframework.stereotype.Service;
import timeregistration.entities.User;
import timeregistration.repositories.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

}
