package com.password_validator_bff.password_validator.dto;

import jakarta.validation.constraints.NotBlank;

public record PasswordRequest(
        @NotBlank(message = "É obrigatório informar uma senha")
        String password
) {}
