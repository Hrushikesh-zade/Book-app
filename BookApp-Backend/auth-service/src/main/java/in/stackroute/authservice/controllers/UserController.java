package in.stackroute.authservice.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import in.stackroute.authservice.domain.User;
import in.stackroute.authservice.service.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping({"", "/"})
    public ResponseEntity<User> postCreateUser(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user));

    }

    @GetMapping({"", "/"})
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> allUsers = userService.getAllUsers();
        if (allUsers.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(allUsers);
    }

    @GetMapping({"/{email}"})
    public ResponseEntity<User> getUserByUserName(@PathVariable String email) {
        Optional<User> user = userService.getUserByEmail(email);
        if (user.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(user.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping({"/{email}"})
    public ResponseEntity<User> updateUser(@RequestBody User newUserData, @PathVariable String email) {
        Optional<User> existingBookOpt = userService.getUserByEmail(email);
        if(existingBookOpt.isPresent()){
            User existingBook =  existingBookOpt.get();
            existingBook.setPassword(newUserData.getPassword());
            
            return ResponseEntity.status(HttpStatus.OK).body(userService.update(existingBook));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

}
