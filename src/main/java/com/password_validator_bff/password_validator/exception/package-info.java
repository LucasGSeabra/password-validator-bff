/**
 * Tratamento de exceções da aplicação Password Validator BFF.
 *
 * <p>Este pacote contém classes responsáveis pelo tratamento centralizado
 * de exceções que podem ocorrer durante o processamento de requisições,
 * garantindo respostas consistentes e informativas para os clientes.</p>
 *
 * <h2>Handlers Disponíveis</h2>
 * <ul>
 *   <li>{@link com.password_validator_bff.password_validator.exception.GlobalExceptionHandler} -
 *       Manipulador global para diferentes tipos de exceções</li>
 * </ul>
 *
 * <h2>Tipos de Exceções Tratadas</h2>
 * <ul>
 *   <li><strong>MethodArgumentNotValidException:</strong> Erros de validação de entrada</li>
 *   <li><strong>Futuras exceções:</strong> Espaço para tratamento de outros tipos de erro</li>
 * </ul>
 *
 * <h2>Características do Tratamento</h2>
 * <ul>
 *   <li>Utiliza @RestControllerAdvice para captura global</li>
 *   <li>Retorna respostas HTTP apropriadas (400, 500, etc.)</li>
 *   <li>Formata mensagens de erro de forma consistente</li>
 *   <li>Evita exposição de detalhes internos para clientes</li>
 * </ul>
 *
 * @author Sistema de Validação de Senhas
 * @version 1.0
 * @since 1.0
 */
package com.password_validator_bff.password_validator.exception;
