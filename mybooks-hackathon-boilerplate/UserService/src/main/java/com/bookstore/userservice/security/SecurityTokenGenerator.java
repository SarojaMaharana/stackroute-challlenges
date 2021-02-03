package com.bookstore.userservice.security;

import com.bookstore.userservice.model.User;

import java.util.Map;

public interface SecurityTokenGenerator {

    Map<String,String> generateToken(User user);

}
