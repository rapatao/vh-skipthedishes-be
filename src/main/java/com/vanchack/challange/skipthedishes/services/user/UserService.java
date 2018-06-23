package com.vanchack.challange.skipthedishes.services.user;

import com.vanchack.challange.skipthedishes.domain.User;
import com.vanchack.challange.skipthedishes.services.user.exception.UserAlreadyExists;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
            throw new UserAlreadyExists();
        }

        user.setUserid(null);
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        Optional<User> byId = userRepository.findById(user.getUserid());
        if (!byId.isPresent()) {
            throw new UserNotExists();
        }

        return userRepository.save(user);
    }
}