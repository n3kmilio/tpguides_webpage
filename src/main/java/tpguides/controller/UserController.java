package tpguides.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tpguides.model.User;
import tpguides.repository.UserRepository;
import tpguides.service.UserService;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    private UserService userService;

    // Suche Benutzer basierend auf dem Benutzernamen
    @GetMapping("/search")
    public ResponseEntity<?> searchUser(@RequestParam("username") String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Benutzer nicht gefunden");
    }

    public Optional<User> getUserByUsername(@PathVariable String username) {
        System.out.println("API-Aufruf für Benutzer: " + username);
        return userService.findByUsername(username);
    }
}
