package dev.hint13.bjs.exceptions;

public class NotEnoughSpaceException extends RuntimeException {
    public NotEnoughSpaceException(String message) {
        super(message);
    }
}
