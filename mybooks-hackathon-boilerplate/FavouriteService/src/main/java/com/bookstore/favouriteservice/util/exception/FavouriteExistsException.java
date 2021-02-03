package com.bookstore.favouriteservice.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "it is already present")
public class FavouriteExistsException extends Exception {
}
