package com.stackroute.user.service;

import com.stackroute.user.model.User;
import com.stackroute.user.util.exception.UserAlreadyExistsException;
import com.stackroute.user.util.exception.UserIdAndPasswordMismatchException;
import com.stackroute.user.util.exception.UserNotFoundException;

public interface UserAuthService {
	
	/*
	 * Should not modify this interface. You have to implement these methods in
	 * corresponding Impl classes
	 */

    public User findByUserIdAndPassword(String userId, String password) throws UserNotFoundException, UserIdAndPasswordMismatchException;

    boolean saveUser(User user) throws UserAlreadyExistsException;
}
