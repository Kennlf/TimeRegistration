package timeregistration.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Employee {
    @Id
    private int employeeNumber;
    private String username;
    private String password; //Char array kan erstatte string for højere sikkerhed
    //forskel på adgang for medarbejder, leder og eventuelt myndighedsadgang


}


