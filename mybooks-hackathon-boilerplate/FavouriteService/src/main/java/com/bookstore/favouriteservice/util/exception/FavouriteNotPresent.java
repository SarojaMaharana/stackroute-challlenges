package com.bookstore.favouriteservice.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "favourite not present")
public class FavouriteNotPresent extends Exception{

    private static final long serialVersionUID = 1L;

    public FavouriteNotPresent(String message) {
        super(message);
    }
}
