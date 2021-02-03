package com.stackroute.newz.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "News not found")
public class NewsNotFoundExeption extends Exception {

	private static final long serialVersionUID = 1L;

	public NewsNotFoundExeption(String message) {
		super(message);
	}
}
