package timeregistration.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import timeregistration.dto.TimecardRequest;
import timeregistration.dto.TimecardResponse;
import timeregistration.services.TimecardService;

@RestController
//@RequestMapping("api/timeCard")
@CrossOrigin
public class TimeCardController {

    private TimecardService timecardService;

    public TimeCardController(TimecardService timecardService) {
        this.timecardService = timecardService;
    }

    @PostMapping
    public TimecardResponse addtimeCard(@RequestBody TimecardRequest body){
        return timecardService.addTimeCard(body);
    }


}
