package com.stackroute.user.security;

import com.stackroute.user.model.User;
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
        final String jwtToken = Jwts.builder().setIssuer("Newz").setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "newzSecret").compact();
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", jwtToken);
        tokenMap.put("message","Authentication Successful");
        tokenMap.put("username",user.getUserId());
        return tokenMap;
    }
}
