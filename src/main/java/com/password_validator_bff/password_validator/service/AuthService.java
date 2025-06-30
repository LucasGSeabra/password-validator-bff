package com.password_validator_bff.password_validator.service;

import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.stereotype.Service;

/**
 * Serviço responsável pela autenticação OAuth2 e gerenciamento de tokens de acesso.
 *
 * <p>Esta classe gerencia a autenticação via OAuth2 client credentials flow,
 * integrando com o servidor de autorização (Keycloak) para obter tokens JWT
 * que serão utilizados para proteger os endpoints da aplicação.</p>
 *
 * <p>Funcionalidades principais:</p>
 * <ul>
 *   <li>Obtenção de tokens de acesso via client credentials</li>
 *   <li>Integração com Keycloak como servidor de autorização</li>
 *   <li>Gerenciamento automatizado de tokens através do Spring Security</li>
 * </ul>
 *
 * @author Sistema de Validação de Senhas
 * @version 1.0
 * @since 1.0
 */
@Service
public class AuthService {

    /** Gerenciador de clientes OAuth2 autorizados do Spring Security. */
    private final OAuth2AuthorizedClientManager clientManager;

    /**
     * Construtor para injeção de dependência do gerenciador de clientes OAuth2.
     *
     * @param clientManager instância do gerenciador de clientes OAuth2
     */
    public AuthService(OAuth2AuthorizedClientManager clientManager) {
        this.clientManager = clientManager;
    }

    /**
     * Obtém um token de acesso JWT através do fluxo OAuth2 client credentials.
     *
     * <p>Este método realiza a autenticação com o servidor Keycloak utilizando
     * as credenciais configuradas (client_id e client_secret) e retorna um
     * token JWT válido que pode ser utilizado para acessar recursos protegidos.</p>
     *
     * <p>O token é obtido automaticamente pelo Spring Security OAuth2 Client,
     * que gerencia o ciclo de vida do token incluindo renovação quando necessário.</p>
     *
     * @return token de acesso JWT válido
     * @throws IllegalStateException se não for possível obter o token de acesso
     *         (por exemplo, devido a credenciais inválidas ou servidor indisponível)
     */
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
