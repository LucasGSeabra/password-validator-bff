/**
 * DTOs (Data Transfer Objects) da aplicação Password Validator BFF.
 *
 * <p>Este pacote contém os objetos de transferência de dados utilizados
 * para comunicação entre as diferentes camadas da aplicação e com
 * clientes externos via API REST.</p>
 *
 * <h2>DTOs Disponíveis</h2>
 * <ul>
 *   <li>{@link com.password_validator_bff.password_validator.dto.PasswordRequest} - 
 *       Representa uma requisição de validação de senha</li>
 *   <li>{@link com.password_validator_bff.password_validator.dto.PasswordResponse} - 
 *       Representa a resposta de uma validação de senha</li>
 * </ul>
 *
 * <h2>Características dos DTOs</h2>
 * <ul>
 *   <li>Implementados como Java Records para imutabilidade</li>
 *   <li>Contêm validações usando Bean Validation (@NotBlank, etc.)</li>
 *   <li>São serializáveis para JSON automaticamente</li>
 *   <li>Servem como contrato da API REST</li>
 *   <li>Encapsulam dados sem lógica de negócio</li>
 * </ul>
 *
 * @author Sistema de Validação de Senhas
 * @version 1.0
 * @since 1.0
 */
package com.password_validator_bff.password_validator.dto;
