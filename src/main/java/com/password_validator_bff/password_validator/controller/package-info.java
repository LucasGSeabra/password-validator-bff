/**
 * Controllers REST da aplicação Password Validator BFF.
 *
 * <p>Este pacote contém os controladores REST responsáveis por expor
 * as APIs da aplicação, servindo como pontos de entrada para as
 * requisições HTTP dos clientes.</p>
 *
 * <h2>Controllers Disponíveis</h2>
 * <ul>
 *   <li>{@link com.password_validator_bff.password_validator.controller.PasswordValidatorController} - 
 *       Endpoint para validação de senhas</li>
 *   <li>{@link com.password_validator_bff.password_validator.controller.AuthController} - 
 *       Endpoint para obtenção de tokens JWT</li>
 * </ul>
 *
 * <h2>Características Comuns</h2>
 * <ul>
 *   <li>Utilizam anotações Spring MVC (@RestController, @RequestMapping)</li>
 *   <li>Implementam validação de entrada via Bean Validation</li>
 *   <li>Retornam ResponseEntity para controle preciso das respostas HTTP</li>
 *   <li>Integram com as camadas de serviço para lógica de negócio</li>
 * </ul>
 *
 * @author Sistema de Validação de Senhas
 * @version 1.0
 * @since 1.0
 */
package com.password_validator_bff.password_validator.controller;
