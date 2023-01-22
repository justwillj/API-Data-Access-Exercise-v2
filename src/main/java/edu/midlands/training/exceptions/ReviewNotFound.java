package edu.midlands.training.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "The review ID you have entered is not in the system")
public class ReviewNotFound extends RuntimeException{
    public ReviewNotFound() {
    }

    public ReviewNotFound(String message) {
        super(message);
    }
}
