package com.hackathon.hackathon.controller;

import com.hackathon.hackathon.common.JwtUtil;
import com.hackathon.hackathon.entity.UserEntity;
import com.hackathon.hackathon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserEntity user) {
        System.out.println("---------------------------");
        System.out.println("UserId:" + user.getUserId());
        System.out.println("Password:" + user.getPassword());

        UserEntity authenticatedUser = userService.authenticate(user.getUserId(), user.getPassword());

        //System.out.println("authenticatedUser:" + authenticatedUser.getUserId());
        System.out.println("sono3");
        if (authenticatedUser != null) {
            System.out.println("sono4:" + authenticatedUser.getUserId());
            String token = JwtUtil.generateToken(authenticatedUser.getUserId());

            return ResponseEntity.ok(new AuthResponse(token));
        } else {
            System.out.println("sono5:");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    public static class AuthResponse {
        private String token;

        public AuthResponse(String token) {
            this.token = token;
        }

        public String getToken() {
            return token;
        }
    }
}
