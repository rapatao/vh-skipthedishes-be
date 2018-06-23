package com.vanchack.challange.skipthedishes.services.restaurant.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Restaurant contains duplicated data")
public class DuplicatedRestaurantDocumentException extends RuntimeException {
}
