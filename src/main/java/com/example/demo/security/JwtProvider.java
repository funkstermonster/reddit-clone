package com.example.demo.security;

import com.example.demo.service.UserDetailsImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.Instant;

import static io.jsonwebtoken.Jwts.parserBuilder;
import static java.util.Date.from;

@Service
public class JwtProvider {


    private String secretkey;

    @PostConstruct
    public void init() {
        secretkey = "secret";

    }

    public String generateToken(Authentication authentication) {
        UserDetailsImpl principal = (UserDetailsImpl) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(principal.getUsername())
                .signWith(SignatureAlgorithm.HS512, secretkey)
                .compact();
    }

    public String generateTokenWithUsername(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(from(Instant.now()))
                .signWith(SignatureAlgorithm.HS512, secretkey)
                .compact();
    }

    private String getPrivateKey() {
        return secretkey;
    }

    public boolean validateToken(String jwt) {
       try {
           parserBuilder().setSigningKey(secretkey).build().parseClaimsJws(jwt);
           return true;
       } catch (JwtException e) {
           System.err.println(e.getMessage());
       }
       return false;
    }


    public String getUsernameFromJwt(String token) {
        Claims claims = parserBuilder()
                .setSigningKey(secretkey)
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }


}
