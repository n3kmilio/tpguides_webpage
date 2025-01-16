package tpguides.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tpguides.model.Guide;
import tpguides.model.User;
import tpguides.repository.GuideRepository;
import tpguides.repository.UserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Benutzer nicht gefunden (searchUser)");
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> getUserByUsername(@PathVariable String username) {

        Optional<User> user = userRepository.findByUsername(username);

        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Benutzer nicht gefunden (getUser)");
        }
    }

    @PostMapping("/myprofile")
    public ResponseEntity<?> updateUser(@RequestParam("username") String username, @RequestParam("description") String description) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            user.get().setDescription(description);
            user.get().setUsername(username);
            userRepository.save(user.get());

            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Benutzer nicht gefunden (updateUser)");
        }
    }
}
