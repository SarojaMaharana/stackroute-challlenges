package com.mehersupreeth.springsecurityexample.service;

import com.mehersupreeth.springsecurityexample.model.User;
import com.mehersupreeth.springsecurityexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean registerUser(User user) {
        final Optional<User> optionalUser = userRepository.findByUserName(user.getUserName());
        if(optionalUser.isEmpty()) {
            userRepository.save(user);
            return true;
        }
        return false;
    }
}
