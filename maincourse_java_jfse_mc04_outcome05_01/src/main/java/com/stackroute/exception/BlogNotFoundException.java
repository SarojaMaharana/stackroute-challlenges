package com.stackroute.exception;

public class BlogNotFoundException extends Exception{
    private String message;

    public BlogNotFoundException() {
    }

    public BlogNotFoundException(String message, String message1) {
        super(message);
        this.message = message1;
    }
}
