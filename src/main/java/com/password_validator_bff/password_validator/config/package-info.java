/**
 * Configurações da aplicação Password Validator BFF.
 *
 * <p>Este pacote contém as classes de configuração do Spring responsáveis
 * por definir beans, configurações de segurança, e integrações com
 * sistemas externos como OAuth2 e CORS.</p>
 *
 * <h2>Configurações Disponíveis</h2>
 * <ul>
 *   <li>{@link com.password_validator_bff.password_validator.config.SecurityConfig} - 
 *       Configurações de segurança, CORS e OAuth2 Resource Server</li>
 *   <li>{@link com.password_validator_bff.password_validator.config.OAuthClientConfig} - 
 *       Configurações do cliente OAuth2 para client credentials</li>
 * </ul>
 *
 * <h2>Características das Configurações</h2>
 * <ul>
 *   <li>Anotadas com @Configuration para detecção automática</li>
 *   <li>Definem beans através de métodos @Bean</li>
 *   <li>Configuram aspectos transversais da aplicação</li>
 *   <li>Integram Spring Security com OAuth2 e JWT</li>
 *   <li>Configuram CORS para integração com frontend</li>
 * </ul>
 *
 * @author Sistema de Validação de Senhas
 * @version 1.0
 * @since 1.0
 */
package com.password_validator_bff.password_validator.config;
