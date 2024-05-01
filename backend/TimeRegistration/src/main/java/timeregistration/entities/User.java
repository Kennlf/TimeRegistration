package timeregistration.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name= "user")
public class User {

    @Id
    private int employeeNumber;
    private String username;
    private String password; //Char arroy kan erstatte string for højere sikkerhed
    //forskel på adgang for medarbejder, leder og eventuelt myndighedsadgang


}


