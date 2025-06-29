package com.password_validator_bff.password_validator.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.password_validator_bff.password_validator.dto.PasswordResponse;

public class PasswordValidatorServiceTests {

    private PasswordValidatorService service;

    @BeforeEach
    public void setup() {
        service = new PasswordValidatorService();
    }

    @Test
    public void testValidPassword() {
        String validPassword = "Abcdefg1!";
        PasswordResponse response = service.validate(validPassword);

        assertTrue(response.isValid());
        assertTrue(response.messages().isEmpty());
    }

    @Test
    public void testPasswordTooShort() {
        String shortPassword = "Ab1!";
        PasswordResponse response = service.validate(shortPassword);

        assertFalse(response.isValid());
        assertTrue(response.messages().contains("A senha deve conter pelo menos 9 caracteres."));
    }

    @Test
    public void testPasswordMissingDigit() {
        String noDigit = "Abcdefghi!";
        PasswordResponse response = service.validate(noDigit);

        assertFalse(response.isValid());
        assertTrue(response.messages().contains("A senha deve conter ao menos um dígito."));
    }

    @Test
    public void testPasswordMissingLowercase() {
        String noLower = "ABCDEFG1!";
        PasswordResponse response = service.validate(noLower);

        assertFalse(response.isValid());
        assertTrue(response.messages().contains("A senha deve conter ao menos uma letra minúscula."));
    }

    @Test
    public void testPasswordMissingUppercase() {
        String noUpper = "abcdefg1!";
        PasswordResponse response = service.validate(noUpper);

        assertFalse(response.isValid());
        assertTrue(response.messages().contains("A senha deve conter ao menos uma letra maiúscula."));
    }

    @Test
    public void testPasswordWithSpaces() {
        String withSpaces = "Abcdefg 1!";
        PasswordResponse response = service.validate(withSpaces);

        assertFalse(response.isValid());
        assertTrue(response.messages().contains("A senha não deve conter espaços em branco."));
    }

    @Test
    public void testPasswordMissingSpecialCharacter() {
        String noSpecial = "Abcdefg12";
        PasswordResponse response = service.validate(noSpecial);

        assertFalse(response.isValid());
        assertTrue(response.messages().stream()
                .anyMatch(msg -> msg.startsWith("A senha deve conter ao menos um caractere especial")));
    }

    @Test
    public void testPasswordWithDuplicateCharacters() {
        String duplicates = "Abcdefg11!";
        PasswordResponse response = service.validate(duplicates);

        assertFalse(response.isValid());
        assertTrue(response.messages().contains("A senha não deve conter caracteres repetidos."));
    }
}