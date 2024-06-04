package timeregistration.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import timeregistration.dto.EmployeeRequest;
import timeregistration.dto.EmployeeResponse;
import timeregistration.entities.Employee;
import timeregistration.repositories.EmployeeRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public EmployeeResponse getSingleEmployee(int employeeNumber){
        Employee employee = employeeRepository.findById(employeeNumber).orElseThrow(()->
                 new ResponseStatusException(HttpStatus.NOT_FOUND, "Medarbejderen med dette medarbejder nummer kan ikke findes"));
        EmployeeResponse employeeResponse = new EmployeeResponse(employee);
        return employeeResponse;
    }

    public EmployeeResponse updateEmployee(EmployeeRequest body, int employeeNumber){

        Employee employee = employeeRepository.findById(employeeNumber).orElseThrow(()->
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Medarbejderen kunne ikke findes"));


        employee.setEmail(body.getEmail());
        employee.setPassword(body.getPassword());
        employeeRepository.save(employee);
        return new EmployeeResponse(employee);

    }

    public List<EmployeeResponse> getAllEmployees(){
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeResponse> response = employees
                .stream().map(EmployeeResponse::new)
                .collect(Collectors.toList());
        return response;
    }

    /*public class EmployeeService {
        private List<EmployeeImpl> userList;

        public EmployeeService() {
            this.userList = new ArrayList<>();
        }

        public HttpStatus addUser(EmployeeImpl user) {
            if (!userExists(user)) {
                userList.add(user);
                return HttpStatus.CREATED;
            } else {
                return HttpStatus.CONFLICT;
            }
        }

        public HttpStatus findUser(String username) {
            for (EmployeeImpl user : userList) {
                if (user.getName().equals(username)) {
                    return HttpStatus.OK;
                }
            }
            return HttpStatus.NOT_FOUND;
        }

        private boolean userExists(EmployeeImpl user) {
            for (EmployeeImpl existingUser : userList) {
                if (existingUser.getName().equals(user.getName())) {
                    return true;
                }
            }
            return false;
        }*/

}
