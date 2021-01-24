package pl.sdacademy.springproject.controller;

public class NoCarFoundException extends RuntimeException {
    public NoCarFoundException(final String message) {
        super(message);
    }
}
