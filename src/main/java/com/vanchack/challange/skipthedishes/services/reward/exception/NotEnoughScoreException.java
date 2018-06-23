package com.vanchack.challange.skipthedishes.services.reward.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN, reason = "Uses does not have enough score")
public class NotEnoughScoreException extends RuntimeException {
}
