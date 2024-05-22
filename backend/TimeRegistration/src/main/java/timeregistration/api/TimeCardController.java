package timeregistration.api;

import org.springframework.web.bind.annotation.*;
import timeregistration.dto.TimecardRequest;
import timeregistration.dto.TimecardResponse;
import timeregistration.services.TimecardService;

@RestController
@RequestMapping("api/timecard")
@CrossOrigin
public class TimeCardController {

    private TimecardService timecardService;

    public TimeCardController(TimecardService timecardService) {
        this.timecardService = timecardService;
    }

    //Session cookie til id - HttpOnly cookie
    @PostMapping("/test/{id}")
    public TimecardResponse addtimeCard(@RequestBody TimecardRequest body, @PathVariable int id){
        // check id mod database at brugeren eksistere.

        return timecardService.addTimeCard(body, id);
    }

    @GetMapping("/find/{id}")
    public TimecardResponse showSpecificTimecard(@PathVariable int id){


        return timecardService.getSingleTimecard(id);
    }


}
