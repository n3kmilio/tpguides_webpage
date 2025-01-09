package tpguides;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import tpguides.model.Role;
import tpguides.model.User;
import tpguides.repository.UserRepository;
import tpguides.repository.RoleRepository;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class TpguidesApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(TpguidesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Rollen erstellen
		Role adminRole = new Role("ADMIN");
		Role userRole = new Role("USER");

		// Rollen in die DB speichern
		roleRepository.save(adminRole);
		roleRepository.save(userRole);

		// Benutzer erstellen
		Set<Role> adminRoles = new HashSet<>();
		adminRoles.add(adminRole);
		adminRoles.add(userRole);

		Set<Role> userRoles = new HashSet<>();
		userRoles.add(userRole);

		User adminUser = new User("admin", "admin123","admin@admin.de",adminRoles);
		User regularUser = new User("user", "user123","user@user.de", userRoles);

		// Benutzer in die DB speichern
		userRepository.save(adminUser);
		userRepository.save(regularUser);

		System.out.println("Daten wurden erfolgreich in die Datenbank eingefügt!");
	}
}
