package tpguides.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tpguides.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
