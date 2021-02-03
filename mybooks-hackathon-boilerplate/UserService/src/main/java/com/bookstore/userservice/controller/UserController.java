package com.bookstore.userservice.controller;

import com.bookstore.userservice.model.Credentials;
import com.bookstore.userservice.model.User;
import com.bookstore.userservice.security.SecurityTokenGenerator;
import com.bookstore.userservice.service.UserService;
import com.bookstore.userservice.util.exception.UserAlreadyExistsException;
import com.bookstore.userservice.util.exception.UserIdAndPasswordMismatchException;
import com.bookstore.userservice.util.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private UserService userService;
    private SecurityTokenGenerator securityTokenGenerator;

    @Autowired
    public UserController(UserService userService, SecurityTokenGenerator securityTokenGenerator) {
        this.userService = userService;
        this.securityTokenGenerator = securityTokenGenerator;
    }

    @PostMapping("/auth/register")
    public ResponseEntity<?> registerUser(@RequestBody User newUser) throws UserAlreadyExistsException {
        return new ResponseEntity<>(userService.saveUser(newUser), HttpStatus.CREATED);
    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody Credentials user) throws UserNotFoundException, UserIdAndPasswordMismatchException {
        final User existingUser = userService.findByUserIdAndPassword(user.getUserId(), user.getPassword());
        Map<String, String> tokenMap = null;
        if(existingUser != null)
            tokenMap = securityTokenGenerator.generateToken(existingUser);
        return new ResponseEntity<>(tokenMap, HttpStatus.OK);
    }

    @GetMapping("/user/welcome")
    public String welcome() {
        return "Welcome to users";
    }
}
