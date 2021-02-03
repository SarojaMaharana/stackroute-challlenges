package com.bookstore.userservice.security;

import com.bookstore.userservice.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtSecurityTokenGeneratorImpl implements SecurityTokenGenerator {
    @Override
    public Map<String, String> generateToken(User user) {
        final String jwtToken = Jwts.builder().setIssuer("mybook").setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "mybookSecret").compact();
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", jwtToken);
        tokenMap.put("message", "Authentication Successful");
        return tokenMap;
    }
}
