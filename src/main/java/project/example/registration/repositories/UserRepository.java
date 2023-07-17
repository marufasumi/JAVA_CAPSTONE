package project.example.registration.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.example.registration.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
