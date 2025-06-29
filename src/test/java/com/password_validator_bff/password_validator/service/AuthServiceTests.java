package com.password_validator_bff.password_validator.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.core.OAuth2AccessToken;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class AuthServiceTests {

    private OAuth2AuthorizedClientManager clientManager;
    private AuthService authService;

    @BeforeEach
    void setUp() {
        clientManager = Mockito.mock(OAuth2AuthorizedClientManager.class);
        authService = new AuthService(clientManager);
    }

    @Test
    void getAccessToken_shouldReturnTokenValue_whenClientIsAuthorized() {
        OAuth2AccessToken accessToken = new OAuth2AccessToken(
                OAuth2AccessToken.TokenType.BEARER,
                "mock-token-value",
                Instant.now(),
                Instant.now().plus(1, ChronoUnit.HOURS)
        );

        OAuth2AuthorizedClient authorizedClient = mock(OAuth2AuthorizedClient.class);
        when(authorizedClient.getAccessToken()).thenReturn(accessToken);

        when(clientManager.authorize(any(OAuth2AuthorizeRequest.class))).thenReturn(authorizedClient);

        String token = authService.getAccessToken();
        assertEquals("mock-token-value", token);

        verify(clientManager, times(1)).authorize(any(OAuth2AuthorizeRequest.class));
    }

    @Test
    void getAccessToken_shouldThrowException_whenClientIsNull() {
        when(clientManager.authorize(any(OAuth2AuthorizeRequest.class))).thenReturn(null);

        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            authService.getAccessToken();
        });

        assertEquals("Não foi possível obter token de acesso", exception.getMessage());

        verify(clientManager, times(1)).authorize(any(OAuth2AuthorizeRequest.class));
    }
}
