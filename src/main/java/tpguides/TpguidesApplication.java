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

	}
}
