package com.pepe.demo.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtil {

    public static String createJwt(String userName, String secretKey, Long expiredMs) {
       Claims claims = Jwts.claims();
       claims.put("userName", userName);

       return Jwts.builder()
               .setClaims(claims)
               .setIssuedAt(new Date(System.currentTimeMillis()))
               .setExpiration(new Date(System.currentTimeMillis() + expiredMs))
               .signWith(SignatureAlgorithm.HS256, secretKey)
               .compact();

    }
}
