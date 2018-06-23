package com.vanchack.challange.skipthedishes.services.restaurant;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Restaurant already exists")
public class RestaurantAlreadyExists extends RuntimeException {
}
