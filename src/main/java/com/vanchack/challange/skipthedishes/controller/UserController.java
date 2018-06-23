package com.vanchack.challange.skipthedishes.controller;

import com.vanchack.challange.skipthedishes.domain.User;
import com.vanchack.challange.skipthedishes.services.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> allUsers() {
        return (List<User>) userService.findAll();
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }


}
