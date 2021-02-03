package com.stackroute.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = BlogAlreadyExistsException.class)
    public ResponseEntity<String> blogAlreadyExistsException(BlogAlreadyExistsException blogAlreadyExistsException) {
        return new ResponseEntity<String>("Blog Already Exists", HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = BlogNotFoundException.class)
    public ResponseEntity<String> blogNotFoundException(BlogNotFoundException blogNotFoundException) {
        return new ResponseEntity<String>("Blog Not Found", HttpStatus.NOT_FOUND);
    }
}
