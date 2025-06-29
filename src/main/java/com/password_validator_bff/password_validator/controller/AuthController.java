package com.password_validator_bff.password_validator.controller;

import com.password_validator_bff.password_validator.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/token")
    public ResponseEntity<Map<String, String>> getToken() {
        String token = authService.getAccessToken();
        return ResponseEntity.ok(Map.of("access_token", token));
    }
}
