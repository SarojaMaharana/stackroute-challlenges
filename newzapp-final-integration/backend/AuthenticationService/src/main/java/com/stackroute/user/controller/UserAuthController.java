package com.stackroute.user.controller;

import com.stackroute.user.service.UserAuthService;
import com.stackroute.user.model.User;
import com.stackroute.user.security.SecurityTokenGenerator;
import com.stackroute.user.util.exception.UserAlreadyExistsException;
import com.stackroute.user.util.exception.UserIdAndPasswordMismatchException;
import com.stackroute.user.util.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/auth")
public class UserAuthController {

    private UserAuthService userAuthService;
    private SecurityTokenGenerator securityTokenGenerator;

    @Autowired
    public UserAuthController(UserAuthService userAuthService, SecurityTokenGenerator securityTokenGenerator) {
        this.userAuthService = userAuthService;
        this.securityTokenGenerator = securityTokenGenerator;
    }

    /*
     * Define a handler method which will create a specific user by reading the
     * Serialized object from request body and save the user details in the
     * database. This handler method should return any one of the status messages
     * basis on different situations:
     * 1. 201(CREATED) - If the user created successfully.
     * 2. 409(CONFLICT) - If the userId conflicts with any existing user,
     * UserAlreadyExistsException is caught.
     *
     * This handler method should map to the URL "/api/v1/auth/register" using HTTP POST method
     */

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User newUser) throws UserAlreadyExistsException {
        return new ResponseEntity<>(userAuthService.saveUser(newUser), HttpStatus.CREATED);
    }

    /*
     * Define a handler method which will authenticate a user by reading the Serialized user
     * object from request body containing the username and password. The username and password should be validated
     * before proceeding ahead with JWT token generation. The user credentials will be validated against the database entries.
     * The error should be return if validation is not successful. If credentials are validated successfully, then JWT
     * token will be generated. The token should be returned back to the caller along with the API response.
     * This handler method should return any one of the status messages basis on different
     * situations:
     * 1. 200(OK) - If login is successful
     * 2. 401(UNAUTHORIZED) - If login is not successful
     *
     * This handler method should map to the URL "/api/v1/auth/login" using HTTP POST method
     */

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) throws UserNotFoundException, UserIdAndPasswordMismatchException {
        final User existingUser = userAuthService.findByUserIdAndPassword(user.getUserId(), user.getPassword());
        Map<String, String> tokenMap = null;
        if(existingUser != null)
            tokenMap = securityTokenGenerator.generateToken(user);
        return new ResponseEntity<>(tokenMap, HttpStatus.OK);
    }

}
