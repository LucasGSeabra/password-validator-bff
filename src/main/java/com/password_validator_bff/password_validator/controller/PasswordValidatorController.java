package com.password_validator_bff.password_validator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/validar")
public class PasswordValidatorController {
    @PostMapping
    public ResponseEntity<String> validatePassword(@RequestBody String password) {
        return ResponseEntity.ok("Requisicao autenticada recebida");
    }
}
