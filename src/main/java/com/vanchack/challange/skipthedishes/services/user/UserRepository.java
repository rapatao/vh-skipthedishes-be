package com.vanchack.challange.skipthedishes.services.user;

import com.vanchack.challange.skipthedishes.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {
}
