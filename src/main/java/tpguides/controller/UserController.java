package tpguides.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tpguides.model.User;
import tpguides.repository.UserRepository;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Suche Benutzer basierend auf dem Benutzernamen
    @GetMapping("/search")
    public ResponseEntity<?> searchUser(@RequestParam("username") String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Benutzer nicht gefunden");
    }
}
