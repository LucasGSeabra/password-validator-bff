package com.password_validator_bff.password_validator.dto;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class PasswordRequestTest {

    private Validator validator;

    @BeforeEach
    void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void shouldPassValidationWhenPasswordIsNotBlank() {
        PasswordRequest request = new PasswordRequest("senha123");
        Set<ConstraintViolation<PasswordRequest>> violations = validator.validate(request);

        assertThat(violations).isEmpty();
    }

    @Test
    void shouldFailValidationWhenPasswordIsBlank() {
        PasswordRequest request = new PasswordRequest("   ");
        Set<ConstraintViolation<PasswordRequest>> violations = validator.validate(request);

        assertThat(violations).isNotEmpty();
        assertThat(violations).anyMatch(v -> v.getMessage().equals("É obrigatório informar uma senha"));
    }

    @Test
    void shouldFailValidationWhenPasswordIsNull() {
        PasswordRequest request = new PasswordRequest(null);
        Set<ConstraintViolation<PasswordRequest>> violations = validator.validate(request);

        assertThat(violations).isNotEmpty();
        assertThat(violations).anyMatch(v -> v.getMessage().equals("É obrigatório informar uma senha"));
    }
}
