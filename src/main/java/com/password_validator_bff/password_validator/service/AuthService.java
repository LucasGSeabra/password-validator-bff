package com.password_validator_bff.password_validator.service;

import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final OAuth2AuthorizedClientManager clientManager;

    public AuthService(OAuth2AuthorizedClientManager clientManager) {
        this.clientManager = clientManager;
    }

    public String getAccessToken() {
        OAuth2AuthorizeRequest request = OAuth2AuthorizeRequest
                .withClientRegistrationId("keycloak-client")
                .principal("frontend-client")
                .build();

        OAuth2AuthorizedClient client = clientManager.authorize(request);

        if(client == null) {
            throw new IllegalStateException("Não foi possível obter token de acesso");
        }

        return client.getAccessToken().getTokenValue();
    }
}
