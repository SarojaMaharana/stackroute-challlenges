package com.stackroute.user.security;

import com.stackroute.user.model.User;

import java.util.Map;

public interface SecurityTokenGenerator {
    Map<String,String> generateToken(User user);
}
