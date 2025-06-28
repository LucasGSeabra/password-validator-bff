package com.password_validator_bff.password_validator.dto;

import java.util.List;

public record PasswordResponse(
        boolean isValid,
        List<String> messages
) {}
