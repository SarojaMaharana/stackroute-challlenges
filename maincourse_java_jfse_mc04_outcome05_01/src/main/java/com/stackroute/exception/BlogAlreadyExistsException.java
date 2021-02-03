package com.stackroute.exception;

public class BlogAlreadyExistsException extends Exception {
    private String message;

    public BlogAlreadyExistsException() {
    }

    public BlogAlreadyExistsException(String message, String message1) {
        super(message);
        this.message = message1;
    }
}
