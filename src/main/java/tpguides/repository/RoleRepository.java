package tpguides.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tpguides.model.Role;



public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
