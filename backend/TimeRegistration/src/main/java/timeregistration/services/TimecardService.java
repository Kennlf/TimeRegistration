package timeregistration.services;

import org.springframework.stereotype.Service;
import timeregistration.repositories.TimecardRepository;


@Service
public class TimecardService {



    private TimecardRepository timecardRepository;

    public TimecardService(TimecardRepository timecardRepository){
        this.timecardRepository = timecardRepository;
    }

}
