package timeregistration.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeNumber;
    private String email;
    private String password; //Char array kan erstatte string for højere sikkerhed
    //forskel på adgang for medarbejder, leder og eventuelt myndighedsadgang

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Timecard> timecardList = new ArrayList<>();


    public void addTimecard(Timecard timecard){
        timecardList.add(timecard);
    }


}


