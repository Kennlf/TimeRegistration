package timeregistration.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;
import timeregistration.repositories.UserRepository;
import timeregistration.services.UserService;

@Controller
public class Setup implements ApplicationRunner {
    UserService userService;
    UserRepository userRepository;

    public Setup(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }
    @Override
    public void run(ApplicationArguments args) throws Exception{

    }
}
