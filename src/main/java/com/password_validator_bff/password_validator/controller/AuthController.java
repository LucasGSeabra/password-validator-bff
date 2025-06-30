package com.password_validator_bff.password_validator.controller;

import com.password_validator_bff.password_validator.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Controller REST responsável pela autenticação e geração de tokens JWT.
 *
 * <p>Esta classe expõe endpoints para autenticação via OAuth2 client credentials,
 * permitindo que o frontend obtenha tokens de acesso para consumir as APIs
 * protegidas do sistema.</p>
 *
 * <p>Endpoints disponíveis:</p>
 * <ul>
 *   <li>POST /auth/token - Obtém token de acesso via client credentials</li>
 * </ul>
 *
 * @author Sistema de Validação de Senhas
 * @version 1.0
 * @since 1.0
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    /** Serviço de autenticação injetado via construtor. */
    private final AuthService authService;

    /**
     * Construtor para injeção de dependência do serviço de autenticação.
     *
     * @param authService instância do serviço de autenticação
     */
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    /**
     * Endpoint para obtenção de token de acesso via OAuth2 client credentials.
     *
     * <p>Este endpoint permite que clientes autenticados obtenham um token JWT
     * para acessar recursos protegidos da API. Utiliza o fluxo client credentials
     * do OAuth2 para autenticação de aplicações.</p>
     *
     * <p><strong>Autenticação:</strong> Não requer autenticação (endpoint público).</p>
     *
     * <p><strong>Exemplo de requisição:</strong></p>
     * <pre>
     * POST /auth/token
     * Content-Type: application/json
     * </pre>
     *
     * <p><strong>Exemplo de resposta:</strong></p>
     * <pre>
     * {
     *   "access_token": "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9..."
     * }
     * </pre>
     *
     * @return {@link ResponseEntity} contendo o token de acesso
     * @throws IllegalStateException se não for possível obter o token de acesso
     */
    @PostMapping("/token")
    public ResponseEntity<Map<String, String>> getToken() {
        String token = authService.getAccessToken();
        return ResponseEntity.ok(Map.of("access_token", token));
    }
}
