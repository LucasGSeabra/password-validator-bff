package com.password_validator_bff.password_validator.dto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PasswordResponseTest {

    @Test
    void shouldCreateValidPasswordResponseWithMessages() {
        List<String> messages = List.of("Senha fraca", "Falta número");
        PasswordResponse response = new PasswordResponse(false, messages);

        assertThat(response.isValid()).isFalse();
        assertThat(response.messages()).containsExactly("Senha fraca", "Falta número");
    }

    @Test
    void shouldCreateValidPasswordResponseWithoutMessages() {
        PasswordResponse response = new PasswordResponse(true, List.of());

        assertThat(response.isValid()).isTrue();
        assertThat(response.messages()).isEmpty();
    }

    @Test
    void shouldAllowNullMessages() {
        PasswordResponse response = new PasswordResponse(false, null);

        assertThat(response.isValid()).isFalse();
        assertThat(response.messages()).isNull();
    }
}