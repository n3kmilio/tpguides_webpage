package tpguides.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tpguides.model.User;
import tpguides.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
