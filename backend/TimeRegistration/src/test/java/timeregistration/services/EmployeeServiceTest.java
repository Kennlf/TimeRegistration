package timeregistration.services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import timeregistration.dto.EmployeeRequest;
import timeregistration.dto.EmployeeResponse;
import timeregistration.entities.Employee;
import timeregistration.repositories.EmployeeRepository;

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
        Employee employee1 = new Employee(123, "Morten1", "qwerty");
        Employee employee2 = new Employee(321, "Jens2", "qqqq");
        Employee employee3 = new Employee(555, "Harry Potter", "ihateron");

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
        Employee employee = new Employee(999, "Jørgen", "Fido123");
        EmployeeRequest employeeRequest = new EmployeeRequest(employee);
        EmployeeResponse response = employeeService.addEmployee(employeeRequest);
        assertEquals(999, response.getEmployeeNumber());
    }

    @Test
    void updateEmployee() {
        EmployeeRequest employeeRequest = new EmployeeRequest(new Employee(555, "Harry P", "ihateron"));
        //employeeService.addEmployee(employeeRequest);
        employeeService.updateEmployee(employeeRequest, 555);

        EmployeeResponse employeeResponse = employeeService.getSingleEmployee(555);
        assertEquals(555, employeeResponse.getEmployeeNumber());
        assertEquals("Harry P", employeeResponse.getUsername());

    }
}