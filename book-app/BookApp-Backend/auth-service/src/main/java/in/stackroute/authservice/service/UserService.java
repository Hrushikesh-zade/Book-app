package in.stackroute.authservice.service;

import java.util.List;
import java.util.Optional;
import in.stackroute.authservice.domain.User;

public interface UserService {

    
    public User saveUser(User user);
    
    public User updateUser(User user);
    
    public void deleteUser(User user);

    public List<User> getAllUsers();

    public User update(User user);

    public Optional<User> getUserById(String id);
    
    public Optional<User> getUserByEmail(String email);
    
    public Optional<User> getUserByEmailAndPassword(String email, String password);
    
}
