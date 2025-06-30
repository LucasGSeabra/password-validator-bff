package com.password_validator_bff.password_validator.controller;

import com.password_validator_bff.password_validator.dto.PasswordRequest;
import com.password_validator_bff.password_validator.dto.PasswordResponse;
import com.password_validator_bff.password_validator.service.PasswordValidatorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller REST responsável pelos endpoints de validação de senhas.
 *
 * <p>Esta classe expõe as APIs REST para validação de senhas, servindo como
 * ponto de entrada para as requisições do frontend. Requer autenticação
 * via JWT token para acesso aos endpoints.</p>
 *
 * <p>Endpoints disponíveis:</p>
 * <ul>
 *   <li>POST /validar - Valida uma senha conforme critérios de segurança</li>
 * </ul>
 *
 * @author Sistema de Validação de Senhas
 * @version 1.0
 * @since 1.0
 */
@RestController
@RequestMapping("/validar")
public class PasswordValidatorController {

    /** Serviço de validação de senhas injetado via construtor. */
    private final PasswordValidatorService service;

    /**
     * Construtor para injeção de dependência do serviço de validação.
     *
     * @param service instância do serviço de validação de senhas
     */
    public PasswordValidatorController(PasswordValidatorService service) {
        this.service = service;
    }

    /**
     * Endpoint para validação de senhas.
     *
     * <p>Recebe uma requisição contendo a senha a ser validada e retorna
     * o resultado da validação junto com eventuais mensagens de erro.</p>
     *
     * <p><strong>Autenticação:</strong> Requer JWT token válido no header Authorization.</p>
     *
     * <p><strong>Exemplo de requisição:</strong></p>
     * <pre>
     * POST /validar
     * Content-Type: application/json
     * Authorization: Bearer [JWT_TOKEN]
     *
     * {
     *   "password": "MinhaSenh@123"
     * }
     * </pre>
     *
     * <p><strong>Exemplo de resposta (senha válida):</strong></p>
     * <pre>
     * {
     *   "isValid": true,
     *   "messages": []
     * }
     * </pre>
     *
     * <p><strong>Exemplo de resposta (senha inválida):</strong></p>
     * <pre>
     * {
     *   "isValid": false,
     *   "messages": [
     *     "A senha deve conter pelo menos 9 caracteres.",
     *     "A senha deve conter ao menos um dígito."
     *   ]
     * }
     * </pre>
     *
     * @param request objeto contendo a senha a ser validada
     * @return {@link ResponseEntity} contendo {@link PasswordResponse} com resultado da validação
     * @throws org.springframework.web.bind.MethodArgumentNotValidException se a requisição for inválida
     */
    @PostMapping
    public ResponseEntity<PasswordResponse> validatePassword(@RequestBody @Valid PasswordRequest request) {
        PasswordResponse response = service.validate(request.password());

        return ResponseEntity.ok(response);
    }
}
