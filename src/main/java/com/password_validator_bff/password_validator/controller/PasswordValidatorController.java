package com.password_validator_bff.password_validator.controller;

import com.password_validator_bff.password_validator.dto.PasswordRequest;
import com.password_validator_bff.password_validator.dto.PasswordResponse;
import com.password_validator_bff.password_validator.service.PasswordValidatorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/validar")
public class PasswordValidatorController {

    private final PasswordValidatorService service;

    public PasswordValidatorController(PasswordValidatorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PasswordResponse> validatePassword(@RequestBody @Valid PasswordRequest request) {
        PasswordResponse response = service.validate(request.password());

        return ResponseEntity.ok(response);
    }
}
