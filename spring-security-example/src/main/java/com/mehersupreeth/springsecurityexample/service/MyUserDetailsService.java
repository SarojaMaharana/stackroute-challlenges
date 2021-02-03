package com.mehersupreeth.springsecurityexample.service;

import com.mehersupreeth.springsecurityexample.model.MyUserDetails;
import com.mehersupreeth.springsecurityexample.model.User;
import com.mehersupreeth.springsecurityexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByUserName(userName);
        if (optionalUser.isEmpty()) throw new UsernameNotFoundException("Not Found: " +userName);
        return new MyUserDetails(optionalUser.get());
    }
}
