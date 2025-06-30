/**
 * Sistema de Validação de Senhas - Password Validator BFF.
 *
 * <p>Este pacote contém a implementação completa de um Backend for Frontend (BFF)
 * para validação de senhas, desenvolvido como microsserviço usando Spring Boot.</p>
 *
 * <h2>Funcionalidades Principais</h2>
 * <ul>
 *   <li><strong>Validação de Senhas:</strong> Implementa critérios rigorosos de segurança</li>
 *   <li><strong>Autenticação OAuth2:</strong> Integração com Keycloak via client credentials</li>
 *   <li><strong>API REST:</strong> Endpoints seguros para integração com frontend</li>
 *   <li><strong>Segurança:</strong> Proteção via JWT tokens e configuração CORS</li>
 * </ul>
 *
 * <h2>Critérios de Validação de Senhas</h2>
 * <p>Uma senha é considerada válida quando atende aos seguintes critérios:</p>
 * <ul>
 *   <li>Mínimo de 9 caracteres</li>
 *   <li>Pelo menos 1 dígito numérico (0-9)</li>
 *   <li>Pelo menos 1 letra minúscula (a-z)</li>
 *   <li>Pelo menos 1 letra maiúscula (A-Z)</li>
 *   <li>Pelo menos 1 caractere especial (!@#$%^&*()-+)</li>
 *   <li>Não deve conter caracteres repetidos</li>
 *   <li>Não deve conter espaços em branco</li>
 * </ul>
 *
 * <h2>Arquitetura</h2>
 * <p>A aplicação segue os princípios de Clean Architecture e é organizada em camadas:</p>
 * <ul>
 *   <li><strong>Controllers:</strong> {@link com.password_validator_bff.password_validator.controller} - Endpoints REST</li>
 *   <li><strong>Services:</strong> {@link com.password_validator_bff.password_validator.service} - Lógica de negócio</li>
 *   <li><strong>DTOs:</strong> {@link com.password_validator_bff.password_validator.dto} - Objetos de transferência</li>
 *   <li><strong>Configuration:</strong> {@link com.password_validator_bff.password_validator.config} - Configurações de segurança</li>
 *   <li><strong>Exception Handling:</strong> {@link com.password_validator_bff.password_validator.exception} - Tratamento de erros</li>
 * </ul>
 *
 * <h2>Endpoints da API</h2>
 * <table border="1">
 *   <tr>
 *     <th>Método</th>
 *     <th>Endpoint</th>
 *     <th>Descrição</th>
 *     <th>Autenticação</th>
 *   </tr>
 *   <tr>
 *     <td>POST</td>
 *     <td>/auth/token</td>
 *     <td>Obtém token de acesso JWT</td>
 *     <td>Não</td>
 *   </tr>
 *   <tr>
 *     <td>POST</td>
 *     <td>/validar</td>
 *     <td>Valida uma senha</td>
 *     <td>JWT Token</td>
 *   </tr>
 * </table>
 *
 * <h2>Tecnologias Utilizadas</h2>
 * <ul>
 *   <li><strong>Spring Boot 3.5.3:</strong> Framework principal</li>
 *   <li><strong>Spring Security:</strong> Segurança e autenticação</li>
 *   <li><strong>OAuth2 Resource Server:</strong> Validação de JWT</li>
 *   <li><strong>OAuth2 Client:</strong> Client credentials flow</li>
 *   <li><strong>Java 24:</strong> Linguagem de programação</li>
 *   <li><strong>Maven:</strong> Gerenciamento de dependências</li>
 *   <li><strong>JUnit 5:</strong> Testes unitários</li>
 *   <li><strong>JaCoCo:</strong> Cobertura de testes</li>
 * </ul>
 *
 * <h2>Como Usar</h2>
 * <ol>
 *   <li>Configure o servidor Keycloak conforme application.yml</li>
 *   <li>Execute a aplicação: {@code mvn spring-boot:run}</li>
 *   <li>Obtenha um token: {@code POST /auth/token}</li>
 *   <li>Use o token para validar senhas: {@code POST /validar}</li>
 * </ol>
 *
 * @author Sistema de Validação de Senhas
 * @version 1.0
 * @since 1.0
 */
package com.password_validator_bff.password_validator;
