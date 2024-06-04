package timeregistration.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("/")
    public String home() {
        return "hello, home";
    }

    @GetMapping("/secured")
    public String securet(){
        return "Hello secured";
    }
}
