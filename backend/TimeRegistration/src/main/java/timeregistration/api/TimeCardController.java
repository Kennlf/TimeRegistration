package timeregistration.api;

import org.springframework.web.bind.annotation.*;
import timeregistration.dto.TimecardRequest;
import timeregistration.dto.TimecardResponse;
import timeregistration.services.TimecardService;

import java.util.List;

@RestController
@RequestMapping("api/timecard")
@CrossOrigin
public class TimeCardController {

    private TimecardService timecardService;

    public TimeCardController(TimecardService timecardService) {
        this.timecardService = timecardService;
    }

    //Session cookie til id - HttpOnly cookie
    @PostMapping("/add/{id}")
    public TimecardResponse addtimeCard(@RequestBody TimecardRequest body, @PathVariable int id){
        // check id mod database at brugeren eksistere.
        System.out.println("Modtaget timeseddel request: " + body);
        return timecardService.addTimeCard(body, id);
    }

    @GetMapping("/find/{id}")
    public TimecardResponse showSpecificTimecard(@PathVariable int id){


        return timecardService.getSingleTimecard(id);
    }
    @GetMapping("/getAll")
    public List<TimecardResponse> getAllTimeCard(){
        List<TimecardResponse> response = timecardService.getAllTimecards();
        return response;
    }

    @GetMapping("/getEmployeeTimecard/{id}")
    public List<TimecardResponse> getEmployeeTimecard(@PathVariable int id){
        List<TimecardResponse> response = timecardService.getEmployeeAll(id);
        return response;
    }

}
