package com.bookstore.userservice.service;

import com.bookstore.userservice.model.User;
import com.bookstore.userservice.repository.UserRepository;
import com.bookstore.userservice.util.exception.UserAlreadyExistsException;
import com.bookstore.userservice.util.exception.UserIdAndPasswordMismatchException;
import com.bookstore.userservice.util.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByUserIdAndPassword(final String userId, final String password) throws UserNotFoundException, UserIdAndPasswordMismatchException {
        final Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()) throw new UserNotFoundException("User is not found");
        final User existingUser = userRepository.findByUserIdAndPassword(userId, password);
        if(existingUser == null) throw new UserIdAndPasswordMismatchException("UserId or password is incorrect");
        return existingUser;
    }

    @Override
    public boolean saveUser(final User user) throws UserAlreadyExistsException {
        user.setCreatedAt(new Date());
        user.setUpdatedAt(new Date());
        if(userRepository.findById(user.getUserId()).isPresent()) throw new UserAlreadyExistsException("User already Exists");
        userRepository.save(user);
        return true;
    }
}
