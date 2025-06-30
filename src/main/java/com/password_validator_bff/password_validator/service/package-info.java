/**
 * Serviços de negócio da aplicação Password Validator BFF.
 *
 * <p>Este pacote contém os serviços responsáveis pela implementação
 * da lógica de negócio da aplicação, incluindo validação de senhas
 * e gerenciamento de autenticação OAuth2.</p>
 *
 * <h2>Serviços Disponíveis</h2>
 * <ul>
 *   <li>{@link com.password_validator_bff.password_validator.service.PasswordValidatorService} - 
 *       Implementa as regras de validação de senhas</li>
 *   <li>{@link com.password_validator_bff.password_validator.service.AuthService} - 
 *       Gerencia autenticação OAuth2 e tokens JWT</li>
 * </ul>
 *
 * <h2>Características dos Serviços</h2>
 * <ul>
 *   <li>Anotados com @Service para injeção de dependência</li>
 *   <li>Implementam lógica de negócio independente da camada de apresentação</li>
 *   <li>São testáveis unitariamente</li>
 *   <li>Seguem princípios SOLID e Clean Code</li>
 * </ul>
 *
 * @author Sistema de Validação de Senhas
 * @version 1.0
 * @since 1.0
 */
package com.password_validator_bff.password_validator.service;
