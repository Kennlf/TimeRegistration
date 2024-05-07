package timeregistration.services;

import org.springframework.stereotype.Service;
import timeregistration.dto.TimecardRequest;
import timeregistration.dto.TimecardResponse;
import timeregistration.entities.Timecard;
import timeregistration.repositories.TimecardRepository;

@Service
public class TimecardService {


    private TimecardRepository timecardRepository;

    public TimecardService(TimecardRepository timecardRepository){
        this.timecardRepository = timecardRepository;
    }

    public TimecardResponse addTimeCard(TimecardRequest timecardRequest) {
        //Skal der laves check af dato og eller tid?
        //Skal vi tjekke andet?
        //Hvad gør vi når folk udfylder for flere dage?
        Timecard newTimecard = TimecardRequest.getTimecardEntity(timecardRequest);
        return new TimecardResponse(newTimecard);
    }
}
