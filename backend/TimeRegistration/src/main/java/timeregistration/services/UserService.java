package timeregistration.services;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import timeregistration.dto.UserRequest;
import timeregistration.dto.UserResponse;
import timeregistration.entities.Employee;
import timeregistration.repositories.UserRepository;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public UserResponse addUser(UserRequest userRequest){

        Optional<Employee> employee = userRepository.findById(userRequest.getEmployeeNumber());
        if(employee.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Dette medarbejdernummer eksistere allerede");
        }
        else{
            Employee newUser = UserRequest.getUserEntity(userRequest);
            newUser = userRepository.save(newUser);
            return new UserResponse(newUser);
        }

    }

    /*public class UserService {
        private List<Employee> userList;

        public UserService() {
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
