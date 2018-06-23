package com.vanchack.challange.skipthedishes.controller;

import com.vanchack.challange.skipthedishes.domain.User;
import com.vanchack.challange.skipthedishes.services.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping
    public Iterable<User> allUsers() {
        return userService.findAll();
    }


}
