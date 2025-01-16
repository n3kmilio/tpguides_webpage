package tpguides.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;
import tpguides.model.Role;
import tpguides.model.User;
import tpguides.repository.RoleRepository;
import tpguides.repository.UserRepository;

import java.util.Set;

class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}

@RestController
public class RegistrationContoller {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @PostMapping(value = "/register", consumes = "application/json")
    public User createUser(@RequestBody User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("Ein Benutzer mit dieser Email existiert bereits.");
        }
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new UserAlreadyExistsException("EIn Benutzer mit disem Username existiert bereits");
        }
        Role userRole = roleRepository.findByName("USER");
        user.setDescription("Hallo ich bin ein neuer User");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Set.of(userRole));
        return userRepository.save(user);

    }
}


