package timeregistration.services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import timeregistration.dto.EmployeeRequest;
import timeregistration.dto.EmployeeResponse;
import timeregistration.entities.Employee;
import timeregistration.entities.Timecard;
import timeregistration.repositories.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class EmployeeServiceTest {

    private EmployeeService employeeService;
    private static EmployeeRepository employeeRepository;



    @BeforeAll
    public static void setUpTestData(@Autowired EmployeeRepository employee_Repository) {
        employeeRepository = employee_Repository;
        employeeRepository.deleteAll();
        List<Timecard> emptyList = new ArrayList<>();
        Employee employee1 = new Employee(123, "Morten1", "qwerty", emptyList);
        Employee employee2 = new Employee(321, "Jens2", "qqqq", emptyList);
        Employee employee3 = new Employee(555, "Harry Potter", "ihateron", emptyList);

        employeeRepository.save(employee1);
        employeeRepository.save(employee2);
        employeeRepository.save(employee3);
    }

    @BeforeEach
    public void initEmployeeService(){
        employeeService = new EmployeeService(employeeRepository);
    }

    @Test
    void addEmployee() {
        List<Timecard> emptyList = new ArrayList<>();
        Employee employee = new Employee(999, "Jørgen", "Fido123",emptyList);
        EmployeeRequest employeeRequest = new EmployeeRequest(employee);
        EmployeeResponse response = employeeService.addEmployee(employeeRequest);
        assertEquals(999, response.getEmployeeNumber());
    }

    @Test
    void updateEmployee() {
        List<Timecard> emptyList = new ArrayList<>();
        EmployeeRequest employeeRequest = new EmployeeRequest(new Employee(555, "Harry P", "ihateron", emptyList));
        //employeeService.addEmployee(employeeRequest);
        employeeService.updateEmployee(employeeRequest, 555);

        EmployeeResponse employeeResponse = employeeService.getSingleEmployee(555);
        assertEquals(555, employeeResponse.getEmployeeNumber());
        assertEquals("Harry P", employeeResponse.getUsername());

    }
}