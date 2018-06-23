package com.vanchack.challange.skipthedishes.services.restaurant.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "User does not exist")
public class RestaurantNotExists extends RuntimeException {
}
