package com.password_validator_bff.password_validator.controller;

import com.password_validator_bff.password_validator.service.AuthService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class AuthControllerTest {

    @Test
    void getToken_shouldReturnTokenInResponseBody() {
        AuthService authServiceMock = mock(AuthService.class);
        String expectedToken = "fake-token-123";
        Mockito.when(authServiceMock.getAccessToken()).thenReturn(expectedToken);

        AuthController authController = new AuthController(authServiceMock);

        ResponseEntity<Map<String, String>> response = authController.getToken();

        assertThat(response.getStatusCodeValue()).isEqualTo(200);

        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody()).containsEntry("access_token", expectedToken);

        Mockito.verify(authServiceMock, Mockito.times(1)).getAccessToken();
    }
}