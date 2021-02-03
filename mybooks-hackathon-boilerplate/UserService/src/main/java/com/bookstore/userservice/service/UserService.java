package com.bookstore.userservice.service;

import com.bookstore.userservice.model.User;
import com.bookstore.userservice.util.exception.UserAlreadyExistsException;
import com.bookstore.userservice.util.exception.UserIdAndPasswordMismatchException;
import com.bookstore.userservice.util.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public User findByUserIdAndPassword(String userId, String password) throws UserNotFoundException, UserIdAndPasswordMismatchException;
    boolean saveUser(User user) throws UserAlreadyExistsException;

}
