package com.stackroute.contactapi.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(ContactExistsException.class)
    public ResponseEntity<String> handleContactExistsException(ContactExistsException exception){
        return new ResponseEntity<>("Contact Already exists", HttpStatus.CONFLICT);
    }
}