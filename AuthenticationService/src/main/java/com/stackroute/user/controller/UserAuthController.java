package com.stackroute.user.controller;

import com.stackroute.user.model.User;
import com.stackroute.user.service.UserService;
import com.stackroute.user.util.JwtUtil;
import com.stackroute.user.util.exception.UserAlreadyExistsException;
import com.stackroute.user.util.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
public class UserAuthController {

    private JwtUtil jwtUtil;
    private AuthenticationManager authenticationManager;
    private UserService userService;

    @Autowired
    public UserAuthController(JwtUtil jwtUtil, AuthenticationManager authenticationManager, UserService userService) {
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }

    @GetMapping
    public String welcome() {
        return "welcome";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User newUser) throws UserAlreadyExistsException {
        return new ResponseEntity<>(userService.saveUser(newUser), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) throws UserNotFoundException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserId(), user.getPassword()));
        } catch (Exception e) {
            throw new UserNotFoundException("User not found");
        }
        final String jwtToken = jwtUtil.generateToken(user.getUserId());
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", jwtToken);
        tokenMap.put("message","Authentication Successful");
        return new ResponseEntity<>(tokenMap, HttpStatus.OK);
    }

}
