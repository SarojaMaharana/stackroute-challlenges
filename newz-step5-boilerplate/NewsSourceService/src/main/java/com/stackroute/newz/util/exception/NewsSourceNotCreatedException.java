package com.stackroute.newz.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "news source not created")
public class NewsSourceNotCreatedException extends Exception {

	private static final long serialVersionUID = 1L;

	public NewsSourceNotCreatedException(String message) {
		super(message);
	}
}
