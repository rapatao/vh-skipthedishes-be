package com.vanchack.challange.skipthedishes.services.user;

import com.vanchack.challange.skipthedishes.domain.User;
import com.vanchack.challange.skipthedishes.services.user.exception.UserAlreadyExistsException;
import com.vanchack.challange.skipthedishes.services.user.exception.UserNotExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public User addUser(User user) {
        Optional<User> byId = userRepository.findUserByUsername(user.getUsername());

        if (byId.isPresent()) {
            throw new UserAlreadyExistsException();
        }

        user.setDateSign(Instant.now());
        user.setId(null);
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        Optional<User> byId = userRepository.findById(user.getId());
        if (!byId.isPresent()) {
            throw new UserNotExistsException();
        }

        user.setDateSign(byId.get().getDateSign());

        return userRepository.save(user);
    }

    public Optional<User> byId(Integer id) {
        return userRepository.findById(id);
    }
}
