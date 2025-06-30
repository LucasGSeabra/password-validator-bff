package com.password_validator_bff.password_validator.dto;

import java.util.List;

/**
 * DTO (Data Transfer Object) que representa a resposta de uma validação de senha.
 *
 * <p>Esta classe encapsula o resultado de uma operação de validação de senha,
 * incluindo um indicador booleano de validade e uma lista de mensagens
 * explicativas sobre eventuais problemas encontrados.</p>
 *
 * <p>Estrutura da resposta:</p>
 * <ul>
 *   <li>isValid: indica se a senha atende a todos os critérios de validação</li>
 *   <li>messages: lista de mensagens descrevendo os problemas encontrados (vazia se senha válida)</li>
 * </ul>
 *
 * @param isValid    true se a senha é válida, false caso contrário
 * @param messages   lista de mensagens de erro encontradas durante a validação
 *                   (lista vazia se a senha for válida)
 *
 * @author Sistema de Validação de Senhas
 * @version 1.0
 * @since 1.0
 */
public record PasswordResponse(
        /**
         * Indica se a senha é válida de acordo com todos os critérios estabelecidos.
         *
         * <p>Será true apenas se a senha atender a todos os requisitos de segurança,
         * caso contrário será false.</p>
         */
        boolean isValid,

        /**
         * Lista de mensagens descrevendo os problemas encontrados na validação.
         *
         * <p>Esta lista conterá mensagens explicativas para cada critério que
         * não foi atendido pela senha. Se a senha for válida, esta lista
         * estará vazia.</p>
         *
         * <p>Exemplos de mensagens:</p>
         * <ul>
         *   <li>"A senha deve conter pelo menos 9 caracteres."</li>
         *   <li>"A senha deve conter ao menos um dígito."</li>
         *   <li>"A senha não deve conter caracteres repetidos."</li>
         * </ul>
         */
        List<String> messages
) {}
