package com.vanchack.challange.skipthedishes.services.user;

import com.vanchack.challange.skipthedishes.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User save(final User user) {
        return userRepository.save(user);
    }

    public Optional<User> findById(final UUID uuid) {
        return userRepository.findById(uuid);
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

}
