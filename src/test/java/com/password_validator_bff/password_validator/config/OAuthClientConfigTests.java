package com.password_validator_bff.password_validator.config;

import org.junit.jupiter.api.Test;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizedClientManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class OAuthClientConfigTest {

    private final OAuthClientConfig config = new OAuthClientConfig();

    @Test
    void authorizedClientManager_shouldCreateManagerWithClientCredentialsProvider() {
        ClientRegistrationRepository clients = mock(ClientRegistrationRepository.class);
        OAuth2AuthorizedClientRepository authRepo = mock(OAuth2AuthorizedClientRepository.class);

        OAuth2AuthorizedClientManager manager = config.authorizedClientManager(clients, authRepo);

        assertThat(manager).isInstanceOf(DefaultOAuth2AuthorizedClientManager.class);

        DefaultOAuth2AuthorizedClientManager defaultManager = (DefaultOAuth2AuthorizedClientManager) manager;
    }
}
