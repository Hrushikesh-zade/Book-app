package in.stackroute.authservice.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import in.stackroute.authservice.domain.User;

public interface UserRepository extends JpaRepository<User, Integer>{

    Optional<User> findByEmail(String email);

    Optional<User> findByEmailAndPassword(String userName, String password);

    List<User> findByRole(String role);
    
}
