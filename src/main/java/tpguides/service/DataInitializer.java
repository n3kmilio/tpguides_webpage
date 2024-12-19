package tpguides.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tpguides.model.Role;
import tpguides.model.User;
import tpguides.repository.RoleRepository;
import tpguides.repository.UserRepository;

import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public DataInitializer(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Rollen initialisieren
        if (roleRepository.count() == 0) {
            Role adminRole = new Role("ADMIN");
            Role modRole = new Role("MOD");
            Role userRole = new Role("USER");
            roleRepository.save(adminRole);
            roleRepository.save(modRole);
            roleRepository.save(userRole);
        }

        // Benutzer initialisieren
        if (userRepository.count() == 0) {
            Role adminRole = roleRepository.findByName("ADMIN");
            Role userRole = roleRepository.findByName("USER");

            User admin = new User("admin", "admin123", Set.of(adminRole, userRole));
            User user = new User("user", "user123", Set.of(userRole));

            userRepository.save(admin);
            userRepository.save(user);
        }
    }
}