package com.password_validator_bff.password_validator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProvider;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProviderBuilder;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;

/**
 * Configuração do cliente OAuth2 para integração com servidor de autorização.
 *
 * <p>Esta classe configura o gerenciamento de clientes OAuth2 da aplicação,
 * definindo como a aplicação irá obter e gerenciar tokens de acesso através
 * do fluxo client credentials do OAuth2.</p>
 *
 * <p>Funcionalidades configuradas:</p>
 * <ul>
 *   <li>Gerenciador de clientes OAuth2 autorizados</li>
 *   <li>Provedor de autorização para client credentials flow</li>
 *   <li>Integração com repositórios de registro e autorização de clientes</li>
 * </ul>
 *
 * <p>Esta configuração é essencial para o funcionamento da autenticação
 * OAuth2 client credentials que permite à aplicação obter tokens JWT
 * do servidor Keycloak.</p>
 *
 * @author Sistema de Validação de Senhas
 * @version 1.0
 * @since 1.0
 */
@Configuration
public class OAuthClientConfig {

    /**
     * Configura o gerenciador de clientes OAuth2 autorizados.
     *
     * <p>Este bean é responsável por gerenciar o ciclo de vida dos clientes
     * OAuth2, incluindo a obtenção, renovação e armazenamento de tokens de
     * acesso. Utiliza o fluxo client credentials para autenticação de
     * aplicação para aplicação.</p>
     *
     * <p>O gerenciador configurado:</p>
     * <ul>
     *   <li>Suporta apenas o fluxo client credentials (adequado para APIs)</li>
     *   <li>Gerencia automaticamente a renovação de tokens expirados</li>
     *   <li>Integra com os repositórios de registro e autorização</li>
     * </ul>
     *
     * @param clients repositório de registros de clientes OAuth2 (configurado via application.yml)
     * @param authRepo repositório de clientes autorizados para armazenamento de tokens
     * @return gerenciador de clientes OAuth2 configurado para client credentials
     */
    @Bean
    public OAuth2AuthorizedClientManager authorizedClientManager(
            ClientRegistrationRepository clients,
            OAuth2AuthorizedClientRepository authRepo) {

        // Configura o provedor para suportar apenas client credentials flow
        OAuth2AuthorizedClientProvider provider =
                OAuth2AuthorizedClientProviderBuilder.builder()
                        .clientCredentials()
                        .build();

        // Cria o gerenciador padrão com os repositórios fornecidos
        DefaultOAuth2AuthorizedClientManager manager =
                new DefaultOAuth2AuthorizedClientManager(clients, authRepo);

        // Associa o provedor ao gerenciador
        manager.setAuthorizedClientProvider(provider);

        return manager;
    }
}
