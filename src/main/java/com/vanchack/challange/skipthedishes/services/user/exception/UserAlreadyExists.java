package com.vanchack.challange.skipthedishes.services.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "User already exists")
public class UserAlreadyExists extends RuntimeException {
}
