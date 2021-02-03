package com.stackroute.user.service;

import com.stackroute.user.model.User;
import com.stackroute.user.repository.UserRepository;
import com.stackroute.user.util.exception.UserAlreadyExistsException;
import com.stackroute.user.util.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByUserIdAndPassword(String userId, String password) throws UserNotFoundException {
        return null;
    }

    @Override
    public boolean saveUser(User user) throws UserAlreadyExistsException {
        if(userRepository.findById(user.getUserId()).isPresent()) throw new UserAlreadyExistsException("user already exists");
        userRepository.save(user);
        return true;
    }
}
