package com.vanchack.challange.skipthedishes.services.user;

import com.vanchack.challange.skipthedishes.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findUserByUsername(String username);

}
