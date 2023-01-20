package edu.midlands.training.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "The vehicle ID you have entered is not in the system")
public class VehicleNotFound extends RuntimeException {
    public VehicleNotFound() {
    }
    public VehicleNotFound(String message) {

        super(message);
    }

}