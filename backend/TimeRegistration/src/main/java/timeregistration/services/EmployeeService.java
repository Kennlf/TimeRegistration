package timeregistration.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import timeregistration.dto.EmployeeRequest;
import timeregistration.dto.EmployeeResponse;
import timeregistration.entities.Employee;
import timeregistration.repositories.EmployeeRepository;

import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }
    public EmployeeResponse addEmployee(EmployeeRequest employeeRequest){

        Optional<Employee> employee = employeeRepository.findById(employeeRequest.getEmployeeNumber());
        if(employee.isPresent()){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Dette medarbejdernummer eksistere allerede");
        }
        else{
            Employee newEmployee = EmployeeRequest.getEmployeeEntity(employeeRequest);
            newEmployee = employeeRepository.save(newEmployee);
            return new EmployeeResponse(newEmployee);
        }
    }

    public EmployeeResponse updateEmployee(EmployeeRequest body, int employeeNumber){

        Employee employee = employeeRepository.findById(employeeNumber).orElseThrow(()->
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Medarbejderen kunne ikke findes"));


        employee.setUsername(body.getUsername());
        employee.setPassword(body.getPassword());
        employeeRepository.save(employee);
        return new EmployeeResponse(employee);

    }

    /*public class EmployeeService {
        private List<Employee> userList;

        public EmployeeService() {
            this.userList = new ArrayList<>();
        }

        public HttpStatus addUser(Employee user) {
            if (!userExists(user)) {
                userList.add(user);
                return HttpStatus.CREATED;
            } else {
                return HttpStatus.CONFLICT;
            }
        }

        public HttpStatus findUser(String username) {
            for (Employee user : userList) {
                if (user.getName().equals(username)) {
                    return HttpStatus.OK;
                }
            }
            return HttpStatus.NOT_FOUND;
        }

        private boolean userExists(Employee user) {
            for (Employee existingUser : userList) {
                if (existingUser.getName().equals(user.getName())) {
                    return true;
                }
            }
            return false;
        }*/

}
