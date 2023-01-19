package edu.midlands.training.exceptions;

public class VehicleNotFound extends RuntimeException {

    public VehicleNotFound() {
    }

    public VehicleNotFound(String message) {

        super(message);
    }

}