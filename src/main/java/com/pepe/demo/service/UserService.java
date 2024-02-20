package com.pepe.demo.service;

import com.pepe.demo.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Value("${jwt.secret}")
    private String secretKey;

    private Long expiredAtMs = 1000 * 60 * 60l;

    public String login(String userName, String password){
        return JwtUtil.createJwt(userName, secretKey, expiredAtMs);
    }
}
