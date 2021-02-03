package com.stackroute.user.service;

import com.stackroute.user.model.User;
import com.stackroute.user.util.exception.UserAlreadyExistsException;
import com.stackroute.user.util.exception.UserNotFoundException;

public interface UserService {
    public User findByUserIdAndPassword(String userId, String password) throws UserNotFoundException;
    boolean saveUser(User user) throws UserAlreadyExistsException;
}
