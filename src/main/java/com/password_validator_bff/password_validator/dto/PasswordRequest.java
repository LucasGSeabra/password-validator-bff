package com.password_validator_bff.password_validator.dto;

import jakarta.validation.constraints.NotBlank;

/**
 * DTO (Data Transfer Object) que representa uma requisição de validação de senha.
 *
 * <p>Esta classe é utilizada para receber dados de requisições HTTP contendo
 * a senha que deve ser validada pelo sistema. Implementa validações básicas
 * para garantir que os dados obrigatórios sejam fornecidos.</p>
 *
 * <p>Validações aplicadas:</p>
 * <ul>
 *   <li>password: campo obrigatório, não pode ser nulo, vazio ou conter apenas espaços</li>
 * </ul>
 *
 * @param password a senha a ser validada (obrigatório)
 *
 * @author Sistema de Validação de Senhas
 * @version 1.0
 * @since 1.0
 */
public record PasswordRequest(
        /**
         * A senha a ser validada pelo sistema.
         *
         * <p>Este campo é obrigatório e não pode ser nulo, vazio ou conter
         * apenas espaços em branco.</p>
         */
        @NotBlank(message = "É obrigatório informar uma senha")
        String password
) {}
