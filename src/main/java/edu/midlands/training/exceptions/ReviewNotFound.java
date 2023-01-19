package edu.midlands.training.exceptions;

public class ReviewNotFound extends RuntimeException{
    public ReviewNotFound() {
    }

    public ReviewNotFound(String message) {
        super(message);
    }
}
